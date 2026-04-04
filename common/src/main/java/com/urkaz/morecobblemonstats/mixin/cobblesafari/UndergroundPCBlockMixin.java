package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.urkaz.morecobblemonstats.MCS_Stats;
import maxigregrze.cobblesafari.block.underground.UndergroundPCBlock;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(UndergroundPCBlock.class)
public class UndergroundPCBlockMixin {

    @Inject(
            method = "useWithoutItem",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;setValue(Lnet/minecraft/world/level/block/state/properties/Property;Ljava/lang/Comparable;)Ljava/lang/Object;"
            )
    )
    private void mcs$giveRewards(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        player.awardStat(MCS_Stats.getStat(MCS_Stats.SECRET_BASE_FLAGS_STOLEN));
    }
}
