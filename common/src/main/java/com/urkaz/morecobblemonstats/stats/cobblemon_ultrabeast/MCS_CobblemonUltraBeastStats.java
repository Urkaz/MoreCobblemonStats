package com.urkaz.morecobblemonstats.stats.cobblemon_ultrabeast;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonUltraBeastStats {

    public static final String MOD_ID = "cobblemon_ultrabeast";

    public static final MCS_Stats.CustomStat ULTRA_WORMHOLES_ENTERED = new MCS_Stats.CustomStat(MOD_ID, "ultra_wormholes_entered");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("ultra_wormholes_entered", ULTRA_WORMHOLES_ENTERED);
        }
    }

}
