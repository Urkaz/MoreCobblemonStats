package com.urkaz.morecobblemonstats.neoforge;

import com.urkaz.morecobblemonstats.MCS_Stats;
import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.commands.MCS_Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.Stats;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(MoreCobblemonStats.MOD_ID)
public final class MoreCobblemonStatsNeoForge {

    public MoreCobblemonStatsNeoForge(IEventBus modBus) {
        modBus.register(this);
        MoreCobblemonStats.init();
        MCS_Stats.registerStats();
    }

    @SubscribeEvent
    public void registerContent(RegisterEvent event) {
        event.register(Registries.CUSTOM_STAT, registry -> {
            MCS_Stats.INSTANCE.getStats().forEach(((statName, cobblemonStat) -> {
                registry.register(cobblemonStat.getResourceLocation(), cobblemonStat.getResourceLocation());
                Stats.CUSTOM.get(cobblemonStat.getResourceLocation(), cobblemonStat.component2());
            }));
        });
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        MCS_Commands.register(event.getDispatcher());
    }
}
