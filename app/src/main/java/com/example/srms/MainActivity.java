package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        TextView fl1 = (TextView) findViewById(R.id.faculty_loginb);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FacultyLoginActivity.class);
                startActivity(i);
            }
        });

        TextView fl2 = (TextView) findViewById(R.id.student_loginb);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(i);
            }
        });
    }


}