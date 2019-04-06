package com.example.asus.mobilodev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class intentActivity2 extends AppCompatActivity {
    List<course> courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
        this.getSupportActionBar().hide();
        RecyclerView rvCourses = findViewById(R.id.rvContacts);

    courses = course.createCoursesList(20);
    courseAdapter adapter = new courseAdapter(this, courses);
    rvCourses.setAdapter(adapter);
    rvCourses.setLayoutManager(new LinearLayoutManager(this));
    }
}
