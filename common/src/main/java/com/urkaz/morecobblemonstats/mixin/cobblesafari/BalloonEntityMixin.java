package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import maxigregrze.cobblesafari.entity.BalloonEntity;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(value = BalloonEntity.class, remap = false)
public class BalloonEntityMixin {

    @Inject(method = "dropBalloonLoot", at = @At("HEAD"))
    private static void mcs$dropBalloonLoot(CallbackInfo ci, @Local(argsOnly = true) Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.awardStat(MCS_Stats.getStat(MCS_Stats.SAFARI_BALLOON_DROP));
        }
    }
}
