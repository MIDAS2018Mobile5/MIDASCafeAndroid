package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.AdminUserChangeActivity;
import com.midas2018mobile5.mobileapp.main.activities.MenuAddActivity;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.model.UserItem;
import com.midas2018mobile5.mobileapp.recyclerview.AdminMenuItemCellViewAdapter;
import com.midas2018mobile5.mobileapp.recyclerview.AdminUserItemCellViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment2 extends Fragment {


    Context mcontext;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    public AdminFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_admin_fragment2, container, false);

        mcontext = rootview.getContext();

        ArrayList<UserItem> userItems = new ArrayList<>();
        for(int i=0;i<20;i++){
            UserItem item = new UserItem("사용자"+i,"id"+i,"USER");
            userItems.add(item);
       }


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        adapter = new AdminUserItemCellViewAdapter(mcontext,userItems);
        layoutManager = new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        //floatingActionButton
        FloatingActionButton floatingActionButton = (FloatingActionButton)rootview.findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MenuItem item = menuItems.get(position);
                Intent intent = new Intent(getContext(), AdminUserChangeActivity.class);
                //intent.putExtra("item_position",position);
                getContext().startActivity(intent);
            }
        });


        return rootview;
    }

}
