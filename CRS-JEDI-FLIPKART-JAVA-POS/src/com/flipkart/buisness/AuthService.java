package com.flipkart.buisness;

public class AuthService implements AuthInterface {

    public void register(
        String name,
        String email,
        String password,
        String role,
        String Gender,
        String Branch,
        Integer Batch
    ) {

    }

    public void login(String email, String password) {
        // Login user

    }

    public String getRole(String userId) {
        // Get role of user
        return "STUDENT";
    }

    public boolean verifyCredentials(String userId, String password) {
        // Verify user
        return true;
    }

}
