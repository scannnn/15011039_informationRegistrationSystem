package com.example.asus.mobilodev1;

import java.util.ArrayList;

public class course{
    private String name;
    private float grade;
    private int number_of_student;

    public course(String name, float grade,int number_of_student){
        this.name = name;
        this.grade = grade;
        this.number_of_student = number_of_student;
    }

    public int getNumber_of_student() {
        return number_of_student;
    }

    public float getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
    public static int lastCourseID = 0;
    public static ArrayList<course> createCoursesList(int numCourses){
        ArrayList<course> courses = new ArrayList<course>();
        for(int i=1; i<= numCourses; i++){
            courses.add(new course("course"+ ++lastCourseID,75,100));
        }
        return courses;
    }
}
