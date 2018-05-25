package com.ether.minhphuong.ether_android.activity.home.drawer;

import android.app.Activity;

import com.ether.minhphuong.ether_android.datasource.DataRepository;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by minhphuong on 5/25/18.
 */

public class DrawerPresenter implements DrawerContract.Presenter {

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    EtherLocalHelp mEtherHelp;

    private DrawerContract.View mView;
    private DataRepository mDataRepository;

    @Inject
    public DrawerPresenter(DataRepository dataRepository, DrawerContract.View view) {
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
