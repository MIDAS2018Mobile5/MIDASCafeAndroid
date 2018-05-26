package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.midas2018mobile5.mobileapp.R;

public class CompleteOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
        Button btnReturn = (Button)findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteOrderActivity.this,UserActivity.class);
                startActivity(intent);

            }
        });
    }
}
