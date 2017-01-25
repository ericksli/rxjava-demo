package com.example.rxjavademo;

import android.app.Application;

import com.example.rxjavademo.di.component.AppComponent;

import com.example.rxjavademo.di.component.DaggerAppComponent;
import com.example.rxjavademo.di.module.AppModule;
import com.example.rxjavademo.di.module.NetModule;


public class MyApplication extends Application {
    private static MyApplication sInstance;
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(Config.API_BASE_URL))
                .build();


    }

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
