package com.urkaz.morecobblemonstats.stats.cobblemon_battle_tower;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonBattleTowerStats {

    public static final String MOD_ID = "cobblemon_battle_tower";

    public static final MCS_Stats.CustomStat BATTLES_WON = new MCS_Stats.CustomStat(MOD_ID, "battles_won");
    public static final MCS_Stats.CustomStat BATTLES_LOST = new MCS_Stats.CustomStat(MOD_ID, "battles_lost");
    public static final MCS_Stats.CustomStat RUNS_FORFEITED = new MCS_Stats.CustomStat(MOD_ID, "runs_forfeited");
    public static final MCS_Stats.CustomStat TOTAL_FLOORS = new MCS_Stats.CustomStat(MOD_ID, "total_floors");
    public static final MCS_Stats.CustomStat BP_EARNED = new MCS_Stats.CustomStat(MOD_ID, "bp_earned");
    public static final MCS_Stats.CustomStat BEST_WIN_STREAK = new MCS_Stats.CustomStat(MOD_ID, "best_win_streak");
    public static final MCS_Stats.CustomStat HIGHEST_FLOOR = new MCS_Stats.CustomStat(MOD_ID, "highest_floor");


    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("battles_won", BATTLES_WON);
            stats.put("battles_lost", BATTLES_LOST);
            stats.put("runs_forfeited", RUNS_FORFEITED);
            stats.put("total_floors", TOTAL_FLOORS);
            stats.put("bp_earned", BP_EARNED);
            stats.put("best_win_streak", BEST_WIN_STREAK);
            stats.put("highest_floor", HIGHEST_FLOOR);
        }
    }
}
