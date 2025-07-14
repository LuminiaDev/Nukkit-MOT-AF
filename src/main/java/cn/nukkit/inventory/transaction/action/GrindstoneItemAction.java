package cn.nukkit.inventory.transaction.action;

import cn.nukkit.Player;
import cn.nukkit.item.Item;

/**
 * @author joserobjr
 * @since 2021-03-21
 */
public class GrindstoneItemAction extends InventoryAction {

    private final int type;
    private final int experience;

    public GrindstoneItemAction(Item sourceItem, Item targetItem, int type, int experience) {
        super(sourceItem, targetItem);
        this.type = type;
        this.experience = experience;
    }

    @Override
    public boolean isValid(Player source) {
        return source.getWindowById(Player.GRINDSTONE_WINDOW_ID) != null;
    }

    @Override
    public boolean execute(Player source) {
        int exp = getExperience();
        if (exp > 0) {
            source.getLevel().dropExpOrb(source, exp, null, 3);
        }
        return true;
    }

    @Override
    public void onExecuteSuccess(Player source) {
        // Does nothing
    }

    @Override
    public void onExecuteFail(Player source) {
        // Does nothing
    }

    public int getExperience() {
        return experience;
    }

    public int getType() {
        return type;
    }
}