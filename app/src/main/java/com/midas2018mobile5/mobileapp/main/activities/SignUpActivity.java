package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.base.BaseActivity;
import com.midas2018mobile5.mobileapp.databinding.ActivitySignupBinding;
import com.midas2018mobile5.mobileapp.main.requests.SignUpRequest;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public class SignUpActivity extends BaseActivity {
    private ActivitySignupBinding mBinding;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_signup;
    }

    @Override
    protected void onCreate() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        mBinding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mBinding.edtSignupId.getText().toString();
                String password = mBinding.edtSignupPassword.getText().toString();
                String name = mBinding.edtSignupName.getText().toString();
                HashMap<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("userid",id);
                parameters.put("password",password);
                parameters.put("username",name);
                confirmPassword(password);
                RequestManager.getInstance().requestSignUp(parameters);
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    public void confirmPassword(String password) {
        String confirmPassword = mBinding.edtSignupConfirmPassword.getText().toString();
        if(!password.equals(confirmPassword)) {

        }
    }
}