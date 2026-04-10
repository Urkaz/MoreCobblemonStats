package com.urkaz.morecobblemonstats.events;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.battles.BattleRegistry;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.jayemceekay.shadowedhearts.PokemonAspectUtil;
import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.shadowedhearts.MCS_ShadowedHeartsStats;
import net.minecraft.server.level.ServerPlayer;

public class MCS_ShadowedHeartsEventListener {

    public static void registerEvents() {
        if (!MCS_Platform.isModLoaded(MCS_ShadowedHeartsStats.MOD_ID)) return;

        MoreCobblemonStats.LOGGER.info("Registering ShadowedHearts Extra Event Listeners...");

        CobblemonEvents.POKEMON_CAPTURED.subscribe((event) -> {
            Pokemon pokemon = event.getPokemon();
            ServerPlayer player = event.getPlayer();

            if (PokemonAspectUtil.hasShadowAspect(pokemon)) {

                // Try to get the current battle to identify if the captured is a Trainer Pokémon
                boolean vsNPC = false;
                try {
                    PokemonBattle battle = BattleRegistry.getBattleByParticipatingPlayer(player);
                    vsNPC = battle.isPvN();
                } catch (Exception ignored) {
                }

                if (vsNPC)
                    player.awardStat(MCS_Stats.getStat(MCS_ShadowedHeartsStats.SHADOW_POKEMON_SNAG));
                player.awardStat(MCS_Stats.getStat(MCS_ShadowedHeartsStats.SHADOW_POKEMON_CAUGHT));
            }
        });
    }
}
