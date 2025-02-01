package vowxky.rotnputrid.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.item.RotnputridItems;

import java.util.*;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */


public class RottenGreatswordHandler {
    private static final int ROT_EFFECT_DURATION = 80;
    private static final Set<UUID> affectedPlayers = new HashSet<>();

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(RottenGreatswordHandler::onServerTick);
    }

    private static void onServerTick(ServerWorld world) {
        for (PlayerEntity player : world.getPlayers()) {
            handlePlayerEffect(player);
        }
    }

    private static void handlePlayerEffect(PlayerEntity player) {
        UUID playerId = player.getUuid();
        ItemStack mainHandItem = player.getStackInHand(Hand.MAIN_HAND);

        if (mainHandItem.getItem() == RotnputridItems.ROTTEN_GREATSWORD) {
            if (!affectedPlayers.contains(playerId)) {
                player.addStatusEffect(new StatusEffectInstance(RotnputridEffects.ROT_EFFECT, ROT_EFFECT_DURATION, 0));
                affectedPlayers.add(playerId);
            }
        } else {
            affectedPlayers.remove(playerId);
        }
    }
}