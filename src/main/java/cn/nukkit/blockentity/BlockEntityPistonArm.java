package cn.nukkit.blockentity;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAir;
import cn.nukkit.block.BlockChest;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.entity.EntityMoveByPistonEvent;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.SimpleAxisAlignedBB;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.IntTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.utils.Faceable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CreeperFace
 */
public class BlockEntityPistonArm extends BlockEntitySpawnable {

    public static final float MOVE_STEP = 0.5f;

    public float progress;
    public float lastProgress = 1;
    public BlockFace facing;
    public boolean extending;
    public boolean sticky;
    public int state;
    public int newState = 1;
    public List<BlockVector3> attachedBlocks;
    public boolean powered;

    public BlockEntityPistonArm(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initBlockEntity() {
        this.state = this.namedTag.getByte("State");
        this.newState = this.namedTag.getByte("NewState");

        if (namedTag.contains("Progress")) {
            this.progress = namedTag.getFloat("Progress");
        }

        if (namedTag.contains("LastProgress")) {
            this.lastProgress = (float) namedTag.getInt("LastProgress");
        }

        this.sticky = namedTag.getBoolean("Sticky");
        this.extending = namedTag.getBoolean("Extending");
        this.powered = namedTag.getBoolean("powered");


        if (namedTag.contains("facing")) {
            this.facing = BlockFace.fromIndex(namedTag.getInt("facing"));
        } else {
            Block b = this.getLevelBlock();

            if (b instanceof Faceable) {
                this.facing = ((Faceable) b).getBlockFace();
            } else {
                this.facing = BlockFace.NORTH;
            }
        }

        attachedBlocks = new ArrayList<>();

        if (namedTag.contains("AttachedBlocks")) {
            ListTag<IntTag> blocks = namedTag.getList("AttachedBlocks", IntTag.class);
            if (blocks != null && !blocks.isEmpty()) {
                for (int i = 0; i < blocks.size(); i += 3) {
                    this.attachedBlocks.add(new BlockVector3(
                            blocks.get(i).data,
                            blocks.get(i + 1).data,
                            blocks.get(i + 1).data
                    ));
                }
            }
        } else {
            namedTag.putList(new ListTag<>("AttachedBlocks"));
        }

        super.initBlockEntity();
    }

    private void moveCollidedEntities() {
        BlockFace pushDir = this.extending ? facing : facing.getOpposite();
        for (BlockVector3 pos : this.attachedBlocks) {
            BlockEntity blockEntity = this.level.getBlockEntity(pos.getSide(pushDir));

            if (blockEntity instanceof BlockEntityMovingBlock) {
                ((BlockEntityMovingBlock) blockEntity).moveCollidedEntities(this, pushDir);
            }
        }

        AxisAlignedBB bb = new SimpleAxisAlignedBB(0, 0, 0, 1, 1, 1).getOffsetBoundingBox(
                this.x + (pushDir.getXOffset() * progress),
                this.y + (pushDir.getYOffset() * progress),
                this.z + (pushDir.getZOffset() * progress)
        );

        Entity[] entities = this.level.getCollidingEntities(bb);

        for (Entity entity : entities) {
            this.moveEntity(entity, pushDir);
        }
    }

    void moveEntity(Entity entity, BlockFace moveDirection) {
        if (!entity.canBePushed()) {
            return;
        }

        EntityMoveByPistonEvent event = new EntityMoveByPistonEvent(entity, entity.getPosition());
        this.level.getServer().getPluginManager().callEvent(event);

        if (!event.isCancelled()) {
            entity.onPushByPiston(this, moveDirection);
        }
    }

    public void move(boolean extending, List<BlockVector3> attachedBlocks) {
        this.extending = extending;
        this.lastProgress = this.progress = extending ? 0 : 1;
        this.state = this.newState = extending ? 1 : 3;
        this.attachedBlocks = attachedBlocks;
        this.movable = false;

        this.level.addChunkPacket(this.getChunkX(), this.getChunkZ(), this.createSpawnPacket());
        this.lastProgress = extending ? -MOVE_STEP : 1 + MOVE_STEP;
        this.moveCollidedEntities();
        this.scheduleUpdate();
    }

    @Override
    public boolean onUpdate() {
        boolean hasUpdate = true;

        if (this.extending) {
            this.progress = Math.min(1, this.progress + MOVE_STEP);
            this.lastProgress = Math.min(1, this.lastProgress + MOVE_STEP);
        } else {
            this.progress = Math.max(0, this.progress - MOVE_STEP);
            this.lastProgress = Math.max(0, this.lastProgress - MOVE_STEP);
        }

        this.moveCollidedEntities();

        if (this.progress == this.lastProgress) {
            this.state = this.newState = extending ? 2 : 0;

            BlockFace pushDir = this.extending ? facing : facing.getOpposite();

            for (BlockVector3 pos : this.attachedBlocks) {
                BlockEntity movingBlock = this.level.getBlockEntity(pos.getSide(pushDir));

                if (movingBlock instanceof BlockEntityMovingBlock) {
                    movingBlock.close();
                    Block moved = movingBlock.getBlock();

                    this.level.setBlock(movingBlock, moved);

                    CompoundTag blockEntityNbt = ((BlockEntityMovingBlock) movingBlock).getBlockEntity();

                    if (blockEntityNbt != null) {
                        blockEntityNbt.putInt("x", movingBlock.getFloorX());
                        blockEntityNbt.putInt("y", movingBlock.getFloorY());
                        blockEntityNbt.putInt("z", movingBlock.getFloorZ());
                        BlockEntity blockEntity = BlockEntity.createBlockEntity(blockEntityNbt.getString("id"), this.level.getChunk(movingBlock.getChunkX(), movingBlock.getChunkZ()), blockEntityNbt);
                        if (blockEntity != null && blockEntity.getBlock() instanceof BlockChest chest) {
                            chest.tryPair();
                        }
                    }
                }
            }

            if (!extending) {
                if (this.level.getBlock(this.getSide(facing)).getId() == (sticky ? BlockID.PISTON_HEAD_STICKY : BlockID.PISTON_HEAD)) {
                    this.level.setBlock(this.getSide(facing), new BlockAir());
                }
                this.movable = true;
            }

            this.level.updateAroundObserver(this);

            this.level.scheduleUpdate(this.getLevelBlock(), 1);
            this.attachedBlocks.clear();
            hasUpdate = false;
        }

        this.level.addChunkPacket(getChunkX(), getChunkZ(), this.createSpawnPacket());
        return super.onUpdate() || hasUpdate;
    }

    private float getExtendedProgress(float progress) {
        return this.extending ? progress - 1 : 1 - progress;
    }

    @Override
    public void saveNBT() {
        super.saveNBT();
        this.namedTag.putByte("State", this.state);
        this.namedTag.putByte("NewState", this.newState);
        this.namedTag.putFloat("Progress", this.progress);
        this.namedTag.putFloat("LastProgress", this.lastProgress);
        this.namedTag.putBoolean("powered", this.powered);
        this.namedTag.putList(getAttachedBlocks());
        this.namedTag.putInt("facing", this.facing.getIndex());
        this.namedTag.putBoolean("Sticky", this.sticky);
        this.namedTag.putBoolean("Extending", this.extending);
    }

    @Override
    public CompoundTag getSpawnCompound() {
        return new CompoundTag()
                .putString("id", BlockEntity.PISTON_ARM)
                .putInt("x", (int) this.x)
                .putInt("y", (int) this.y)
                .putInt("z", (int) this.z)
                .putFloat("Progress", this.progress)
                .putFloat("LastProgress", this.lastProgress)
                .putBoolean("isMovable", this.movable)
                .putList(getAttachedBlocks())
                .putList(new ListTag<>("BreakBlocks"))
                .putBoolean("Sticky", this.sticky)
                .putByte("State", this.state)
                .putByte("NewState", this.newState);
    }

    private ListTag<IntTag> getAttachedBlocks() {
        ListTag<IntTag> attachedBlocks = new ListTag<>("AttachedBlocks");
        for (BlockVector3 block : this.attachedBlocks) {
            attachedBlocks.add(new IntTag("", block.x));
            attachedBlocks.add(new IntTag("", block.y));
            attachedBlocks.add(new IntTag("", block.z));
        }

        return attachedBlocks;
    }
}