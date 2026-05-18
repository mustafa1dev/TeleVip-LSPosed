package com.my.televip.virtuals.ui.Components;

import android.content.Context;
import android.view.View;

import com.my.televip.Class.ClassNames;
import com.my.televip.Class.ClassLoad;
import com.my.televip.dex.DexInjector;
import com.my.televip.obfuscate.AutomationResolver;
import com.my.televip.virtuals.androidx.Adapter;

import de.robv.android.xposed.XposedHelpers;

public class RecyclerListView {

    public final Object recyclerListView;

    public RecyclerListView(Context context){
        recyclerListView = XposedHelpers.newInstance(ClassLoad.getClass(ClassNames.SETTINGS_ADAPTER_RECYCLER_LIST_VIEW, DexInjector.classLoader), context);
    }

    public void setAdapter(Object adapter) {
        XposedHelpers.callMethod(recyclerListView, AutomationResolver.resolve("RecyclerListView", "setAdapter", AutomationResolver.ResolverType.Method), adapter);
    }

    public Adapter getAdapter() {
        return new Adapter(XposedHelpers.callMethod(recyclerListView, AutomationResolver.resolve("RecyclerListView", "getAdapter", AutomationResolver.ResolverType.Method)));
    }

    public void setBackgroundColor(int color) {
        ((View)recyclerListView).setBackgroundColor(color);
    }

    public void setVerticalScrollBarEnabled(boolean b) {
        ((View)recyclerListView).setVerticalScrollBarEnabled(b);
    }

    public void setLayoutManager(Object layout) {
        XposedHelpers.callMethod(recyclerListView, AutomationResolver.resolve("RecyclerListView", "setLayoutManager", AutomationResolver.ResolverType.Method), layout);
    }

    public View getRecyclerListView() {
       return (View) recyclerListView;
    }

}
