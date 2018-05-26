package com.midas2018mobile5.mobileapp.main.requestdatas;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class SignUpRequestData {
    private String userid;
    private String password;
    private String username;
    public SignUpRequestData(HashMap<String, Object> parameters) {
        this.userid = (String)parameters.get("userid");
        this.password = (String)parameters.get("password");
        this.username = (String)parameters.get("username");
    }
}
