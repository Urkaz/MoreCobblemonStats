package com.urkaz.morecobblemonstats.mixin.cobblemonresearchtasks;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemonresearchtasks.MCS_CobblemonResearchTasksStats;
import github.jorgaomc.storage.MasteryManager;
import github.jorgaomc.tasks.TaskDefinition;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Restriction(require = {@Condition(MCS_CobblemonResearchTasksStats.MOD_ID)})
@Mixin(MasteryManager.class)
public class MasteryManagerMixin {

    @Inject(
            method = "maybeNotifyCompleted",
            at = @At(value = "INVOKE",
                    target = "Lgithub/jorgaomc/storage/MasteryManager;sendActionBar(Lnet/minecraft/server/level/ServerPlayer;Ljava/lang/String;)V"
            )
    )
    private static void mcs$maybeNotifyCompleted(ServerPlayer sp, String speciesKey, TaskDefinition t, int before, CallbackInfo ci) {
        sp.awardStat(MCS_Stats.getStat(MCS_CobblemonResearchTasksStats.TASKS_COMPLETED));
    }

    @Inject(
            method = "updateFriendshipWithNotify",
            at = @At(value = "INVOKE",
                    target = "Lgithub/jorgaomc/storage/MasteryManager;sendActionBar(Lnet/minecraft/server/level/ServerPlayer;Ljava/lang/String;)V"
            )
    )
    private static void mcs$updateFriendshipWithNotify(ServerPlayer sp, UUID player, String species, int friendship, CallbackInfo ci) {
        sp.awardStat(MCS_Stats.getStat(MCS_CobblemonResearchTasksStats.TASKS_COMPLETED));
    }

    @Inject(
            method = "handleEvolveWithNotify",
            at = @At(value = "INVOKE",
                    target = "Lgithub/jorgaomc/storage/MasteryManager;sendActionBar(Lnet/minecraft/server/level/ServerPlayer;Ljava/lang/String;)V"
            )
    )
    private static void mcs$handleEvolveWithNotify(ServerPlayer sp, UUID player, String species, CallbackInfo ci) {
        sp.awardStat(MCS_Stats.getStat(MCS_CobblemonResearchTasksStats.TASKS_COMPLETED));
    }

    @Inject(
            method = "claimSpeciesReward",
            at = @At(value = "HEAD")
    )
    private static void mcs$claimSpeciesReward(ServerPlayer sp, String speciesKey, CallbackInfo ci) {
        sp.awardStat(MCS_Stats.getStat(MCS_CobblemonResearchTasksStats.ENTRIES_COMPLETED));
    }
}
