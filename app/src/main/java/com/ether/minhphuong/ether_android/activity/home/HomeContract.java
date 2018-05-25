package com.ether.minhphuong.ether_android.activity.home;

import com.ether.minhphuong.ether_android.base.mvp.BasePresenter;
import com.ether.minhphuong.ether_android.base.mvp.BaseView;

/**
 * Created by minhphuong on 5/25/18.
 */

public interface HomeContract {

    interface View extends BaseView<HomeContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
