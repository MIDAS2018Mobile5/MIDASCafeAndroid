package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.OrderSearchRequestData;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface OrderDeleteRequest {
    @DELETE("/api/order/delete/{id}")
    Call<GeneralResponse> tryOrderDelete(@Path("id") Integer id);

}
