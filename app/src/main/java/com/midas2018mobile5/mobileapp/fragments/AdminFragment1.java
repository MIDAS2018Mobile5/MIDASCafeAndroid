package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.activities.MenuAddActivity;
import com.midas2018mobile5.mobileapp.main.activities.UserActivity;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.recyclerview.AdminMenuItemCellViewAdapter;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment1 extends Fragment {

    Context mcontext;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<MenuItem> mMenuItems;

    public AdminFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_admin_fragment1, container, false);
        mcontext = rootview.getContext();
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);

//        for(int i=0;i<20;i++){
//            MenuItem item = new MenuItem();
//            item.title = "타이틀" + i;
//            item.subtitle = "서브타이틀" + i;
//            menuItems.add(item);
//        }





        //floatingActionButton
        FloatingActionButton floatingActionButton = (FloatingActionButton)rootview.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,MenuAddActivity.class);
                //intent.putExtra("",);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        new LoadAdminMenuTask().execute();
        return rootview;
    }

    class LoadAdminMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            try {
                mMenuItems =  RequestManager.getinstance().requestSearchMenu();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new AdminMenuItemCellViewAdapter(mcontext, mMenuItems);
            layoutManager = new GridLayoutManager(mcontext,2);
            //layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);


        }
    }

}
