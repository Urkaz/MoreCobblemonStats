package com.urkaz.morecobblemonstats.fabric;

import com.urkaz.morecobblemonstats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.commands.MCS_Commands;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
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
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            MCS_Commands.register(dispatcher);
        });
    }
}
