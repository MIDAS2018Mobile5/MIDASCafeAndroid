package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.CompleteOrderActivity;
import com.midas2018mobile5.mobileapp.main.activities.UserActivity;
import com.midas2018mobile5.mobileapp.main.utils.RealmManager;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;
import com.midas2018mobile5.mobileapp.model.CartItem;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment2 extends Fragment {

    Context mContext;
    RecyclerView recyclerView;
    MenuItemCellViewAdapter2 adapter;
    RecyclerView.LayoutManager layoutManager;
    private Button btnOrderButton;
    public UserFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        RealmResults<CartItem> cartItems = RealmManager.getInstance().where(CartItem.class).findAll();
        for(int i=0; i<cartItems.size(); i++) {
            int price = cartItems.get(i).getPrice();
            String menuName = cartItems.get(i).getMenuName();
            int count = cartItems.get(i).getCount();
            adapter.addMenuItem(new MenuItem(menuName,price,count));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_user_fragment2, container, false);
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        mContext = getContext();
        btnOrderButton = (Button)rootview.findViewById(R.id.btn_order);


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        adapter = new MenuItemCellViewAdapter2(mContext,menuItems);
        //layoutManager = new GridLayoutManager(mContext,2);
        layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<CartItem> results = RealmManager.getInstance().where(CartItem.class).findAll();
                for(int i=0; i<results.size(); i++) {
                    String date = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(new Date());
                    HashMap<String,Object> parameters = new HashMap<String,Object>();
                    parameters.put("name","tempName");
                    parameters.put("menu",results.get(i).getMenuName());
                    parameters.put("count",results.get(i).getCount());
                    parameters.put("price",results.get(i).getPrice());
                    parameters.put("date",date);

                    RequestManager.getinstance().requestOrder(parameters);
                }
                RealmManager.clearRealm();
                Intent intent = new Intent(getActivity(), CompleteOrderActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootview;
    }

}
