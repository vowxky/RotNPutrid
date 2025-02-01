package vowxky.rotnputrid.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class Util {
    public static boolean isValidBlock(Block block) {
        return block == Blocks.IRON_BLOCK || block == Blocks.NETHERITE_BLOCK || block == Blocks.COPPER_BLOCK;
    }
}
