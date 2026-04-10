package com.urkaz.morecobblemonstats;

import com.urkaz.morecobblemonstats.events.MCS_CobblemonEventListener;
import com.urkaz.morecobblemonstats.events.MCS_MegaShowdownEventListener;
import com.urkaz.morecobblemonstats.events.MCS_ShadowedHeartsEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreCobblemonStats {

    public static final String MOD_ID = "more_cobblemon_stats";
    public static final Logger LOGGER = LoggerFactory.getLogger("MoreCobblemonStats");

    public static void init() {
        MCS_CobblemonEventListener.registerEvents();
        MCS_MegaShowdownEventListener.registerEvents();
        MCS_ShadowedHeartsEventListener.registerEvents();
    }
}
