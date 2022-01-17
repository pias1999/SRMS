package com.example.srms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FacultyLoginActivity extends AppCompatActivity {

    TextInputLayout flUsername, flPassword;
    Button flLoginBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_login);

        flUsername=findViewById(R.id.flid);
        flPassword=findViewById(R.id.faculty_password);

        flLoginBtn=findViewById(R.id.faculty_loginbutton);
        progressBar=findViewById(R.id.progressBar_fllogin);

        TextView fl2 = (TextView) findViewById(R.id.faculty_create_account);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(FacultyLoginActivity.this, FacultySignupActivity.class);
                startActivity(i);
            }
        });

        flLoginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loginFaculty(view);
            }
        });
    }

    private Boolean validateUsername() {
        String val = flUsername.getEditText().getText().toString();
        if (val.isEmpty()) {
            flUsername.setError("Field cannot be empty");
            return false;
        } else {
            flUsername.setError(null);
            flUsername.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = flPassword.getEditText().getText().toString();
        if (val.isEmpty()) {
            flPassword.setError("Field cannot be empty");
            return false;
        } else {
            flPassword.setError(null);
            flPassword.setErrorEnabled(false);
            return true;
        }
    }
    public void loginFaculty(View view) {

        if (!validateUsername() | !validatePassword()) {
            return;
        }else{
            isUser();
        }
    }

    private void isUser() {


        progressBar.setVisibility(View.VISIBLE);

        final String flUserEnteredUsername = flUsername.getEditText().getText().toString().trim();
        final String flUserEnteredPassword = flPassword.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("FlSignup");
        Query checkUser = reference.orderByChild("flid").equalTo(flUserEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    flUsername.setError(null);
                    flUsername.setErrorEnabled(false);
                    System.out.println("Password "+flUserEnteredUsername);

                    String passwordFromDB = dataSnapshot.child(flUserEnteredUsername).child("flpassword").getValue(String.class);

                    System.out.println("Password "+passwordFromDB);


                    if (passwordFromDB.equals(flUserEnteredPassword)){

                        flPassword.setError(null);
                        flPassword.setErrorEnabled(false);

                        progressBar.setVisibility(View.GONE);

                        Intent intent = new Intent(getApplicationContext(), FacultyHomeActivity.class);
                        startActivity(intent);

                    } else {
                        progressBar.setVisibility(View.GONE);
                        flPassword.setError("Wrong Password");
                        flPassword.requestFocus();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    flUsername.setError("No such User exist");
                    flUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }


}