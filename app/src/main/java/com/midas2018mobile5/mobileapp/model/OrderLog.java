package com.midas2018mobile5.mobileapp.model;

/**
 * Created by Ji Hoon on 2018-05-27.
 */

public class OrderLog {
    private String menus;
    private int priceSum;
    private String date;

    public OrderLog(String _menus, int _priceSum, String _date) {
        menus = _menus;
        priceSum = _priceSum;
        date = _date;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public void setPriceSum(int priceSum) {
        this.priceSum = priceSum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenus() {

        return menus;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public String getDate() {
        return date;
    }
}
