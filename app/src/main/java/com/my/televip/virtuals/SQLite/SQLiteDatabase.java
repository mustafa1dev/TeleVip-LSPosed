package com.my.televip.virtuals.SQLite;

import com.my.televip.obfuscate.AutomationResolver;

import de.robv.android.xposed.XposedHelpers;

public class SQLiteDatabase {

    Object sqLiteDatabase;

    public SQLiteDatabase(Object obj){ sqLiteDatabase = obj; }

    public SQLiteCursor queryFinalized(String s, Object[] objects){
        return new SQLiteCursor(XposedHelpers.callMethod(sqLiteDatabase, AutomationResolver.resolve("SQLiteDatabase", "queryFinalized", AutomationResolver.ResolverType.Method), s, objects));
    }

    public SQLitePreparedStatement executeFast(String s){
        return new SQLitePreparedStatement(XposedHelpers.callMethod(sqLiteDatabase, AutomationResolver.resolve("SQLiteDatabase", "executeFast", AutomationResolver.ResolverType.Method), s));
    }

}
