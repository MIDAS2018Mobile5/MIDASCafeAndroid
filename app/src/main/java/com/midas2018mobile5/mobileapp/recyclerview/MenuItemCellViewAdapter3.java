package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.OrderLog;

import java.util.ArrayList;

public class MenuItemCellViewAdapter3 extends RecyclerView.Adapter<MenuItemCellViewHolder3> {

    private Context mContext;
    private ArrayList<OrderLog> orderItems;

    public MenuItemCellViewAdapter3(Context context,ArrayList<OrderLog> menuItems){
        mContext = context;
        this.orderItems = menuItems;
    }

    public void addOrderItem(OrderLog log) {
        orderItems.add(log);
    }
    public void clearOrderItem() {
        orderItems.clear();
    }
    @NonNull
    @Override
    public MenuItemCellViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //item_cell
        View view = View.inflate(mContext, R.layout.item_history,null);
        MenuItemCellViewHolder3 menuItemCellViewHolder = new MenuItemCellViewHolder3(view);
        return menuItemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemCellViewHolder3 holder, int position) {

        OrderLog item = orderItems.get(position);

        holder.priceTextview.setText(String.valueOf(item.getPriceSum()));
        holder.menusTextView.setText(item.getMenus());
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }
}
