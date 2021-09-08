package com.example.project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.drjacky.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ImageView cover,profile;
    FloatingActionButton fab,fab2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2)
        {
            Uri uri= data.getData();
            profile.setImageURI(uri);
        }
        else {
            Uri uri = data.getData();
            cover.setImageURI(uri);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cover=findViewById(R.id.coverimage);
        fab=findViewById(R.id.floatingActionButton);
        profile=findViewById(R.id.profile);
        fab2=findViewById(R.id.floatingActionButton2);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MainActivity.this)
//                        .crop()	    			//Crop image
//                        .cropOval()	    		//Allow dimmed layer to have a circle inside
//                        .cropFreeStyle()	    //Let the user to resize crop bounds
//                         .galleryOnly()          //We have to define what image provider we want to use
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080
                        .start(2);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MainActivity.this)
                       .crop()	    			//Crop image
                       .cropOval()	    		//Allow dimmed layer to have a circle inside
//                        .cropFreeStyle()	    //Let the user to resize crop bounds
                       .galleryOnly()          //We have to define what image provider we want to use
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080
                        .start(1);
            }
        });

    }
}