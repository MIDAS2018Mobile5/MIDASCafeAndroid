package com.midas2018mobile5.mobileapp.main.requests;

import com.midas2018mobile5.mobileapp.main.requestdatas.SignUpRequestData;
import com.midas2018mobile5.mobileapp.main.responses.SignUpResponse;
import com.midas2018mobile5.mobileapp.main.responses.UserInfoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ji Hoon on 2018-05-27.
 */

public interface UserInfoRequest {
    @POST("/api/svc/account/search")
    Call<List<UserInfoResponse>> requestUserInfo();
}
