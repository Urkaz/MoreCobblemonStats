package com.urkaz.morecobblemonstats.mixin.cobbledollars;

import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import fr.harmex.cobbledollars.common.utils.extensions.PlayerExtensionKt;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.math.BigInteger;

@Restriction(require = {@Condition("cobbledollars")})
@Mixin(value = PlayerExtensionKt.class, remap = false)
public class PlayerExtensionKtMixin {

    @Inject(
            method = "setCobbleDollars",
            at = @At("HEAD")
    )
    private static void mcs$setCobbleDollars(CallbackInfo ci, @Local(argsOnly = true) Player player, @Local(argsOnly = true) BigInteger newAmount) {
        BigInteger current = PlayerExtensionKt.getCobbleDollars(player);
        int diff = newAmount.subtract(current).intValue();
        if (diff > 0) {
            player.awardStat(MCS_Stats.getStat(MCS_Stats.COBBLEDOLLARS_EARNED), diff);
        } else if (diff < 0) {
            player.awardStat(MCS_Stats.getStat(MCS_Stats.COBBLEDOLLARS_LOST), Math.abs(diff));
        }
    }
}
