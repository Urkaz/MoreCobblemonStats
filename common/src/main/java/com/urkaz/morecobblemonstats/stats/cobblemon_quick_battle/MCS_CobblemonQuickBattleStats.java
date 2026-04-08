package com.urkaz.morecobblemonstats.stats.cobblemon_quick_battle;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonQuickBattleStats {

    public static final String MOD_ID = "cobblemon_quick_battle";

    public static final MCS_Stats.CustomStat QUICK_BATTLE_TOTAL = new MCS_Stats.CustomStat(MOD_ID, "quick_battles_total");
    public static final MCS_Stats.CustomStat QUICK_BATTLE_WON = new MCS_Stats.CustomStat(MOD_ID, "quick_battles_won");
    public static final MCS_Stats.CustomStat QUICK_BATTLE_LOST = new MCS_Stats.CustomStat(MOD_ID, "quick_battles_lost");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("quick_battles_total", QUICK_BATTLE_TOTAL);
            stats.put("quick_battles_won", QUICK_BATTLE_WON);
            stats.put("quick_battles_lost", QUICK_BATTLE_LOST);
        }
    }

}
