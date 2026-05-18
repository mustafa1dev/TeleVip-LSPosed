package com.my.televip.virtuals.androidx;

import com.my.televip.obfuscate.AutomationResolver;

import java.util.ArrayList;

import de.robv.android.xposed.XposedHelpers;

public class LongSparseArray {

    Object longSparseArray;

    public LongSparseArray(Object longSparseArray) {
        this.longSparseArray = longSparseArray;
    }

    public ArrayList<Object> get(long id){
        return (ArrayList<Object>) XposedHelpers.callMethod(longSparseArray, AutomationResolver.resolve("LongSparseArray", "get", AutomationResolver.ResolverType.Method), id);

    }
    public int size(){
        return (int) XposedHelpers.callMethod(longSparseArray, AutomationResolver.resolve("LongSparseArray", "size", AutomationResolver.ResolverType.Method));

    }

}
