/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH.util;

//import org.apache.log4j.Logger;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Verification mechanism for the ServlceLocator Class
 * Implemented as a thread
 */
public class ServiceLocatorVerifier extends Thread {
    
    private static boolean debug = false;
    /**
     * Frequency in milliseconds for the invocation of this thread
     */
    private long serverVerifierPeriod;
    /**
     * Application Specific verification logic, points to ServiceLocator object
     */
    private ServiceVerifiable appSpecificServiceVerifiable;
   
   
    /**
     * Public constructor for this class
     * @param _serverVerifierPeriod_Minutes Frequency for the continuous invocation of this thread
     * To be specified in minutes
     * @param _appSpecificServiceVerifiable Application Specific verification logic holder
     */
    public ServiceLocatorVerifier(int _serverVerifierPeriod_Minutes, ServiceVerifiable _appSpecificServiceVerifiable) {
        // convert minutes to miliseconds
        serverVerifierPeriod = _serverVerifierPeriod_Minutes * 60 * 1000;
        appSpecificServiceVerifiable = _appSpecificServiceVerifiable;
        this.debug = ((ServiceLocator)appSpecificServiceVerifiable).getDebug();
        this.setDaemon(true);
        this.start();
        
    }
    
    /**
     * Overriding the run method of the Thread
     */
    public void run() {
        // execute until is interrupted
        while (true) {
            // Notify the Waiting object
            this.alarmRinging();
            try {
                // sleep for milisecondsPeriod
                sleep(serverVerifierPeriod);
            } catch (InterruptedException e) {
                // executiong interrupted
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Method which gets invoked when this thread runs
     * In turn this method calls the Application Specific verification logic from the ServiceLocator
     */
    public void alarmRinging() {
        try {
            appSpecificServiceVerifiable.checkServices();
        }
        catch( Exception exc) {
            appSpecificServiceVerifiable.followError(exc);
        }
    }

	/**
     * Method to set the verification frequency
     * @param freq Frequency for the continuous invocation of this thread
     * To be specified in minutes
     */
	void setVerificationFrequency(int freq){
		serverVerifierPeriod = freq * 60 * 1000;
	}
    
    /**
     * Finalizer method fr cleanup
     * @throws Throwable Exception occurring while cleanup
     */
    protected void finalize() throws Throwable {
        this.stop();
    }
}
