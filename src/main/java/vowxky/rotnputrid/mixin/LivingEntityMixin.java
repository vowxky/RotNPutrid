package vowxky.rotnputrid.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import vowxky.rotnputrid.effect.RotnputridEffects;
import vowxky.rotnputrid.util.RottenArmorUtils;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Redirect(method = "getArmor", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"))
    private int modifyArmorValue(double value) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (hasRottenArmor(entity) && entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT) || entity.hasStatusEffect(RotnputridEffects.DECAY_EFFECT)) {
            return MathHelper.floor(value * 0.75);
        }
        return MathHelper.floor(value);
    }

    @Unique
    private boolean hasRottenArmor(LivingEntity entity) {
        return java.util.Arrays.stream(EquipmentSlot.values())
                .filter(slot -> slot.getType() == EquipmentSlot.Type.ARMOR)
                .map(entity::getEquippedStack)
                .map(ItemStack::getItem)
                .filter(item -> item instanceof ArmorItem)
                .map(item -> ((ArmorItem) item).getMaterial())
                .anyMatch(RottenArmorUtils::isRotAffected);
    }
}