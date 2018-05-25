package com.ether.minhphuong.ether_android.activity.launch;

import android.app.Activity;

import com.ether.minhphuong.ether_android.datasource.DataRepository;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/24/18.
 */

public class LaunchPresenter implements LaunchContract.Presenter {

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    EtherLocalHelp mEtherHelp;

    @Inject
    Activity mActivity;

    private LaunchContract.View mView;
    private DataRepository mDataRepository;

    @Inject
    public LaunchPresenter(DataRepository dataRepository, LaunchContract.View view) {
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

}
