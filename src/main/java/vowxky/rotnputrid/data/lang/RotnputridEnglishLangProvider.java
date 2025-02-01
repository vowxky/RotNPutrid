package vowxky.rotnputrid.data.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridEnglishLangProvider extends FabricLanguageProvider {
    public RotnputridEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.rotnputrid", "Rot N' Putrid");

        // Items
        translationBuilder.add("item.rotnputrid.rotten_greatsword", "Rotten Greatsword");
        translationBuilder.add("item.rotnputrid.netherite_greatsword", "Netherite Greatsword");
        translationBuilder.add("item.rotnputrid.putrid_netherite_ingot", "Putrid Netherite Ingot");
        translationBuilder.add("item.rotnputrid.putrid_upgrade_template", "Putrid Upgrade Template");
        translationBuilder.add("item.rotnputrid.rot_bottle", "Rot Bottle");

        // Blocks
        translationBuilder.add("block.rotnputrid.rotten_tumour", "Rotten Tumour");

        // Effects
        translationBuilder.add("effect.rotnputrid.rot", "Rot");
        translationBuilder.add("effect.rotnputrid.purity", "Purity");
        translationBuilder.add("effect.rotnputrid.decay", "Decay");

        // Potions - ROT
        translationBuilder.add("item.minecraft.potion.effect.rot_potion", "Potion of Rotting");
        translationBuilder.add("item.minecraft.splash_potion.effect.rot_potion", "Splash Potion of Rotting");
        translationBuilder.add("item.minecraft.lingering_potion.effect.rot_potion", "Lingering Potion of Rotting");

        translationBuilder.add("item.minecraft.potion.effect.long_rot_potion", "Potion of Extended Rotting");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_rot_potion", "Splash Potion of Extended Rotting");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_rot_potion", "Lingering Potion of Extended Rotting");

        // Potions - PURITY
        translationBuilder.add("item.minecraft.potion.effect.purity_potion", "Potion of Purity");
        translationBuilder.add("item.minecraft.splash_potion.effect.purity_potion", "Splash Potion of Purity");
        translationBuilder.add("item.minecraft.lingering_potion.effect.purity_potion", "Lingering Potion of Purity");

        translationBuilder.add("item.minecraft.potion.effect.long_purity_potion", "Potion of Extended Purity");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_purity_potion", "Splash Potion of Extended Purity");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_purity_potion", "Lingering Potion of Extended Purity");
    }
}