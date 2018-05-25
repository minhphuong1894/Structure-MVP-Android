package com.ether.minhphuong.ether_android.datasource.local;

import android.content.Context;

import javax.inject.Inject;

import static com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp.SCHEMA.LOGIN_PREF;
import static com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp.SCHEMA.PIN_CODE_TOKEN;

/**
 * Created by minhphuong on 5/23/18.
 */

public class EtherLocalHelp extends BasePreference {
    private String pinCode;


    @Inject
    public EtherLocalHelp(Context context) {
        this.context = context;
        this.PREF_NAME = LOGIN_PREF;
    }

    static class SCHEMA {
        static String LOGIN_PREF = "LOGIN_PREF";
        static String PIN_CODE_TOKEN = "PIN_CODE_TOKEN";
    }

    public void onClearPinCode() {
        context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public  String onGetPinCode() {
        return load(context, LOGIN_PREF, PIN_CODE_TOKEN, "");
    }

    public void onSetPinCode(String accessToken) {
        this.pinCode = accessToken;
        save(PIN_CODE_TOKEN, accessToken);
    }

}
