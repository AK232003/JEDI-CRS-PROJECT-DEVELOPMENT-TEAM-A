package com.flipkart.beans;

public class User {
    private int userId;
    private String userName;
    private String role;
    private String password;

    User(int userId, String userName, String role, String password) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setName(String string) {
    }

    public void setGender(Object o) {
    }

    public void setAddress(String string) {
    }

    public void setCountry(String string) {
    }

    public String getName() {
    }

    public Object getGender() {
    }

    public String getAddress() {
    }

    public String getCountry() {
    }
}
