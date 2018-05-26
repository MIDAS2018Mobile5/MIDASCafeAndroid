package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class AdminUserItemCellViewHolder extends RecyclerView.ViewHolder{

    public TextView titleTextview;
    public TextView subtitleTextView;


    AdminUserItemCellViewAdapter mAdapter;

    public AdminUserItemCellViewHolder(View itemView, AdminUserItemCellViewAdapter mAdapter) {
        super(itemView);

        this.mAdapter = mAdapter;

        titleTextview = (TextView) itemView.findViewById(R.id.textView_log_price);
        subtitleTextView = (TextView) itemView.findViewById(R.id.textView_log_menus);

    }
}
