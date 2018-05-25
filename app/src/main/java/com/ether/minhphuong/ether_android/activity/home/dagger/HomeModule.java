package com.ether.minhphuong.ether_android.activity.home.dagger;

import android.app.Activity;

import com.ether.minhphuong.ether_android.activity.home.HomeContract;
import com.ether.minhphuong.ether_android.activity.home.HomePresenter;
import com.ether.minhphuong.ether_android.activity.home.view.HomeActivity;
import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/25/18.
 */

@Module
public abstract class HomeModule {
    @ActivityScoped
    @Binds
    abstract HomeContract.View view(HomeActivity loginActivity);

    @ActivityScoped
    @Binds
    abstract HomeContract.Presenter presenter(HomePresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(HomeActivity homeActivity);
}
