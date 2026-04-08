package com.urkaz.morecobblemonstats.stats.cobbledollars;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobbledollarsStats {

    public static final String MOD_ID = "cobbledollars";

    public static final MCS_Stats.CustomStat COBBLEDOLLARS_LOST = new MCS_Stats.CustomStat(MOD_ID, "cobbledollars_lost");
    public static final MCS_Stats.CustomStat COBBLEDOLLARS_EARNED = new MCS_Stats.CustomStat(MOD_ID, "cobbledollars_earned");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("cobbledollars_lost", COBBLEDOLLARS_LOST);
            stats.put("cobbledollars_earned", COBBLEDOLLARS_EARNED);
        }
    }
}
