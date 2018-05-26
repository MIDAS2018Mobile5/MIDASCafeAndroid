package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class MenuItemCellViewHolder2 extends RecyclerView.ViewHolder {

    public TextView menuNameTextview;
    public TextView priceTextView;
    public TextView countTextView;
    public ImageView photoImageView;
    public ImageButton imgBtnMinus;
    public ImageButton imgBtnPlus;
    public MenuItemCellViewHolder2(View itemView) {
        super(itemView);

        menuNameTextview = (TextView) itemView.findViewById(R.id.tv_cart_menu_name);
        priceTextView = (TextView) itemView.findViewById(R.id.tv_cart_price_sum);
        countTextView = (TextView)itemView.findViewById(R.id.tv_cart_count);
        photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);
        imgBtnMinus = (ImageButton)itemView.findViewById(R.id.imgbtn_cart_minus);
        imgBtnPlus = (ImageButton)itemView.findViewById(R.id.imgbtn_cart_plus);


    }
}

