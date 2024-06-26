package com.flipkart.buisness;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOImpl;
import com.flipkart.exception.*;
import com.flipkart.validator.AdminValidator;

import java.util.List;

public class AdminServiceOperation implements AdminService {

    private static volatile AdminServiceOperation instance = null;

    private AdminServiceOperation(){}

	public static AdminServiceOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminServiceOperation.class){
				instance = new AdminServiceOperation();
			}
		}
		return instance;
	}

    AdminDAO adminDaoImpl = AdminDAOImpl.getInstance();

    public void deleteCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException{

        if(!AdminValidator.isValidDropCourse(dropCourseCode, courseList)) {
            System.out.println("courseCode: " + dropCourseCode + " not present in catalog!");
            throw new CourseNotFoundException(dropCourseCode);
        }

        try {
            adminDaoImpl.deleteCourse(dropCourseCode);
        }
        catch(CourseNotFoundException | CourseNotDeletedException e) {
            throw e;
        }
    }
    public void addCourse(Course newCourse, List<Course> courseList) throws CourseFoundException {
        if(!AdminValidator.isValidNewCourse(newCourse, courseList)) {
            System.out.println("courseCode: " + newCourse.getCourseCode() + " already present in catalog!");
            throw new CourseFoundException(newCourse.getCourseCode());
        }

        try {
            adminDaoImpl.addCourse(newCourse);
        }
        catch(CourseFoundException e) {
            throw e;
        }
    }

    public void approveStudent(String studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
        if(!AdminValidator.isValidUnapprovedStudent(studentId, studentList)) {
            //logger.error("studentId: " + studentId + " is already approvet/not-present!");
            throw new StudentNotFoundForApprovalException(studentId);
        }

        try {
            adminDaoImpl.approveStudent(studentId);
        }
        catch(StudentNotFoundForApprovalException e) {
            throw e;
        }
    }

    public void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        try {
            adminDaoImpl.addProfessor(professor);
        }
        catch(ProfessorNotAddedException | UserIdAlreadyInUseException e) {
            throw e;
        }

    }

    public List<Course> viewCourses() {
        return adminDaoImpl.viewCourses();
    }

    public List<Professor> viewProfessors() {
        return adminDaoImpl.viewProfessors();
    }

    @Override
    public List<Student> viewPendingGradeCard() {
        return adminDaoImpl.viewPendingGradeCard();
    }

    @Override
    public void approveGradeCard(String studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
        try {
            adminDaoImpl.approveGradeCard(studentId);
        }
        catch(StudentNotFoundForApprovalException e) {
            throw e;
        }
    }

    public List<Student> viewPendingAdmission() {
        return adminDaoImpl.viewPendingAdmission();
    }

    public List<Student> viewCompletedAdmission(){
        return adminDaoImpl.viewCompletedAdmission();
    }

    public List<Student> viewPendingRegistration(){
        return adminDaoImpl.viewPendingRegistration();
    }


    public void approveRegistration(String studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
        try {
            adminDaoImpl.approveRegistration(studentId);
        }
        catch(StudentNotFoundForApprovalException e) {
            throw e;
        }
    }


}
