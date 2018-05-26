package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.DeleteMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.LoginRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.responses.SearchMenuResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface SearchMenuRequest {
    @GET("/api/svc/cafe/search")
    Call<List<SearchMenuResponse>> searchMenu();

}
