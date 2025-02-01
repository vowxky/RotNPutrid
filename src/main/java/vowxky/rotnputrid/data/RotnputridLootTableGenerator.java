package vowxky.rotnputrid.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.function.BiConsumer;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridLootTableGenerator extends SimpleFabricLootTableProvider {
    public RotnputridLootTableGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator, LootContextTypes.CHEST);
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(LootTables.NETHER_BRIDGE_CHEST, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(RotnputridItems.PUTRID_UPGRADE_TEMPLATE)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .conditionally(RandomChanceLootCondition.builder(0.05F))
                        )
                )
        );
    }
}