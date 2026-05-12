package Packages.interface;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface PaymentGateway {


    /**
     * 
     */
    public void processPayment(paymentDetails: String): boolean();

}