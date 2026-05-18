package com.my.televip.virtuals.SQLite;

import com.my.televip.obfuscate.AutomationResolver;
import com.my.televip.virtuals.tgnet.NativeByteBuffer;

import de.robv.android.xposed.XposedHelpers;

public class SQLitePreparedStatement {

    Object sQLitePreparedStatement;

    public SQLitePreparedStatement(Object sQLitePreparedStatement){
        this.sQLitePreparedStatement = sQLitePreparedStatement;
    }

    public void requery() {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","requery", AutomationResolver.ResolverType.Method));
    }

    public void step() {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","step", AutomationResolver.ResolverType.Method));
    }

    public void dispose() {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","dispose", AutomationResolver.ResolverType.Method));
    }

    public void bindByteBuffer(int index, NativeByteBuffer value) {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","bindByteBuffer", AutomationResolver.ResolverType.Method), index, value.nativeByteBuffer);
    }

    public void bindLong(int index, long value) {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","bindLong", AutomationResolver.ResolverType.Method), index, value);
    }

    public void bindInteger(int index, int value) {
        XposedHelpers.callMethod(sQLitePreparedStatement, AutomationResolver.resolve("SQLitePreparedStatement","bindInteger", AutomationResolver.ResolverType.Method), index, value);
    }

}
