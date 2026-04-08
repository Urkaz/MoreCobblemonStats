package com.urkaz.morecobblemonstats.stats.cobblesafari;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import maxigregrze.cobblesafari.dungeon.DungeonConfig;
import maxigregrze.cobblesafari.dungeon.DungeonDimensions;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MCS_CobbleSafariDungeonHelper {

    private static final Map<String, MCS_Stats.CustomStat> dungeonStats = new LinkedHashMap<>();

    public static void autoRegisterDungeonStats(Map<String, MCS_Stats.CustomStat> stats) {
        List<DungeonConfig> dungeons = DungeonDimensions.getAllDungeons();
        for (DungeonConfig entry : dungeons) {
            String statName = entry.getDimensionId().split(":")[1] + "_entered";
            MCS_Stats.CustomStat dimensionStat = new MCS_Stats.CustomStat(MCS_CobbleSafariStats.MOD_ID, statName);

            dungeonStats.put(entry.getDimensionId(), dimensionStat);
            stats.put(statName, dimensionStat);
        }
    }

    public static MCS_Stats.CustomStat getDimensionStat(@NotNull String dimensionID) {
        return dungeonStats.get(dimensionID);
    }
}
