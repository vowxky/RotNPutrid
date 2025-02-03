package vowxky.rotnputrid.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.RotnputridBlocks;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.function.Consumer;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridRecipesGenerator extends FabricRecipeProvider {
    public RotnputridRecipesGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(RotnputridItems.PUTRID_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(RotnputridItems.PUTRID_NETHERITE_INGOT),
                        Ingredient.ofItems(Items.NETHERITE_SWORD),
                        RecipeCategory.COMBAT, RotnputridItems.ROTTEN_GREATSWORD
                )
                .criterion("has_putrid_netherite_ingot", conditionsFromItem(RotnputridItems.PUTRID_NETHERITE_INGOT))
                .criterion("has_putrid_upgrade_template", conditionsFromItem(RotnputridItems.PUTRID_UPGRADE_TEMPLATE))
                .offerTo(consumer, Constant.id("rotten_greatsword"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, RotnputridItems.PUTRID_NETHERITE_INGOT)
                .input(Items.NETHERITE_INGOT)
                .input(RotnputridItems.ROT_BOTTLE)
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_rot_bottle", conditionsFromItem(RotnputridItems.ROT_BOTTLE))
                .offerTo(consumer, Constant.id("putrid_netherite_ingot"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, RotnputridBlocks.ROTTEN_TUMOUR.asItem())
                .pattern(" R ")
                .pattern("RIR")
                .pattern(" R ")
                .input('I', Items.IRON_BLOCK)
                .input('R', RotnputridItems.ROT_BOTTLE)
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .criterion("has_rot_bottle", conditionsFromItem(RotnputridItems.ROT_BOTTLE))
                .offerTo(consumer, Constant.id("rotten_tumour"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RotnputridItems.ROT_BOTTLE)
                .pattern("NNN")
                .pattern("NTN")
                .pattern("NNN")
                .input('N', Items.NETHERRACK)
                .input('T', Items.GLASS_BOTTLE)
                .criterion("has_netherrack", conditionsFromItem(Items.NETHERRACK))
                .criterion("has_thick_potion", conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(consumer, Constant.id("rot_bottle"));
    }
}