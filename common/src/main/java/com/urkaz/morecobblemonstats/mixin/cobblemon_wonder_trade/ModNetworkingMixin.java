package com.urkaz.morecobblemonstats.mixin.cobblemon_wonder_trade;

import com.cobblemon.mod.common.api.stats.CobblemonStats;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_wonder_trade.MCS_CobblemonWonderTradeStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wonder.trade.network.ModNetworking;

@Restriction(require = {@Condition(MCS_CobblemonWonderTradeStats.MOD_ID)})
@Mixin(ModNetworking.class)
public class ModNetworkingMixin {

    @Inject(
            method = "handleTradeRequest",
            at = @At(value = "INVOKE",
                    target = "Lwonder/trade/data/PlayerCooldown;recordTrade(Ljava/util/UUID;)V"
            )
    )
    private static void mcs$handleTradeRequest(ServerPlayer player, int partySlot, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonWonderTradeStats.WONDER_TRADES));
        player.awardStat(CobblemonStats.getStat(CobblemonStats.TRADED));
    }
}
