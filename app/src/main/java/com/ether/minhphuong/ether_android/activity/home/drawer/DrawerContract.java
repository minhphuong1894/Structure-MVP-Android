package com.ether.minhphuong.ether_android.activity.home.drawer;

import com.ether.minhphuong.ether_android.base.mvp.BasePresenter;
import com.ether.minhphuong.ether_android.base.mvp.BaseView;

/**
 * Created by minhphuong on 5/25/18.
 */

public interface DrawerContract {

    interface View extends BaseView<DrawerContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
