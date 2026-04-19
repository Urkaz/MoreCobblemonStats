package com.urkaz.morecobblemonstats.mixin.cobblemon;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.events.pokemon.PokemonGainedEvent;
import com.cobblemon.mod.common.api.pokedex.PokedexEntryProgress;
import com.cobblemon.mod.common.api.pokedex.SpeciesDexRecord;
import com.cobblemon.mod.common.events.StatHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.extensions.ServerPlayerExtensions;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon.MCS_CobblemonStats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Mixin(StatHandler.class)
public class StatHandlerMixin {

    @WrapOperation(method = "onDexEntryGain", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;awardStat(Lnet/minecraft/resources/ResourceLocation;)V"))
    void mcs$fixDexEntryAward(ServerPlayer instance, ResourceLocation resourceLocation, Operation<Void> original, @Local(argsOnly = true) PokemonGainedEvent event) {

        // Calculate seen and caught
        AtomicInteger caught = new AtomicInteger();
        AtomicInteger seen = new AtomicInteger();
        Map<ResourceLocation, SpeciesDexRecord> speciesRecords = Cobblemon.playerDataManager.getPokedexData(instance.getUUID()).getSpeciesRecords();
        speciesRecords.values().forEach(dexRecord -> {
            if (dexRecord.getKnowledge() == PokedexEntryProgress.CAUGHT) caught.getAndIncrement();
            if (dexRecord.getKnowledge().ordinal() >= PokedexEntryProgress.ENCOUNTERED.ordinal()) seen.getAndIncrement();
        });

        ((ServerPlayerExtensions) instance).mcs$setStat(resourceLocation, caught.intValue());
        ((ServerPlayerExtensions) instance).mcs$setStat(MCS_Stats.getStat(MCS_CobblemonStats.DEX_ENCOUNTERED), seen.intValue());
    }
}
