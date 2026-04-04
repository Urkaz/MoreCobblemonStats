package com.urkaz.morecobblemonstats.mixin.cobblemon;

import com.cobblemon.mod.common.item.PokeBallItem;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PokeBallItem.class)
public class PokeBallItemMixin {

    @Inject(
            method = "throwPokeBall",
            at = @At("HEAD")
    )
    private void mcs$pokeBallThrown(CallbackInfo ci, @Local(argsOnly = true) ServerPlayer player) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEBALL_THROWN));
    }
}
