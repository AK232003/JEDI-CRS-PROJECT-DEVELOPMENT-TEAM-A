package com.flipkart.dao;
import java.util.Date;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Card Dao Operations
 *
 */
public interface CardDAO {
    /**
     * This method adds the card payment to database
     * @param refId
     * @param cardNo
     * @param type
     * @param cvv
     */
    public void addCard(int refId, String cardNo, String type, int cvv, Date date);

}
