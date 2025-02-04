package vowxky.rotnputrid.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.registry.Registry;
import vowxky.rotnputrid.Constant;
import vowxky.rotnputrid.effect.effects.DecayEffect;
import vowxky.rotnputrid.effect.effects.PurityEffect;
import vowxky.rotnputrid.effect.effects.RotEffect;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RotnputridEffects {
    public static final StatusEffect ROT_EFFECT = registerStatusEffect("rot", new RotEffect());
    public static final StatusEffect PURITY_EFFECT = registerStatusEffect("purity", new PurityEffect());
    public static final StatusEffect DECAY_EFFECT = registerStatusEffect("decay", new DecayEffect());

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, Constant.id(name), effect);
    }

    public static void register() {
        Constant.LOGGER.info("Reg Effects for " + Constant.MOD_ID);
    }
}
