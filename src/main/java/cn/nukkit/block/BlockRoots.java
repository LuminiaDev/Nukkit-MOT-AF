package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockFace;

public abstract class BlockRoots extends BlockFlowable {

    protected BlockRoots() {
        super(0);
    }

    protected BlockRoots(int meta) {
        super(meta);
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL && !isSupportValid()) {
            level.useBreakOn(this, null, null, true);
            return type;
        }
        return 0;
    }

    @Override
    public boolean place(Item item, Block block, Block target, BlockFace face, double fx, double fy, double fz, Player player) {
        return isSupportValid() && super.place(item, block, target, face, fx, fy, fz, player);
    }

    protected boolean isSupportValid() {
        return switch (down().getId()) {
            case WARPED_NYLIUM, CRIMSON_NYLIUM, GRASS, PODZOL, DIRT, SOUL_SOIL -> true;
            default -> false;
        };
    }

    @Override
    public int getBurnChance() {
        return 5;
    }
}
