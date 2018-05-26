package com.midas2018mobile5.mobileapp.main.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.midas2018mobile5.mobileapp.main.activities.AdminActivity;
import com.midas2018mobile5.mobileapp.main.activities.UserActivity;
import com.midas2018mobile5.mobileapp.main.requestdatas.AddMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.DeleteMenuRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.LoginRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.OrderAddRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.OrderSearchRequestData;
import com.midas2018mobile5.mobileapp.main.requestdatas.SignUpRequestData;
import com.midas2018mobile5.mobileapp.main.requests.AddMenuRequest;
import com.midas2018mobile5.mobileapp.main.requests.DeleteMenuRequest;
import com.midas2018mobile5.mobileapp.main.requests.LoginRequest;
import com.midas2018mobile5.mobileapp.main.requests.OrderAddRequest;
import com.midas2018mobile5.mobileapp.main.requests.OrderSearchRequest;
import com.midas2018mobile5.mobileapp.main.requests.SearchMenuRequest;
import com.midas2018mobile5.mobileapp.main.requests.SignUpRequest;
import com.midas2018mobile5.mobileapp.main.requests.UserInfoRequest;
import com.midas2018mobile5.mobileapp.main.responses.GeneralResponse;
import com.midas2018mobile5.mobileapp.main.responses.LoginResponse;
import com.midas2018mobile5.mobileapp.main.responses.OrderSearchResponse;
import com.midas2018mobile5.mobileapp.main.responses.SearchMenuResponse;
import com.midas2018mobile5.mobileapp.main.responses.SignUpResponse;
import com.midas2018mobile5.mobileapp.main.responses.UserInfoResponse;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class RequestManager {
    private static RequestManager instance;
    private static Context context;
    public static boolean completeFlag = false;
    public static RequestManager getInstance() {
        if (instance == null)
            instance = new RequestManager();
        return instance;
    }
    public static RequestManager getInstance(Context _context) {
        context = _context;
        if (instance == null)
            instance = new RequestManager();
        return instance;
    }


    /**
     * 로그인 요청
     *
     * @param parameters
     */
    public void requestLogin(HashMap<String, Object> parameters) {
        APIClient.getInstance().create(LoginRequest.class).tryLogin(new LoginRequestData(parameters))
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            String token = loginResponse.getToken();
                            PrefManager prefManager = new PrefManager(context);
                            prefManager.putPrefString("token","Token "+token);
                            APIClient.setToken(token);
                            Intent intent;
                            if(loginResponse.getRole().equals("USER")) {
                                intent = new Intent(context, AdminActivity.class);
                                context.startActivity(intent);
                            }
                            else {
                                intent = new Intent(context, AdminActivity.class);
                                context.startActivity(intent);
                            }
                        } else {
                            int code = response.raw().code();
                            String message = response.raw().message();
                            Log.d("status", "not success");
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("status", "failed");
                    }
                });
    }

    /**
     * 회원가입 요청
     *
     * @param parameters
     */
    public void requestSignUp(HashMap<String, Object> parameters) {
        APIClient.getInstance().create(SignUpRequest.class).trySignUp(new SignUpRequestData(parameters))
                .enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        if (response.isSuccessful()) {
                            SignUpResponse signUpResponse = response.body();
                        } else {
                            int code = response.raw().code();
                            String message = response.raw().message();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {

                    }
                });
    }

    public void requestAddMenu(HashMap<String, Object> parameters) {
        APIClient.getInstance().create(AddMenuRequest.class).addMenu("Token "+APIClient.getToken(),new AddMenuRequestData(parameters))
                .enqueue(new Callback<GeneralResponse>() {
                    @Override
                    public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                        if (response.isSuccessful()) {
                            GeneralResponse generalResponse = response.body();
                        } else {
                            int code = response.raw().code();
                            String message = response.raw().message();
                        }
                    }

                    @Override
                    public void onFailure(Call<GeneralResponse> call, Throwable t) {

                    }
                });
    }

    public void requestDeleteMenu(HashMap<String, Object> parameters) {
        try {
            APIClient.getInstance().create(DeleteMenuRequest.class).deleteMenu("Token "+APIClient.getToken(),new DeleteMenuRequestData(parameters))
                    .execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MenuItem> requestSearchMenu() throws IOException {
        final ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        List<SearchMenuResponse> menuResponse = APIClient.getInstance().create(SearchMenuRequest.class).searchMenu("Token "+APIClient.getToken())
                .execute().body();
        if(menuResponse==null)
            return menu;
        for (int i = 0; i < menuResponse.size(); i++) {
            MenuItem item = new MenuItem(menuResponse.get(i).getName(), menuResponse.get(i).getPrice());
            menu.add(item);
        }
        return menu;
    }

    public List<OrderSearchResponse> requestOrderLog(String userid) throws IOException{
        HashMap<String,Object> parameters = new HashMap<String,Object>();
        parameters.put("userid",userid);
        List<OrderSearchResponse> response = APIClient.getInstance().create(OrderSearchRequest.class).tryOrderSearch("Token "+APIClient.getToken(),new OrderSearchRequestData(parameters))
                .execute().body();
        return response;
    }

    public List<UserInfoResponse> requestUserInfo() throws IOException {
        HashMap<String,Object> parameters = new HashMap<String,Object>();
        List<UserInfoResponse> response = APIClient.getInstance().create(UserInfoRequest.class).requestUserInfo("Token "+APIClient.getToken())
                .execute().body();
        return response;
    }


    public void requestOrder(HashMap<String,Object> data) {
        APIClient.getInstance().create(OrderAddRequest.class).tryOrder("Token "+APIClient.getToken(),new OrderAddRequestData(data))
                .enqueue(new Callback<GeneralResponse>() {
                    @Override
                    public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                        if(response.isSuccessful()) {
                            Log.d("status","success");
                        }
                        else{
                            Log.d("status","failed");
                        }
                    }

                    @Override
                    public void onFailure(Call<GeneralResponse> call, Throwable t) {
                        Log.d("status","error");
                    }
                });
    }

}
