package com.my.televip.features;

import com.my.televip.Class.ClassLoad;
import com.my.televip.Class.ClassNames;
import com.my.televip.Configs.ConfigManager;
import com.my.televip.application.AndroidUtilities;
import com.my.televip.base.AbstractMethodHook;
import com.my.televip.hooks.HMethod;
import com.my.televip.logging.Logger;
import com.my.televip.obfuscate.AutomationResolver;
import com.my.televip.virtuals.messenger.MessagesController;

public class HideProxySponsor {

    public static boolean isEnable = false;

    public static void init() {
        try {
            if (!isEnable) {
                isEnable = true;
                if (ClassLoad.getClass(ClassNames.MESSAGES_CONTROLLER) != null) {
                    HMethod.hookMethod(ClassLoad.getClass(ClassNames.MESSAGES_CONTROLLER),
                            AutomationResolver.resolve("MessagesController", "checkPromoInfoInternal", AutomationResolver.ResolverType.Method),AutomationResolver.merge(AutomationResolver.resolveObject("checkPromoInfoInternal", new Class[]{boolean.class}), new AbstractMethodHook() {
                                @Override
                                protected void afterMethod(MethodHookParam param) {
                                    if (ConfigManager.hideProxySponsor.isEnable()) {
                                        MessagesController messagesController = new MessagesController(param.thisObject);
                                        AndroidUtilities.runOnUIThread(messagesController::removePromoDialog);
                                        removePromoDialog();
                                    }
                                }
                            }));
                }
            }
        } catch (Throwable e) {
            Logger.e(e);
        }
    }

    public static void removePromoDialog() {
        if (MessagesController.getGlobalMainSettings() == null) return;
        MessagesController.getGlobalMainSettings().edit().remove("proxy_dialog").remove("proxyDialogAddress").remove("nextPromoInfoCheckTime").apply();
    }

}
