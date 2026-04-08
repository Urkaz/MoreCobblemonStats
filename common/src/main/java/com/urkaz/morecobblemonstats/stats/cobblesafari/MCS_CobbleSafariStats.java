package com.urkaz.morecobblemonstats.stats.cobblesafari;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import net.minecraft.stats.StatFormatter;

import java.util.Map;

public class MCS_CobbleSafariStats {

    public static final String MOD_ID = "cobblesafari";

    public static final MCS_Stats.CustomStat SAFARI_ENTER = new MCS_Stats.CustomStat(MOD_ID, "safari_entered");
    public static final MCS_Stats.CustomStat HOOPA_RINGS_USED = new MCS_Stats.CustomStat(MOD_ID, "hoopa_rings_used");
    public static final MCS_Stats.CustomStat UNDERGROUND_TREASURES_FOUND = new MCS_Stats.CustomStat(MOD_ID, "underground_treasures_found");
    public static final MCS_Stats.CustomStat SECRET_BASE_FLAGS_STOLEN = new MCS_Stats.CustomStat(MOD_ID, "secret_base_flags_stolen");
    public static final MCS_Stats.CustomStat SAFARI_BALLOON_DROP = new MCS_Stats.CustomStat(MOD_ID, "reward_balloons_looted");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("safari_entered", SAFARI_ENTER);
            stats.put("hoopa_rings_used", HOOPA_RINGS_USED);
            stats.put("underground_treasures_found", UNDERGROUND_TREASURES_FOUND);
            stats.put("secret_base_flags_stolen", SECRET_BASE_FLAGS_STOLEN);
            stats.put("reward_balloons_looted", SAFARI_BALLOON_DROP);
        }
    }

}
