package com.urkaz.morecobblemonstats.extensions;

import net.minecraft.resources.ResourceLocation;

public interface ServerPlayerExtensions {
    int mcs$getStat(ResourceLocation stat);

    void mcs$setStat(ResourceLocation stat, int value);

    void mcs$setHighStat(ResourceLocation stat, int value);
}