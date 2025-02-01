package vowxky.rotnputrid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import vowxky.rotnputrid.block.RotnputridBlocks;

public class RotnputridClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RotnputridBlocks.ROTTEN_TUMOUR, RenderLayer.getTranslucent());
    }
}
