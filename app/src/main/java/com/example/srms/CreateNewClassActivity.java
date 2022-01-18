package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNewClassActivity extends AppCompatActivity {


    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private EditText inputCoursetitle, inputCoursecode, inputSection, inputInstructor;
    private Button createClassButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_class);

        inputCoursetitle = (EditText) findViewById(R.id.course_title);
        inputCoursecode = (EditText) findViewById(R.id.course_code);
        inputSection = (EditText) findViewById(R.id.section);
        inputInstructor = (EditText) findViewById(R.id.instructor);
        createClassButton = (Button) findViewById(R.id.create_class_button);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("CreateNewClass");

        createClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coursetitle = inputCoursetitle.getText().toString();
                String coursecode = inputCoursecode.getText().toString();
                String section = inputSection.getText().toString();
                String instructor = inputInstructor.getText().toString();

                if (TextUtils.isEmpty(inputCoursetitle.getText())) {
                    inputCoursetitle.setError("This field is required");
                } else if (TextUtils.isEmpty(inputCoursecode.getText())) {
                    inputCoursecode.setError("This field is required");
                } else if (TextUtils.isEmpty(inputSection.getText())) {
                    inputSection.setError("This field is required");
                }  else if (TextUtils.isEmpty(inputInstructor.getText())) {
                    inputInstructor.setError("This field is required");
                } else {

                    createCreateNewClass(coursetitle, coursecode, section, instructor);

                    Toast.makeText(getApplicationContext(), "New section created syccessfully!",
                            Toast.LENGTH_LONG).show();

                    Intent i = new Intent(CreateNewClassActivity.this, NewSectionCreatedActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void createCreateNewClass(String coursetitle, String coursecode, String section, String instructor) {
        //String key =mFirebaseDatabase.push().getKey();
        CreateNewClass newClass = new CreateNewClass(inputCoursetitle.getText().toString(), inputCoursecode.getText().toString(),
                inputSection.getText().toString(), inputInstructor.getText().toString());
        mFirebaseDatabase.child(coursecode).setValue(newClass);
        finish();
    }
}