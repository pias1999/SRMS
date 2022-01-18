package com.example.srms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ClassEnrollmentActivity extends AppCompatActivity {

    //FirebaseDatabase database;
    //DatabaseReference myRef;
    List<CreateNewClass> classList = new ArrayList<>();
    //RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_enrollment);

        //recyclerview = findViewById(R.id.all_courses_rec);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CreateNewClass");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    CreateNewClass classdetails = dataSnapshot1.getValue(CreateNewClass.class);
                    classList.add(classdetails);
                }
                System.out.println("Data Changed: "+classList);

                RecyclerView rv = findViewById(R.id.all_courses_rv);
                rv.setLayoutManager(new LinearLayoutManager(ClassEnrollmentActivity.this));
                rv.setAdapter(new ClassEnrolAdapter(ClassEnrollmentActivity.this, classList));

            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }

}
