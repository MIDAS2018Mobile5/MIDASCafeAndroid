package com.midas2018mobile5.mobileapp.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.AdminMenuDetailActivity;
import com.midas2018mobile5.mobileapp.main.activities.AdminUserChangeActivity;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.model.UserItem;

import java.util.ArrayList;

public class AdminUserItemCellViewAdapter extends RecyclerView.Adapter<AdminUserItemCellViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<UserItem> userItems;

    public AdminUserItemCellViewAdapter(Context context, ArrayList<UserItem> userItems){
        mContext = context;
        this.userItems = userItems;
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
        return userItems.size();
    }


    @Override
    public void onClick(View v) {

    }

    public void onEditClicked(int position){

        //MenuItem item = menuItems.get(position);
        Intent intent = new Intent(mContext, AdminUserChangeActivity.class);
        //intent.putExtra("item_position",position);
        mContext.startActivity(intent);
    }


    public void onRemoveClicked(int position){

        Toast.makeText(mContext,"삭제되었습니다",Toast.LENGTH_SHORT).show();
    }

}
