/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH.util;

/**
 * This class implements an exception which can wrapped a lower-level exception.
 *
 */
public class ServiceLocatorException extends Exception {
    /**
     * Root cause Exception
     */
    private Exception exception;
    
    /**
     * Creates a new ServiceLocatorException wrapping another exception, and with a detail message.
     * @param message the detail message.
     * @param exception the wrapped exception.
     */
    public ServiceLocatorException(String message, Exception exception) {
        super(message);
        this.exception = exception;
        return;
    }
    
    /**
     * Creates a ServiceLocatorException with the specified detail message.
     * @param message the detail message.
     */
    public ServiceLocatorException(String message) {
        this(message, null);
        return;
    }
    
    /**
     * Creates a new ServiceLocatorException wrapping another exception, and with no detail message.
     * @param exception the wrapped exception.
     */
    public ServiceLocatorException(Exception exception) {
        this(null, exception);
        return;
    }
    
    /**
     * Gets the wrapped exception.
     *
     * @return the wrapped exception.
     */
    public Exception getException() {
        return exception;
    }
    
    /**
     * Retrieves (recursively) the root cause exception.
     *
     * @return the root cause exception.
     */
    public Exception getRootCause() {
        if (exception instanceof ServiceLocatorException) {
            return ((ServiceLocatorException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }
    
    /**
     * Method to return the String representation of this exception
     * @return String representation of this exception
     */
    public String toString() {
        if (exception instanceof ServiceLocatorException) {
            return ((ServiceLocatorException) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
    }
}
