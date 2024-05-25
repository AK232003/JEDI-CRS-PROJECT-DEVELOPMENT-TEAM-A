package com.flipkart.exception;

import com.flipkart.constant.ColourConstant;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Exception if course is not assigned to any professor
 *
 */
public class NoAssignedCourseException extends Exception{
    /**
     * Constructor
     * @param profId
     */
    public NoAssignedCourseException(String profId) {
        this.profId = profId;
    }

    /**
     * getter method for profId
     * @return profId
     */
    public String getProfId() {
        return profId;
    }

    /**
     * setter method for profId
     * @param profId
     */
    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String profId;

    /**
     * getter method
     * @return exception message
     */
    @Override
    public String getMessage()
    {
        return ColourConstant.ANSI_YELLOW + "No assigned courses for professor Id: "+profId + ColourConstant.ANSI_RESET;
    }

}
