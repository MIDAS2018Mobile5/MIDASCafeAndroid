package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;
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

        ArrayList<MenuItem> menuItems = new ArrayList<>();
//        for(int i=0;i<20;i++){
//            MenuItem item = new MenuItem();
//            item.title = "타이틀" + i;
//            item.subtitle = "서브타이틀" + i;
//            menuItems.add(item);
//        }


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        adapter = new AdminUserItemCellViewAdapter(mcontext,menuItems);
        layoutManager = new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootview;
    }

}
