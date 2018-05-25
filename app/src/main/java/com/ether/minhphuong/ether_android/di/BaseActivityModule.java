package com.ether.minhphuong.ether_android.di;

import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/23/18.
 */

@Module
public class BaseActivityModule {

    @ActivityScoped
    @Provides
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }

    @ActivityScoped
    @Provides
    Bus bus() {
        return new Bus();
    }
}

