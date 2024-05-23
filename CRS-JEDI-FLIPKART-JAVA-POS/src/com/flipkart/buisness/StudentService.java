package com.flipkart.buisness;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 *
 * Interface for Admin Dao Operations
 *
 */

public interface StudentService {
    /**
     * Method for student registration
     * @param name
     * @param userId
     * @param password
     * @param gender
     * @param batch
     * @param branch
     * @param address
     * @throws StudentNotRegisteredException
     */
    public void register(String name, String userId, String password, String gender, int batch, String branch, String address) throws StudentNotRegisteredException;

    /**
     * Method to get studentId
     * @param userId
     * @return studentId
     */
    public int getStudentId(String userId);

    /**
     * Method to set approval
     * @param studentId
     * @return boolean
     */
    public boolean isApproved(int studentId);
}
