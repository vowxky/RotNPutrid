package vowxky.rotnputrid.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import vowxky.rotnputrid.datagen.lang.RotnputridEnglishLangProvider;
import vowxky.rotnputrid.datagen.lang.RotnputridRussianLangProvider;
import vowxky.rotnputrid.datagen.lang.RotnputridSpanishLangProvider;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.addProvider(RotnputridRecipesGenerator::new);
        generator.addProvider(RotnputridItemTagsGenerator::new);
        //lang
        generator.addProvider(RotnputridEnglishLangProvider::new);
        generator.addProvider(RotnputridSpanishLangProvider::new);
        generator.addProvider(RotnputridRussianLangProvider::new);
    }
}
