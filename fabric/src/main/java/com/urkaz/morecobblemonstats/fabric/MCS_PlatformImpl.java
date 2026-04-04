package com.urkaz.morecobblemonstats.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class MCS_PlatformImpl {

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
