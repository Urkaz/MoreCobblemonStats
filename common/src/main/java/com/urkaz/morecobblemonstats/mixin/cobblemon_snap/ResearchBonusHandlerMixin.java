package com.urkaz.morecobblemonstats.mixin.cobblemon_snap;

import cobblemon.snap.CobblemonSnap;
import cobblemon.snap.data.PlayerSnapData;
import cobblemon.snap.research.ResearchBonus;
import cobblemon.snap.research.ResearchBonusHandler;
import com.cobblemon.mod.common.api.events.pokemon.ShinyChanceCalculationEvent;
import com.urkaz.morecobblemonstats.stats.cobblemon_snap.MCS_CobblemonSnapStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Restriction(require = {@Condition(value = MCS_CobblemonSnapStats.MOD_ID, versionPredicates = "<=1.1.2")})
@Mixin(ResearchBonusHandler.class)
public class ResearchBonusHandlerMixin {

    @Redirect(
            method = "lambda$register$1",
            at = @At(value = "INVOKE",
                    target = "Lcobblemon/snap/research/ResearchBonusHandler;onShinyChanceCalculation(Lcom/cobblemon/mod/common/api/events/pokemon/ShinyChanceCalculationEvent;)V")
    )
    private static void modifyBoostedChance(ShinyChanceCalculationEvent event) {
        event.addModificationFunction((currentChance, player, pokemon) -> {
            if (player != null) {
                PlayerSnapData data = CobblemonSnap.getStorage().getPlayerSnapData(player.getUUID());
                float shinyBonus = ResearchBonus.getTotalShinyBonus(data);
                if (shinyBonus > 0.0F) {
                    float boostedChance = currentChance / (1.0F + shinyBonus);
                    CobblemonSnap.LOGGER.debug("SNAP: Applied shiny odds bonus to {} ({} -> {})", player.getName().getString(), currentChance, boostedChance);
                    return boostedChance;
                }
            }
            return currentChance;
        });
    }
}
