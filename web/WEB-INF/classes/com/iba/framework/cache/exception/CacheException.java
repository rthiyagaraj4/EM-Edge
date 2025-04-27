/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 19, 2006
 */
package com.iba.framework.cache.exception;

import com.iba.framework.core.exception.SystemException;

/**
 * CacheException is a generic exception, which indicates a cache error has occurred.
 * @author S Sabarinathan
 * 
 */
public class CacheException extends SystemException {
	
	/**
	 * Constructs a new CacheException.
	 */
	 public CacheException() {
		super();
	 }

	/**
	 * Constructs a new CacheException with a message string.
	 * @param code
	 */
	 public CacheException(String code) {
		super(code);
	 }

	/**
	 * Constructs a CacheException with a message string, and a base exception.
	 * @param code
	 * @param cause
	 */
	  public CacheException(String code, Throwable cause) {
			super(code, cause);
	  }

	/**
	 * Constructs a new CacheException with message string and detail message of cause.
	 * @param code
	 * @param exceptionMessage
	 */
	 public CacheException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	
	 /**
	  * Constructs a new CacheException with the message string,detail message of cause and a base exception.
	  * @param code
	  * @param exceptionMessage
	  * @param cause
	  */
	   public CacheException(String code, String exceptionMessage, Throwable cause) {
		super(code, exceptionMessage, cause);
	   }
}
