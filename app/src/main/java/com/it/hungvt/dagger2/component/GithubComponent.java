package com.it.hungvt.dagger2.component;

import com.it.hungvt.dagger2.MainActivity;
import com.it.hungvt.dagger2.UserScope;
import com.it.hungvt.dagger2.module.GithubModule;

import dagger.Component;

/**
 * Created by Administrator on 11/7/2017.
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GithubModule.class)
public interface GithubComponent {
    void inject(MainActivity mainActivity);
}
