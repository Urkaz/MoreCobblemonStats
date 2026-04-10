package com.urkaz.morecobblemonstats.stats.pokebike;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import net.minecraft.stats.StatFormatter;

import java.util.Map;

public class MCS_PokeBikeStats {

    public static final String MOD_ID = "pokebike";

    public static final MCS_Stats.CustomStat BIKING = new MCS_Stats.CustomStat(MOD_ID, "biking", StatFormatter.DISTANCE);

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("biking", BIKING);
        }
    }

}
