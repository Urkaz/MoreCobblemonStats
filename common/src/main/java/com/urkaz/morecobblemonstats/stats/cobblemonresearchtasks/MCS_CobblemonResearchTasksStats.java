package com.urkaz.morecobblemonstats.stats.cobblemonresearchtasks;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonResearchTasksStats {

    public static final String MOD_ID = "cobblemonresearchtasks";

    public static final MCS_Stats.CustomStat TASKS_COMPLETED = new MCS_Stats.CustomStat(MOD_ID, "tasks_completed");
    public static final MCS_Stats.CustomStat ENTRIES_COMPLETED = new MCS_Stats.CustomStat(MOD_ID, "entries_completed");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("tasks_completed", TASKS_COMPLETED);
            stats.put("entries_completed", ENTRIES_COMPLETED);
        }
    }

}
