package com.example.peter.simpledatabinding.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;

public class UserViewModel extends BaseObservable {
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    public ObservableField<String> totals = new ObservableField<>();
    public ObservableField<String> display =
            new ObservableField<String>(username, password) {
                @Override
                public String get() {
                    return String.valueOf(calculateTotals());
                }
            };

    public String computeTotals() {
        Log.e("ClickMe__" ,"Clicked " );
        return "";
    }

    private int calculateTotals() {
        int totals = 0;
        if (username.get() != null && password.get() != null) {
            if (isCalculateableValue(username.get())) {
                int a = Integer.parseInt(username.get());
                int b = Integer.parseInt(password.get());
                totals = a + b;
            }
        }
        return totals;
    }

    private boolean isCalculateableValue(String string){
        try
        {
            Integer.parseInt(string);
            Log.e("isCalculateAbleValue__","True");
            return true;
        }catch (Exception e){
            Log.e("isCalculateAbleValue__","False");
            return false;
        }
    }

    @Bindable
    public ObservableField<String> getUsername() {
        return username;
    }

    @Bindable
    public ObservableField<String> getPassword() {
        return password;
    }
}
