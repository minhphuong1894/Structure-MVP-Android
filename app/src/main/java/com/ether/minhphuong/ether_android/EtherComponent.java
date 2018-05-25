package com.ether.minhphuong.ether_android;

import android.app.Application;

import com.ether.minhphuong.ether_android.di.BaseActivityModuleBinding;
import com.ether.minhphuong.ether_android.di.BaseFragmentModuleBinding;
import com.ether.minhphuong.ether_android.di.NetModule;
import com.ether.minhphuong.ether_android.di.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by minhphuong on 5/23/18.
 */
@Singleton
@Component(modules = {
        NetModule.class,
        EtherModule.class,
        RepositoryModule.class,
        BaseActivityModuleBinding.class,
        BaseFragmentModuleBinding.class,
        AndroidSupportInjectionModule.class
})
public interface EtherComponent extends AndroidInjector<DaggerApplication> {
    void inject(EtherApp app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        EtherComponent.Builder application(Application application);

        EtherComponent builder();

    }
}
