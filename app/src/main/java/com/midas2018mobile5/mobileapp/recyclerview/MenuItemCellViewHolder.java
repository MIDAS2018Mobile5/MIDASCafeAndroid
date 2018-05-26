package com.midas2018mobile5.mobileapp.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.midas2018mobile5.mobileapp.R;

public class MenuItemCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView titleTextview;
    public TextView subtitleTextView;
    public ImageView photoImageView;


    MenuItemCellViewAdapter mAdapter;

    public MenuItemCellViewHolder(View itemView,MenuItemCellViewAdapter mAdapter) {
        super(itemView);

        this.mAdapter = mAdapter;

        titleTextview = (TextView) itemView.findViewById(R.id.textView_title);
        subtitleTextView = (TextView) itemView.findViewById(R.id.textView_sub);
        photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);


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

        /*
        switch (v.getId()){
            case R.id.imageView:
                mAdapter.onItemClicked(position);
                break;
        }
        */
    }
}

