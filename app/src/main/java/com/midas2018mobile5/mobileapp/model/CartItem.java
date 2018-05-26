package com.midas2018mobile5.mobileapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ji Hoon on 2018-05-26.
 */

public class CartItem extends RealmObject {
    private String menuName;
    private int price;
    private int count;


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
