package com.flipkart.beans;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;
    private Catalog catalog;

    Admin(int id, String name, String password, ArrayList<Student> students,
          ArrayList<Professor> professors, ArrayList<Course> courses, Catalog catalog) {
        super(id, name, "Admin", password);
        this.students = students;
        this.professors = professors;
        this.courses = courses;
        this.catalog = catalog;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
