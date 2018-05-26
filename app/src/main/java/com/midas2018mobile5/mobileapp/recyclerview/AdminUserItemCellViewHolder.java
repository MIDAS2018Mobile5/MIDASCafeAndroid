package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;


import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class AdminUserItemCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView titleTextview;
    public TextView subtitleTextView;


    AdminUserItemCellViewAdapter mAdapter;

    public AdminUserItemCellViewHolder(View itemView, AdminUserItemCellViewAdapter mAdapter) {
        super(itemView);

        this.mAdapter = mAdapter;

        titleTextview = (TextView) itemView.findViewById(R.id.textView_log_price);
        subtitleTextView = (TextView) itemView.findViewById(R.id.textView_log_menus);

        ImageButton imageButton_user_edit = itemView.findViewById(R.id.imageButton_user_edit);
        imageButton_user_edit.setOnClickListener(this);

        ImageButton imageButton_user_remove= itemView.findViewById(R.id.imageButton_user_remove);
        imageButton_user_remove.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // 현재 이 뷰가 몇번째에 있는지
        int position = getAdapterPosition();

        switch (v.getId()){
            case R.id.imageButton_user_edit:
                mAdapter.onEditClicked(position);
                break;
            case R.id.imageButton_user_remove:
                mAdapter.onRemoveClicked(position);
                break;
        }
    }

}
