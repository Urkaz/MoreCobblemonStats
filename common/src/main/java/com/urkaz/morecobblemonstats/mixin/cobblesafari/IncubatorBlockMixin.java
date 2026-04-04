package com.urkaz.morecobblemonstats.mixin.cobblesafari;

import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.pokemon.HatchEggEvent;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.llamalad7.mixinextras.sugar.Local;
import maxigregrze.cobblesafari.block.incubator.IncubatorBlock;
import maxigregrze.cobblesafari.block.incubator.IncubatorBlockEntity;
import maxigregrze.cobblesafari.incubator.CobbreedingCompat;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Restriction(require = {@Condition("cobblesafari")})
@Mixin(IncubatorBlock.class)
public class IncubatorBlockMixin {

    @Inject(
            method = "useItemOn",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V",
                    ordinal = 2
            )
    )
    private void mcs$hatchEggPre(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir, @Local IncubatorBlockEntity incubator) {
        PokemonProperties properties = CobbreedingCompat.extractProperties(incubator.getInputItem());
        ServerPlayer serverPlayer = (ServerPlayer) player;
        CobblemonEvents.HATCH_EGG_PRE.post(new HatchEggEvent.Pre(properties, serverPlayer));
    }

    @Inject(
            method = "useItemOn",
            at = @At(value = "INVOKE",
                    target = "Lmaxigregrze/cobblesafari/block/incubator/IncubatorBlockEntity;reset()V"
            )
    )
    private void mcs$hatchEggPost(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<ItemInteractionResult> cir, @Local Pokemon pokemon) {
        ServerPlayer serverPlayer = (ServerPlayer) player;
        CobblemonEvents.HATCH_EGG_POST.post(new HatchEggEvent.Post(serverPlayer, pokemon));
    }
}
