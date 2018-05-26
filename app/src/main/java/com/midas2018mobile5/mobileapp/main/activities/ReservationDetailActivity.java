package com.midas2018mobile5.mobileapp.main.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.midas2018mobile5.mobileapp.R;

public class ReservationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);

        ImageButton imageButton_back = findViewById(R.id.imageButton_back);
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                //intent.putExtra("",);
                //startActivity(intent);
                finish();
            }
        });

        Button btn_reservation_finish = findViewById(R.id.btn_reservation_finish);
        btn_reservation_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                //intent.putExtra("",);
                //startActivity(intent);
                finish();
            }
        });
    }
}
