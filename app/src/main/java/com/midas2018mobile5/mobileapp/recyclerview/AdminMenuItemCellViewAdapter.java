package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.AdminMenuDetailActivity;
import com.midas2018mobile5.mobileapp.main.activities.DetailActivity;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class AdminMenuItemCellViewAdapter extends RecyclerView.Adapter<AdminMenuItemCellViewHolder> {

    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public AdminMenuItemCellViewAdapter(Context context,ArrayList<MenuItem> menuItems){
        mContext = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public AdminMenuItemCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(mContext, R.layout.item_menu,null);
        AdminMenuItemCellViewHolder menuItemCellViewHolder = new AdminMenuItemCellViewHolder(view,this);
        return menuItemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminMenuItemCellViewHolder holder, int position) {

        MenuItem item = menuItems.get(position);

        holder.titleTextview.setText(item.getMenuName());
        holder.subtitleTextView.setText(item.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


    public void onItemClicked(int position){

        MenuItem item = menuItems.get(position);
        //Toast.makeText(mContext,item.title + position,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(mContext, AdminMenuDetailActivity.class);
        intent.putExtra("item_position",position);
        intent.putExtra("menu",item.getMenuName());
        intent.putExtra("price",item.getPrice());
        mContext.startActivity(intent);
    }
}
