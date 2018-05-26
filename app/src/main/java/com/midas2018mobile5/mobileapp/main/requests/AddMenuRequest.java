package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.AddMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.LoginRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface AddMenuRequest {
    @POST("/api/svc/cafe/add")
    Call<GeneralResponse> addMenu(@Body AddMenuRequestData data);

}
