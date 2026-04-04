package com.urkaz.morecobblemonstats.mixin.rustlingspots;

import com.urkaz.morecobblemonstats.MCS_Stats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.levelscraft7.rustlingspots.spot.RustlingSpot;
import net.levelscraft7.rustlingspots.spot.SpotRewardResolver;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Restriction(require = {@Condition("rustlingspots")})
@Mixin(SpotRewardResolver.class)
public class SpotRewardResolverMixin {

    @Inject(
            method = "resolve",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerLevel;sendParticles(Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I")
    )
    private static void mcs$resolveRustlingSpot(ServerLevel level, ServerPlayer player, RustlingSpot spot, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.RUSTLING_SPOTS_EXAMINED));
    }
}
