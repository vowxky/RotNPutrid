package vowxky.rotnputrid.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridRussianLangProvider extends FabricLanguageProvider {
    public RotnputridRussianLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, "ru_ru");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.rotnputrid.rotnputrid", "Гнилостная гниль");

        // Предметы
        translationBuilder.add("item.rotnputrid.rotten_greatsword", "Гнилой двуручный меч");
        translationBuilder.add("item.rotnputrid.netherite_greatsword", "Незеритовый двуручный меч");
        translationBuilder.add("item.rotnputrid.putrid_netherite_ingot", "Гнилостный незеритовый слиток");
        translationBuilder.add("item.rotnputrid.putrid_upgrade_template", "Шаблон гнилого улучшения");
        translationBuilder.add("item.rotnputrid.rot_bottle", "Бутылка гнили");

        // Блоки
        translationBuilder.add("block.rotnputrid.rotten_tumour", "Гнилостная опухоль");

        // Эффекты
        translationBuilder.add("effect.rotnputrid.rot", "Гниение");
        translationBuilder.add("effect.rotnputrid.purity", "Чистота");
        translationBuilder.add("effect.rotnputrid.decay", "Разложение");

        // Зелья - Гниение
        translationBuilder.add("item.minecraft.potion.effect.rot_potion", "Зелье гниения");
        translationBuilder.add("item.minecraft.splash_potion.effect.rot_potion", "Взрывное зелье гниения");
        translationBuilder.add("item.minecraft.lingering_potion.effect.rot_potion", "Долговременное зелье гниения");

        translationBuilder.add("item.minecraft.potion.effect.long_rot_potion", "Долгое зелье гниения");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_rot_potion", "Долгое взрывное зелье гниения");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_rot_potion", "Долгое долговременное зелье гниения");

        // Зелья - Чистота
        translationBuilder.add("item.minecraft.potion.effect.purity_potion", "Зелье чистоты");
        translationBuilder.add("item.minecraft.splash_potion.effect.purity_potion", "Взрывное зелье чистоты");
        translationBuilder.add("item.minecraft.lingering_potion.effect.purity_potion", "Долговременное зелье чистоты");

        translationBuilder.add("item.minecraft.potion.effect.long_purity_potion", "Долгое зелье чистоты");
        translationBuilder.add("item.minecraft.splash_potion.effect.long_purity_potion", "Долгое взрывное зелье чистоты");
        translationBuilder.add("item.minecraft.lingering_potion.effect.long_purity_potion", "Долгое долговременное зелье чистоты");

        // Стрелы с эффектами
        translationBuilder.add("item.minecraft.tipped_arrow.effect.rot_potion", "Стрела гниения");
        translationBuilder.add("item.minecraft.tipped_arrow.effect.long_rot_potion", "Стрела длительного гниения");

        translationBuilder.add("item.minecraft.tipped_arrow.effect.purity_potion", "Стрела чистоты");
        translationBuilder.add("item.minecraft.tipped_arrow.effect.long_purity_potion", "Стрела длительной чистоты");
    }
}