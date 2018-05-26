package com.midas2018mobile5.mobileapp.main.utils;

import android.graphics.Bitmap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public class APIClient {
    private static Retrofit retrofit = null;
    public static Retrofit getInstance() {
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.35:5000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
