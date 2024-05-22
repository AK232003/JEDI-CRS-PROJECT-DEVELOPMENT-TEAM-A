package com.flipkart.buisness;

import com.flipkart.beans.Student;

import java.util.UUID;

public class Auth {

    public void register(
        String name,
        String email,
        String password,
        String role,
        String Gender,
        String Branch,
        Integer Batch
    ) {

        // Generate userId
        String userId = UID.randomUUID().toString();
        // Register user
        Student newStudent=new Student(userId,name,Role.STUDENT,password,gender,address,country,branch,0,batch,false);
        studentId=studentDaoInterface.addStudent(newStudent);


    }

    public void login(String email, String password) {
        // Login user

    }

    public String getRole(String userId) {
        // Get role of user
        return "STUDENT";
    }

    public boolean verifyCredentials(String userId) {
        // Verify user
        return true;
    }

}
