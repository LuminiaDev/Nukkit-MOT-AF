package cn.nukkit.event.inventory;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.inventory.GrindstoneInventory;
import cn.nukkit.item.Item;
import org.jetbrains.annotations.NotNull;

/**
 * @author joserobjr
 * @since 2021-03-21
 */
public class GrindstoneEvent extends InventoryEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final @NotNull Item firstItem;
    private final @NotNull Item resultItem;
    private final @NotNull Item secondItem;
    private int experienceDropped;
    private final @NotNull Player player;

    public GrindstoneEvent(GrindstoneInventory inventory, @NotNull Item firstItem, @NotNull Item resultItem, @NotNull Item secondItem, int cost, @NotNull Player player) {
        super(inventory);
        this.firstItem = firstItem;
        this.resultItem = resultItem;
        this.secondItem = secondItem;
        this.experienceDropped = cost;
        this.player = player;
    }

    @NotNull
    public Item getFirstItem() {
        return this.firstItem;
    }

    @NotNull
    public Item getResultItem() {
        return this.resultItem;
    }

    @NotNull
    public Item getSecondItem() {
        return this.secondItem;
    }

    public int getExperienceDropped() {
        return this.experienceDropped;
    }

    public void setExperienceDropped(int experienceDropped) {
        this.experienceDropped = experienceDropped;
    }

    @NotNull
    public Player getPlayer() {
        return this.player;
    }
}
