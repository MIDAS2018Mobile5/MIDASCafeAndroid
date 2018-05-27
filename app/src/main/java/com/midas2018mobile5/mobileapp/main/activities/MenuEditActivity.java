package com.midas2018mobile5.mobileapp.main.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ImageView;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.databinding.ActivityMenuEditBinding;
import com.midas2018mobile5.mobileapp.main.utils.RequestManager;

import java.util.HashMap;
public class MenuEditActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    private ActivityMenuEditBinding mBinding;
    private String beforeName;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_menu_edit);
        Intent intent = getIntent();
        beforeName = intent.getStringExtra("name");
        Button modifyButton = (Button)findViewById(R.id.button_menu_add);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ModifyMenuTask().execute();
            }
        });


        imageView = findViewById(R.id.imageView_menu_photo_add);
        imageView.setOnClickListener(this);


        // back button 추가
        ImageButton backButton = findViewById(R.id.imageButton_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



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

    class ModifyMenuTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... integers) {
            String menu = mBinding.editTextName.getText().toString();
            int price = Integer.valueOf(mBinding.editTextPrice.getText().toString());
            HashMap<String,Object> addParameters = new HashMap<String,Object>();
            HashMap<String,Object> deleteParameters = new HashMap<String,Object>();
            addParameters.put("name",menu);
            addParameters.put("price",price);
            addParameters.put("imgpath","image");
            deleteParameters.put("name",beforeName);
            RequestManager.getInstance().requestDeleteMenu(deleteParameters);
            RequestManager.getInstance().requestAddMenu(addParameters);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(),"수정되었습니다",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuEditActivity.this,AdminActivity.class);
            startActivity(intent);


        }
    }
}