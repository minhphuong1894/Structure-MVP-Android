package com.ether.minhphuong.ether_android.activity.login;

import com.ether.minhphuong.ether_android.base.mvp.BasePresenter;
import com.ether.minhphuong.ether_android.base.mvp.BaseView;

/**
 * Created by minhphuong on 5/24/18.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void onShowResponse(String message);
    }

    interface Presenter extends BasePresenter {
        void onShowTestDemo(String test);
    }
}
