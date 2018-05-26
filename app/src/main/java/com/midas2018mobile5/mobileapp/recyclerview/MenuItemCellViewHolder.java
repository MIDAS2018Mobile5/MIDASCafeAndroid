package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class MenuItemCellViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextview;
    public TextView subtitleTextView;
    public ImageView photoImageView;

    public MenuItemCellViewHolder(View itemView) {
        super(itemView);

        titleTextview = (TextView) itemView.findViewById(R.id.textView_title);
        subtitleTextView = (TextView) itemView.findViewById(R.id.textView_sub);
        photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);


        // 이미지뷰 받아와서 동그랗게 짜르기
        //photoImageView.setBackground(new ShapeDrawable(new OvalShape()));
        //photoImageView.setClipToOutline(true);

    }
}

