package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public interface OrderUpdateRequest {
    @PUT("/api/svc/order/update/{bid}")
    Call<GeneralResponse> tryOrderUpdate(@Path("bid") Integer id);

}
