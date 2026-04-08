package com.urkaz.morecobblemonstats.stats.cobblemonmarks;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonMarksStats {

    public static final String MOD_ID = "cobblemonmarks";

    public static final MCS_Stats.CustomStat POKEMON_MARKS_OBTAINED = new MCS_Stats.CustomStat(MOD_ID, "pokemon_marks_obtained");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("pokemon_marks_obtained", POKEMON_MARKS_OBTAINED);
        }
    }
}
