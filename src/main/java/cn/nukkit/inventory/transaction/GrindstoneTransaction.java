package cn.nukkit.inventory.transaction;

import cn.nukkit.Player;
import cn.nukkit.event.inventory.GrindstoneEvent;
import cn.nukkit.inventory.GrindstoneInventory;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.transaction.action.GrindstoneItemAction;
import cn.nukkit.inventory.transaction.action.InventoryAction;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.types.NetworkInventoryAction;

import java.util.List;

/**
 * @author joserobjr
 * @since 2021-03-21
 */
public class GrindstoneTransaction extends InventoryTransaction {

    private Item firstItem;
    private Item secondItem;
    private Item outputItem;

    public GrindstoneTransaction(Player source, List<InventoryAction> actions) {
        super(source, actions);
    }

    @Override
    public void addAction(InventoryAction action) {
        super.addAction(action);
        if (action instanceof GrindstoneItemAction grindstoneAction) {
            switch (grindstoneAction.getType()) {
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_INPUT:
                    this.firstItem = action.getTargetItem();
                    break;
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_RESULT:
                    this.outputItem = action.getSourceItem();
                    break;
                case NetworkInventoryAction.SOURCE_TYPE_ANVIL_MATERIAL:
                    this.secondItem = action.getTargetItem();
                    break;
            }
        }
    }

    @Override
    public boolean canExecute() {
        Inventory inventory = getSource().getWindowById(Player.GRINDSTONE_WINDOW_ID);
        if (inventory == null) {
            return false;
        }

        GrindstoneInventory grindstoneInventory = (GrindstoneInventory) inventory;
        if (outputItem == null || outputItem.isNull() ||
                ((firstItem == null || firstItem.isNull()) && (secondItem == null || secondItem.isNull()))) {
            return false;
        }

        Item air = Item.get(0);
        Item first = firstItem != null ? firstItem : air;
        Item second = secondItem != null ? secondItem : air;

        // GrindstoneTransaction从数据包接受到的物品竟然和RepairItemTransaction接受到的物品在NBT "RepairCost"上存在区别,实际上也没必要检测这个,这里放宽检查
        return first.equals(grindstoneInventory.getFirstItem(), true, true)
                && second.equals(grindstoneInventory.getSecondItem(), true, true)
                && outputItem.equals(grindstoneInventory.getResult(), true, false)
                && !outputItem.hasEnchantments();
    }

    @Override
    public boolean execute() {
        if (this.hasExecuted() || !this.canExecute()) {
            this.source.removeAllWindows(false);
            this.sendInventories();
            return false;
        }
        GrindstoneInventory inventory = (GrindstoneInventory) getSource().getWindowById(Player.GRINDSTONE_WINDOW_ID);
        int exp = inventory.getResultExperience();
        Item air = Item.get(0);
        Item first = firstItem != null ? firstItem : air;
        Item second = secondItem != null ? secondItem : air;
        GrindstoneEvent event = new GrindstoneEvent(inventory, first, outputItem, second, exp, source);
        this.source.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            this.source.removeAllWindows(false);
            this.sendInventories();
            return true;
        }

        for (InventoryAction action : this.actions) {
            if (action.execute(this.source)) {
                action.onExecuteSuccess(this.source);
            } else {
                action.onExecuteFail(this.source);
            }
        }
        return true;
    }

    public Item getFirstItem() {
        return firstItem == null ? null : firstItem.clone();
    }

    public Item getSecondItem() {
        return secondItem == null ? null : secondItem.clone();
    }

    public Item getOutputItem() {
        return outputItem == null ? null : outputItem.clone();
    }

    public static boolean checkForItemPart(List<InventoryAction> actions) {
        return actions.stream().anyMatch(it -> it instanceof GrindstoneItemAction);
    }
}