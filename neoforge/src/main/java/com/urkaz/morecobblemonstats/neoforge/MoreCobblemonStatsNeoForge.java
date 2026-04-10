package com.urkaz.morecobblemonstats.neoforge;

import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.commands.MCS_Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.Stats;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(MoreCobblemonStats.MOD_ID)
public final class MoreCobblemonStatsNeoForge {

    public MoreCobblemonStatsNeoForge(IEventBus eventBus, ModContainer container) {
        MoreCobblemonStats.init();
        MCS_Stats.registerStats();
    }

    @SubscribeEvent
    public void registerContent(RegisterEvent event) {
        event.register(Registries.CUSTOM_STAT, registry -> {
            MCS_Stats.INSTANCE.getCustomStats().forEach(((statName, customStat) -> {
                registry.register(customStat.getLocation(), customStat.getLocation());
                Stats.CUSTOM.get(customStat.getLocation(), customStat.formatter());
            }));
        });
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        MCS_Commands.register(event.getDispatcher());
    }
}
