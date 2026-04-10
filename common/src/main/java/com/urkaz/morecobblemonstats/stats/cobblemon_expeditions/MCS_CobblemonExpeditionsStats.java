package com.urkaz.morecobblemonstats.stats.cobblemon_expeditions;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonExpeditionsStats {

    public static final String MOD_ID = "cobblemon_expeditions";

    public static final MCS_Stats.CustomStat EXPEDITIONS = new MCS_Stats.CustomStat(MOD_ID, "expeditions");
    public static final MCS_Stats.CustomStat EXPEDITIONS_CANCELED = new MCS_Stats.CustomStat(MOD_ID, "expeditions_canceled");
    public static final MCS_Stats.CustomStat EXPEDITIONS_FINISHED = new MCS_Stats.CustomStat(MOD_ID, "expeditions_finished");
    public static final MCS_Stats.CustomStat EXPEDITIONS_FAILED = new MCS_Stats.CustomStat(MOD_ID, "expedition_result_failed");
    public static final MCS_Stats.CustomStat EXPEDITIONS_PARTIAL = new MCS_Stats.CustomStat(MOD_ID, "expedition_result_partial");
    public static final MCS_Stats.CustomStat EXPEDITIONS_GREAT = new MCS_Stats.CustomStat(MOD_ID, "expedition_result_great");
    public static final MCS_Stats.CustomStat EXPEDITIONS_SUCCESS = new MCS_Stats.CustomStat(MOD_ID, "expedition_result_success");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("expeditions_started", EXPEDITIONS);
            stats.put("expeditions_canceled", EXPEDITIONS_CANCELED);
            stats.put("expeditions_finished", EXPEDITIONS_FINISHED);
            stats.put("expedition_result_failed", EXPEDITIONS_FAILED);
            stats.put("expedition_result_partial", EXPEDITIONS_PARTIAL);
            stats.put("expedition_result_great", EXPEDITIONS_GREAT);
            stats.put("expedition_result_success", EXPEDITIONS_SUCCESS);
        }
    }

}
