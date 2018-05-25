package com.ether.minhphuong.ether_android;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by minhphuong on 5/23/18.
 */

public class EtherApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerEtherComponent.builder().application(this).builder();
    }
}
