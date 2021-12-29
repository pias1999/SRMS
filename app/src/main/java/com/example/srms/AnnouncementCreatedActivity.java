package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnnouncementCreatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_created);

        Button fl1 = (Button) findViewById(R.id.dismiss1);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnnouncementCreatedActivity.this, NewAnnouncementActivity.class);
                startActivity(i);
            }
        });
    }
}