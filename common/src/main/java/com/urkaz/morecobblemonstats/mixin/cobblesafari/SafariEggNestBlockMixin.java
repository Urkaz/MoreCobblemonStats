package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.pokemon.CollectEggEvent;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.pokemon.Pokemon;
import maxigregrze.cobblesafari.block.misc.SafariEggNestBlock;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(value = SafariEggNestBlock.class, remap = false)
public class SafariEggNestBlockMixin {

    @Inject(
            method = "handleInteraction",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/Block;popResource(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemStack;)V"
            )
    )
    private void mcs$hatchEggPre(BlockState state, Level level, BlockPos pos, Player player, CallbackInfoReturnable<InteractionResult> cir) {
        ServerPlayer serverPlayer = (ServerPlayer) player;
        CobblemonEvents.COLLECT_EGG.post(new CollectEggEvent(
                new PokemonProperties(),
                new Pokemon(),
                new Pokemon(),
                serverPlayer));
    }
}
