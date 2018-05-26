package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.responses.OrderSearchResponse;
import com.midas2018mobile5.mobileapp.main.utils.PrefManager;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;
import com.midas2018mobile5.mobileapp.model.OrderLog;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.realm.annotations.PrimaryKey;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment3 extends Fragment {

    Context mcontext;
    RecyclerView recyclerView;
    MenuItemCellViewAdapter3 adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pair<Integer,Integer>> terms;
    private ArrayList<String> spinnerItems;
    private List<OrderLog> menuItems = new ArrayList<OrderLog>();

    public UserFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_user_fragment3, container, false);
        // 리싸이클러

        mcontext = rootview.getContext();
        terms = new ArrayList<Pair<Integer,Integer>>();
        spinnerItems = new ArrayList<String>();
        int year = Integer.parseInt(new SimpleDateFormat("yyyy", Locale.KOREA).format(new Date()));
        int month = Integer.parseInt(new SimpleDateFormat("MM", Locale.KOREA).format(new Date()));
        for(int i=0; i<5; i++) {
            terms.add(new Pair<Integer,Integer>(year,month));
            month--;
            if(month<=0) {
                month = 12;
                year--;
            }
        }
        for(int i=0; i<5; i++) {
            spinnerItems.add(String.valueOf(terms.get(i).first)+"년 "+String.valueOf(terms.get(i).second)+"월");
        }
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(rootview.getContext(),
                R.layout.spinner_textview_layout, spinnerItems);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_textview_layout);
        Spinner spinner=(Spinner) rootview.findViewById(R.id.spinner_term);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int index, long l) {
                new LoadMenuTask().execute();
                /*try {
                    logs = RequestManager.getInstance().requestOrderLog("tempName");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(logs==null)
                    return;

                for(int i=0; i<logs.size(); i++) {
                    int price = 0;
                    String menu = "";
                    OrderSearchResponse log = logs.get(i);
                    int bid = log.getBid();
                    for(int s=i; s<logs.size(); s++) {
                        if(bid==logs.get(s).getBid()) {
                            price+=logs.get(s).getPrice();
                            menu+=(logs.get(s).getDate()+" ");
                        }
                        else {
                            i = s;
                            OrderLog orderLog = new OrderLog(menu,price,log.getDate());
                            adapter.addOrderItem(orderLog);
                        }
                        if(s>=logs.size()-1) {
                            i = logs.size() - 1;
                            OrderLog orderLog = new OrderLog(menu,price,log.getDate());
                            adapter.addOrderItem(orderLog);
                        }

                    }
                }
                adapter.notifyDataSetChanged();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);


        new UserFragment3.LoadMenuTask().execute();
        // Inflate the layout for this fragment
        return rootview;

    }


    class LoadMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            List<OrderSearchResponse> logs;
            try {
                PrefManager prefManager = new PrefManager(getContext());
                String id = prefManager.getPrefString("id");
                logs =  RequestManager.getInstance().requestOrderLog(id);
                for(int i=0; i<logs.size(); i++) {
                    OrderLog orderLog = new OrderLog(logs.get(i).getMenu(),logs.get(i).getPrice(),logs.get(i).getDate());
                    menuItems.add(orderLog);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new MenuItemCellViewAdapter3(mcontext,menuItems);
            layoutManager = new LinearLayoutManager(mcontext,LinearLayoutManager.VERTICAL,false);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        }
    }

}
