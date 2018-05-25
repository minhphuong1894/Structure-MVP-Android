package com.ether.minhphuong.ether_android.di;

import com.ether.minhphuong.ether_android.datasource.DataSource;
import com.ether.minhphuong.ether_android.datasource.remote.RemoteDataSource;
import com.ether.minhphuong.ether_android.di.scope.Remote;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by minhphuong on 5/23/18.
 */

@Module
public abstract class RepositoryModule {
    @Singleton
    @Binds
    @Remote
    abstract DataSource provideRemoteDataSource(RemoteDataSource remoteDataSource);
}

