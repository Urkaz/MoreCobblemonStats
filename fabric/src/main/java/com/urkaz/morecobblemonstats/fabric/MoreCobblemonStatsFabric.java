package com.urkaz.morecobblemonstats.fabric;

import com.urkaz.morecobblemonstats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.stats.Stats;

public class MoreCobblemonStatsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreCobblemonStats.init();
        MCS_Stats.registerStats();
        MCS_Stats.INSTANCE.getStats().forEach(((statName, cobblemonStat) -> {
            Registry.register(BuiltInRegistries.CUSTOM_STAT, cobblemonStat.getResourceLocation(), cobblemonStat.getResourceLocation());
            Stats.CUSTOM.get(cobblemonStat.getResourceLocation(), cobblemonStat.component2());
        }));
    }
}
