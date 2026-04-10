package com.urkaz.morecobblemonstats.stats.shadowedhearts;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_ShadowedHeartsStats {

    public static final String MOD_ID = "shadowedhearts";

    public static final MCS_Stats.CustomStat SHADOW_POKEMON_DEFEATED = new MCS_Stats.CustomStat(MOD_ID, "shadow_pokemon_defeated");
    public static final MCS_Stats.CustomStat SHADOW_POKEMON_CAUGHT = new MCS_Stats.CustomStat(MOD_ID, "shadow_pokemon_caught");
    public static final MCS_Stats.CustomStat SHADOW_POKEMON_PURIFIED = new MCS_Stats.CustomStat(MOD_ID, "shadow_pokemon_purified");
    public static final MCS_Stats.CustomStat SHADOW_POKEMON_SNAG = new MCS_Stats.CustomStat(MOD_ID, "shadow_pokemon_snag");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("shadow_pokemon_defeated", SHADOW_POKEMON_DEFEATED);
            stats.put("shadow_pokemon_caught", SHADOW_POKEMON_CAUGHT);
            stats.put("shadow_pokemon_purified", SHADOW_POKEMON_PURIFIED);
            stats.put("shadow_pokemon_snag", SHADOW_POKEMON_SNAG);
        }
    }
}
