package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.AddMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.DeleteMenuRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface DeleteMenuRequest {
    @POST("/api/svc/cafe/delete")
    Call<GeneralResponse> deleteMenu(@Header("Authorisation") String authorization, @Body DeleteMenuRequestData data);

}
