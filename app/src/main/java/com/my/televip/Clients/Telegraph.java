package com.my.televip.Clients;

import com.my.televip.Class.ClassLoad;
import com.my.televip.Class.ClassNames;
import com.my.televip.hooks.HMethod;
import com.my.televip.logging.Logger;
import com.my.televip.obfuscate.struct.ClassInfo;
import com.my.televip.obfuscate.struct.FieldInfo;
import com.my.televip.obfuscate.struct.MethodInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.robv.android.xposed.XC_MethodReplacement;

public class Telegraph {
    private static final List<ClassInfo> classList = new ArrayList<>();
    private static final List<FieldInfo> fieldList = new ArrayList<>();
    private static final List<MethodInfo> methodList = new ArrayList<>();

    public static class ClassResolver
    {
        public static String resolve(String name) {
            for (ClassInfo info : classList)
                if (info.getOriginal().equals(name))
                    return info.getResolved();

            return null;
        }

        public static boolean has(String name)
        {
            boolean has = false;
            for (ClassInfo info : classList) {
                if (info.getOriginal().equals(name)) {
                    has = true;
                    break;
                }
            }
            return has;
        }
    }

    public static class FieldResolver
    {
        public static String resolve(String className, String name) {
            for (FieldInfo info : fieldList)
                if (info.getClassName().equals(className) && info.getOriginal().equals(name))
                    return info.getResolved();

            return null;
        }

        public static boolean has(String className, String name)
        {
            boolean has = false;
            for (FieldInfo info : fieldList) {
                if (info.getClassName().equals(className) && info.getOriginal().equals(name)) {
                    has = true;
                    break;
                }
            }
            return has;
        }
    }

    public static class MethodResolver
    {
        public static String resolve(String className, String name) {
            for (MethodInfo info : methodList)
                if (info.getClassName().equals(className) && info.getOriginal().equals(name))
                    return info.getResolved();

            return null;
        }

        public static boolean has(String className, String name)
        {
            boolean has = false;
            for (MethodInfo info : methodList) {
                if (info.getClassName().equals(className) && info.getOriginal().equals(name)) {
                    has = true;
                    break;
                }
            }
            return has;
        }
    }
    public static class ParameterResolver
    {
        static Map<String,Class<?>[]> objectList = new HashMap<>();

        public static void register(String name,  Class<?>[] classes){
            objectList.put(name,classes);
        }

        public static Class<?>[] resolve(String name) {
            return objectList.get(name);
        }

        public static boolean has(String name)
        {
            boolean has = false;
           Class<?>[] classes = objectList.get(name);
           if (classes != null){
               has = true;
           }
            return has;
        }
    }

