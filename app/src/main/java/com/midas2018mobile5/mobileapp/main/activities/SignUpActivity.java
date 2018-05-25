package com.midas2018mobile5.mobileapp.main.activities;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.base.BaseActivity;
import com.midas2018mobile5.mobileapp.databinding.ActivitySignupBinding;
import com.midas2018mobile5.mobileapp.main.requests.SignUpRequest;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.responses.SignUpResponse;
import com.midas2018mobile5.mobileapp.main.utils.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public class SignUpActivity extends BaseActivity {
    private ActivitySignupBinding binding;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_signup;
    }

    @Override
    protected void onCreate() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.edtSignupId.getText().toString();
                String password = binding.edtSignupPassword.getText().toString();
                APIClient.getInstance().create(SignUpRequest.class).trySignUp(id,password)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                if(response.isSuccessful()) {
                                    SignUpResponse signUpResponse = response.body();
                                }
                                else {
                                    int code = response.raw().code();
                                    String message = response.raw().message();
                                }
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }
                        });
            }
        });
    }
}