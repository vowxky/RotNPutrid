package vowxky.rotnputrid.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.*;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import vowxky.rotnputrid.effect.RotnputridEffects;

import java.util.stream.StreamSupport;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Redirect(
            method = "applyArmorToDamage",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getArmor()I")
    )
    private int modifyArmorValue(LivingEntity entity) {
        int originalArmor = entity.getArmor();

        if (!(entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT) || entity.hasStatusEffect(RotnputridEffects.DECAY_EFFECT))) {
            return originalArmor;
        }

        if (StreamSupport.stream(entity.getArmorItems().spliterator(), false)
                .anyMatch(item -> item.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == ArmorMaterials.GOLD)) {
            return originalArmor;
        }

        return (int) (originalArmor * 0.5);
    }

    @ModifyVariable(
            method = "modifyAppliedDamage",
            at = @At("HEAD"),
            ordinal = 0
    )
    private float modifyDamageReduction(float amount, DamageSource source) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT) || entity.hasStatusEffect(RotnputridEffects.DECAY_EFFECT)) {
            return amount * 1.5f;
        }

        return amount;
    }
}