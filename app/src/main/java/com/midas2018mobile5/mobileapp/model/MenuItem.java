package com.midas2018mobile5.mobileapp.model;

public class MenuItem {
    private String menuName;
    private Integer price;

    private Integer count;
    public MenuItem(String _menuName, Integer _price) {
        menuName = _menuName;
        price = _price;
    }
    public MenuItem(String _menuName, Integer _price, Integer _count) {
        menuName = _menuName;
        price = _price;
        count = _count;
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getPrice() {
        return price;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
