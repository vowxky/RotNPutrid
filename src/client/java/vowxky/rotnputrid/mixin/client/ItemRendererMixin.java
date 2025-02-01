package vowxky.rotnputrid.mixin.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.item.RotnputridItems;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(RotnputridItems.ROTTEN_GREATSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).renderer$getModels().getModelManager().getModel(new ModelIdentifier(Constant.MOD_ID, "rotten_greatsword_alt", "inventory"));
        }
        return value;
    }
}