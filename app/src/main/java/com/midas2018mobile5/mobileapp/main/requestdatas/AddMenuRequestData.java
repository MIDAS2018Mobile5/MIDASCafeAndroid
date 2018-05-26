package com.midas2018mobile5.mobileapp.main.requestdatas;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class AddMenuRequestData {
    private String name;
    private String price;

    public AddMenuRequestData(HashMap<String, Object> parameters) {
        this.name = (String)parameters.get("name");
        this.price = (String)parameters.get("price");

    }
}
