package com.ether.minhphuong.ether_android.di;

import android.app.Application;
import android.text.TextUtils;

import com.ether.minhphuong.ether_android.BuildConfig;
import com.ether.minhphuong.ether_android.utils.ApiContants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by minhphuong on 5/23/18.
 */

@Module
public class NetModule {

    @Singleton
    @Provides
    OkHttpClient okHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request.Builder newBuilder = request.newBuilder()
                            .addHeader("User-Agent", "Android");
                    return chain.proceed(newBuilder.build());
                })
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(ApiContants.Net.API_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(ApiContants.Net.API_REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://mobile.dev.edeel.dirox.net");
        return builder.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

}

