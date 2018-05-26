package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class MenuItemCellViewAdapter2 extends RecyclerView.Adapter<MenuItemCellViewHolder2> {

    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public MenuItemCellViewAdapter2(Context context, ArrayList<MenuItem> menuItems) {
        mContext = context;
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    @NonNull
    @Override
    public MenuItemCellViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //item_cell
        View view = View.inflate(mContext, R.layout.item_wish, null);
        MenuItemCellViewHolder2 menuItemCellViewHolder = new MenuItemCellViewHolder2(view);
        return menuItemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuItemCellViewHolder2 holder, int position) {

        final MenuItem item = menuItems.get(position);
        int sumPrice = item.getPrice() * item.getCount();
        holder.menuNameTextview.setText(item.getMenuName());
        holder.priceTextView.setText(((Integer) (sumPrice)).toString() + "원");
        holder.countTextView.setText(item.getCount().toString());
        holder.imgBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(holder.countTextView.getText().toString());
                if (currentCount < 99) {
                    currentCount++;
                    holder.countTextView.setText(String.valueOf(currentCount));
                    holder.priceTextView.setText("총 " + String.valueOf((Integer) (currentCount * item.getPrice())).toString() + "원");
                }
            }
        });
        holder.imgBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(holder.countTextView.getText().toString());
                if (currentCount > 1) {
                    currentCount--;
                    holder.countTextView.setText(String.valueOf(currentCount));
                    holder.priceTextView.setText("총 " + String.valueOf((Integer) (currentCount * item.getPrice())).toString() + "원");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

}