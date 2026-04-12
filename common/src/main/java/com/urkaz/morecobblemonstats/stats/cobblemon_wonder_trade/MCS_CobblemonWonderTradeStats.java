package com.urkaz.morecobblemonstats.stats.cobblemon_wonder_trade;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonWonderTradeStats {

    public static final String MOD_ID = "cobblemon_wonder_trade";

    public static final MCS_Stats.CustomStat WONDER_TRADES = new MCS_Stats.CustomStat(MOD_ID, "wonder_trades");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("wonder_trades", WONDER_TRADES);
        }
    }
}
