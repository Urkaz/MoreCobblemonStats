package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import maxigregrze.cobblesafari.underground.UndergroundMinigame;
import maxigregrze.cobblesafari.underground.logic.PlacedTreasure;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(UndergroundMinigame.class)
public class UndergroundMinigameMixin {

    @Inject(
            method = "giveRewards",
            at = @At("HEAD")
    )
    private static void mcs$giveRewards(CallbackInfo ci, @Local(argsOnly = true) ServerPlayer player, @Local(argsOnly = true) List<PlacedTreasure> treasures) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.UNDERGROUND_TREASURES_FOUND), treasures.size());
    }
}
