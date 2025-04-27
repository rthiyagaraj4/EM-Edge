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
package com.iba.framework.cache.exception;

/**
 * Indicates that the Cache region is not valid.
 * @author Sabarinathan S
 */
public class InvalidCacheRegionException extends CacheException {
	
	/**
	 * Constructor for the InvalidCacheRegionException object.
	 *
	 */
	 public InvalidCacheRegionException() {
		super();
	}

	/**
	 * Constructs a new InvalidCacheRegionException with a message string.
	 * @param code
	 */
	 public InvalidCacheRegionException(String code) {
		super(code);
	}

	/**
	 * Constructs a CacheException with a message string, and a base exception.
	 * @param code
	 * @param cause
	 */public InvalidCacheRegionException(String code, Throwable cause) {
		super(code, cause);
	}

	/**
	 * Constructs a new InvalidCacheRegionException with message string and detail message of cause.
	 * @param code
	 * @param exceptionMessage
	 */
	 public InvalidCacheRegionException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	/**
	 * Constructs a new InvalidCacheRegionException with the message string,detail message of cause and a base exception.
	 * @param code
	 * @param exceptionMessage
	 * @param cause
	 */public InvalidCacheRegionException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
