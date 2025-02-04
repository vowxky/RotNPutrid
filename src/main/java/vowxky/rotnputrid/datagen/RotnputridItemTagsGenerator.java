package vowxky.rotnputrid.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridItemTagsGenerator extends FabricTagProvider.ItemTagProvider {


    public RotnputridItemTagsGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }


    @Override
    protected void generateTags() {
        TagKey<Item> BIG_WEAPONS = TagKey.of(Registry.ITEM_KEY, Constant.id("big_weapons"));

        getOrCreateTagBuilder(BIG_WEAPONS)
                .add(RotnputridItems.ROTTEN_GREATSWORD);
    }
}
