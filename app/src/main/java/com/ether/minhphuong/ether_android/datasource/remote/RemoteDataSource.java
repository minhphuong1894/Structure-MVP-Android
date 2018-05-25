package com.ether.minhphuong.ether_android.datasource.remote;

import com.ether.minhphuong.ether_android.datasource.DataSource;
import com.ether.minhphuong.ether_android.datasource.remote.response.transaction.GetAllTransactionResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by minhphuong on 5/23/18.
 */

@Singleton
public class RemoteDataSource implements DataSource {

    private EtherServiceAPI mService;

    @Inject
    public RemoteDataSource(Retrofit retrofit) {
        mService = retrofit.create(EtherServiceAPI.class);
    }

    @Override
    public Observable<Response<GetAllTransactionResponse>> onGetAllTransaction(String email, String phone) {
        return mService.onGetAllTransaction(email,phone);
    }
}
