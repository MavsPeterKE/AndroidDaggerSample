package com.example.peter.simpledatabinding.di.components;


import com.example.peter.simpledatabinding.di.modules.UserModule;
import com.example.peter.simpledatabinding.view.MainActivity;

import dagger.Component;

@Component(modules = UserModule.class)
public interface UserComponent {
   void inject(MainActivity mainActivity);

}
