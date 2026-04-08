package com.urkaz.morecobblemonstats.stats;

import com.urkaz.morecobblemonstats.MoreCobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobbledollars.MCS_CobbledollarsStats;
import com.urkaz.morecobblemonstats.stats.cobblemon.MCS_CobblemonStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_mega_showdown.MCS_MegaShowdownStats;
import com.urkaz.morecobblemonstats.stats.cobblemon_quick_battle.MCS_CobblemonQuickBattleStats;
import com.urkaz.morecobblemonstats.stats.cobblemonmarks.MCS_CobblemonMarksStats;
import com.urkaz.morecobblemonstats.stats.cobblemonraiddens.MCS_CobblemonRaidDensStats;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariDungeonHelper;
import com.urkaz.morecobblemonstats.stats.cobblesafari.MCS_CobbleSafariStats;
import com.urkaz.morecobblemonstats.stats.rustlingspots.MCS_RustlingSpotsStats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;
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
        MCS_MegaShowdownStats.registerStats(stats);
        MCS_RustlingSpotsStats.registerStats(stats);
        MCS_CobblemonMarksStats.registerStats(stats);
    }

    public static void initStatScreen(StatType<ResourceLocation> custom) {
        MCS_CobblemonRaidDensStats.initStatScreen(custom);
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
