/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.eslp;

/**
 * Interface to verify the cached services
 */
public interface ServiceVerifiable {
    /**
     * Method to be implemented for checking the cached services
     * @throws Exception Exception occurring while executing this method
     */
    public void checkServices() throws Exception;
    /**
     * Method to be invoked
     * when a cached service expires
     * execption occurrs in the process of caching
     * @param e Exception occurring during the process of the error callback
     */
    public void followError(Exception e);
}
