package com.midas2018mobile5.mobileapp.main.utils;

import android.util.Log;

import com.midas2018mobile5.mobileapp.main.requestdatas.AddMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.LoginRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.SignUpRequestData;
import com.midas2018mobile5.mobileapp.main.requests.AddMenuRequest;
import com.midas2018mobile5.mobileapp.main.requests.LoginRequest;
import com.midas2018mobile5.mobileapp.main.requests.SignUpRequest;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.responses.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class RequestManager {
    private static RequestManager instance;
    public static RequestManager getinstance() {
        return instance;
    }

    /**
     * 로그인 요청
     * @param parameters
     */
    public void requestLogin(HashMap<String,Object> parameters) {
        APIClient.getInstance().create(LoginRequest.class).tryLogin(new LoginRequestData(parameters))
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            Log.d("status", "success");
                        } else {
                            int code = response.raw().code();
                            String message = response.raw().message();
                            Log.d("status", "not success");
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("status", "failed");
                    }
                });
    }

    /**
     * 회원가입 요청
     * @param parameters
     */
    public void requestSignUp(HashMap<String,Object> parameters) {
        APIClient.getInstance().create(SignUpRequest.class).trySignUp(new SignUpRequestData(parameters))
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

    public void requestAddMenu(HashMap<String,Object> parameters) {
        APIClient.getInstance().create(AddMenuRequest.class).addMenu(new AddMenuRequestData(parameters))
                .enqueue(new Callback<GeneralResponse>() {
                    @Override
                    public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                        if(response.isSuccessful()) {
                            GeneralResponse generalResponse = response.body();
                        }
                        else {
                            int code = response.raw().code();
                            String message = response.raw().message();
                        }
                    }

                    @Override
                    public void onFailure(Call<GeneralResponse> call, Throwable t) {

                    }
                });
    }
}
