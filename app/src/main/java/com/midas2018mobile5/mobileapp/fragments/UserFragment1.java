package com.midas2018mobile5.mobileapp.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;
import com.midas2018mobile5.mobileapp.model.MenuItem;
import com.midas2018mobile5.mobileapp.recyclerview.MenuItemCellViewAdapter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment1 extends Fragment {
    ArrayList<MenuItem> mMenuItems = null;
    Context mcontext;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public UserFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_user_fragment1, container, false);
        mcontext = rootview.getContext();



        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerview);

        new LoadMenuTask().execute();
        // Inflate the layout for this fragment
        return rootview;
    }

    class LoadMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            try {
                mMenuItems =  RequestManager.getInstance().requestSearchMenu();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new MenuItemCellViewAdapter(mcontext, mMenuItems);
            layoutManager = new GridLayoutManager(mcontext,2);
            //layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);


        }
    }

}
