package cn.nukkit.blockentity;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * Created by Snake1999 on 2016/2/3.
 * Package cn.nukkit.blockentity in project Nukkit.
 */
public class BlockEntitySkull extends BlockEntitySpawnable {
    public BlockEntitySkull(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initBlockEntity() {
        if (!namedTag.contains("SkullType")) {
            namedTag.putByte("SkullType", 0);
        }
        if (!namedTag.contains("Rot")) {
            namedTag.putByte("Rot", 0);
        }

        super.initBlockEntity();
    }

    @Override
    public void saveNBT() {
        super.saveNBT();
        this.namedTag.remove("Creator");
    }

    @Override
    public CompoundTag getSpawnCompound() {
        return new CompoundTag()
                .putString("id", BlockEntity.SKULL)
                .put("SkullType", this.namedTag.get("SkullType"))
                .putInt("x", (int) this.x)
                .putInt("y", (int) this.y)
                .putInt("z", (int) this.z)
                .put("Rot", this.namedTag.get("Rot"));
    }
}