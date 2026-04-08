package com.urkaz.morecobblemonstats.stats.rustlingspots;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_RustlingSpotsStats {

    public static final String MOD_ID = "rustlingspots";

    public static final MCS_Stats.CustomStat RUSTLING_SPOTS_EXAMINED = new MCS_Stats.CustomStat(MOD_ID, "rustling_spots_examined");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("rustling_spots_examined", RUSTLING_SPOTS_EXAMINED);
        }
    }

}
