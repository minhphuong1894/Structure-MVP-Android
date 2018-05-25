package com.ether.minhphuong.ether_android.activity.register.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.MenuItem;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.register.RegisterContract;
import com.ether.minhphuong.ether_android.base.activity.BaseActivity;
import com.ether.minhphuong.ether_android.databinding.ActivityRegisterBinding;

import javax.inject.Inject;

/**
 * Created by minhphuong on 5/24/18.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @Inject
    RegisterContract.Presenter mPresenter;

    ActivityRegisterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        mBinding.test.setText("register");
        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(mBinding.toolbarRegister);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.register_header_title));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_ico_backpress);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
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
}
