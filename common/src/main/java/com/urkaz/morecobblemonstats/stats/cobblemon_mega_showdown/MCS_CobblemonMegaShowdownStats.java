package com.urkaz.morecobblemonstats.stats.cobblemon_mega_showdown;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonMegaShowdownStats {

    public static final String MOD_ID = "cobblemon_mega_showdown";

    public static final MCS_Stats.CustomStat POKEMON_DYNAMAXED = new MCS_Stats.CustomStat(MOD_ID, "pokemon_dynamaxed");
    public static final MCS_Stats.CustomStat POKEMON_ULTRA_BURST_USED = new MCS_Stats.CustomStat(MOD_ID, "ultra_burst_used");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("pokemon_dynamaxed", POKEMON_DYNAMAXED);
            stats.put("ultra_burst_used", POKEMON_ULTRA_BURST_USED);
        }
    }

}
