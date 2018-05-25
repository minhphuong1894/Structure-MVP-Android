package com.ether.minhphuong.ether_android.activity.launch.dagger;

import android.app.Activity;

import com.ether.minhphuong.ether_android.activity.launch.LaunchContract;
import com.ether.minhphuong.ether_android.activity.launch.LaunchPresenter;
import com.ether.minhphuong.ether_android.activity.launch.view.LaunchActivity;
import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/24/18.
 */

@Module
public abstract class LaunchActivityModule {

    @ActivityScoped
    @Binds
    abstract LaunchContract.View view(LaunchActivity launchActivity);

    @ActivityScoped
    @Binds
    abstract LaunchContract.Presenter presenter(LaunchPresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(LaunchActivity launchActivity);

}
