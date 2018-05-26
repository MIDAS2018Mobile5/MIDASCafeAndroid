package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.SignUpRequestData;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.responses.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public interface SignUpRequest {
    @POST("/api/account/signup")
    Call<SignUpResponse> trySignUp(@Body SignUpRequestData data);
}
