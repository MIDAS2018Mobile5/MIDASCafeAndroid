package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class MenuItemCellViewAdapter3 extends RecyclerView.Adapter<MenuItemCellViewHolder3> {

    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public MenuItemCellViewAdapter3(Context context,ArrayList<MenuItem> menuItems){
        mContext = context;
        this.menuItems = menuItems;
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

        MenuItem item = menuItems.get(position);

        holder.titleTextview.setText(item.getMenuName());
        holder.subtitleTextView.setText(item.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }
}
