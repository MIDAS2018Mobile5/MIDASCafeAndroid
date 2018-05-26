package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class AdminMenuItemCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView titleTextview;
    public TextView subtitleTextView;

    AdminMenuItemCellViewAdapter mAdapter;


    public AdminMenuItemCellViewHolder(View itemView, AdminMenuItemCellViewAdapter mAdapter) {

        super(itemView);

        this.mAdapter = mAdapter;

        titleTextview = (TextView) itemView.findViewById(R.id.textView_menu_name);
        subtitleTextView = (TextView) itemView.findViewById(R.id.textView_sub);

        itemView.setOnClickListener(this);


        // 이미지뷰 받아와서 동그랗게 짜르기
        //photoImageView.setBackground(new ShapeDrawable(new OvalShape()));
        //photoImageView.setClipToOutline(true);

    }

    @Override
    public void onClick(View v) {
        // 현재 이 뷰가 몇번째에 있는지
        int position = getAdapterPosition();
        mAdapter.onItemClicked(position);
    }
}
