package com.example.peter.simpledatabinding.di.modules;

import com.example.peter.simpledatabinding.model.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    User providesUser() {
        return new User();
    }
}
