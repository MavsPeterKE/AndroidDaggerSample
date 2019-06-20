package com.example.peter.simpledatabinding.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.peter.simpledatabinding.MyApp;
import com.example.peter.simpledatabinding.R;
import com.example.peter.simpledatabinding.databinding.ActivityMainBinding;
import com.example.peter.simpledatabinding.model.User;
import com.example.peter.simpledatabinding.viewmodel.UserViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    User mUser;
    UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_main);
        mUserViewModel = new UserViewModel();
        activityMainBinding.setUserviewmodel(mUserViewModel);
        MyApp.app().userComponent().inject(this);
    }

    /*@OnClick(R.id.btlogin)
    void login() {
        getUserInput();
    }*/

    /**
     * Method that retrieves user input from the edittexts and bind them to the user object
     */
    /*public void getUserInput() {
        String username = edUsername.getText().toString().trim();
        String password = edPassword.getText().toString().trim();

        mUser.setUsername(username);
        mUser.setPassword(password);
        putString(USER_NAME, username);
        showUserDetail(mUser);
    }*/

    /*@OnClick(R.id.btnext)
    void openNewActivity() {
        startActivity(new Intent(this, Main2Activity.class));
    }*/

    /**
     * method that displays user details
     *
     * @param user
     */
    public void showUserDetail(User user) {
        Toast.makeText(this, "Username: " + user.getUsername() + " " + user.getPassword(), Toast
                .LENGTH_SHORT).show();
    }
}
