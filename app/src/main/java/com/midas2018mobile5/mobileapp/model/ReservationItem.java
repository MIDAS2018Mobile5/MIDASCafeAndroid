package com.midas2018mobile5.mobileapp.model;

import java.util.ArrayList;

public class ReservationItem {

    //주문번호
    private String bid;
    //주문자의 이름
    private String name;
    //주문번호가 같은 order list
    private ArrayList<OrderItem> orderItems;


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
