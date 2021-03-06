package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;

public class perscrip_upload_choice extends Activity {
    private Button toThePerscripPic;
    private Button toThePerscripManual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perscrip_upload_choice);

        toThePerscripPic = findViewById(R.id.toPicPerUpload);
        toThePerscripManual = findViewById(R.id.toManualPerUpload);
        FloatingActionButton home = findViewById(R.id.PerscripUploadChoiceHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(perscrip_upload_choice.this, Homepage.class);
                startActivity(i);
            }
        });

        toThePerscripManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toperscrip = new Intent(perscrip_upload_choice.this, PerscriptionView.class);
                startActivity(toperscrip);
            }
        });

        toThePerscripPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toperscrip = new Intent(perscrip_upload_choice.this, UploadImageActivity.class);
                toperscrip.putExtra("From", "perscrip");
                startActivity(toperscrip);
            }
        });
    }

}