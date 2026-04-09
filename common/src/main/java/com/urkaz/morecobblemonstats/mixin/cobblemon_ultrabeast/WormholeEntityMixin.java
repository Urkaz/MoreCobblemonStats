package com.urkaz.morecobblemonstats.mixin.cobblemon_ultrabeast;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_ultrabeast.MCS_CobblemonUltraBeastStats;
import dev.darcosse.ultrabeasts.fabric.entity.WormholeEntity;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition(MCS_CobblemonUltraBeastStats.MOD_ID)})
@Mixin(WormholeEntity.class)
public class WormholeEntityMixin {

    @Inject(
            method = "teleportToUltraSpaceDimension",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;teleportTo(Lnet/minecraft/server/level/ServerLevel;DDDFF)V",
                    ordinal = 0
            )
    )
    private static void mcs$teleportPlayer(ServerPlayer player, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonUltraBeastStats.ULTRA_WORMHOLES_ENTERED));
    }
}
