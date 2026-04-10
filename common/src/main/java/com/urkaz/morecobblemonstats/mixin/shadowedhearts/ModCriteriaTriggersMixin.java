package com.urkaz.morecobblemonstats.mixin.shadowedhearts;

import com.jayemceekay.shadowedhearts.advancements.ModCriteriaTriggers;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.shadowedhearts.MCS_ShadowedHeartsStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_ShadowedHeartsStats.MOD_ID)})
@Mixin(ModCriteriaTriggers.class)
public class ModCriteriaTriggersMixin {

    @Inject(
            method = "triggerShadowPurified",
            at = @At(value = "HEAD")
    )
    private static void mcs$shadowPurified(ServerPlayer player, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_ShadowedHeartsStats.SHADOW_POKEMON_PURIFIED));
    }

    @Inject(
            method = "triggerWildShadowDefeated",
            at = @At(value = "HEAD")
    )
    private static void mcs$shadowDefeated(ServerPlayer player, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_ShadowedHeartsStats.SHADOW_POKEMON_DEFEATED));
    }
}
