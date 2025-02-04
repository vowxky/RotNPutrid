package vowxky.rotnputrid.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.block.RotnputridBlocks;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridBlocksEntities {
    public static final BlockEntityType<RottenTumourBlockEntity> ROTTEN_TUMOUR_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, Constant.id("rotten_tumour_block_entity"),
                    FabricBlockEntityTypeBuilder.create(RottenTumourBlockEntity::new,
                            RotnputridBlocks.ROTTEN_TUMOUR).build());

    public static void register() {
        Constant.LOGGER.info("Reg BlocksEntities for " + Constant.MOD_ID);
    }
}
