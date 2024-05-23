package com.flipkart.buisness;

public interface AuthInterface {
    public void register(
            String name,
            String email,
            String password,
            String role,
            String Gender,
            String Branch,
            Integer Batch
    );
    public void login(String email, String password);
    public String getRole(String userId);
    public boolean verifyCredentials(String userId, String password);
}
