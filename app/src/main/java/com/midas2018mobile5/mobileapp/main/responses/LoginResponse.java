package com.midas2018mobile5.mobileapp.main.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ji Hoon on 2018-05-24.
 */

public class LoginResponse {
    @SerializedName("token")
    @Expose
    private String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @SerializedName("role")
    @Expose
    private String role;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
