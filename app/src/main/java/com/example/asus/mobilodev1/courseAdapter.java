package com.example.asus.mobilodev1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder> {
    private List<course> mCourses;
    Context con;

    public courseAdapter(Context context,List<course> contacts) {
        mCourses = contacts;
        this.con = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.course, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final course course = mCourses.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.courseName;
        textView.setText(course.getName()+"   "+course.getGrade());

        viewHolder.courseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con,intentActivity3.class);
                intent.putExtra("course_name",course.getName());
                intent.putExtra("grade",""+course.getGrade());
                intent.putExtra("number_of_student",""+course.getNumber_of_student());
                con.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            courseName = itemView.findViewById(R.id.course_name);
        }
    }
}
