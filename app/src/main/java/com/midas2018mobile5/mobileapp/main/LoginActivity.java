package com.midas2018mobile5.mobileapp.main;

import android.view.View;
import android.widget.Button;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate() {
        Button loginBtn = findViewById(R.id.loginBtn);
        Button signUp = findViewById(R.id.signupBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
