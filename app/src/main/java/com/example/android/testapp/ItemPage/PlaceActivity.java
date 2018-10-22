package com.example.android.testapp.ItemPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.testapp.R;

public class PlaceActivity extends AppCompatActivity {

    private static final String TAG = "PlaceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("Title") && getIntent().hasExtra("Image")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("Image");
            String imageName = getIntent().getStringExtra("Title");

            setImage(imageUrl, imageName);
        }
    }


    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting the image and name to widgets.");

        TextView name = findViewById(R.id.name_title);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image_title);

        Glide.with(this).load(Integer.valueOf(imageUrl)).into(image);
    }

}