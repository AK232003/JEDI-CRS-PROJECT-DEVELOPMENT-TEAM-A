package com.flipkart.buisness;
import java.util.UUID;

/**
 * @author JEDI-A group Janhavi,Anurag,Priyansh,Arya,poojitha,yasavi
 * Interface for Admin Dao Operations
 *
 */
public interface NotificationService {
    /**
     * Method to send notification
     * @param refId
     * @param notifId
     */
    public void sendNotification( int refId,int notifId);

    /**
     * Method to get reference id
     * @param notificationID
     * @return
     */
    public UUID getReferenceID(int notificationID);
}
