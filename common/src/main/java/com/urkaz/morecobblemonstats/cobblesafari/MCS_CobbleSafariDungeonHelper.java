package com.urkaz.morecobblemonstats.cobblesafari;

import com.cobblemon.mod.common.api.stats.CobblemonStats;
import maxigregrze.cobblesafari.dungeon.DungeonConfig;
import maxigregrze.cobblesafari.dungeon.DungeonDimensions;
import net.minecraft.stats.StatFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MCS_CobbleSafariDungeonHelper {

    private static final Map<String, CobblemonStats.CobblemonStat> dungeonStats = new LinkedHashMap<String, CobblemonStats.CobblemonStat>();

    public static void autoRegisterDungeonStats(Map<String, CobblemonStats.CobblemonStat> stats) {
        List<DungeonConfig> dungeons = DungeonDimensions.getAllDungeons();
        for (DungeonConfig entry : dungeons) {
            String statName = entry.getDimensionId().split(":")[1] + "_entered";
            CobblemonStats.CobblemonStat dimensionStat = new CobblemonStats.CobblemonStat(statName, StatFormatter.DEFAULT);

            dungeonStats.put(entry.getDimensionId(), dimensionStat);
            stats.put(statName, dimensionStat);
        }
    }

    public static CobblemonStats.CobblemonStat getDimensionStat(@NotNull String dimensionID) {
        return dungeonStats.get(dimensionID);
    }
}
