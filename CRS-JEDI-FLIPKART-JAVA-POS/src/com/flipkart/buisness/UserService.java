package com.flipkart.buisness;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Admin Dao Operations
 *
 */

public interface UserService{

    /**
     * Method to get role of userId
     * @param userId
     * @return role
     */
    public String getRole(String userId);

    /**
     * Method to change password
     * @param userID
     * @param password
     * @return boolean
     */
    public boolean changePassword(String userID, String password);

    /**
     * Method to verify credentials
     * @param userID
     * @param password
     * @return
     */
    public boolean verifyCredentials(String userID, String password) throws UserNotFoundException;
}
