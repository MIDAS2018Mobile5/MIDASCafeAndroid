package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageButton;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.databinding.ActivityMenuAddBinding;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;
import com.midas2018mobile5.mobileapp.recyclerview.AdminMenuItemCellViewAdapter;

import java.io.IOException;
import java.util.HashMap;

public class MenuAddActivity extends AppCompatActivity {
    private ActivityMenuAddBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_menu_add);
        mBinding.imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AddMenuTask().execute();
            }
        });
    }
    class AddMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            String menuName = mBinding.editTextName.getText().toString();
            int price = Integer.parseInt(mBinding.editTextPrice.getText().toString());
            HashMap<String,Object> parameters = new HashMap<String,Object>();
//            parameters.put("")
//            RequestManager.getinstance().requestAddMenu();
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
            //intent.putExtra("",);
            startActivity(intent);

        }
    }
}
