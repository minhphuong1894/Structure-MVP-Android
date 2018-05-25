package com.ether.minhphuong.ether_android.activity.login;

import android.app.Activity;

import com.ether.minhphuong.ether_android.datasource.DataRepository;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/24/18.
 */

public class LoginPresenter implements LoginContract.Presenter {

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    EtherLocalHelp mEtherHelp;

    @Inject
    Activity mActivity;

    private LoginContract.View mView;
    private DataRepository mDataRepository;

    @Inject
    public LoginPresenter(DataRepository dataRepository, LoginContract.View view) {
        this.mView = view;
        this.mDataRepository = dataRepository;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void onShowTestDemo(String test) {
        String a = "aaa ";
        mView.onShowResponse(a+test);
    }
}
