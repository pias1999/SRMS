package com.example.srms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }
}

    class MyHolder extends RecyclerView.ViewHolder{
        TextView vCorseCode , vInstructor,vSection;

        public MyHolder(View itemView) {
            super(itemView);
            vCorseCode = (TextView) itemView.findViewById(R.id.cc);
            vInstructor = (TextView) itemView.findViewById(R.id.ins);
            vSection = (TextView) itemView.findViewById(R.id.sec);

        }
    }