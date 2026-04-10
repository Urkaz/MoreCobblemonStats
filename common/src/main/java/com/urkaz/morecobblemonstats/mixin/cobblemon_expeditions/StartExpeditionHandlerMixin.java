package com.urkaz.morecobblemonstats.mixin.cobblemon_expeditions;

import com.cobblemonexpeditions.network.c2s.StartExpeditionHandler;
import com.cobblemonexpeditions.network.c2s.StartExpeditionPayload;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_expeditions.MCS_CobblemonExpeditionsStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_CobblemonExpeditionsStats.MOD_ID)})
@Mixin(StartExpeditionHandler.class)
public class StartExpeditionHandlerMixin {

    @Inject(method = "handle$lambda$1",
            at = @At(value = "INVOKE",
                    target = "Lcom/cobblemonexpeditions/player/PlayerExpeditionData;addActiveExpedition(Lcom/cobblemonexpeditions/expedition/ExpeditionInstance;)V")
    )
    private static void mcs$startExpedition(ServerPlayer $player, StartExpeditionPayload $payload, CallbackInfo ci) {
        $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS));
    }
}
