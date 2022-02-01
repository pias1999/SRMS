package com.example.srms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClassEnrolAdapter extends RecyclerView.Adapter<MyHolder>{

    Context context;
    List<CreateNewClass> classList = new ArrayList<>();

    public ClassEnrolAdapter(Context context, List<CreateNewClass> classList) {
        this.context = context;
        this.classList = classList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_list,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        CreateNewClass data = classList.get(position);
        holder.vCorseCode.setText(data.getCoursecode());
        holder.vInstructor.setText(data.getInstructor());
        holder.vSection.setText(data.getSection());
        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stid = data.getStid().toString();
                String fullname = data.getFullname().toString();
                String dept = data.getDept().toString();
                String fathersname = data.getFathersname().toString();
                String mothersname = data.getMothersname().toString();
                String guardcont = data.getGuardcont().toString();
                String studcont = data.getStudcont().toString();

                createTable(stid, fullname, dept, fathersname, mothersname, guardcont, studcont);

                    Toast.makeText(getApplicationContext(), "Enrollment Successful!",
                            Toast.LENGTH_LONG).show();
            });*/
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }
}

    class MyHolder extends RecyclerView.ViewHolder{
        TextView vCorseCode , vInstructor,vSection;
        //View mView;

        public MyHolder(View itemView) {
            super(itemView);
            vCorseCode = (TextView) itemView.findViewById(R.id.cc);
            vInstructor = (TextView) itemView.findViewById(R.id.ins);
            vSection = (TextView) itemView.findViewById(R.id.sec);

        }
    }

        /*private void createStBasicInfo(String stid, String fullname, String dept, String fathersname, String mothersname, String guardcont, String studcont) {
            //String key =mFirebaseDatabase.push().getKey();
            Table newStudent = new Table(data.getStid().toString(), data.getFullname().toString(), data.getDept().toString(),
                    data.getFathersname().toString(), data.getMothersname().toString(),
                    data.getGuardcont().toString(), data.getStudcont().toString());
            mFirebaseDatabase.child(stid).setValue(newStudent);
            finish();
        }*/