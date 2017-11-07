package com.it.hungvt.dagger2;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.it.hungvt.dagger2.model.Repository;
import com.it.hungvt.dagger2.network.GithubApi;

import java.util.List;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    Retrofit retrofit;

    @Inject
    GithubApi githubApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v->{
            Call<List<Repository>> call = githubApi.getRepository("lequanghoa");
            call.enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(Response<List<Repository>> response, Retrofit retrofit) {
                    if (response.isSuccess()){

                        Log.i(TAG, "onResponse: "+response.body().toString());
                        Snackbar.make(v,"Data Retrieved ",Snackbar.LENGTH_LONG).setAction("Action",null).show();

                    }
                    else {
                        Log.i(TAG, "onResponse: "+String.valueOf(response.code()));
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

        });

        ((MyApplication) getApplication()).githubComponent.inject(this);
    }
}
