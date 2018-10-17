package com.example.peter.daggersample;

import android.app.Application;

import com.example.peter.daggersample.di.components.DaggerUserComponent;
import com.example.peter.daggersample.di.components.UserComponent;
import com.example.peter.daggersample.di.modules.UserModule;

public class MyApp extends Application {
    private static MyApp app;
    private UserModule userModule;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        userModule = new UserModule();
        userComponent = DaggerUserComponent.builder()
                .userModule(userModule)
                .build();
    }

    public static MyApp app() {
        return app;
    }

    public UserComponent userComponent() {
        return userComponent;
    }
}
