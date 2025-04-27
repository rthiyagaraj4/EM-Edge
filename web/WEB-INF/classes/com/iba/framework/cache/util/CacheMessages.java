/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 29, 2006
 */
package com.iba.framework.cache.util;

/**
 * Contains error messages that might occur due to caching problems. 
 * @author Sabarinathan S
 * 
 */
public interface CacheMessages {
	public static String UNSERIALIZED_OBJECT = "Found unserialized object for key {0}";

	public static String CONFIG_ERROR = "Problem in starting the Cache service due to configuration error.";

	public static String STARTUP_PROBLEM = "Problem in starting the Cache service.";

	public static String WRITE_ERROR = "Problem in pushing an object into the cache.";

	public static String INVALID_REGION = "Trying to push data into an invalid region. Valid regions are Constants.USER_SESSION_CACHE or Constants.PATIENT_CACHE or Constants.GLOBAL_CACHE";

	public static String REMOVAL_ERROR = "Problem in removing the following object {0} from the cache. ";

	public static String US_WRITE_ERROR = "Pls provide session id to push data into Constants.USER_SESSION_CACHE";
}
