package com.example.rxjavademo.di.module;


import com.example.rxjavademo.api.ApiService;
import com.example.rxjavademo.di.scope.PerApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.Moshi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;



@Module
public class NetModule {
    private String mBaseUrl;

    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }


    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @PerApplication
    Retrofit provideRetrofit(MoshiConverterFactory moshiConverterFactory,
                             RxJava2CallAdapterFactory rxJavaCallAdapterFactory,
                             OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(moshiConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @PerApplication
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


    @Provides
    MoshiConverterFactory provideMoshiConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Provides
    @PerApplication
    Moshi provideMoshi() {
        return new Moshi.Builder()
                .build();
    }

    @Provides
    RxJava2CallAdapterFactory provideRxJava() {
        return RxJava2CallAdapterFactory.create();
    }

}
