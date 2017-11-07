package com.it.hungvt.dagger2;

import android.app.Application;

import com.it.hungvt.dagger2.component.DaggerGithubComponent;
import com.it.hungvt.dagger2.component.DaggerNetComponent;

import com.it.hungvt.dagger2.component.GithubComponent;
import com.it.hungvt.dagger2.component.NetComponent;
import com.it.hungvt.dagger2.module.AppModule;
import com.it.hungvt.dagger2.module.GithubModule;
import com.it.hungvt.dagger2.module.NetModule;

import dagger.internal.DaggerCollections;

/**
 * Created by Administrator on 11/7/2017.
 */

public class MyApplication extends Application{

    GithubComponent githubComponent;
    NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder().appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com")).build();

        githubComponent = DaggerGithubComponent.builder().netComponent(netComponent)
                .githubModule(new GithubModule()).build();


    }


}
