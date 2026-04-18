package com.urkaz.morecobblemonstats.mixin.cobblemon_snap;

import cobblemon.snap.CobblemonSnap;
import cobblemon.snap.data.PhotoData;
import cobblemon.snap.data.PlayerSnapData;
import cobblemon.snap.item.CameraItem;
import cobblemon.snap.item.CapturedPokemonData;
import com.cobblemon.mod.common.Cobblemon;
import com.llamalad7.mixinextras.sugar.Local;
import com.urkaz.morecobblemonstats.stats.MCS_Stats;
import com.urkaz.morecobblemonstats.stats.cobblemon_snap.MCS_CobblemonSnapStats;
import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Restriction(require = {@Condition(MCS_CobblemonSnapStats.MOD_ID)})
@Mixin(CameraItem.class)
public class CameraItemMixin {

    @Inject(
            method = "handlePhotoCapture",
            at = @At(value = "INVOKE",
                    target = "Ljava/util/List;isEmpty()Z",
                    ordinal = 0
            )
    )
    private static void mcs$handlePhotoCapture(ServerPlayer player, float zoomLevel, CallbackInfo ci) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonSnapStats.PHOTOS_TAKEN));
    }

    @Inject(
            method = "handlePhotoCapture",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V",
                    ordinal = 0
            )
    )
    private static void mcs$captured(ServerPlayer player, float zoomLevel, CallbackInfo ci, @Local(name = "captures") List<CapturedPokemonData> captures) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonSnapStats.TOTAL_POKEMON_CAPTURED), captures.size());

        captures.forEach(capturedPokemonData -> {
            Cobblemon.playerDataManager.getPokedexData(player.getUUID()).encounter(capturedPokemonData.entity().getPokemon());
        });
    }

    @Inject(
            method = "processCapture",
            at = @At(value = "INVOKE",
                    target = "Lcobblemon/snap/storage/SnapdexStorage;recordPhoto(Ljava/util/UUID;Lcobblemon/snap/data/PhotoData;)V",
                    ordinal = 0
            )
    )
    private static void mcs$processCaptureRecord(CallbackInfo ci, @Local(argsOnly = true) ServerPlayer player, @Local(name = "photoData") PhotoData photoData) {
        player.awardStat(MCS_Stats.getStat(MCS_CobblemonSnapStats.PHOTOS_RECORDED));

        PlayerSnapData data = CobblemonSnap.getStorage().getPlayerSnapData(player.getUUID());
        boolean isNewSpecies = !data.hasPhotographed(photoData.species());
        if (isNewSpecies)
            player.awardStat(MCS_Stats.getStat(MCS_CobblemonSnapStats.UNIQUE_POKEMON_CAPTURED));
    }
}
