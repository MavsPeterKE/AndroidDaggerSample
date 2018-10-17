package com.example.peter.daggersample.di.modules;

import com.example.peter.daggersample.model.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    User providesUser() {
        return new User();
    }
}
