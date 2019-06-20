package com.example.peter.simpledatabinding.util;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.peter.simpledatabinding.viewmodel.UserViewModel;


public class CustomViewModelProvider implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;

    }
}
