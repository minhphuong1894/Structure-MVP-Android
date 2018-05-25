package com.ether.minhphuong.ether_android.activity.home.view;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.home.HomeContract;
import com.ether.minhphuong.ether_android.activity.home.drawer.view.DrawerFragment;
import com.ether.minhphuong.ether_android.base.activity.BaseActivity;
import com.ether.minhphuong.ether_android.databinding.ActivityHomeBinding;

import javax.inject.Inject;

/**
 * Created by minhphuong on 5/25/18.
 */

public class HomeActivity extends BaseActivity implements HomeContract.View,DrawerFragment.onNavigationItemClick
,NavigationView.OnNavigationItemSelectedListener{

    @Inject
    HomeContract.Presenter mPresenter;

    ActivityHomeBinding mBinding;

    private DrawerFragment mFragmentDrawer;

    private ActionBarDrawerToggle mActionDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initDrawer();
        initActionDrawer();

    }

    private void initActionDrawer(){
        setSupportActionBar(mBinding.appbar.toolbar);
        setAppTitle();
        mActionDrawer = new ActionBarDrawerToggle(
                this, mBinding.drawerLayout, mBinding.appbar.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mBinding.appbar.appBarMainView.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };
        mActionDrawer.setDrawerIndicatorEnabled(false);
        mActionDrawer.setHomeAsUpIndicator(R.drawable.ic_ico_menu);
        mActionDrawer.setToolbarNavigationClickListener(view -> {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        mBinding.drawerLayout.setScrimColor(ContextCompat.getColor(this, android.R.color.transparent));
        mBinding.drawerLayout.addDrawerListener(mActionDrawer);
        mBinding.navView.setNavigationItemSelectedListener(this);
        mFragmentDrawer.setOnNavigationItemClick(this);
    }

    private void initDrawer(){
        mFragmentDrawer = (DrawerFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragment_navigation_drawer);
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
    public void onNavigationItemClicked(int id) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        new Handler().postDelayed(() -> {
            switch (id) {
                case R.id.fragment_transaction_navigation:
                    Toast.makeText(this, "Transaction", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.fragment_sign_out_navigation:
                    onSignOut();
                    Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
                    break;
            }
        }, 400);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
