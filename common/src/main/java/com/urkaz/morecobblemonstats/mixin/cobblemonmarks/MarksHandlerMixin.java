package com.urkaz.morecobblemonstats.mixin.cobblemonmarks;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_quick_battle.MCS_CobblemonQuickBattleStats;
import com.urkaz.morecobblemonstats.stats.cobblemonmarks.MCS_CobblemonMarksStats;
import dev.darcosse.common.cobblemonmarks.config.MarksCondition;
import dev.darcosse.common.cobblemonmarks.handler.MarksHandler;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_CobblemonMarksStats.MOD_ID)})
@Mixin(MarksHandler.class)
public class MarksHandlerMixin {

    @Inject(
            method = "awardMark",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V",
                    ordinal = 0
            )
    )
    private static void mcs$awardMark(Pokemon pokemon, MarksCondition markCondition, ServerPlayer player, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonMarksStats.POKEMON_MARKS_OBTAINED));
    }
}
