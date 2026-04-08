package com.urkaz.morecobblemonstats.fabric;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
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
        MCS_Stats.INSTANCE.getCustomStats().forEach(((statName, customStat) -> {
            Registry.register(BuiltInRegistries.CUSTOM_STAT, customStat.getLocation(), customStat.getLocation());
            Stats.CUSTOM.get(customStat.getLocation(), customStat.formatter());
        }));

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            MCS_Commands.register(dispatcher);
        });
    }
}
