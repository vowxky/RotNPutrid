package vowxky.rotnputrid.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.RotnputridBlocks;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.function.Consumer;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridRecipesGenerator extends FabricRecipeProvider {


    public RotnputridRecipesGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> consumer) {

        SmithingRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_SWORD), // Base (espada netherite)
                        Ingredient.ofItems(RotnputridItems.PUTRID_NETHERITE_INGOT), // Material de mejora
                        RotnputridItems.ROTTEN_GREATSWORD) // Resultado
                .criterion("has_putrid_netherite_ingot", conditionsFromItem(RotnputridItems.PUTRID_NETHERITE_INGOT))
                .criterion("has_netherite_sword", conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(consumer, Constant.id("rotten_greatsword"));


        // Receta shapeless para Putrid Netherite Ingot
        ShapelessRecipeJsonBuilder.create(RotnputridItems.PUTRID_NETHERITE_INGOT)
                .input(Items.NETHERITE_INGOT)
                .input(RotnputridItems.ROT_BOTTLE)
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion("has_rot_bottle", conditionsFromItem(RotnputridItems.ROT_BOTTLE))
                .offerTo(consumer, Constant.id("putrid_netherite_ingot"));

        // Receta shaped para Rotten Tumour
        ShapedRecipeJsonBuilder.create(RotnputridBlocks.ROTTEN_TUMOUR.asItem())
                .pattern(" R ")
                .pattern("RIR")
                .pattern(" R ")
                .input('I', Items.IRON_BLOCK)
                .input('R', RotnputridItems.ROT_BOTTLE)
                .criterion("has_iron_block", conditionsFromItem(Items.IRON_BLOCK))
                .criterion("has_rot_bottle", conditionsFromItem(RotnputridItems.ROT_BOTTLE))
                .offerTo(consumer, Constant.id("rotten_tumour"));

        // Receta shaped para Rot Bottle
        ShapedRecipeJsonBuilder.create(RotnputridItems.ROT_BOTTLE)
                .pattern("NNN")
                .pattern("NTN")
                .pattern("NNN")
                .input('N', Items.NETHERRACK)
                .input('T', Items.GLASS_BOTTLE)
                .criterion("has_netherrack", conditionsFromItem(Items.NETHERRACK))
                .criterion("has_glass_bottle", conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(consumer, Constant.id("rot_bottle"));
    }
}