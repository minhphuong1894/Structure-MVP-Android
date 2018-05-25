package com.ether.minhphuong.ether_android.datasource;

import com.ether.minhphuong.ether_android.datasource.remote.response.transaction.GetAllTransactionResponse;
import com.ether.minhphuong.ether_android.di.scope.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by minhphuong on 5/23/18.
 */

@Singleton
public class DataRepository implements DataSource {

    private DataSource mRemoteSource;

    @Inject
    public DataRepository(@Remote DataSource remoteDataSource) {
        this.mRemoteSource = remoteDataSource;
    }


    @Override
    public Observable<Response<GetAllTransactionResponse>> onGetAllTransaction(String email, String phone) {
        return mRemoteSource.onGetAllTransaction(email,phone);
    }
}
