package com.midas2018mobile5.mobileapp.main.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ji Hoon on 2018-05-27.
 */

public class OrderSearchResponse {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("menu")
    @Expose
    private String menu;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("isordered")
    @Expose
    private Boolean isordered;
    @SerializedName("bid")
    @Expose
    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getIsordered() {
        return isordered;
    }

    public void setIsordered(Boolean isordered) {
        this.isordered = isordered;
    }
}
