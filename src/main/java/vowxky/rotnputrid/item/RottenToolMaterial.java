package vowxky.rotnputrid.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public enum RottenToolMaterial implements ToolMaterial {
    INSTANCE;

    @Override
    public int getDurability() {
        return 2031;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0f;
    }

    @Override
    public float getAttackDamage() {
        return 2f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RotnputridItems.PUTRID_NETHERITE_INGOT);
    }
}
