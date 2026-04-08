package com.urkaz.morecobblemonstats.stats.cobblemon;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonStats {

    public static final String MOD_ID = "cobblemon";

    public static final MCS_Stats.CustomStat POKEBALL_THROWN = new MCS_Stats.CustomStat(MOD_ID, "poke_ball_thrown");
    public static final MCS_Stats.CustomStat POKEBALL_THROWN_HIT = new MCS_Stats.CustomStat(MOD_ID, "poke_ball_thrown_hit");
    public static final MCS_Stats.CustomStat POKEMON_TERASTALIZED = new MCS_Stats.CustomStat(MOD_ID, "pokemon_terastalized");
    public static final MCS_Stats.CustomStat POKEMON_MEGAEVOLVED = new MCS_Stats.CustomStat(MOD_ID, "pokemon_megaevolved");
    public static final MCS_Stats.CustomStat POKEMON_ZMOVES_USED = new MCS_Stats.CustomStat(MOD_ID, "z_moves_used");
    public static final MCS_Stats.CustomStat POKEMON_FORME_CHANGES = new MCS_Stats.CustomStat(MOD_ID, "pokemon_forme_changes");
    public static final MCS_Stats.CustomStat POKEMON_DEFEATED = new MCS_Stats.CustomStat(MOD_ID, "pokemon_defeated");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        stats.put("poke_ball_thrown", POKEBALL_THROWN);
        stats.put("poke_ball_thrown_hit", POKEBALL_THROWN_HIT);
        stats.put("pokemon_terastalized", POKEMON_TERASTALIZED);
        stats.put("pokemon_megaevolved", POKEMON_MEGAEVOLVED);
        stats.put("z_moves_used", POKEMON_ZMOVES_USED);
        stats.put("pokemon_forme_changes", POKEMON_FORME_CHANGES);
        stats.put("pokemon_defeated", POKEMON_DEFEATED);
    }
}
