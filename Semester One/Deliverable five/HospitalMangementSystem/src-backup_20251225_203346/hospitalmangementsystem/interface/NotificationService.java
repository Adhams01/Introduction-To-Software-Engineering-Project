package Packages.interface;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface NotificationService {



    /**
     * 
     */
    public void sendNotification(notificationDetails: String): boolean();

    /**
     * 
     */
    public void getNotificationStatus(notificationId: String): String();

}