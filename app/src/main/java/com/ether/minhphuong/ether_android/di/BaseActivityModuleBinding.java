package com.ether.minhphuong.ether_android.di;

import com.ether.minhphuong.ether_android.activity.home.dagger.HomeModule;
import com.ether.minhphuong.ether_android.activity.home.view.HomeActivity;
import com.ether.minhphuong.ether_android.activity.launch.dagger.LaunchActivityModule;
import com.ether.minhphuong.ether_android.activity.launch.view.LaunchActivity;
import com.ether.minhphuong.ether_android.activity.login.dagger.LoginActivityModule;
import com.ether.minhphuong.ether_android.activity.login.view.LoginActivity;
import com.ether.minhphuong.ether_android.activity.register.dagger.RegisterActivityModule;
import com.ether.minhphuong.ether_android.activity.register.view.RegisterActivity;
import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by minhphuong on 5/24/18.
 */

@Module
public abstract class BaseActivityModuleBinding {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            LaunchActivityModule.class,
            BaseActivityModule.class
    })
    abstract LaunchActivity launchActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            LoginActivityModule.class,
            BaseActivityModule.class
    })
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            RegisterActivityModule.class,
            BaseActivityModule.class
    })
    abstract RegisterActivity registerActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            HomeModule.class,
            BaseActivityModule.class
    })
    abstract HomeActivity homeActivity();
}
