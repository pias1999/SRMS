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

public class StudentBasicInfoActivity extends AppCompatActivity {


    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private EditText inputStid, inputFullname, inputDept, inputFathersname, inputMothersname, inputGuardcont, inputStudcont;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_basic_info);

        inputStid = (EditText) findViewById(R.id.student_id_bi);
        inputFullname = (EditText) findViewById(R.id.student_fullname);
        inputDept = (EditText) findViewById(R.id.student_dept);
        inputFathersname = (EditText) findViewById(R.id.stu_fathers_name);
        inputMothersname = (EditText) findViewById(R.id.stu_mothers_name);
        inputGuardcont = (EditText) findViewById(R.id.stu_guardians_contact);
        inputStudcont = (EditText) findViewById(R.id.students_contact);
        nextButton = (Button) findViewById(R.id.student_sign_up_next);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("StBasicInfo");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stid = inputStid.getText().toString();
                String fullname = inputFullname.getText().toString();
                String dept = inputDept.getText().toString();
                String fathersname = inputFathersname.getText().toString();
                String mothersname = inputMothersname.getText().toString();
                String guardcont = inputGuardcont.getText().toString();
                String studcont = inputStudcont.getText().toString();
                if (TextUtils.isEmpty(inputStid.getText())) {
                    inputStid.setError("This field is required");
                } else if (TextUtils.isEmpty(inputFullname.getText())) {
                    inputFullname.setError("This field is required");
                } else if (TextUtils.isEmpty(inputDept.getText())) {
                    inputDept.setError("This field is required");
                } else if (TextUtils.isEmpty(inputFathersname.getText())) {
                    inputFathersname.setError("This field is required");
                } else if (TextUtils.isEmpty(inputMothersname.getText())) {
                    inputMothersname.setError("This field is required");
                } else if (TextUtils.isEmpty(inputGuardcont.getText())) {
                    inputGuardcont.setError("This field is required");
                } else if (TextUtils.isEmpty(inputStudcont.getText())) {
                    inputStudcont.setError("This field is required");
                } else {

                    createStBasicInfo(stid, fullname, dept, fathersname, mothersname, guardcont, studcont);

                    Toast.makeText(getApplicationContext(), "Data submitted successfully!",
                            Toast.LENGTH_LONG).show();


                    Intent i = new Intent(StudentBasicInfoActivity.this, StudentSignupActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void createStBasicInfo(String stid, String fullname, String dept, String fathersname, String mothersname, String guardcont, String studcont) {
        //String key =mFirebaseDatabase.push().getKey();
        StBasicInfo newStudent = new StBasicInfo(inputStid.getText().toString(), inputFullname.getText().toString(), inputDept.getText().toString(),
                inputFathersname.getText().toString(), inputMothersname.getText().toString(),
                inputGuardcont.getText().toString(), inputStudcont.getText().toString());
        mFirebaseDatabase.child(stid).setValue(newStudent);
        finish();
    }
}