package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.base.BaseActivity;
import com.midas2018mobile5.mobileapp.databinding.ActivityLoginBinding;
import com.midas2018mobile5.mobileapp.main.utils.PrefManager;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        RequestManager.getInstance(this);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = binding.accountID.getText().toString();
                String password = binding.accountPW.getText().toString();
                HashMap<String, Object> parameters = new HashMap<String, Object>();
                parameters.put("userid", id);
                parameters.put("password", password);
                RequestManager.getInstance().requestLogin(parameters);
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.putPrefString("id",id);
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }



}
