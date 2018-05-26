package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.databinding.ActivityDetailBinding;
import com.midas2018mobile5.mobileapp.fragments.UserFragment2;
import com.midas2018mobile5.mobileapp.main.utils.RealmManager;
import com.midas2018mobile5.mobileapp.model.CartItem;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter2;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Intent intent = getIntent();
        String menuName = intent.getStringExtra("menuName");
        final int price = intent.getIntExtra("price",0);
        mBinding.tvMenuName.setText(menuName);
        mBinding.tvPrice.setText(String.valueOf(price));
        mBinding.tvPriceSum.setText(String.valueOf(price));
        mBinding.btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserActivity.class);
                RealmManager.getInstance().beginTransaction();
                CartItem item = RealmManager.getInstance().createObject(CartItem.class);
                item.setMenuName(mBinding.tvMenuName.getText().toString());
                item.setCount(Integer.parseInt(mBinding.tvCount.getText().toString()));
                item.setPrice(Integer.parseInt(mBinding.tvPrice.getText().toString()));
                RealmManager.getInstance().commitTransaction();
                startActivity(intent);
            }
        });
        mBinding.btnPlusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(mBinding.tvCount.getText().toString());
                if(currentCount<99) {
                    currentCount++;
                    mBinding.tvCount.setText(String.valueOf(currentCount));
                    mBinding.tvPriceSum.setText("총 " + String.valueOf(currentCount * price) + "원");
                }
            }
        });

        mBinding.btnMinusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(mBinding.tvCount.getText().toString());
                if(currentCount>1) {
                    currentCount--;
                    mBinding.tvCount.setText(String.valueOf(currentCount));
                    mBinding.tvPriceSum.setText("총 " + String.valueOf(currentCount * price) + "원");
                }
            }
        });


    }
}
