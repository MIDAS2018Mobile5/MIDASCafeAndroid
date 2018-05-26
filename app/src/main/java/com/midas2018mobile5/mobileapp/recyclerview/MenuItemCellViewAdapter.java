package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class MenuItemCellViewAdapter extends RecyclerView.Adapter<MenuItemCellViewHolder> {

    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public MenuItemCellViewAdapter(Context context,ArrayList<MenuItem> menuItems){
        mContext = context;
        this.menuItems = menuItems;
    }


    @NonNull
    @Override
    public MenuItemCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //item_cell
        View view = View.inflate(mContext, R.layout.item_menu,null);
        MenuItemCellViewHolder menuItemCellViewHolder = new MenuItemCellViewHolder(view);
        return menuItemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemCellViewHolder holder, int position) {

        MenuItem item = menuItems.get(position);

        holder.titleTextview.setText(item.title);
        holder.subtitleTextView.setText(item.subtitle);
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }
}
