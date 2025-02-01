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
import vowxky.rotnputrid.util.Util;

import java.util.List;
import java.util.UUID;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenTumour extends BlockWithEntity implements BlockEntityProvider {

    private static final int DURATION_IRON = 2400;
    private static final int DURATION_COPPER = 400;
    private static final int DURATION_NETHERITE = 36000;

    private static final int RANGE_IRON = 5;
    private static final int RANGE_COPPER = 10;
    private static final int RANGE_NETHERITE = 20;

    public RottenTumour(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Util.isValidBlock(world.getBlockState(pos.down()).getBlock());
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
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
                blockEntity.setDecayTime(getDecayTime(world.getBlockState(pos.down()).getBlock()));
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
        int range = getDecayRange(world.getBlockState(pos.down()).getBlock());
        List<LivingEntity> entities = world.getEntitiesByClass(
                LivingEntity.class,
                new Box(pos.add(-range, -range, -range), pos.add(range, range, range)),
                entity -> entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT)
        );

        for (LivingEntity entity : entities) {
            StatusEffectInstance rotEffect = entity.getStatusEffect(RotnputridEffects.ROT_EFFECT);
            StatusEffectInstance decayEffect = entity.getStatusEffect(RotnputridEffects.DECAY_EFFECT);

            if (rotEffect != null && decayEffect == null) {
                int decayDuration = rotEffect.getDuration() * 2;
                entity.removeStatusEffect(RotnputridEffects.ROT_EFFECT);
                entity.addStatusEffect(new StatusEffectInstance(RotnputridEffects.DECAY_EFFECT, decayDuration, 0));
            }
        }
    }

    private int getDecayRange(Block blockBelow) {
        if (blockBelow == Blocks.IRON_BLOCK) return RANGE_IRON;
        if (blockBelow == Blocks.COPPER_BLOCK) return RANGE_COPPER;
        if (blockBelow == Blocks.NETHERITE_BLOCK) return RANGE_NETHERITE;
        return 0;
    }

    private int getDecayTime(Block blockBelow) {
        if (blockBelow == Blocks.IRON_BLOCK) return DURATION_IRON;
        if (blockBelow == Blocks.COPPER_BLOCK) return DURATION_COPPER;
        if (blockBelow == Blocks.NETHERITE_BLOCK) return DURATION_NETHERITE;
        return 0;
    }

    public static VoxelShape makeShape() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(-0.000625, -0.000625, -0.000625, 1.000625, 0.000625, 1.000625),
                VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.3125, 0.75)
        );
    }
}