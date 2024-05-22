package com.flipkart.beans;

import java.util.ArrayList;

public class Professor extends User {
    private String emailAddress;
    private String department;
    ArrayList<Course> courses;

    Professor(int id, String name, String password, String emailAddress, ArrayList<Course> courses, String department) {
        super(id, name, "Professor", password);
        this.emailAddress = emailAddress;
        this.courses = courses;
        this.department = department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
