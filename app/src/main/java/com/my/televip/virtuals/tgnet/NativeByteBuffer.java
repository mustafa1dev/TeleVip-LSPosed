package com.my.televip.virtuals.tgnet;

import com.my.televip.obfuscate.AutomationResolver;

import de.robv.android.xposed.XposedHelpers;

public class NativeByteBuffer {

    public final Object nativeByteBuffer;

    public NativeByteBuffer(Object obj){
        nativeByteBuffer = obj;
    }

    public void reuse(){
        XposedHelpers.callMethod(nativeByteBuffer, AutomationResolver.resolve("NativeByteBuffer", "reuse", AutomationResolver.ResolverType.Method));
    }

    public int readInt32(boolean exception) {
        return (int) XposedHelpers.callMethod(nativeByteBuffer, AutomationResolver.resolve("NativeByteBuffer","readInt32", AutomationResolver.ResolverType.Method), exception);
    }

    public void position(int i) {
        XposedHelpers.callMethod(nativeByteBuffer, AutomationResolver.resolve("NativeByteBuffer","position", AutomationResolver.ResolverType.Method), i);
    }

    public void writeInt32(int i) {
        XposedHelpers.callMethod(nativeByteBuffer, AutomationResolver.resolve("NativeByteBuffer","writeInt32", AutomationResolver.ResolverType.Method), i);
    }

}
