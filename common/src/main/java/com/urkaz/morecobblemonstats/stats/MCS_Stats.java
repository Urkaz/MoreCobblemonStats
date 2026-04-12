package com.urkaz.morecobblemonstats.stats;

import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobbledollars.MCS_CobbledollarsStats;
import com.urkaz.morecobblemonstats.stats.cobblemon.MCS_CobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_battle_tower.MCS_CobblemonBattleTowerStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_expeditions.MCS_CobblemonExpeditionsStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_mega_showdown.MCS_CobblemonMegaShowdownStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_quick_battle.MCS_CobblemonQuickBattleStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_snap.MCS_CobblemonSnapStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_ultrabeast.MCS_CobblemonUltraBeastStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_wonder_trade.MCS_CobblemonWonderTradeStats;
import com.urkaz.morecobblemonstats.stats.cobblemonmarks.MCS_CobblemonMarksStats;
import com.urkaz.morecobblemonstats.stats.cobblemonresearchtasks.MCS_CobblemonResearchTasksStats;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariDungeonHelper;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariStats;
import com.urkaz.morecobblemonstats.stats.pokebike.MCS_PokeBikeStats;
import com.urkaz.morecobblemonstats.stats.rustlingspots.MCS_RustlingSpotsStats;
import com.urkaz.morecobblemonstats.stats.shadowedhearts.MCS_ShadowedHeartsStats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MCS_Stats {

    public static final MCS_Stats INSTANCE = new MCS_Stats();

    private static final Map<String, CustomStat> stats = new LinkedHashMap<>();

    public static void registerStats() {
        MoreCobblemonStats.LOGGER.info("Registering stats...");

        MCS_CobblemonStats.registerStats(stats);
        MCS_CobbledollarsStats.registerStats(stats);
        MCS_CobbleSafariStats.registerStats(stats);
        MCS_CobblemonQuickBattleStats.registerStats(stats);
        MCS_CobblemonMegaShowdownStats.registerStats(stats);
        MCS_RustlingSpotsStats.registerStats(stats);
        MCS_CobblemonMarksStats.registerStats(stats);
        MCS_CobblemonUltraBeastStats.registerStats(stats);
        MCS_CobblemonResearchTasksStats.registerStats(stats);
        MCS_CobblemonSnapStats.registerStats(stats);
        MCS_PokeBikeStats.registerStats(stats);
        MCS_CobblemonExpeditionsStats.registerStats(stats);
        MCS_ShadowedHeartsStats.registerStats(stats);
        MCS_CobblemonBattleTowerStats.registerStats(stats);
        MCS_CobblemonWonderTradeStats.registerStats(stats);
    }

    @NotNull
    public final Map<String, CustomStat> getCustomStats() {
        return stats;
    }

    public static ResourceLocation getStat(@NotNull CustomStat customStat) {
        ResourceLocation resourceLocation = customStat.getLocation();
        ResourceLocation stat = BuiltInRegistries.CUSTOM_STAT.get(resourceLocation);
        if (stat == null) {
            MoreCobblemonStats.LOGGER.error("Could not find stat with id {}", resourceLocation);
        }
        return stat;
    }

    public static void registerCobblesafariDynamicStats() {
        MoreCobblemonStats.LOGGER.info("Registering CobbleSafari Dynamic stats...");
        MCS_CobbleSafariDungeonHelper.autoRegisterDungeonStats(stats);
    }

    public static final class CustomStat {
        private final ResourceLocation location;
        private final StatFormatter formatter;

        public CustomStat(String namespace, String path, StatFormatter formatter) {
            this.location = ResourceLocation.fromNamespaceAndPath(namespace, path);
            this.formatter = formatter;
        }

        public CustomStat(String namespace, String path) {
            this.location = ResourceLocation.fromNamespaceAndPath(namespace, path);
            this.formatter = StatFormatter.DEFAULT;
        }

        public ResourceLocation getLocation() {
            return location;
        }

        public StatFormatter formatter() {
            return formatter;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (CustomStat) obj;
            return Objects.equals(this.location, that.location) &&
                    Objects.equals(this.formatter, that.formatter);
        }

        @Override
        public int hashCode() {
            return Objects.hash(location, formatter);
        }

        @Override
        public String toString() {
            return "CustomStat[" +
                    "location=" + location + ", " +
                    "formatter=" + formatter + ']';
        }
    }
}
