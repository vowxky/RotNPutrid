package vowxky.rotnputrid.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import vowxky.rotnputrid.data.lang.RotnputridEnglishLangProvider;
import vowxky.rotnputrid.data.lang.RotnputridRussianLangProvider;
import vowxky.rotnputrid.data.lang.RotnputridSpanishLangProvider;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(RotnputridRecipesGenerator::new);
        pack.addProvider(RotnputridLootTableGenerator::new);
        //lang
        pack.addProvider(RotnputridEnglishLangProvider::new);
        pack.addProvider(RotnputridSpanishLangProvider::new);
        pack.addProvider(RotnputridRussianLangProvider::new);
    }
}
