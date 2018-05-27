package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.model.ReservationItem;
import com.midas2018mobile5.mobileapp.recyclerview.AdminReservationItemCellViewAdapter;
import com.midas2018mobile5.mobileapp.recyclerview.AdminUserItemCellViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment3 extends Fragment {


    Context mcontext;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    public AdminFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_admin_fragment3, container, false);
        mcontext = rootview.getContext();

        ArrayList<ReservationItem> reservationItems = new ArrayList<>();
        for(int i=0;i<5;i++){

            ReservationItem item = new ReservationItem();
            item.setBid(""+ (i+1));
            item.setName("마이다스 직원 " + (i+1));
            reservationItems.add(item);
        }


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        adapter = new AdminReservationItemCellViewAdapter(mcontext,reservationItems);
        layoutManager = new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return rootview;
    }

}
