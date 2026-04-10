package com.urkaz.morecobblemonstats.mixin.pokebike;

import com.levelscraft7.pokebike.entity.BikeEntity;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.pokebike.MCS_PokeBikeStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Restriction(require = {@Condition(MCS_PokeBikeStats.MOD_ID)})
@Mixin(ServerPlayer.class)
public class ServerPlayerBikingMixin {

    @WrapOperation(method = "checkRidingStatistics", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;getVehicle()Lnet/minecraft/world/entity/Entity;"))
    public Entity cobblemon$checkRidingStatistics(ServerPlayer player, Operation<Entity> original, @Local(name = "i") int distance) {
        var entity = original.call(player);
        Entity vehicle = player.getVehicle();
        if (!(vehicle instanceof BikeEntity)) {
            return entity;
        }
        player.awardStat(MCS_Stats.getStat(MCS_PokeBikeStats.BIKING), distance);
        return entity;
    }

}
