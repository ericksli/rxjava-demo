package com.example.rxjavademo.di.component;



import com.example.rxjavademo.ui.MainActivity;
import com.example.rxjavademo.di.module.ActivityModule;
import com.example.rxjavademo.di.scope.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
