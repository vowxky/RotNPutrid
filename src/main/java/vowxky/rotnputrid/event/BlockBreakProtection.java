package vowxky.rotnputrid.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vowxky.rotnputrid.block.blocks.RottenTumour;
import vowxky.rotnputrid.util.RottenTumourUtils;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */


public class BlockBreakProtection {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register(BlockBreakProtection::onBlockBreak);
    }

    private static boolean onBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (world instanceof ServerWorld) {
            BlockState aboveState = world.getBlockState(pos.up());

            return !RottenTumourUtils.isValidBlock(state.getBlock()) || !(aboveState.getBlock() instanceof RottenTumour);
        }
        return true;
    }
}