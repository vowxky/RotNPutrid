package vowxky.rotnputrid.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.RotnputridBlocks;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridItemGroup {
    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Constant.id(""),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rotnputrid"))
                    .icon(() -> new ItemStack(RotnputridBlocks.ROTTEN_TUMOUR)).entries((displayContext, entries) -> {
                        entries.add(RotnputridItems.ROTTEN_GREATSWORD);
                        entries.add(RotnputridItems.PUTRID_NETHERITE_INGOT);
                        entries.add(RotnputridItems.PUTRID_UPGRADE_TEMPLATE);
                        entries.add(RotnputridItems.ROT_BOTTLE);
                    }).build());


    public static void register() {
        Constant.LOGGER.info("Reg ItemGroup for " + Constant.MOD_ID);
    }
}
