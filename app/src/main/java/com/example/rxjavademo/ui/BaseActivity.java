package com.example.rxjavademo.ui;

import android.support.v7.app.AppCompatActivity;

import com.example.rxjavademo.MyApplication;
import com.example.rxjavademo.di.component.ActivityComponent;
import com.example.rxjavademo.di.component.DaggerActivityComponent;
import com.example.rxjavademo.di.module.ActivityModule;



public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    protected final ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .appComponent(MyApplication.getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }
}
