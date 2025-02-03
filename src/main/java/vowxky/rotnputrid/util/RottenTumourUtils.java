package vowxky.rotnputrid.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import vowxky.rotnputrid.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenTumourUtils {
    private static final Map<Block, RottenEffectData> ROTTEN_EFFECTS = new HashMap<>();

    public static void registerRottenBlock(Block block, int duration, int range) {
        if (ROTTEN_EFFECTS.containsKey(block)) {
            Constant.LOGGER.warn("Block {} is already registered and will not be overwritten.", block);
            return;
        }
        ROTTEN_EFFECTS.put(block, new RottenEffectData(duration, range));
    }

    public static int getRottenRange(Block block) {
        return ROTTEN_EFFECTS.getOrDefault(block, new RottenEffectData(0, 0)).getRange();
    }

    public static int getRottenTime(Block block) {
        return ROTTEN_EFFECTS.getOrDefault(block, new RottenEffectData(0, 0)).getDuration();
    }

    public static boolean isValidBlock(Block block) {
        return ROTTEN_EFFECTS.containsKey(block);
    }

    public static void registerDefaults() {
        registerRottenBlock(Blocks.IRON_BLOCK, 2400, 5);
        registerRottenBlock(Blocks.COPPER_BLOCK, 400, 10);
        registerRottenBlock(Blocks.EXPOSED_COPPER, 400, 10);
        registerRottenBlock(Blocks.WEATHERED_COPPER, 400, 10);
        registerRottenBlock(Blocks.OXIDIZED_COPPER, 400, 10);
        registerRottenBlock(Blocks.NETHERITE_BLOCK, 36000, 20);
    }
}