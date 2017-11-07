package com.it.hungvt.dagger2.component;

import android.content.SharedPreferences;

import com.it.hungvt.dagger2.module.AppModule;
import com.it.hungvt.dagger2.module.NetModule;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by Administrator on 11/7/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();

    OkHttpClient okHttpClient();

    SharedPreferences sharedPreferences();
}
