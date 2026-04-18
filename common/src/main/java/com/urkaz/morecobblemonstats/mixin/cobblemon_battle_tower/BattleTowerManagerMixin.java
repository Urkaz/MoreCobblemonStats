package com.urkaz.morecobblemonstats.mixin.cobblemon_battle_tower;

import battle.tower.battle.BattleTowerManager;
import battle.tower.data.PlayerTowerData;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.extensions.ServerPlayerExtensions;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_battle_tower.MCS_CobblemonBattleTowerStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_CobblemonBattleTowerStats.MOD_ID)})
@Mixin(BattleTowerManager.class)
public class BattleTowerManagerMixin {

    @Inject(method = "onBattleWin",
            at = @At(value = "INVOKE", target = "Lbattle/tower/data/TowerDataManager;savePlayerData(Ljava/util/UUID;)V"))
    private static void mcs$onBattleWin(ServerPlayer player, CallbackInfo ci, @Local(name = "data") PlayerTowerData data) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BATTLES_WON));

        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BEST_WIN_STREAK), data.getCurrentStreak());
        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.HIGHEST_FLOOR), data.getCurrentFloor());

        int floors = ((ServerPlayerExtensions) player).mcs$getStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.TOTAL_FLOORS)) + 1;
        ((ServerPlayerExtensions) player).mcs$setStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.TOTAL_FLOORS), floors);
    }

    @Inject(method = "onBattleLoss",
            at = @At(value = "INVOKE", target = "Lbattle/tower/data/TowerDataManager;savePlayerData(Ljava/util/UUID;)V"))
    private static void mcs$onBattleLoss(ServerPlayer player, CallbackInfo ci, @Local(name = "data") PlayerTowerData data, @Local(name = "earnedBP") int earnedBP) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BATTLES_LOST));
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BP_EARNED), earnedBP);

        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BEST_WIN_STREAK), data.getBestStreak());
        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.HIGHEST_FLOOR), data.getHighestFloor());
    }

    @Inject(method = "forfeitRun",
            at = @At(value = "INVOKE", target = "Lbattle/tower/data/TowerDataManager;savePlayerData(Ljava/util/UUID;)V", ordinal = 1))
    private static void mcs$forfeitRun(ServerPlayer player, CallbackInfo ci, @Local(name = "data") PlayerTowerData data, @Local(name = "earnedBP") int earnedBP) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.RUNS_FORFEITED));
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BP_EARNED), earnedBP);

        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.BEST_WIN_STREAK), data.getBestStreak());
        ((ServerPlayerExtensions) player).mcs$setHighStat(MCS_Stats.getStat(MCS_CobblemonBattleTowerStats.HIGHEST_FLOOR), data.getHighestFloor());
    }
}
