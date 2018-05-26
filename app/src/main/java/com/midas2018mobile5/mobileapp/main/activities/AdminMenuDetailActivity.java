package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.databinding.ActivityAdminMenuDetailBinding;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;

import java.util.HashMap;

public class AdminMenuDetailActivity extends AppCompatActivity {
    private String menuName;
    private int price;
    private ActivityAdminMenuDetailBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_admin_menu_detail);
        Intent intent = getIntent();
        menuName = intent.getStringExtra("menu");
        price = intent.getIntExtra("price",0);
        mBinding.textViewAdminMenu.setText(menuName);
        mBinding.textViewAdminPrice.setText(String.valueOf(price));
        mBinding.imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                //intent.putExtra("",);
                startActivity(intent);
            }
        });


        //수정버튼
        Button editButton = (Button)findViewById(R.id.button_edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuEditActivity.class);
                //intent.putExtra("",);
                intent.putExtra("name",menuName);
                startActivity(intent);
            }
        });


        //삭제버튼
        Button removeButton = (Button)findViewById(R.id.button_remove);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //서버에서 제거한후 리프레쉬?
                //사용자에게는 토스트 보여줌

                new DeleteMenuTask().execute();
            }
        });


    }

    class DeleteMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            HashMap<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("name",menuName);
            RequestManager.getInstance().requestDeleteMenu(parameters);

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(),"삭제되었습니다",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AdminMenuDetailActivity.this,AdminActivity.class);
            startActivity(intent);


        }
    }
}
