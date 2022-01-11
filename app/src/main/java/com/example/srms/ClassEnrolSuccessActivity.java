package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassEnrolSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_enrol_success);

        Button fl1 = (Button) findViewById(R.id.dismiss6);
        fl1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClassEnrolSuccessActivity.this, FacultyHomeActivity.class);
                startActivity(i);
            }
        });
    }
}