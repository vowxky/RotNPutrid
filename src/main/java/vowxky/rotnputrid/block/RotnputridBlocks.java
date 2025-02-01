package vowxky.rotnputrid.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.blocks.RottenTumour;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridBlocks {
    public static final Block ROTTEN_TUMOUR = registerBlock("rotten_tumour",
            new RottenTumour(FabricBlockSettings.copyOf(Blocks.NETHERRACK)
                    .requiresTool()
                    .strength(0.4f, 0.4f)
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Constant.id(name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Constant.id(name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void register() {
        Constant.LOGGER.info("Reg Blocks for " + Constant.MOD_ID);
    }
}
