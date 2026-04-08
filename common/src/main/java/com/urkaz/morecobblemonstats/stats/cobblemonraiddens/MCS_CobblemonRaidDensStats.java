package com.urkaz.morecobblemonstats.stats.cobblemonraiddens;

import com.necro.raid.dens.common.statistics.RaidStatistics;
import com.urkaz.morecobblemonstats.MCS_Platform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatType;

public class MCS_CobblemonRaidDensStats {

    public static final String MOD_ID = "cobblemonraiddens";

    public static void initStatScreen(StatType<ResourceLocation> custom) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            custom.get(RaidStatistics.RAIDS_HOSTED);
            custom.get(RaidStatistics.RAIDS_JOINED);
            custom.get(RaidStatistics.RAIDS_COMPLETED);
            custom.get(RaidStatistics.TIER_ONE_COMPLETED);
            custom.get(RaidStatistics.TIER_TWO_COMPLETED);
            custom.get(RaidStatistics.TIER_THREE_COMPLETED);
            custom.get(RaidStatistics.TIER_FOUR_COMPLETED);
            custom.get(RaidStatistics.TIER_FIVE_COMPLETED);
            custom.get(RaidStatistics.TIER_SIX_COMPLETED);
            custom.get(RaidStatistics.TIER_SEVEN_COMPLETED);
        }
    }
}
