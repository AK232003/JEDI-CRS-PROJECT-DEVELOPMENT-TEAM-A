package com.flipkart.beans;

public class GradeCard {
    private int studentId;
    private int semester;
    private double cpi;

    GradeCard(int studentId, int semester, double cpi) {
        this.studentId = studentId;
        this.semester = semester;
        this.cpi = cpi;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }s

    public double getCpi() {
        return cpi;
    }

    public void setCpi(double cpi) {
        this.cpi = cpi;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
