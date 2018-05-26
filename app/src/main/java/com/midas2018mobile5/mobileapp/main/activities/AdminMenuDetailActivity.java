package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.midas2018mobile5.mobileapp.R;

public class AdminMenuDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_detail);

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(getApplicationContext(),"삭제되었습니다",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
