package com.flipkart.dao;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for UPI Dao Operations
 *
 */
public interface UpiDAO {
    /**
     * This method adds the UPI payment to database
     * @param refId
     * @param upiId
     * @param serviceProvider
     */
    public void addUPI(int refId,String upiId,String serviceProvider);
}