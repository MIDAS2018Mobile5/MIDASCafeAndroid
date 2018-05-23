package com.midas2018mobile5.mobileapp.main.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;

public interface MidasApiService {
    final String server_Url = "http://localhost:5000";

    @POST("/api/account/signup")
    Call<ResponseBody> signup();
}
