package vowxky.rotnputrid.event;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import vowxky.rotnputrid.item.RotnputridItems;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class LootModification {
    public static void register() {
        LootTableEvents.MODIFY.register(LootModification::modifyLootTables);
    }

    private static void modifyLootTables(ResourceManager resourceManager, LootManager lootManager, Identifier identifier, LootTable.Builder builder, LootTableSource lootTableSource) {
        if (LootTables.NETHER_BRIDGE_CHEST.equals(identifier)) {
            LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1.0F))
                    .with(ItemEntry.builder(RotnputridItems.PUTRID_UPGRADE_TEMPLATE)
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                            .conditionally(RandomChanceLootCondition.builder(0.05F))
                    );

            builder.pool(poolBuilder);
        }
    }
}