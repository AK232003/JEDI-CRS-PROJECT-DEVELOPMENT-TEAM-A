package com.flipkart.buisness;

public interface AdminInterface {
    public void addCourse(int adminId);
    public void deleteCourse(int adminId);
    public void closeRegistration();
    public void showCourses(int adminId);
    public void assignCourse();
}
