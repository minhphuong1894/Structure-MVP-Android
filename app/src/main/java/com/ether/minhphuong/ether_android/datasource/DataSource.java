package com.ether.minhphuong.ether_android.datasource;

import com.ether.minhphuong.ether_android.datasource.remote.response.transaction.GetAllTransactionResponse;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by minhphuong on 5/23/18.
 */

public interface DataSource {

    Observable<Response<GetAllTransactionResponse>> onGetAllTransaction(String email, String phone);
}
