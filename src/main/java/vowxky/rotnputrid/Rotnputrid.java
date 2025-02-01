package vowxky.rotnputrid;

import net.fabricmc.api.ModInitializer;
import vowxky.rotnputrid.block.RotnputridBlocks;
import vowxky.rotnputrid.block.entity.RotnputridBlocksEntities;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.event.BlockBreakProtection;
import vowxky.rotnputrid.event.RottenGreatswordHandler;
import vowxky.rotnputrid.item.RotnputridItemGroup;
import vowxky.rotnputrid.item.RotnputridItems;
import vowxky.rotnputrid.potion.RotnputridPotions;

public class Rotnputrid implements ModInitializer {

    @Override
    public void onInitialize() {
        RotnputridItems.register();
        RotnputridBlocks.register();
        RotnputridBlocksEntities.register();
        RotnputridItemGroup.register();
        RotnputridEffects.register();
        RotnputridPotions.register();
        RottenGreatswordHandler.register();
        BlockBreakProtection.register();
        RotnputridPotions.registerRecipes();
    }
}
