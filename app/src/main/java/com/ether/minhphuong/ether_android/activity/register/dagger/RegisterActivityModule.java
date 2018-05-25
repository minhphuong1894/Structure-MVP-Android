package com.ether.minhphuong.ether_android.activity.register.dagger;

import android.app.Activity;

import com.ether.minhphuong.ether_android.activity.register.RegisterContract;
import com.ether.minhphuong.ether_android.activity.register.RegisterPresenter;
import com.ether.minhphuong.ether_android.activity.register.view.RegisterActivity;
import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/24/18.
 */

@Module
public abstract class RegisterActivityModule {
    @ActivityScoped
    @Binds
    abstract RegisterContract.View view(RegisterActivity loginActivity);

    @ActivityScoped
    @Binds
    abstract RegisterContract.Presenter presenter(RegisterPresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(RegisterActivity loginActivity);
}
