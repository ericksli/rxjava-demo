package com.example.rxjavademo.di.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


import com.example.rxjavademo.di.qualifier.ActivityContext;
import com.example.rxjavademo.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    FragmentManager provideFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }
}
