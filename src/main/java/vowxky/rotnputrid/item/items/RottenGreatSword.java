package vowxky.rotnputrid.item.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import vowxky.rotnputrid.effect.RotnputridEffects;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class RottenGreatSword extends SwordItem {
    private static final int ROT_DURATION = 200;
    private static final int COOLDOWN_TICKS = 80;

    public RottenGreatSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                target.addStatusEffect(new StatusEffectInstance(RotnputridEffects.ROT_EFFECT, ROT_DURATION, 0));
                player.getItemCooldownManager().set(this, COOLDOWN_TICKS);
            }
        }
        return super.postHit(stack, target, attacker);
    }

}