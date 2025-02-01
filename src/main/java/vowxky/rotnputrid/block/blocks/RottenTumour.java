package vowxky.rotnputrid.block.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import vowxky.rotnputrid.block.entity.RottenTumourBlockEntity;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.util.RottenTumourUtils;
import vowxky.rotnputrid.util.Util;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenTumour extends BlockWithEntity implements BlockEntityProvider {

    public RottenTumour(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Util.isValidBlock(world.getBlockState(pos.down()).getBlock());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RottenTumourBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            RottenTumourBlockEntity blockEntity = (RottenTumourBlockEntity) serverWorld.getBlockEntity(pos);
            if (blockEntity != null) {
                blockEntity.setDecayTime(getRottenTime(world.getBlockState(pos.down()).getBlock()));
            }
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : (w, p, s, be) -> {
            if (be instanceof RottenTumourBlockEntity tumour && w instanceof ServerWorld serverWorld) {
                tumour.tick();
                applyDecayInRange(serverWorld, p);
            }
        };
    }

    private void applyDecayInRange(ServerWorld world, BlockPos pos) {
        int range = getRottenRange(world.getBlockState(pos.down()).getBlock());

        world.getEntitiesByClass(LivingEntity.class,
                        new Box(pos.add(-range, -range, -range), pos.add(range, range, range)),
                        entity -> entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT))
                .stream()
                .filter(entity -> {
                    StatusEffectInstance rotEffect = entity.getStatusEffect(RotnputridEffects.ROT_EFFECT);
                    return rotEffect != null && entity.getStatusEffect(RotnputridEffects.DECAY_EFFECT) == null;
                })
                .forEach(entity -> {
                    int decayDuration = Optional.ofNullable(entity.getStatusEffect(RotnputridEffects.ROT_EFFECT))
                            .map(StatusEffectInstance::getDuration)
                            .orElse(0) * 2;
                    entity.removeStatusEffect(RotnputridEffects.ROT_EFFECT);
                    entity.addStatusEffect(new StatusEffectInstance(RotnputridEffects.DECAY_EFFECT, decayDuration, 0));
                });
    }

    private int getRottenRange(Block blockBelow) {
        return RottenTumourUtils.getRottenRange(blockBelow);
    }

    private int getRottenTime(Block blockBelow) {
        return RottenTumourUtils.getRottenTime(blockBelow);
    }

    public static VoxelShape makeShape() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(-0.000625, -0.000625, -0.000625, 1.000625, 0.000625, 1.000625),
                VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.3125, 0.75)
        );
    }
}