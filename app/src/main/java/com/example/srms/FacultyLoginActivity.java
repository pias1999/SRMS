package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FacultyLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_login);

        TextView fl1 = (TextView) findViewById(R.id.faculty_loginbutton);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyLoginActivity.this, FacultyHomeActivity.class);
                startActivity(i);
            }
        });

        TextView fl2 = (TextView) findViewById(R.id.faculty_create_account);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyLoginActivity.this, FacultySignupActivity.class);
                startActivity(i);
            }
        });
    }


}