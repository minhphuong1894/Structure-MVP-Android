package com.ether.minhphuong.ether_android.activity.home.drawer.dagger;

import android.support.v4.app.Fragment;

import com.ether.minhphuong.ether_android.activity.home.drawer.DrawerContract;
import com.ether.minhphuong.ether_android.activity.home.drawer.DrawerPresenter;
import com.ether.minhphuong.ether_android.activity.home.drawer.view.DrawerFragment;
import com.ether.minhphuong.ether_android.di.scope.FragmentScoped;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/25/18.
 */

@Module
public abstract class DrawerModule {
    @FragmentScoped
    @Binds
    abstract DrawerContract.View view(DrawerFragment loginActivity);

    @FragmentScoped
    @Binds
    abstract DrawerContract.Presenter presenter(DrawerPresenter presenter);

    @FragmentScoped
    @Binds
    abstract Fragment fragment(DrawerFragment navigationDrawerFragment);
}
