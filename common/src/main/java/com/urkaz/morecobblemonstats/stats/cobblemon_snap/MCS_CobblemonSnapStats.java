package com.urkaz.morecobblemonstats.stats.cobblemon_snap;

import com.urkaz.morecobblemonstats.MCS_Platform;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;

import java.util.Map;

public class MCS_CobblemonSnapStats {

    public static final String MOD_ID = "cobblemon_snap";

    public static final MCS_Stats.CustomStat PHOTOS_TAKEN = new MCS_Stats.CustomStat(MOD_ID, "photos_taken");
    public static final MCS_Stats.CustomStat PHOTOS_RECORDED = new MCS_Stats.CustomStat(MOD_ID, "photos_recorded");
    public static final MCS_Stats.CustomStat TOTAL_POKEMON_CAPTURED = new MCS_Stats.CustomStat(MOD_ID, "total_pokemon_captured");
    public static final MCS_Stats.CustomStat UNIQUE_POKEMON_CAPTURED = new MCS_Stats.CustomStat(MOD_ID, "unique_pokemon_captured");

    public static void registerStats(Map<String, MCS_Stats.CustomStat> stats) {
        if (MCS_Platform.isModLoaded(MOD_ID)) {
            stats.put("photos_taken", PHOTOS_TAKEN);
            stats.put("photos_recorded", PHOTOS_RECORDED);
            stats.put("total_pokemon_captured", TOTAL_POKEMON_CAPTURED);
            stats.put("unique_pokemon_captured", UNIQUE_POKEMON_CAPTURED);
        }
    }

}
