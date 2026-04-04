package com.urkaz.morecobblemonstats;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class MCS_Platform {

    @ExpectPlatform
    public static boolean isModLoaded(String modId) {
        return false;
    }
}
