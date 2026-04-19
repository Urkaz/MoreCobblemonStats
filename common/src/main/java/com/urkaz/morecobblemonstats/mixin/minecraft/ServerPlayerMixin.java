package com.urkaz.morecobblemonstats.mixin.minecraft;

import com.urkaz.morecobblemonstats.extensions.ServerPlayerExtensions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.ServerStatsCounter;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin implements ServerPlayerExtensions {

    @Final
    @Shadow
    private ServerStatsCounter stats;

    @Shadow
    public abstract void resetStat(Stat<?> stat);

    @Shadow
    public abstract void awardStat(Stat<?> stat, int i);

    //Stats.CUSTOM.get(

    @Unique
    public int mcs$getStat(ResourceLocation stat) {
        Stat<ResourceLocation> s = Stats.CUSTOM.get(stat);
        return this.stats.getValue(s);
    }

    @Unique
    public int mcs$getStat(Stat<?> stat) {
        return this.stats.getValue(stat);
    }

    @Unique
    public void mcs$setStat(ResourceLocation stat, int value) {
        Stat<ResourceLocation> s = Stats.CUSTOM.get(stat);
        resetStat(s);
        awardStat(s, value);
    }

    @Unique
    public void mcs$setHighStat(ResourceLocation stat, int value) {
        Stat<ResourceLocation> s = Stats.CUSTOM.get(stat);
        if (mcs$getStat(s) < value) {
            resetStat(s);
            awardStat(s, value);
        }
    }
}
