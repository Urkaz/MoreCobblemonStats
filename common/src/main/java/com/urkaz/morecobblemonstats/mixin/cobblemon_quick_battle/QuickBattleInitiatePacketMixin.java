package com.urkaz.morecobblemonstats.mixin.cobblemon_quick_battle;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_quick_battle.MCS_CobblemonQuickBattleStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quick.battle.battle.QuickBattleResult;
import quick.battle.network.QuickBattleInitiatePacket;

@Restriction(require = {@Condition(MCS_CobblemonQuickBattleStats.MOD_ID)})
@Mixin(QuickBattleInitiatePacket.class)
public class QuickBattleInitiatePacketMixin {

    @Inject(
            method = "lambda$handle$1",
            at = @At(value = "INVOKE",
                    target = "Lquick/battle/integration/CobblemonIntegration;getDisplayName(Ljava/lang/Object;)Ljava/lang/String;",
                    ordinal = 0
            ),
            remap = false
    )
    private static void mcs$quickBattleResult(Object finalSelectedMove, ServerPlayer player, Object finalSelectedPokemon, Object finalTargetPokemon, Entity finalTarget, CallbackInfo ci, @Local(name = "result") QuickBattleResult result) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonQuickBattleStats.QUICK_BATTLE_TOTAL));
        if (result.isVictory()) {
            player.awardStat(MCS_Stats.getStat(MCS_CobblemonQuickBattleStats.QUICK_BATTLE_WON));
        } else {
            player.awardStat(MCS_Stats.getStat(MCS_CobblemonQuickBattleStats.QUICK_BATTLE_LOST));
        }
    }
}
