package cn.nukkit.event.block;

import cn.nukkit.block.Block;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.item.Item;

/**
 * Event when a block was broken without the player.
 *
 * @author MEFRREEX
 */
public class BlockNaturalBreakEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    protected Item item;
    protected Item[] drops;
    protected int dropExp;

    public BlockNaturalBreakEvent(Block block, Item item, Item[] drops, int dropExp) {
        super(block);
        this.item = item;
        this.drops = drops;
        this.dropExp = dropExp;
    }

    public Item getItem() {
        return item;
    }

    public Item[] getDrops() {
        return drops;
    }

    public void setDrops(Item[] drops) {
        this.drops = drops;
    }

    public int getDropExp() {
        return this.dropExp;
    }

    public void setDropExp(int dropExp) {
        this.dropExp = dropExp;
    }
}