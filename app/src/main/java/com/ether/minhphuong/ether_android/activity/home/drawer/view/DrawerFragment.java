package com.ether.minhphuong.ether_android.activity.home.drawer.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.home.drawer.DrawerContract;
import com.ether.minhphuong.ether_android.base.fragment.BaseFragment;
import com.ether.minhphuong.ether_android.databinding.FragmentNavigationBinding;

import javax.inject.Inject;

/**
 * Created by minhphuong on 5/25/18.
 */

public class DrawerFragment extends BaseFragment implements DrawerContract.View ,View.OnClickListener{

    @Inject
    DrawerContract.Presenter mPresenter;

    FragmentNavigationBinding mBinding;

    private onNavigationItemClick mOnNavigationItemClick;

    public onNavigationItemClick getOnNavigationItemClick() {
        return mOnNavigationItemClick;
    }

    public void setOnNavigationItemClick(onNavigationItemClick mOnNavigationItemClick) {
        this.mOnNavigationItemClick = mOnNavigationItemClick;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_navigation, container, false);
        initHandle();
        return mBinding.getRoot();
    }

    private void initHandle() {
        mBinding.fragmentChangePinNavigation.setOnClickListener(this);
        mBinding.fragmentEarnCoinNavigation.setOnClickListener(this);
        mBinding.fragmentJoinAirdropNavigation.setOnClickListener(this);
        mBinding.fragmentRecoverNavigation.setOnClickListener(this);
        mBinding.fragmentSignOutNavigation.setOnClickListener(this);
        mBinding.fragmentTransactionNavigation.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onClick(View view) {
        if (getOnNavigationItemClick() != null) {
            mOnNavigationItemClick.onNavigationItemClicked(view.getId());
        }
    }

    public interface onNavigationItemClick {
        void onNavigationItemClicked(int id);
    }
}
