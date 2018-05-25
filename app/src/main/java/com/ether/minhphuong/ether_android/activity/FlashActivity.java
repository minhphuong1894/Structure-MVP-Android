package com.ether.minhphuong.ether_android.activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ether.minhphuong.ether_android.R;
import com.ether.minhphuong.ether_android.activity.home.view.HomeActivity;
import com.ether.minhphuong.ether_android.activity.login.view.LoginActivity;
import com.ether.minhphuong.ether_android.activity.register.view.RegisterActivity;
import com.ether.minhphuong.ether_android.base.activity.BaseActivity;
import com.ether.minhphuong.ether_android.datasource.local.EtherLocalHelp;
import com.ether.minhphuong.ether_android.utils.Config;
import com.ether.minhphuong.ether_android.utils.Utils;

import javax.inject.Inject;

import static com.ether.minhphuong.ether_android.utils.Config.ServerMode.SERVER_MODE_DEVELOPMENT;

public class FlashActivity extends BaseActivity {

    @Inject
    EtherLocalHelp mLocalHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Config.setMode(SERVER_MODE_DEVELOPMENT);
        onShowDelayActivity();
    }

    private void onShowDelayActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isShowActivity();
            }
        }, 3000);
    }

    private void isShowActivity(){
        if (Utils.isStringNull(mLocalHelp.onGetPinCode())){
            finish();
            startActivity(new Intent(this, HomeActivity.class));
        }else{
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
