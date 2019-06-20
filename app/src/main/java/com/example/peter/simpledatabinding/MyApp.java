package com.example.peter.simpledatabinding;

import android.app.Application;
import android.content.ContextWrapper;

import com.example.peter.simpledatabinding.di.components.DaggerUserComponent;
import com.example.peter.simpledatabinding.di.components.UserComponent;
import com.example.peter.simpledatabinding.di.modules.UserModule;
import com.example.peter.simpledatabinding.util.Prefs;

public class MyApp extends Application {
    private static MyApp app;
    private UserModule userModule;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initializeDaggerComponent();

        // Initialize the Prefs class
        initializePreferences();
    }

    private void initializeDaggerComponent() {
        userModule = new UserModule();
        userComponent = DaggerUserComponent.builder()
                .userModule(userModule)
                .build();
    }

    private void initializePreferences() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    public static MyApp app() {
        return app;
    }

    public UserComponent userComponent() {
        return userComponent;
    }
}
