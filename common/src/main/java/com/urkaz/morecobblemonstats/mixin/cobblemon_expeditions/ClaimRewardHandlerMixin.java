package com.urkaz.morecobblemonstats.mixin.cobblemon_expeditions;

import com.cobblemonexpeditions.expedition.ExpeditionOutcome;
import com.cobblemonexpeditions.network.c2s.ClaimRewardHandler;
import com.cobblemonexpeditions.network.c2s.ClaimRewardPayload;
import com.cobblemonexpeditions.network.c2s.StartExpeditionHandler;
import com.cobblemonexpeditions.network.c2s.StartExpeditionPayload;
import com.cobblemonexpeditions.player.RewardBundle;
import com.llamalad7.mixinextras.sugar.Local;
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
@Mixin(ClaimRewardHandler.class)
public class ClaimRewardHandlerMixin {

    @Inject(method = "handle$lambda$0",
            at = @At(value = "INVOKE",
                    target = "Lcom/cobblemonexpeditions/player/RewardBundle;getPlayerXP()I")
    )
    private static void mcs$claimRewards(ServerPlayer $player, ClaimRewardPayload $payload, CallbackInfo ci, @Local(name = "reward") RewardBundle reward) {
        $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS_FINISHED));
        ExpeditionOutcome outcome = reward.getOutcome();
        switch (outcome) {
            case FAIL -> {
                $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS_FAILED));
            }
            case PARTIAL -> {
                $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS_PARTIAL));
            }
            case SUCCESS -> {
                $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS_SUCCESS));
            }
            case GREAT -> {
                $player.awardStat(MCS_Stats.getStat(MCS_CobblemonExpeditionsStats.EXPEDITIONS_GREAT));
            }
        }
    }
}
