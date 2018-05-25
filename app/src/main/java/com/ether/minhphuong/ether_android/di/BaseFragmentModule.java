package com.ether.minhphuong.ether_android.di;

import com.ether.minhphuong.ether_android.di.scope.FragmentScoped;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/25/18.
 */

@Module
public class BaseFragmentModule {
    @FragmentScoped
    @Provides
    CompositeDisposable compositeDisposable() {
        return new CompositeDisposable();
    }

    @FragmentScoped
    @Provides
    Bus bus() {
        return new Bus();
    }
}
