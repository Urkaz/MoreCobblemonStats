package com.urkaz.morecobblemonstats.mixin.cobblemonmarks;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import dev.darcosse.common.cobblemonmarks.config.MarksCondition;
import dev.darcosse.common.cobblemonmarks.handler.MarksHandler;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quick.battle.battle.QuickBattleResult;

@Restriction(require = {@Condition("cobblemonmarks")})
@Mixin(MarksHandler.class)
public class MarksHandlerMixin {

    @Inject(
            method = "awardMark",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;sendSystemMessage(Lnet/minecraft/network/chat/Component;)V",
                    ordinal = 0
            ),
            remap = false
    )
    private static void mcs$awardMark(Pokemon pokemon, MarksCondition markCondition, ServerPlayer player, CallbackInfo ci, @Local(name = "result") QuickBattleResult result) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEMON_MARKS_OBTAINED));
    }
}
