package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariStats;
import maxigregrze.cobblesafari.teleporter.TeleporterTickHandler;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(TeleporterTickHandler.class)
public class TeleporterTickHandlerMixin {

    @Inject(
            method = "teleportToSafari",
            at = @At("HEAD")
    )
    private static void mcs$teleportToSafari(CallbackInfo ci, @Local(argsOnly = true) ServerPlayer player) {
        player.awardStat(MCS_Stats.getStat(MCS_CobbleSafariStats.SAFARI_ENTER));
    }
}
