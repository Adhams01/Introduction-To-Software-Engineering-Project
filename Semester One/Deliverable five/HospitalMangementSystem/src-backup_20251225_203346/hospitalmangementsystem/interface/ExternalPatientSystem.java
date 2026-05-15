package Packages.interface;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface ExternalPatientSystem {



    /**
     * 
     */
    public void sendDataToExternalSystem(data: String): boolean();

    /**
     * 
     */
    public void getExternalSystemStatus(): String();

}