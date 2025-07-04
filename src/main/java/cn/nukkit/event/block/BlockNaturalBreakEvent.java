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
    protected int blockExp;

    public BlockNaturalBreakEvent(Block block, Item item, Item[] drops) {
        super(block);
        this.drops = drops;
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
        return this.blockExp;
    }

    public void setDropExp(int blockExp) {
        this.blockExp = blockExp;
    }
}