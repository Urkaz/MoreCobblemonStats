package com.urkaz.morecobblemonstats.neoforge;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class MCS_PlatformImpl {

    public static boolean isModLoaded(String modId) {
        if (ModList.get() != null)
            return ModList.get().isLoaded(modId);
        return FMLLoader.getLoadingModList().getModFileById(modId) != null;
    }
}
