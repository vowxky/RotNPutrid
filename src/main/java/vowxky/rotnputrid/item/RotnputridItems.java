package vowxky.rotnputrid.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.item.items.RottenGreatSword;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridItems {
    public static final Item ROTTEN_GREATSWORD = registerItem("rotten_greatsword",
            new RottenGreatSword(
                    RottenToolMaterial.INSTANCE,
                    6,
                    -2.8f,
                    new FabricItemSettings().maxCount(1).fireproof()
    ));
    public static final Item PUTRID_NETHERITE_INGOT = registerItem("putrid_netherite_ingot", new Item(new Item.Settings()));
    public static final Item PUTRID_UPGRADE_TEMPLATE = registerItem("putrid_upgrade_template", new Item(new Item.Settings()));
    public static final Item ROT_BOTTLE = registerItem("rot_bottle", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Constant.id(name), item);
    }

    public static void register() {
        Constant.LOGGER.info("Reg Items for " + Constant.MOD_ID);
    }
}
