package vowxky.rotnputrid.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vowxky.rotnputrid.item.RotnputridItems;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow private GameMode gameMode;

    @Inject(method = "getReachDistance", at = @At("HEAD"), cancellable = true)
    private void modifyInteractionDistance(CallbackInfoReturnable<Float> cir) {
        ClientPlayerEntity player = client.player;
        if (player != null) {
            ItemStack mainHandStack = player.getMainHandStack();
            ItemStack offHandStack = player.getOffHandStack();

            if (mainHandStack.getItem() == RotnputridItems.ROTTEN_GREATSWORD || offHandStack.getItem() == RotnputridItems.ROTTEN_GREATSWORD) {
                float reach = (this.gameMode.isCreative() ? 5.0F : 4.5F) + 0.5F;
                cir.setReturnValue(reach);
            }
        }
    }
}
