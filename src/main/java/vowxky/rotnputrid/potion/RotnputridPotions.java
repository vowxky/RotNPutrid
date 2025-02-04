package vowxky.rotnputrid.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.util.registry.Registry;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.item.RotnputridItems;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridPotions {
    public static final Potion ROT_POTION = registerPotion("rot_potion", new Potion(new StatusEffectInstance(RotnputridEffects.ROT_EFFECT, 600, 0)));
    public static final Potion LONG_ROT_POTION = registerPotion("long_rot_potion", new Potion(new StatusEffectInstance(RotnputridEffects.ROT_EFFECT, 2400, 0)));
    public static final Potion PURITY_POTION = registerPotion("purity_potion", new Potion(new StatusEffectInstance(RotnputridEffects.PURITY_EFFECT, 600, 0)));
    public static final Potion LONG_PURITY_POTION = registerPotion("long_purity_potion", new Potion(new StatusEffectInstance(RotnputridEffects.PURITY_EFFECT, 2400, 0)));

    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, Constant.id(name), potion);
    }

    public static void register() {
        Constant.LOGGER.info("Reg Potions for " + Constant.MOD_ID);
    }

    public static void registerRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, RotnputridItems.ROT_BOTTLE, ROT_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(ROT_POTION, Items.REDSTONE, LONG_ROT_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.GOLDEN_APPLE, PURITY_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(PURITY_POTION, Items.REDSTONE, LONG_PURITY_POTION);
    }
}
