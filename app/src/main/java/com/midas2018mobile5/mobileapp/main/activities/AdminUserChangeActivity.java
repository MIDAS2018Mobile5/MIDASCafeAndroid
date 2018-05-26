package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.midas2018mobile5.mobileapp.R;

public class AdminUserChangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_admin_user_change);


        Button changeFinishButton = findViewById(R.id.btn_change_finish);
        changeFinishButton.setOnClickListener(new View.OnClickListener() {
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
