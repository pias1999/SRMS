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

public class StudentSignupActivity extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private EditText inputStid, inputStemail, inputStpassword, inputStConfPass;
    private Button stSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_signup);

        inputStid = (EditText) findViewById(R.id.student_id_signup);
        inputStemail = (EditText) findViewById(R.id.student_email);
        inputStpassword = (EditText) findViewById(R.id.student_password_signup);
        inputStConfPass = (EditText) findViewById(R.id.student_conf_password);
        stSignupButton = (Button) findViewById(R.id.student_signupbt);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("StSignup");

        stSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stid = inputStid.getText().toString();
                String stemail = inputStemail.getText().toString();
                String stpassword = inputStpassword.getText().toString();

                if (TextUtils.isEmpty(inputStid.getText())) {
                    inputStid.setError("This field is required");
                } else if (TextUtils.isEmpty(inputStemail.getText())) {
                    inputStemail.setError("This field is required");
                } else if (TextUtils.isEmpty(inputStpassword.getText())) {
                    inputStpassword.setError("This field is required");
                } else if(inputStpassword.getText().toString().equals( inputStConfPass.getText().toString())) {

                    createStSignup(stid, stemail, stpassword);

                    Intent i = new Intent(StudentSignupActivity.this, StudentLoginActivity.class);
                    startActivity(i);
                }else{
                    //Toast is the pop up message
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password should be same!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void createStSignup(String stid, String stemail, String stpassword) {
        String key = mFirebaseDatabase.push().getKey();
        StSignup newStSignup = new StSignup(inputStid.getText().toString(), inputStemail.getText().toString(), inputStpassword.getText().toString());
        mFirebaseDatabase.child(key).setValue(newStSignup);
        finish();
    }
}