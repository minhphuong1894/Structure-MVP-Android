package com.ether.minhphuong.ether_android.datasource.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by minhphuong on 5/23/18.
 */

abstract class BasePreference {
    String PREF_NAME = "DEFAULT_PREF";
    Context context;

    void save(String tag, String value) {
        SharedPreferences.Editor  editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(tag, value);
        editor.apply();
    }

    String load(String tag, String defValue) {
        return load(context, PREF_NAME, tag, defValue);
    }

    public void clearLocalCache() {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().clear().apply();
    }

    static String load(Context context, String PREF_NAME, String tag, String defValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(tag, defValue);
    }

}

