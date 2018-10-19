package com.example.peter.daggersample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peter.daggersample.MyApp;
import com.example.peter.daggersample.R;
import com.example.peter.daggersample.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edusername)
    EditText edUsername;
    @BindView(R.id.edpassword)
    EditText edPassword;
    @Inject
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApp.app().userComponent().inject(this);
    }

    @OnClick(R.id.btlogin)
    void login() {
        getUserInput();
    }

    /**
     * Method that retrieves user input from the edittexts and bind them to the user object
     */
    public void getUserInput() {
        String username = edUsername.getText().toString().trim();
        String password = edPassword.getText().toString().trim();

        mUser.setUsername(username);
        mUser.setPassword(password);
        showUserDetail(mUser);
    }

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
