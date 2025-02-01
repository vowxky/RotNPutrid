package vowxky.rotnputrid.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import vowxky.rotnputrid.effect.RotnputridEffects;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class DecayEffect extends StatusEffect {

    public DecayEffect() {
        super(StatusEffectCategory.HARMFUL, 0x4B0082);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            if (entity.age % 20 == 0) {
                entity.damage(entity.getDamageSources().magic(), 2.0F);
            }
        }

        if (entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT)) {
            entity.removeStatusEffect(RotnputridEffects.ROT_EFFECT);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}