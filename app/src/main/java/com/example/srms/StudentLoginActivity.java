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

public class StudentLoginActivity extends AppCompatActivity {

    TextInputLayout username, password;
    Button loginBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        username=findViewById(R.id.student_id);
        password=findViewById(R.id.student_password);

        loginBtn=findViewById(R.id.student_loginbutton);
        progressBar=findViewById(R.id.progressBar_login);

        TextView fl2 = (TextView) findViewById(R.id.student_create_account);
        fl2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentLoginActivity.this, StudentBasicInfoActivity.class);
                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loginUser(view);
            }
        });
    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    public void loginUser(View view) {

        if (!validateUsername() | !validatePassword()) {
            return;
        }else{
            isUser();
        }
    }

    private void isUser() {


        progressBar.setVisibility(View.VISIBLE);

        final String userEnteredUsername = username.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("StSignup");
        Query checkUser = reference.orderByChild("stid").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    username.setError(null);
                    username.setErrorEnabled(false);
                    System.out.println("Password "+userEnteredUsername);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("stpassword").getValue(String.class);

                    System.out.println("Password "+passwordFromDB);


                    if (passwordFromDB.equals(userEnteredPassword)){

                        password.setError(null);
                        password.setErrorEnabled(false);

                        progressBar.setVisibility(View.GONE);

                        Intent intent = new Intent(getApplicationContext(), StudentHomeActivity.class);
                        startActivity(intent);

                    } else {
                        progressBar.setVisibility(View.GONE);
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }


}