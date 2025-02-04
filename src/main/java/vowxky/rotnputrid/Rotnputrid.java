package vowxky.rotnputrid;

import net.fabricmc.api.ModInitializer;
import vowxky.rotnputrid.block.RotnputridBlocks;
import vowxky.rotnputrid.block.entity.RotnputridBlocksEntities;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.event.BlockBreakProtection;
import vowxky.rotnputrid.event.RottenGreatswordHandler;
import vowxky.rotnputrid.item.RotnputridItems;
import vowxky.rotnputrid.potion.RotnputridPotions;
import vowxky.rotnputrid.util.RottenArmorUtils;
import vowxky.rotnputrid.util.RottenTumourUtils;

public class Rotnputrid implements ModInitializer {

    @Override
    public void onInitialize() {
        RottenTumourUtils.registerDefaults();
        RottenArmorUtils.registerDefaults();
        RotnputridItems.register();
        RotnputridBlocks.register();
        RotnputridBlocksEntities.register();
        RotnputridEffects.register();
        RotnputridPotions.register();
        RottenGreatswordHandler.register();
        BlockBreakProtection.register();
        RotnputridPotions.registerRecipes();
    }
}