    public static void loadParameter() {

        classList.add(new ClassInfo("org.telegram.ui.Components.UniversalAdapter", "org.telegram.ui.Components.IP"));
        classList.add(new ClassInfo("org.telegram.messenger.LocaleController", "org.telegram.messenger.i9"));
        classList.add(new ClassInfo("org.telegram.messenger.ApplicationLoader", "org.telegram.messenger.com5"));
        classList.add(new ClassInfo("org.telegram.messenger.AndroidUtilities", "org.telegram.messenger.com4"));
        classList.add(new ClassInfo("org.telegram.ui.ActionBar.Theme", "org.telegram.ui.ActionBar.x"));
        classList.add(new ClassInfo("org.telegram.ui.Cells.HeaderCell", "org.telegram.ui.Cells.LPT6"));
        classList.add(new ClassInfo("org.telegram.ui.Cells.TextCheckCell", "org.telegram.ui.Cells.O0"));
        classList.add(new ClassInfo("org.telegram.ui.Cells.ShadowSectionCell", "org.telegram.ui.Cells.S"));
        classList.add(new ClassInfo("org.telegram.ui.Cells.TextSettingsCell", "org.telegram.ui.Cells.o1"));
        classList.add(new ClassInfo("org.telegram.ui.ActionBar.AlertDialog$OnButtonClickListener", "org.telegram.ui.ActionBar.AlertDialog$coN"));
        classList.add(new ClassInfo("org.telegram.messenger.UserConfig", "org.telegram.messenger.jF"));
        classList.add(new ClassInfo("org.telegram.messenger.MessagesStorage", "org.telegram.messenger.Ew"));
        classList.add(new ClassInfo("org.telegram.messenger.MessagesController", "org.telegram.messenger.ir"));

        fieldList.add(new FieldInfo("ApplicationLoader","applicationContext", "b"));
        fieldList.add(new FieldInfo("LocaleController","currentLocale", "y"));
        fieldList.add(new FieldInfo("UItem","id", "d"));
        fieldList.add(new FieldInfo("SettingsActivity$SettingCell","iconView", "c"));
        fieldList.add(new FieldInfo("LaunchActivity","frameLayout", "H"));
        fieldList.add(new FieldInfo("UserConfig","selectedAccount", "j0"));

        methodList.add(new MethodInfo("SettingsActivity","fillItems","q0"));
        methodList.add(new MethodInfo("SettingsActivity","onClick","u0"));
        methodList.add(new MethodInfo("SettingsActivity$SettingCell","set","a"));
        methodList.add(new MethodInfo("LocaleController","getInstance","F1"));
        methodList.add(new MethodInfo("AndroidUtilities","isTablet","x4"));
        methodList.add(new MethodInfo("Theme","isCurrentThemeDark","T3"));
        methodList.add(new MethodInfo("TextCheckCell","setTextAndCheck","i"));
        methodList.add(new MethodInfo("TextCheckCell","setTextAndValueAndCheck","j"));
        methodList.add(new MethodInfo("TextCheckCell","isChecked","d"));
        methodList.add(new MethodInfo("TextSettingsCell","setTextAndValue","h"));
        methodList.add(new MethodInfo("TextSettingsCell","setText","c"));
        methodList.add(new MethodInfo("AlertDialog","setTitle","H"));
        methodList.add(new MethodInfo("AlertDialog","setView","O"));
        methodList.add(new MethodInfo("AlertDialog","setMessage","x"));
        methodList.add(new MethodInfo("AlertDialog","setPositiveButton","F"));
        methodList.add(new MethodInfo("AlertDialog","setNegativeButton","z"));
        methodList.add(new MethodInfo("AlertDialog","setNeutralButton","A"));
        methodList.add(new MethodInfo("AlertDialog","show","R"));
        methodList.add(new MethodInfo("AlertDialog","create","c"));
        methodList.add(new MethodInfo("AlertDialog","getDismissRunnable","f"));
        methodList.add(new MethodInfo("AlertDialog$OnButtonClickListener","onClick","a"));
        methodList.add(new MethodInfo("UserConfig","isPremium","N"));
        methodList.add(new MethodInfo("UserConfig","getClientUserId","v"));
        methodList.add(new MethodInfo("UserConfig","getCurrentUser","w"));
        methodList.add(new MethodInfo("MessagesController","getInstance","Ob"));
        methodList.add(new MethodInfo("MessagesStorage","getInstance","N5"));
        methodList.add(new MethodInfo("MessagesController","processNewDifferenceParams","qf"));
        methodList.add(new MethodInfo("MessagesStorage","getStorageQueue","g6"));
        methodList.add(new MethodInfo("MessagesStorage","getDatabase","z5"));

        //ParameterResolver.register("fillMessageMenu", new Class[]{ClassLoad.getClass(ClassNames.MESSAGE_OBJECT), ClassLoad.getClass(ClassNames.MESSAGE_OBJECT), ArrayList.class, ArrayList.class, ArrayList.class});

    }

    public static void removeAd(){
        try {
            Class<?> connectionsManager = ClassLoad.getClass(ClassNames.CONNECTIONS_MANAGER);
            if (connectionsManager != null) {
                HMethod.hookMethod(connectionsManager, "native_expireFile", long.class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) {
                        return false;
                    }
                });
                HMethod.hookMethod(connectionsManager, "native_daysFile", long.class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) {
                        return 999;
                    }
                });
                HMethod.hookMethod(connectionsManager, "native_checkLicense", long.class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) {
                        return true;
                    }
                });
                HMethod.hookMethod(connectionsManager, "native_removeInstance", int.class, boolean.class, new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) {
                        return true;
                    }
                });
            }
        } catch (Throwable t){
            Logger.e(t);
        }
    }

}
