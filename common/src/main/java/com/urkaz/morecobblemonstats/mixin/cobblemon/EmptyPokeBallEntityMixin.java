package com.urkaz.morecobblemonstats.mixin.cobblemon;

import com.cobblemon.mod.common.entity.pokeball.EmptyPokeBallEntity;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.MCS_Stats;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EmptyPokeBallEntity.class)
public class EmptyPokeBallEntityMixin {

    @Inject(
            method = "onHitEntity",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/network/syncher/SynchedEntityData;set(Lnet/minecraft/network/syncher/EntityDataAccessor;Ljava/lang/Object;)V",
                    ordinal = 1)
    )
    private void mcs$onHitEntity(CallbackInfo ci, @Local(name = "owner") Entity owner) {
        if (owner instanceof ServerPlayer player) {
            player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEBALL_THROWN_HIT));
        }
    }
}
