package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariStats;
import maxigregrze.cobblesafari.CobbleSafari;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_CobbleSafariStats.MOD_ID)})
@Mixin(value = CobbleSafari.class)
public class CobbleSafariMixin {

    @Inject(method = "init", at = @At("TAIL"), remap = false)
    private static void mcs$afterInit(CallbackInfo ci) {
        MCS_Stats.registerCobblesafariDynamicStats();
    }
}
