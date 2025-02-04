package vowxky.rotnputrid.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
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
                    5,
                    -2.9f,
                    new FabricItemSettings().maxCount(1).fireproof().group(RotnputridItemGroup.ROTN_GROUP)
    ));
    public static final Item PUTRID_NETHERITE_INGOT = registerItem("putrid_netherite_ingot", new Item(new Item.Settings().group(RotnputridItemGroup.ROTN_GROUP)));
    public static final Item ROT_BOTTLE = registerItem("rot_bottle", new Item(new Item.Settings().group(RotnputridItemGroup.ROTN_GROUP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, Constant.id(name), item);
    }

    public static void register() {
        Constant.LOGGER.info("Reg Items for " + Constant.MOD_ID);
    }
}
