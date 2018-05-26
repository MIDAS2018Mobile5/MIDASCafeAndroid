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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter2;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment3 extends Fragment {

    Context mcontext;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public UserFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_user_fragment3, container, false);
        mcontext = rootview.getContext();


        //스피너
        Spinner spinner=(Spinner) rootview.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(mcontext, R.array.spinner_list, R.layout.spinner_textview_layout);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(0);

        // 리싸이클러
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        for(int i=0;i<20;i++){
            MenuItem item = new MenuItem();
            item.title = "15000원" + i;
            item.subtitle = "아메리카노 2, 카페라떼 2" + i;
            menuItems.add(item);
        }


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);
        adapter = new MenuItemCellViewAdapter3(mcontext,menuItems);
        //layoutManager = new GridLayoutManager(mcontext,1);
        layoutManager = new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        // Inflate the layout for this fragment
        return rootview;

    }

}
