package com.flipkart.dao;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Net banking Dao Operations
 *
 */
public interface NetBankingDAO {
    /**
     * This method adds the net banking payment to database
     * @param refId
     * @param accountNo
     * @param ifsc
     */
    public void addTransaction(int refId,int accountNo,String ifsc);

}
