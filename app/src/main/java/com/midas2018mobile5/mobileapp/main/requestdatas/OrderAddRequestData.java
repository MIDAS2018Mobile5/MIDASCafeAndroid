package com.midas2018mobile5.mobileapp.main.requestdatas;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class OrderAddRequestData {
    private String name;
    private String menu;
    private Integer count;
    private Integer price;
    private String date;

    public OrderAddRequestData(HashMap<String,Object> parameters) {
        name = (String)parameters.get("name");
        menu = (String)parameters.get("menu");
        count = (Integer)parameters.get("count");
        price = (Integer)parameters.get("price");
        date = (String)parameters.get("date");
    }
}
