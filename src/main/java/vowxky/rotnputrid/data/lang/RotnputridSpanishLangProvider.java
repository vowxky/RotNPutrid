package vowxky.rotnputrid.data.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridSpanishLangProvider extends FabricLanguageProvider {
    public RotnputridSpanishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "es_es");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.rotnputrid", "Rot N' Putrid");

        // Ítems
        translationBuilder.add("item.rotnputrid.rotten_greatsword", "Espada Putrefacta");
        translationBuilder.add("item.rotnputrid.netherite_greatsword", "Gran Espada de Netherite");
        translationBuilder.add("item.rotnputrid.putrid_netherite_ingot", "Lingote de Netherite Pútrido");
        translationBuilder.add("item.rotnputrid.putrid_upgrade_template", "Plantilla de Mejora Pútrida");
        translationBuilder.add("item.rotnputrid.rot_bottle", "Botella de Putrefacción");

        // Bloques
        translationBuilder.add("block.rotnputrid.rotten_tumour", "Tumor Pútrido");

        // Efectos
        translationBuilder.add("effect.rotnputrid.rot", "Putrefacción");
        translationBuilder.add("effect.rotnputrid.purity", "Pureza");
        translationBuilder.add("effect.rotnputrid.decay", "Decadencia");

        // Pociones - Putrefacción
        translationBuilder.add("item.minecraft.potion.effect.rot_potion", "Poción de Putrefacción");
        translationBuilder.add("item.minecraft.splash_potion.effect.rot_potion", "Poción Arrojadiza de Putrefacción");
        translationBuilder.add("item.minecraft.lingering_potion.effect.rot_potion", "Poción Persistente de Putrefacción");

        translationBuilder.add("item.minecraft.potion.effect.long_rot_potion", "Poción de Putrefacción Prolongada");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_rot_potion", "Poción Arrojadiza de Putrefacción Prolongada");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_rot_potion", "Poción Persistente de Putrefacción Prolongada");

        // Pociones - Pureza
        translationBuilder.add("item.minecraft.potion.effect.purity_potion", "Poción de Pureza");
        translationBuilder.add("item.minecraft.splash_potion.effect.purity_potion", "Poción Arrojadiza de Pureza");
        translationBuilder.add("item.minecraft.lingering_potion.effect.purity_potion", "Poción Persistente de Pureza");

        translationBuilder.add("item.minecraft.potion.effect.long_purity_potion", "Poción de Pureza Prolongada");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_purity_potion", "Poción Arrojadiza de Pureza Prolongada");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_purity_potion", "Poción Persistente de Pureza Prolongada");
    }
}