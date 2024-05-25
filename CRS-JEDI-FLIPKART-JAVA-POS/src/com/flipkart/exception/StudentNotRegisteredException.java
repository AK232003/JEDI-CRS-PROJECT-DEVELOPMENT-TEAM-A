package com.flipkart.exception;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Exception to check if student is not registered
 *
 */
public class StudentNotRegisteredException extends Exception{
	 private String studentName;

	/**
	 * Constructor to set studentName
	 * @param studentName
	 */
	 public StudentNotRegisteredException(String studentName)
	 {
		 this.studentName=studentName;
	 }
	 
	 /**
	  * getter function for student Name
	  * @return student name
	  */
	 public String getStudentName()
	 {
		 return studentName;
	 }
	 
}
