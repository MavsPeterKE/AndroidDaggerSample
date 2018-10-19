package com.example.peter.daggersample.di.components;

import android.app.Activity;

import com.example.peter.daggersample.di.modules.UserModule;
import com.example.peter.daggersample.view.MainActivity;

import dagger.Component;

@Component(modules = UserModule.class)
public interface UserComponent {
   void inject(MainActivity mainActivity);

}
