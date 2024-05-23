/**
 *
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.beans.Course;
import com.flipkart.beans.Professor;
import com.flipkart.beans.Student;
import com.flipkart.beans.User;



/**
 * @author JEDI-03
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDaoInterface {

    public void deleteCourse(String courseCode) ;


    public void addCourse(Course course) ;
    /**
     * Fetch Students yet to approved using SQL commands
     * @return List of Students yet to approved
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Approve Student using SQL commands
     * @param studentId
     */
    public void approveStudent(int studentId) ;

    /**
     * Add professor using SQL commands
     * @param professor

     */
    public void addProfessor(Professor professor) ;

    /**
     * Method to add user using SQL commands
     * @param user

     */
    public void addUser(User user) ;

    /**
     * Assign courses to Professor using SQL commands
     * @param courseCode
     * @param professorId

     */
    public void assignCourse(String courseCode, String professorId) ;

    /**
     * View courses in the catalog
     * @return List of courses in the catalog
     */
    public List<Course> viewCourses(int catalogId);

    /**
     * View professor in the institute
     * @return List of the professors in the institute
     */
    public List<Professor> viewProfessors();
}