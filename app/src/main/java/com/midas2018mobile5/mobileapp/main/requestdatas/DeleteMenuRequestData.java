package com.midas2018mobile5.mobileapp.main.requestdatas;

import java.util.HashMap;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class DeleteMenuRequestData {
    private String name;

    public DeleteMenuRequestData(HashMap<String, Object> parameters) {
        this.name = (String)parameters.get("name");
    }
}
