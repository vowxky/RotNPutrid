package vowxky.rotnputrid.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.RotnputridBlocks;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridItemGroup {
    public static final ItemGroup ROTN_GROUP = FabricItemGroupBuilder.build(
            Constant.id(Constant.MOD_ID), () -> new ItemStack(RotnputridBlocks.ROTTEN_TUMOUR));
}
