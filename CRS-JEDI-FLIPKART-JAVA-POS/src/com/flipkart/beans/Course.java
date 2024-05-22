package com.flipkart.beans;

public class Course {
    private int courseId;
    private String courseName;
    private String prerequisite;
    private int maxCapacity;
    private int minCapacity;
    private int currentEnrolled;

    Course(int courseId, String courseName, String prerequisite, int maxCapacity, int minCapacity, int currentEnrolled) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.prerequisite = prerequisite;
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.currentEnrolled = currentEnrolled;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public int getCurrentEnrolled() {
        return currentEnrolled;
    }

    public void setCurrentEnrolled(int currentEnrolled) {
        this.currentEnrolled = currentEnrolled;
    }
}
