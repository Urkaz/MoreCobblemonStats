package com.urkaz.morecobblemonstats.cobblemon;

import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.urkaz.morecobblemonstats.MCS_Stats;
import net.minecraft.server.level.ServerPlayer;

public class MCS_CobblemonEventListener {

    public static void registerEvents() {
        CobblemonEvents.TERASTALLIZATION.subscribe((event) -> {
            ServerPlayer player =  event.component2().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEMON_TERASTALIZED));
            }
        });

        CobblemonEvents.MEGA_EVOLUTION.subscribe((event) -> {
            ServerPlayer player =  event.component2().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEMON_MEGAEVOLVED));
            }
        });

        CobblemonEvents.ZPOWER_USED.subscribe((event) -> {
            ServerPlayer player =  event.component2().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEMON_ZMOVES_USED));
            }
        });

        CobblemonEvents.FORME_CHANGE.subscribe((event) -> {
            ServerPlayer player =  event.component2().getOriginalPokemon().getOwnerPlayer();
            if (player != null) {
                player.awardStat(MCS_Stats.getStat(MCS_Stats.POKEMON_FORME_CHANGES));
            }
        });
    }
}
