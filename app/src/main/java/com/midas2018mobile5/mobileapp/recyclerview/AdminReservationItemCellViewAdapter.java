package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.AdminMenuDetailActivity;
import com.midas2018mobile5.mobileapp.main.activities.ReservationDetailActivity;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class AdminReservationItemCellViewAdapter extends RecyclerView.Adapter<AdminReservationItemCellViewHolder> {


    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public AdminReservationItemCellViewAdapter(Context context, ArrayList<MenuItem> menuItems){
        mContext = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public AdminReservationItemCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_reservation,null);
        AdminReservationItemCellViewHolder iemCellViewHolder = new AdminReservationItemCellViewHolder(view,this);

        return iemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminReservationItemCellViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


    public void onItemClicked(int position){

        MenuItem item = menuItems.get(position);

        Intent intent = new Intent(mContext, ReservationDetailActivity.class);
        intent.putExtra("item_position",position);
        mContext.startActivity(intent);
    }
}
