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
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(RotnputridRecipesGenerator::new);
        pack.addProvider(RotnputridItemTagsGenerator::new);
        //lang
        pack.addProvider(RotnputridEnglishLangProvider::new);
        pack.addProvider(RotnputridSpanishLangProvider::new);
        pack.addProvider(RotnputridRussianLangProvider::new);
    }
}
