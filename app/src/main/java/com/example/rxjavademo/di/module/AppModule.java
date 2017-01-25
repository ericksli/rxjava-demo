package com.example.rxjavademo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.example.rxjavademo.di.qualifier.AppContext;
import com.example.rxjavademo.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @PerApplication
    @AppContext
    Context providesAppContext() {
        return mApplication;
    }

    @Provides
    @PerApplication
    SharedPreferences provideSharedPreferences(@AppContext Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    Resources providesResources() {
        return mApplication.getResources();
    }


}
