package com.urkaz.morecobblemonstats;

import com.cobblemon.mod.common.api.stats.CobblemonStats;
import com.urkaz.morecobblemonstats.cobblesafari.MCS_CobbleSafariDungeonHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

public class MCS_Stats {

    public static final MCS_Stats INSTANCE = new MCS_Stats();

    private static final Map<String, CobblemonStats.CobblemonStat> stats = new LinkedHashMap<String, CobblemonStats.CobblemonStat>();

    // Cobblemon
    public static final CobblemonStats.CobblemonStat POKEBALL_THROWN = new CobblemonStats.CobblemonStat("poke_ball_thrown", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEBALL_THROWN_HIT = new CobblemonStats.CobblemonStat("poke_ball_thrown_hit", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEMON_TERASTALIZED = new CobblemonStats.CobblemonStat("pokemon_terastalized", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEMON_MEGAEVOLVED = new CobblemonStats.CobblemonStat("pokemon_megaevolved", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEMON_ZMOVES_USED = new CobblemonStats.CobblemonStat("z_moves_used", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEMON_FORME_CHANGES = new CobblemonStats.CobblemonStat("pokemon_forme_changes", StatFormatter.DEFAULT);
    // Cobbledollars
    public static final CobblemonStats.CobblemonStat COBBLEDOLLARS_LOST = new CobblemonStats.CobblemonStat("cobbledollars_lost", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat COBBLEDOLLARS_EARNED = new CobblemonStats.CobblemonStat("cobbledollars_earned", StatFormatter.DEFAULT);
    // Cobblesafari
    public static final CobblemonStats.CobblemonStat SAFARI_ENTER = new CobblemonStats.CobblemonStat("safari_entered", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat HOOPA_RINGS_USED = new CobblemonStats.CobblemonStat("hoopa_rings_used", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat UNDERGROUND_TREASURES_FOUND = new CobblemonStats.CobblemonStat("underground_treasures_found", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat SECRET_BASE_FLAGS_STOLEN = new CobblemonStats.CobblemonStat("secret_base_flags_stolen", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat SAFARI_BALLOON_DROP = new CobblemonStats.CobblemonStat("reward_balloons_looted", StatFormatter.DEFAULT);
    // Cobblemon Quick Battle
    public static final CobblemonStats.CobblemonStat QUICK_BATTLE_TOTAL = new CobblemonStats.CobblemonStat("quick_battles_total", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat QUICK_BATTLE_WON = new CobblemonStats.CobblemonStat("quick_battles_won", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat QUICK_BATTLE_LOST = new CobblemonStats.CobblemonStat("quick_battles_lost", StatFormatter.DEFAULT);
    // Mega Showdown
    public static final CobblemonStats.CobblemonStat POKEMON_DYNAMAXED = new CobblemonStats.CobblemonStat("pokemon_dynamaxed", StatFormatter.DEFAULT);
    public static final CobblemonStats.CobblemonStat POKEMON_ULTRA_BURST_USED = new CobblemonStats.CobblemonStat("ultra_burst_used", StatFormatter.DEFAULT);
    // Rustling Spots
    public static final CobblemonStats.CobblemonStat RUSTLING_SPOTS_EXAMINED = new CobblemonStats.CobblemonStat("rustling_spots_examined", StatFormatter.DEFAULT);

    @NotNull
    public final Map<String, CobblemonStats.CobblemonStat> getStats() {
        return stats;
    }

    public static void registerStats() {
        MoreCobblemonStats.LOGGER.info("Registering stats...");

        stats.put("poke_ball_thrown", POKEBALL_THROWN);
        stats.put("poke_ball_thrown_hit", POKEBALL_THROWN_HIT);
        stats.put("pokemon_terastalized", POKEMON_TERASTALIZED);
        stats.put("pokemon_megaevolved", POKEMON_MEGAEVOLVED);
        stats.put("z_moves_used", POKEMON_ZMOVES_USED);
        stats.put("pokemon_forme_changes", POKEMON_FORME_CHANGES);

        if (MCS_Platform.isModLoaded("cobbledollars")) {
            stats.put("cobbledollars_lost", COBBLEDOLLARS_LOST);
            stats.put("cobbledollars_earned", COBBLEDOLLARS_EARNED);
        }

        if (MCS_Platform.isModLoaded("cobblesafari")) {
            stats.put("safari_entered", SAFARI_ENTER);
            stats.put("hoopa_rings_used", HOOPA_RINGS_USED);
            stats.put("underground_treasures_found", UNDERGROUND_TREASURES_FOUND);
            stats.put("secret_base_flags_stolen", SECRET_BASE_FLAGS_STOLEN);
            stats.put("reward_balloons_looted", SAFARI_BALLOON_DROP);
        }

        if (MCS_Platform.isModLoaded("cobblemon_quick_battle")) {
            stats.put("quick_battles_total", QUICK_BATTLE_TOTAL);
            stats.put("quick_battles_won", QUICK_BATTLE_WON);
            stats.put("quick_battles_lost", QUICK_BATTLE_LOST);
        }

        if (MCS_Platform.isModLoaded("cobblemon_mega_showdown")) {
            stats.put("pokemon_dynamaxed", POKEMON_DYNAMAXED);
            stats.put("ultra_burst_used", POKEMON_ULTRA_BURST_USED);
        }

        if (MCS_Platform.isModLoaded("rustlingspots")) {
            stats.put("rustling_spots_examined", RUSTLING_SPOTS_EXAMINED);
        }
    }

    public static ResourceLocation getStat(@NotNull CobblemonStats.CobblemonStat cobblemonStat) {
        ResourceLocation resourceLocation = cobblemonStat.getResourceLocation();
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
}
