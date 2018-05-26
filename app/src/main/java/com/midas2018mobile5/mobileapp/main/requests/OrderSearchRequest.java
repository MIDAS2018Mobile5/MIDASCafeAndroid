package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.OrderAddRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.OrderSearchRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;
import com.midas2018mobile5.mobileapp.main.responses.OrderSearchResponse;
import com.midas2018mobile5.mobileapp.main.responses.SearchMenuResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface OrderSearchRequest {
    @POST("/api/svc/order/search")
    Call<List<OrderSearchResponse>> tryOrderSearch(@Header("Authorisation") String authorization, @Body OrderSearchRequestData data);

}
