package vowxky.rotnputrid.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
    public RotnputridItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        TagKey<Item> BIG_WEAPONS = TagKey.of(RegistryKeys.ITEM, Constant.id("big_weapons"));

        getOrCreateTagBuilder(BIG_WEAPONS)
                .add(RotnputridItems.ROTTEN_GREATSWORD);
    }
}
