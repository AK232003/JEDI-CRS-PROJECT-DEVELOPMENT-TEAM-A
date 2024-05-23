package com.flipkart.buisness;

public interface StudentInterface {
    public int getStudentId(String userId);
    public boolean isApproved(int studentId);
//    public int register(String name, String userId, String password, String gender, int batch, String branchName, String address, String country);
    public void registercourse(int studentid);
    public void viewresult(int studentid);
    public void viewcatalogue(int studentid);
    public void payBills(int studentid);
}
