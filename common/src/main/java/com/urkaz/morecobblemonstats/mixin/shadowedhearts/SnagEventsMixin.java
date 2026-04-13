package com.urkaz.morecobblemonstats.mixin.shadowedhearts;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.battles.BattleRegistry;
import com.jayemceekay.shadowedhearts.snag.SnagEvents;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.urkaz.morecobblemonstats.stats.shadowedhearts.MCS_ShadowedHeartsStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Restriction(require = {@Condition(MCS_ShadowedHeartsStats.MOD_ID)})
@Mixin(SnagEvents.class)
public class SnagEventsMixin {

    @WrapOperation(method = "lambda$init$2",
            at = @At(value = "INVOKE", target = "Lcom/jayemceekay/shadowedhearts/advancements/ModCriteriaTriggers;triggerSnagFromNpc(Lnet/minecraft/server/level/ServerPlayer;)V"))
    private static void mcs$fixSnagEvent(ServerPlayer player, Operation<Void> original) {
        // Try to get the current battle to identify if the captured Pokémon is from a Trainer
        boolean vsNPC;
        try {
            PokemonBattle battle = BattleRegistry.getBattleByParticipatingPlayer(player);
            vsNPC = battle.isPvN();
        } catch (Exception ignored) {
            vsNPC = true; // if the above fails, set to true to mimic the default behavior from the mod
        }

        if (vsNPC)
            original.call(player);
    }
}
