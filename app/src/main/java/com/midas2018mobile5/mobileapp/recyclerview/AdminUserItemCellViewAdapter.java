package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;

import java.util.ArrayList;

public class AdminUserItemCellViewAdapter extends RecyclerView.Adapter<AdminUserItemCellViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<MenuItem> menuItems;

    public AdminUserItemCellViewAdapter(Context context, ArrayList<MenuItem> menuItems){
        mContext = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public AdminUserItemCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_user,null);
        AdminUserItemCellViewHolder userItemCellViewHolder = new AdminUserItemCellViewHolder(view,this);
        return userItemCellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminUserItemCellViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


    @Override
    public void onClick(View v) {

    }
}
