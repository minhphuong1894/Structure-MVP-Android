package com.ether.minhphuong.ether_android.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.login.view.LoginActivity;
import com.ether.minhphuong.ether_android.commonview.ActivityManager;
import com.ether.minhphuong.ether_android.utils.Utils;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by minhphuong on 5/23/18.
 */

public class BaseActivity extends DaggerAppCompatActivity implements HasActivityInjector,
        HasFragmentInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject
    DispatchingAndroidInjector<android.app.Fragment> fragmentSupportInjector;

    public static BaseActivity mBaseActivityInstance = null;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActivityInstance = this;
        ActivityManager.getInstance().push(this);
    }

    public void finishAllActivity() {
        finish();
        ActivityManager.getInstance().finishAll();
    }

    public void onFinishActivity(){
        Utils.slideLeftToRight(this);
        finish();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Utils.slideRightToLeft(this);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
        Utils.slideRightToLeft(this);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        Utils.slideRightToLeft(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Utils.slideLeftToRight(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return fragmentSupportInjector;
    }

    protected void setAppTitle() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.origin_name);
        }
    }

    protected void onSignOut(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }


}
