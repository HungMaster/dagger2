package com.it.hungvt.dagger2.network;


import com.it.hungvt.dagger2.model.Repository;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Administrator on 11/7/2017.
 */

public interface GithubApi {

    @GET("/users/{user}/repos")
    Call<List<Repository>> getRepository(@Path("user") String username);
}
