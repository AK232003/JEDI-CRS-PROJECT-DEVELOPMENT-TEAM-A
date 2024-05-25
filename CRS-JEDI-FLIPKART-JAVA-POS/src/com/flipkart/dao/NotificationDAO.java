package com.flipkart.dao;

import java.sql.SQLException;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Notification Dao Operations
 *
 */
public interface NotificationDAO {
    /**
     * This method adds the notification during payment to database
     * @param refId
     * @param notifId
     * @throws SQLException
     */
    public void sendNotification(int refId,int notifId) throws SQLException;
}