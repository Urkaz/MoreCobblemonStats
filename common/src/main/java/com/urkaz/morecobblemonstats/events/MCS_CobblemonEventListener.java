package com.urkaz.morecobblemonstats.events;

import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.battles.ActiveBattlePokemon;
import com.cobblemon.mod.common.battles.BattleSide;
import com.cobblemon.mod.common.battles.actor.PlayerBattleActor;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobblemon.MCS_CobblemonStats;
import net.minecraft.server.level.ServerPlayer;

public class MCS_CobblemonEventListener {

    public static void registerEvents() {
        MoreCobblemonStats.LOGGER.info("Registering Cobblemon Event Listeners...");

        CobblemonEvents.TERASTALLIZATION.subscribe((event) -> {
            ServerPlayer player = event.getPokemon().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_CobblemonStats.POKEMON_TERASTALIZED));
            }
        });

        CobblemonEvents.MEGA_EVOLUTION.subscribe((event) -> {
            ServerPlayer player = event.getPokemon().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_CobblemonStats.POKEMON_MEGAEVOLVED));
            }
        });

        CobblemonEvents.ZPOWER_USED.subscribe((event) -> {
            ServerPlayer player = event.getPokemon().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_CobblemonStats.POKEMON_ZMOVES_USED));
            }
        });

        CobblemonEvents.FORME_CHANGE.subscribe((event) -> {
            ServerPlayer player = event.getPokemon().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_CobblemonStats.POKEMON_FORME_CHANGES));
            }
        });

        CobblemonEvents.BATTLE_FAINTED.subscribe((event) -> {
            BattleActor killedActor = event.getKilled().getActor();
            BattleActor killerActor = null;
            // Find the "killer"
            for (BattleSide side : event.getBattle().getSides()) {
                for (ActiveBattlePokemon pokemon : side.getActivePokemon()) {
                    BattleActor actor = pokemon.getActor();
                    if (killedActor != actor) {
                        killerActor = actor;
                        break;
                    }
                }
            }

            if (killerActor instanceof PlayerBattleActor playerActor) {
                ServerPlayer player = playerActor.getEntity();
                if (player != null) {
                    player.awardStat(MCS_Stats.getStat(MCS_CobblemonStats.POKEMON_DEFEATED));
                }
            }
        });
    }
}
