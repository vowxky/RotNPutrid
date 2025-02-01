package vowxky.rotnputrid.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import vowxky.rotnputrid.effect.RotnputridEffects;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class PurityEffect extends StatusEffect {
    public PurityEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFFEDC5);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(RotnputridEffects.ROT_EFFECT)) {
            entity.removeStatusEffect(RotnputridEffects.ROT_EFFECT);
        }
        if (entity.hasStatusEffect(RotnputridEffects.DECAY_EFFECT)) {
            entity.removeStatusEffect(RotnputridEffects.DECAY_EFFECT);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
