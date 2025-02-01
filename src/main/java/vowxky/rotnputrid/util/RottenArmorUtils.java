package vowxky.rotnputrid.util;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;

import java.util.HashSet;
import java.util.Set;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenArmorUtils {
    private static final Set<ArmorMaterials> METAL_ARMORS = new HashSet<>();

    public static void registerRottenArmor(ArmorMaterials material) {
        METAL_ARMORS.add(material);
    }

    public static boolean isRotAffected(ArmorMaterial material) {
        return (material instanceof ArmorMaterials armorMat) && METAL_ARMORS.contains(armorMat);
    }

    public static void registerDefaults() {
        registerRottenArmor(ArmorMaterials.IRON);
        registerRottenArmor(ArmorMaterials.CHAIN);
        registerRottenArmor(ArmorMaterials.NETHERITE);
    }
}