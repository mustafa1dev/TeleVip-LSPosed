package com.my.televip.features.otherFeatures;

import android.view.View;

import com.my.televip.Class.ClassLoad;
import com.my.televip.Class.ClassNames;
import com.my.televip.base.AbstractMethodHook;
import com.my.televip.hooks.HMethod;
import com.my.televip.logging.Logger;
import com.my.televip.obfuscate.AutomationResolver;
import com.my.televip.virtuals.ui.PhotoViewer;

public class AlwaysSaveMedia {
    public static void init() {
        try {
            if (ClassLoad.getClass(ClassNames.PHOTO_VIEWER) != null) {

                HMethod.hookMethod(ClassLoad.getClass(ClassNames.PHOTO_VIEWER), AutomationResolver.resolve("PhotoViewer", "setIsAboutToSwitchToIndex", AutomationResolver.ResolverType.Method), AutomationResolver.merge(AutomationResolver.resolveObject("setIsAboutToSwitchToIndex", new Class[]{int.class, boolean.class, boolean.class, boolean.class}), new AbstractMethodHook() {
                    @Override
                    protected void afterMethod(MethodHookParam param) {
                        final PhotoViewer photoViewer = new PhotoViewer(param.thisObject);
                        if (photoViewer.getGalleryButton()!= null) photoViewer.getGalleryButton().setVisibility(View.VISIBLE);

                    }
                }));
            }
        } catch (Throwable t) {
            Logger.e(t);
        }
    }
}