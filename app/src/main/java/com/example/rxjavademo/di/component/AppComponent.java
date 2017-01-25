package com.example.rxjavademo.di.component;

import android.content.Context;
import android.content.res.Resources;

import com.example.rxjavademo.api.ApiService;
import com.example.rxjavademo.di.module.AppModule;
import com.example.rxjavademo.di.module.NetModule;
import com.example.rxjavademo.di.qualifier.AppContext;
import com.example.rxjavademo.di.scope.PerApplication;
import com.squareup.moshi.Moshi;

import dagger.Component;


@PerApplication
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    @AppContext
    Context context();

    Resources resources();

    Moshi moshi();

    ApiService apiService();
}
