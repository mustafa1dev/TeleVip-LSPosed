package com.my.televip.features.otherFeatures;


import android.content.Context;

import com.my.televip.Configs.ConfigPreferences;

public class FeatureStateManager {

    public static final String KEY_CHAT = "ChatOnItemClick";
    public static final String KEY_CHAT_BOOL = "ChatOnItemClick_boolean";


    public static boolean isChatEnabled() {
        return ConfigPreferences.getBoolean(KEY_CHAT_BOOL);
    }

    public static String getChatClass() {
        return ConfigPreferences.getString(KEY_CHAT);
    }

    public static void saveChat(String className) {
        ConfigPreferences.putBoolean(KEY_CHAT_BOOL, true);
        ConfigPreferences.putString(KEY_CHAT, className);
    }

    public static void reset(Context context) {
        ConfigPreferences.remove(KEY_CHAT);
        ConfigPreferences.remove(KEY_CHAT_BOOL);
        FeatureInitializer.init(context);
    }
}