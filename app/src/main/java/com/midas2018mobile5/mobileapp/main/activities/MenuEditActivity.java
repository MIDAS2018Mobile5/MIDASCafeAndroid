package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.midas2018mobile5.mobileapp.R;

public class MenuEditActivity extends AppCompatActivity implements View.OnClickListener{


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_edit);

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AdminActivity.class);
                //intent.putExtra("",);
                startActivity(intent);
            }
        });


        imageView = findViewById(R.id.imageView_menu_photo_add);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        imageView.setImageURI(data.getData());
    }
}
