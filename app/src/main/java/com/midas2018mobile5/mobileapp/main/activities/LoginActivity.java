package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.View;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.base.BaseActivity;
import com.midas2018mobile5.mobileapp.databinding.ActivityLoginBinding;
import com.midas2018mobile5.mobileapp.main.requests.LoginRequest;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.utils.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
        protected void onCreate() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = binding.accountID.getText().toString();
                String password = binding.accountPW.getText().toString();
                APIClient.getInstance().create(LoginRequest.class).tryLogin(id,password)
                        .enqueue(new Callback<LoginResponse>() {
                            @Override
                            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                if(response.isSuccessful()) {
                                    LoginResponse loginResponse = response.body();
                                }
                                else {
                                    int code = response.raw().code();
                                    String message = response.raw().message();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginResponse> call, Throwable t) {Log.d("awdawd","error");
                            }
                        });
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
