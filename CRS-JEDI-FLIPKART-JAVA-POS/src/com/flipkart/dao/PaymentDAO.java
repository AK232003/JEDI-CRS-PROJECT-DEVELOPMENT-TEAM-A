package com.flipkart.dao;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Payment Dao Operations
 *
 */
public interface PaymentDAO {
    /**
     * This method adds the payments to database
     * @param refId
     * @param studentId
     * @param amount
     * @param type
     * @param bank
     */
    public void addPayment(int refId,String studentId,double amount,String type,String bank);

    /**
     * This methods checks whether payment is already done by the student
     * @param studentId
     */
    public void isPaid(String studentId);
}
