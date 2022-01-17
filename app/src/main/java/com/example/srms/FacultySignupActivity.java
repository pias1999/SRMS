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

public class FacultySignupActivity extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private EditText inputFlid, inputFlfullname, inputFlemail, inputFlpassword, inputFlConfPass;
    private Button flSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_signup);

        inputFlid = (EditText) findViewById(R.id.Sflid);
        inputFlfullname = (EditText) findViewById(R.id.faculty_fullname);
        inputFlemail = (EditText) findViewById(R.id.Sfaculty_email);
        inputFlpassword = (EditText) findViewById(R.id.Sfaculty_pass);
        inputFlConfPass = (EditText) findViewById(R.id.Sfaculty_conf_pass);
        flSignupButton = (Button) findViewById(R.id.faculty_signupbt);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("FlSignup");

        flSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String flid = inputFlid.getText().toString();
                String flfullname = inputFlfullname.getText().toString();
                String flemail = inputFlemail.getText().toString();
                String flpassword = inputFlpassword.getText().toString();
                if (TextUtils.isEmpty(inputFlid.getText())) {
                    inputFlid.setError("This field is required");
                } else if (TextUtils.isEmpty(inputFlfullname.getText())) {
                    inputFlfullname.setError("This field is required");
                } else if (TextUtils.isEmpty(inputFlemail.getText())) {
                    inputFlemail.setError("This field is required");
                } else if (TextUtils.isEmpty(inputFlpassword.getText())) {
                    inputFlpassword.setError("This field is required");
                } else if(inputFlpassword.getText().toString().equals( inputFlConfPass.getText().toString())) {

                    createFlSignup(flid, flfullname, flemail, flpassword);

                    Toast.makeText(getApplicationContext(), "Sign Up successful!",
                            Toast.LENGTH_LONG).show();

                    Intent i = new Intent(FacultySignupActivity.this, FacultyLoginActivity.class);
                    startActivity(i);
                }else{
                    //Toast is the pop up message
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password should be same!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void createFlSignup(String flid, String flfullname, String flemail, String flpassword) {
        //String key = mFirebaseDatabase.push().getKey();
        FlSignup newFlSignup = new FlSignup(inputFlid.getText().toString(), inputFlfullname.getText().toString(), inputFlemail.getText().toString(), inputFlpassword.getText().toString());
        mFirebaseDatabase.child(flid).setValue(newFlSignup);
        finish();
    }
}