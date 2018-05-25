package com.ether.minhphuong.ether_android;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/23/18.
 */

@Module
public abstract class EtherModule {

    @Binds
    abstract Context context(Application application);

}
