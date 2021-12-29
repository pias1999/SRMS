package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FacultyHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_home);

        TextView fl1 = (TextView) findViewById(R.id.faculty_logoutbutton);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, FacultyLoginActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl2 = (ImageButton) findViewById(R.id.classbutton);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, CreateNewClassActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl4 = (ImageButton) findViewById(R.id.markingbutton);
        fl4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, AssessmentMarksActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl5 = (ImageButton) findViewById(R.id.update_marksb);
        fl5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, UpdateMarksActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl6 = (ImageButton) findViewById(R.id.reviewbutton);
        fl6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, ReviewRequestsActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl7 = (ImageButton) findViewById(R.id.announcebutton);
        fl7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyHomeActivity.this, NewAnnouncementActivity.class);
                startActivity(i);
            }
        });
    }
}