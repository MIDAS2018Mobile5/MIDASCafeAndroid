package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class MenuItemCellViewHolder3 extends RecyclerView.ViewHolder {


    public TextView priceTextview;
    public TextView menusTextView;
    public ImageView photoImageView;

    public MenuItemCellViewHolder3(View itemView) {
        super(itemView);

        priceTextview = (TextView) itemView.findViewById(R.id.textView_log_price);
        menusTextView = (TextView) itemView.findViewById(R.id.textView_log_menus);
        photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);

    }
}
