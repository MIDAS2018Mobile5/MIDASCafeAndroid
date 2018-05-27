package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class AdminReservationItemCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    AdminReservationItemCellViewAdapter mAdapter;
    public TextView titleTextview;
    public TextView subtitleTextView;

    public AdminReservationItemCellViewHolder(View itemView, AdminReservationItemCellViewAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        itemView.setOnClickListener(this);


        titleTextview = itemView.findViewById(R.id.textView_order_menu_name);
        subtitleTextView = itemView.findViewById(R.id.textView_order_user_name);
    }

    @Override
    public void onClick(View v) {
        // 현재 이 뷰가 몇번째에 있는지
        int position = getAdapterPosition();
        mAdapter.onItemClicked(position);
    }
}
