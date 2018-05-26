package com.midas2018mobile5.mobileapp.main.requestdatas;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class OrderSearchRequestData {
    private String userid;
    public OrderSearchRequestData(HashMap<String,Object> parameters) {
        userid = (String)parameters.get("userid");
    }
}
