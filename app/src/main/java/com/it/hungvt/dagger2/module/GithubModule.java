package com.it.hungvt.dagger2.module;

import com.it.hungvt.dagger2.UserScope;
import com.it.hungvt.dagger2.network.GithubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by Administrator on 11/7/2017.
 */

@Module
public class GithubModule {

    @Provides
    @UserScope
    public GithubApi provideGithubApi(Retrofit retrofit){
        return retrofit.create(GithubApi.class);
    }
}
