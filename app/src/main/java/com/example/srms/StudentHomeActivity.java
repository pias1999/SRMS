package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class StudentHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);

        TextView fl1 = (TextView) findViewById(R.id.student_logoutbutton);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentHomeActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl2 = (ImageButton) findViewById(R.id.class_enrol_button);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentHomeActivity.this, ClassEnrollmentActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl3 = (ImageButton) findViewById(R.id.grades_check_button);
        fl3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentHomeActivity.this, ProgressReportActivity.class);
                startActivity(i);
            }
        });

        ImageButton fl4 = (ImageButton) findViewById(R.id.request_review_button);
        fl4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentHomeActivity.this, MakeRevReqActivity.class);
                startActivity(i);
            }
        });
    }
}