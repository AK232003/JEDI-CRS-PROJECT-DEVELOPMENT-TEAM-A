package com.flipkart.exception;

/**
 *
 * Exception to check if user is approved by administration
 *
 */
public class UserNotApprovedException extends Exception{
	private String userId;
	
	/**
	 * Constructor to set userId
	 * @param userId
	 */
	public UserNotApprovedException(String userId) {
		this.userId = userId;
	}

	/**
	 * Getter for userId
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

}
