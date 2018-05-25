package com.ether.minhphuong.ether_android.activity.login.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.login.LoginContract;
import com.ether.minhphuong.ether_android.base.activity.BaseActivity;
import com.ether.minhphuong.ether_android.databinding.ActivityMainBinding;

import javax.inject.Inject;

/**
 * Created by minhphuong on 5/24/18.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginContract.Presenter mPresenter;

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter.onShowTestDemo("login");

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

    @Override
    public void onShowResponse(String message) {
        mBinding.test.setText(message);
    }
}
