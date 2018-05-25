package com.ether.minhphuong.ether_android.activity.home;

import android.app.Activity;

import com.ether.minhphuong.ether_android.datasource.DataRepository;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/25/18.
 */

public class HomePresenter implements HomeContract.Presenter {

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    EtherLocalHelp mEtherHelp;

    @Inject
    Activity mActivity;

    private HomeContract.View mView;
    private DataRepository mDataRepository;

    @Inject
    public HomePresenter(DataRepository dataRepository, HomeContract.View view) {
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
