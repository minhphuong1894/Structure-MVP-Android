package com.ether.minhphuong.ether_android.activity.launch.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.home.view.HomeActivity;
import com.ether.minhphuong.ether_android.activity.launch.LaunchContract;
import com.ether.minhphuong.ether_android.activity.login.view.LoginActivity;
import com.ether.minhphuong.ether_android.activity.register.view.RegisterActivity;
import com.ether.minhphuong.ether_android.base.activity.BaseActivity;
import com.ether.minhphuong.ether_android.databinding.ActivityLaunchBinding;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;
import com.ether.minhphuong.ether_android.utils.Config;
import com.ether.minhphuong.ether_android.utils.Utils;

import javax.inject.Inject;

import static com.ether.minhphuong.ether_android.utils.Config.ServerMode.SERVER_MODE_DEVELOPMENT;

/**
 * Created by minhphuong on 5/24/18.
 */

public class LaunchActivity extends BaseActivity implements LaunchContract.View {

    @Inject
    LaunchContract.Presenter mPresenter;

    @Inject
    EtherLocalHelp mLocalHelp;

    ActivityLaunchBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_launch);
        Config.setMode(SERVER_MODE_DEVELOPMENT);
        onShowDelayActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    private void onShowDelayActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isShowActivity();
            }
        }, 3000);
    }

    private void isShowActivity(){
        onFinishActivity();
        if (Utils.isStringNull(mLocalHelp.onGetPinCode())){
            startActivity(new Intent(this, HomeActivity.class));
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
