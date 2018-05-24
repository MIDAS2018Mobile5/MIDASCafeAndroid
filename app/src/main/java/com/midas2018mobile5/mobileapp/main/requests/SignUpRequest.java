package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public interface SignUpRequest {
    @POST("/api/account/signup")
    @FormUrlEncoded
    Call<LoginResponse> trySignUp(@Field("name") String userID, @Field("password") String userSecret);
}
