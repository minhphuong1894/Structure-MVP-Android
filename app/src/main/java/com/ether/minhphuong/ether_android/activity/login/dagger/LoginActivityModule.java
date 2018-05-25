package com.ether.minhphuong.ether_android.activity.login.dagger;

import android.app.Activity;

import com.ether.minhphuong.ether_android.activity.login.LoginContract;
import com.ether.minhphuong.ether_android.activity.login.LoginPresenter;
import com.ether.minhphuong.ether_android.activity.login.view.LoginActivity;
import com.ether.minhphuong.ether_android.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/24/18.
 */

@Module
public abstract class LoginActivityModule {

    @ActivityScoped
    @Binds
    abstract LoginContract.View view(LoginActivity loginActivity);

    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter presenter(LoginPresenter presenter);

    @ActivityScoped
    @Binds
    abstract Activity activity(LoginActivity loginActivity);

}

