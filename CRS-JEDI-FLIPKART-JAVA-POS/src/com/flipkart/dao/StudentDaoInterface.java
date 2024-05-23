/**
 *
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.beans.Student;;

/**
 * @author Dilpreet Kaur
 *
 */
public interface StudentDaoInterface {
    /**
     *
     * @param student: student object containing all the fields
     * @return true if student is added, else false
     */
    public boolean addStudent(Student student);


    /**
     * Get studentId of user
     * @param userId
     * @return studentId
     */
    public int getStudentId(String userId);

    /**
     * Check if student is approved
     * @param studentId
     * @return
     */
    public boolean isApproved(int studentId);
}