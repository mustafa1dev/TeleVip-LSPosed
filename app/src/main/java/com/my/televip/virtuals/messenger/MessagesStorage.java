package com.my.televip.virtuals.messenger;

import com.my.televip.Class.ClassNames;
import com.my.televip.Class.ClassLoad;
import com.my.televip.obfuscate.AutomationResolver;
import com.my.televip.virtuals.SQLite.SQLiteDatabase;

import de.robv.android.xposed.XposedHelpers;

public class MessagesStorage {

    Object messagesStorage;

    public MessagesStorage(Object obj) {
        messagesStorage = obj;
    }

    public SQLiteDatabase getDatabase() {

        return new SQLiteDatabase(XposedHelpers.callMethod(messagesStorage, AutomationResolver.resolve("MessagesStorage", "getDatabase", AutomationResolver.ResolverType.Method)));
    }

    public DispatchQueue getStorageQueue() {

        return new DispatchQueue(XposedHelpers.callMethod(messagesStorage, AutomationResolver.resolve("MessagesStorage", "getStorageQueue", AutomationResolver.ResolverType.Method)));
    }

    public static MessagesStorage getInstance(int num) {
        return new MessagesStorage(XposedHelpers.callStaticMethod(ClassLoad.getClass(ClassNames.MESSAGES_STORAGE), AutomationResolver.resolve("MessagesStorage", "getInstance", AutomationResolver.ResolverType.Method), num));
    }

}
