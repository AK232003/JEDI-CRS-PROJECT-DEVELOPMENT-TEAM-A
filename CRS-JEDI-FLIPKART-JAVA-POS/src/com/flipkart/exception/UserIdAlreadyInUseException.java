/**
 * 
 */
package com.flipkart.exception;
import com.flipkart.constant.ColourConstant;



/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Exception if userID is already in use
 *
 */
public class UserIdAlreadyInUseException extends Exception{
	private String userId;


	/**
	 * Constructor to set user id
	 * @param userId
	 */
	public UserIdAlreadyInUseException(String userId) {
		this.userId = userId;
	}

	/**
	 * Method to get user id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Method to set professor id
	 * @param userId
	 */
	public void setProfessorId(String userId) {
		this.userId = userId;
	}

	/**
	 * Method to get error message
	 * @return string
	 */
	@Override
	public String getMessage() {
		return ColourConstant.ANSI_YELLOW + "userId: " + userId + " is already in use." + ColourConstant.ANSI_RESET;
	}

}
