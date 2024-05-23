package com.flipkart.beans;
import com.flipkart.beans.User;

import java.util.ArrayList;

public class Student extends User {
    private String emailAddress;
    private ArrayList<Course> enrolledCourses;
    private ArrayList<Course> alternativeCourses;

    public Student(int id, String firstName, String password, String emailAddress) {
        super(id, firstName, "Student", password);
        this.emailAddress = emailAddress;
        this.enrolledCourses = new ArrayList<>();
        this.alternativeCourses = new ArrayList<>();
    }

    public Student() {
        super();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public ArrayList<Course> getAlternativeCourses() {
        return alternativeCourses;
    }

    public void setAlternativeCourses(ArrayList<Course> alternativeCourses) {
        this.alternativeCourses = alternativeCourses;
    }

    public void setStudentId(int anInt) {
    }

    public String getBranchName() {
        return "null";
    }

    public int getBatch() {
        return 0;
    }

//    public ArrayList<Course> requestCatalog()
//    {
//        // here we need to send the whole catalog, presently putting the enrolled courses over here
//        return enrolledCourses;
//    }
//
//    public void enrollCourse(Course course) {
//        enrolledCourses.add(course);
//    }
//
//    public void dropCourse(Course course) {
//        // here we drop course.
//    }
}
