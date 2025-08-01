package cn.nukkit.blockentity;

import cn.nukkit.Player;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.BlockEntityDataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;

import java.io.IOException;
import java.nio.ByteOrder;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public abstract class BlockEntitySpawnable extends BlockEntity {

    public BlockEntitySpawnable(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initBlockEntity() {
        super.initBlockEntity();

        this.spawnToAll();
    }

    public abstract CompoundTag getSpawnCompound();

    public CompoundTag getSpawnCompound(int protocol) {
        return this.getSpawnCompound();
    }

    public BlockEntityDataPacket createSpawnPacket() {
        return this.createSpawnPacket(ProtocolInfo.CURRENT_PROTOCOL);
    }

    public BlockEntityDataPacket createSpawnPacket(int protocol) {
        CompoundTag tag = this.getSpawnCompound(protocol);
        BlockEntityDataPacket pk = new BlockEntityDataPacket();
        pk.x = (int) this.x;
        pk.y = (int) this.y;
        pk.z = (int) this.z;

        try {
            pk.namedTag = NBTIO.write(tag, ByteOrder.LITTLE_ENDIAN, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pk;
    }

    public void spawnTo(Player player) {
        if (!this.closed) {
            player.dataPacket(this.createSpawnPacket(player.protocol));
        }
    }

    public void spawnToAll() {
        if (!this.closed) {
            for (Player player : this.getLevel().getChunkPlayers(this.chunk.getX(), this.chunk.getZ()).values()) {
                if (player.spawned) {
                    this.spawnTo(player);
                }
            }
        }
    }

    /**
     * Called when a player updates a block entity's NBT data
     * for example when writing on a sign.
     *
     * @param nbt    tag
     * @param player player
     * @return bool indication of success, will respawn the tile to the player if false.
     */
    public boolean updateCompoundTag(CompoundTag nbt, Player player) {
        return false;
    }
}
