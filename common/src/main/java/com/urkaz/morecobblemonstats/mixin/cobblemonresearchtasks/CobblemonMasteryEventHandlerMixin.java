package com.urkaz.morecobblemonstats.mixin.cobblemonresearchtasks;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.urkaz.morecobblemonstats.stats.cobblemonresearchtasks.MCS_CobblemonResearchTasksStats;
import github.jorgaomc.events.CobblemonMasteryEventHandler;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Restriction(require = {@Condition(MCS_CobblemonResearchTasksStats.MOD_ID)})
@Mixin(CobblemonMasteryEventHandler.class)
public class CobblemonMasteryEventHandlerMixin {

    // Fix Evolution not handled if not made outside the Pokeball
    @WrapOperation(
            method = "lambda$register$2",
            at = @At(value = "INVOKE",
                    target = "Lgithub/jorgaomc/events/CobblemonMasteryEventHandler;tryResolveOwnerPlayer(Lcom/cobblemon/mod/common/pokemon/Pokemon;)Lnet/minecraft/server/level/ServerPlayer;"
            )
    )
    private static ServerPlayer mcs$maybeNotifyCompleted(Pokemon p, Operation<ServerPlayer> original) {
        ServerPlayer sp = original.call(p);
        if (sp == null) sp = p.getOwnerPlayer();
        return sp;
    }
}
