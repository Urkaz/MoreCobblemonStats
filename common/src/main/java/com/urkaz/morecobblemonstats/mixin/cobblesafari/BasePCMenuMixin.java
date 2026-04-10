package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariStats;
import maxigregrze.cobblesafari.block.basepc.BasePCMenu;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Restriction(require = {@Condition(MCS_CobbleSafariStats.MOD_ID)})
@Mixin(BasePCMenu.class)
public class BasePCMenuMixin {

    @WrapOperation(
            method = "clickMenuButton",
            at = @At(value = "INVOKE",
                    target = "Lmaxigregrze/cobblesafari/block/basepc/BasePCMenu;consumeFlag()Z"
            )
    )
    private boolean mcs$consumeFlag(BasePCMenu instance, Operation<Boolean> original, @Local(argsOnly = true) Player player) {
        boolean consume = original.call(instance);
        if (consume)
            player.awardStat(MCS_Stats.getStat(MCS_CobbleSafariStats.SECRET_BASE_FLAGS_STOLEN));
        return consume;
    }
}
