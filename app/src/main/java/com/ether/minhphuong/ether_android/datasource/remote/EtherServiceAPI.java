package com.ether.minhphuong.ether_android.datasource.remote;

import com.ether.minhphuong.ether_android.datasource.remote.response.transaction.GetAllTransactionResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by minhphuong on 5/23/18.
 */

public interface EtherServiceAPI {

    @GET("/api/v0/sales/check-existing-user")
    Observable<Response<GetAllTransactionResponse>> onGetAllTransaction(@Query("email") String email, @Query("phone") String phone);
}
