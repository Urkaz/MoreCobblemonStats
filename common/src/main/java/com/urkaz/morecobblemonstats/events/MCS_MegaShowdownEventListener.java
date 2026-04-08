package com.urkaz.morecobblemonstats.events;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.github.yajatkaul.mega_showdown.api.event.DynamaxStartCallback;
import com.github.yajatkaul.mega_showdown.api.event.UltraBurstCallback;
import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_mega_showdown.MCS_MegaShowdownStats;
import net.minecraft.server.level.ServerPlayer;

public class MCS_MegaShowdownEventListener {
    public static void registerEvents() {
        if (!MCS_Platform.isModLoaded("cobblemon_mega_showdown")) return;

        MoreCobblemonStats.LOGGER.info("Registering MegaShowdown Event Listeners...");

        DynamaxStartCallback.EVENT.register((PokemonBattle battle, BattlePokemon battlePokemon, Boolean gmax) -> {
            ServerPlayer player = battlePokemon.getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_MegaShowdownStats.POKEMON_DYNAMAXED));
            }
        });

        UltraBurstCallback.EVENT.register((PokemonBattle battle, BattlePokemon battlePokemon) -> {
            ServerPlayer player = battlePokemon.getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_MegaShowdownStats.POKEMON_ULTRA_BURST_USED));
            }
        });
    }
}
