package com.flipkart.buisness;

import com.flipkart.bean.Course;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.RegistrationDAO;
import com.flipkart.dao.RegistrationDAOImpl;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.validator.StudentValidator;

import java.sql.SQLException;
import java.util.List;
public class RegistrationServiceOperation implements RegistrationService{
    private static volatile RegistrationServiceOperation instance = null;

    private RegistrationServiceOperation() {

    }
    public static RegistrationServiceOperation getInstance() {
        if (instance == null) {
            synchronized (RegistrationServiceOperation.class) {
                instance = new RegistrationServiceOperation();
            }
        }
        return instance;
    }

    RegistrationDAO registrationDaoInterface = RegistrationDAOImpl.getInstance();

    /**
     * @param courseCode
     * @param studentId
     * @param availableCourseList
     * @return
     * @throws CourseNotFoundException
     * @throws CourseLimitExceedException
     * @throws SeatNotAvailableException
     * @throws SQLException
     */
    @Override
    public boolean addCourse(String courseCode, String studentId,List<Course> availableCourseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException, SQLException
    {
        if (registrationDaoInterface.numOfRegisteredCourses(studentId) >= 6)
        {
            throw new CourseLimitExceedException(6);
        }
        else if (registrationDaoInterface.isRegistered(courseCode, studentId))
        {
            return false;
        }
        else if (!registrationDaoInterface.seatAvailable(courseCode))
        {
            throw new SeatNotAvailableException(courseCode);
        }
        else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
        {
            throw new CourseNotFoundException(courseCode);
        }



        return registrationDaoInterface.addCourse(courseCode, studentId);

    }

    /**
     * @param courseCode
     * @param studentId
     * @param registeredCourseList
     * @return
     * @throws CourseNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean dropCourse(String courseCode, String studentId,List<Course> registeredCourseList) throws CourseNotFoundException, SQLException {
        if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
        {
            throw new CourseNotFoundException(courseCode);
        }

        return registrationDaoInterface.dropCourse(courseCode, studentId);

    }

    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public List<StudentGrade> viewGradeCard(String studentId) throws SQLException {
        return registrationDaoInterface.viewGradeCard(studentId);
    }

    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    public List<Course> viewCourses(String studentId) throws SQLException {
        return registrationDaoInterface.viewCourses(studentId);
    }

    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public List<Course> viewRegisteredCourses(String studentId) throws SQLException {
        return registrationDaoInterface.viewRegisteredCourses(studentId);
    }


    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public double calculateFee(String studentId) throws SQLException {
        return registrationDaoInterface.calculateFee(studentId);
    }

    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getRegistrationStatus(String studentId) throws SQLException  {
        return registrationDaoInterface.getRegistrationStatus(studentId);
    }

    /**
     * @param studentId
     * @throws SQLException
     */
    @Override
    public void setRegistrationStatus(String studentId) throws SQLException {
        registrationDaoInterface.setRegistrationStatus(studentId);

    }

    /**
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getLoginStatus(String studentId) throws SQLException {

        return registrationDaoInterface.getLoginStatus(studentId);
    }
}