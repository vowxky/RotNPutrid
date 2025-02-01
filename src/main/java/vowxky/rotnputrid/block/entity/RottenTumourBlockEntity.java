package vowxky.rotnputrid.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenTumourBlockEntity extends BlockEntity{
    private int decayTime = 0;
    private int maxDecayTime = 0;

    public RottenTumourBlockEntity(BlockPos pos, BlockState state) {
        super(RotnputridBlocksEntities.ROTTEN_TUMOUR_BLOCK_ENTITY, pos, state);
    }

    public void setDecayTime(int ticks) {
        this.decayTime = ticks;
        this.maxDecayTime = ticks;
        markDirty();
    }

    public void tick() {
        if (world != null && !world.isClient()) {
            if (decayTime > 0) {
                decayTime--;
                markDirty();
            }

            if (decayTime % 20 == 0) {
                spawnDecayParticles();
            }


            if (decayTime <= 0) {
                if (world instanceof ServerWorld serverWorld) {
                    BlockPos belowPos = pos.down();
                    serverWorld.breakBlock(pos, false);
                    serverWorld.breakBlock(belowPos, false);
                }
            }
        }
    }

    private void spawnDecayParticles() {
        if (world instanceof ServerWorld serverWorld) {
            for (int i = 0; i < 5; i++) {
                double offsetX = (world.random.nextDouble() - 0.5) * 0.5;
                double offsetY = world.random.nextDouble() * 0.5;
                double offsetZ = (world.random.nextDouble() - 0.5) * 0.5;

                serverWorld.spawnParticles(
                        ParticleTypes.SMOKE,
                        pos.getX() + 0.5 + offsetX,
                        pos.getY() + 0.5 + offsetY,
                        pos.getZ() + 0.5 + offsetZ,
                        1,
                        0.1, 0.1, 0.1,
                        0.02
                );
            }
        }
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("DecayTime", decayTime);
        tag.putInt("DecayTimeMaxTime", maxDecayTime);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        decayTime = tag.getInt("DecayTime");
        maxDecayTime = tag.getInt("DecayTimeMaxTime");
    }
}