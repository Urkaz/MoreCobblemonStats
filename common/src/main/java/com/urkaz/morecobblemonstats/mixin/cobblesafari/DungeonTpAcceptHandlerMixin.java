package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import com.urkaz.morecobblemonstats.cobblesafari.MCS_CobbleSafariDungeonHelper;
import maxigregrze.cobblesafari.dungeon.DungeonTeleportHandler;
import maxigregrze.cobblesafari.dungeon.DungeonTpAcceptHandler;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(DungeonTpAcceptHandler.class)
public class DungeonTpAcceptHandlerMixin {

    @Inject(
            method = "executeTeleportOrCountdown",
            at = @At("HEAD")
    )
    private static void mcs$executeTeleportOrCountdown(CallbackInfo ci, @Local(argsOnly = true) ServerPlayer player, @Local(argsOnly = true) DungeonTeleportHandler.DungeonValidationResult validation) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.HOOPA_RINGS_USED));
        player.awardStat(MCS_Stats.getStat(MCS_CobbleSafariDungeonHelper.getDimensionStat(validation.dimensionId())));
    }
}
