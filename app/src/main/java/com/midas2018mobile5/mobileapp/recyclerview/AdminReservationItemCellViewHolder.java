package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class AdminReservationItemCellViewHolder extends RecyclerView.ViewHolder{

    AdminReservationItemCellViewAdapter mAdapter;

    public AdminReservationItemCellViewHolder(View itemView, AdminReservationItemCellViewAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
    }
}
