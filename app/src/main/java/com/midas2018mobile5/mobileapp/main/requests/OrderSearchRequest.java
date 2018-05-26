package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.OrderAddRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.OrderSearchRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface OrderSearchRequest {
    @POST("/api/order/search")
    Call<GeneralResponse> tryOrderSearch(@Body OrderSearchRequestData data);

}
