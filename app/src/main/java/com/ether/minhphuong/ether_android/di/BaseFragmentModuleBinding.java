package com.ether.minhphuong.ether_android.di;

import com.ether.minhphuong.ether_android.activity.home.drawer.dagger.DrawerModule;
import com.ether.minhphuong.ether_android.activity.home.drawer.view.DrawerFragment;
import com.ether.minhphuong.ether_android.di.scope.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by minhphuong on 5/25/18.
 */

@Module
public abstract class BaseFragmentModuleBinding {

    @FragmentScoped
    @ContributesAndroidInjector(modules = {
            DrawerModule.class,
            BaseFragmentModule.class
    })
    abstract DrawerFragment drawerFragment();
}
