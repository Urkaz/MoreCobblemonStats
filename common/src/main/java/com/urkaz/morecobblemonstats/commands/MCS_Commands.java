package com.urkaz.morecobblemonstats.commands;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.pokemon.ShinyChanceCalculationEvent;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.mojang.brigadier.CommandDispatcher;
import kotlin.Unit;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.concurrent.atomic.AtomicReference;

public class MCS_Commands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("mcs")
                        .then(Commands.literal("shiny_check")
                                .then(Commands.argument("target", EntityArgument.player())
                                        .executes(context -> {
                                            ServerPlayer target = EntityArgument.getPlayer(context, "target");
                                            context.getSource().sendSuccess(
                                                    () -> {
                                                        var shinyRate = Cobblemon.config.getShinyRate();
                                                        AtomicReference<Float> newShinyChance = new AtomicReference<>(shinyRate);
                                                        CobblemonEvents.SHINY_CHANCE_CALCULATION.post(new ShinyChanceCalculationEvent[]{new ShinyChanceCalculationEvent(shinyRate, new Pokemon())}, event -> {
                                                            newShinyChance.set(event.calculate(target));
                                                            return Unit.INSTANCE;
                                                        });
                                                        float shinyChance = newShinyChance.get();
                                                        return Component.literal(String.format("Shiny change for %s: 1/%.0f (%.5f)", target.getName().getString(), shinyChance, 1 / shinyChance));
                                                    },
                                                    false
                                            );
                                            return 1;
                                        })
                                )
                        )
        );
    }
}
