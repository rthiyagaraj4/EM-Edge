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

import com.iba.framework.core.exception.SystemException;

/**
 * Indicates that the caching object is not supported by the system.  
 * @author Sabarinathan S
 */
public class UnsupportedCacheObjectException extends SystemException {
	/**
	 * Constructor for the UnsupportedCacheObjectException object.
	 *
	 */public UnsupportedCacheObjectException() {
		super();
	}

	/**
	 * Constructs a new UnsupportedCacheObjectException with a message string.
	 * @param code
	 */public UnsupportedCacheObjectException(String code) {
		super(code);
	}

	/**
	 * Constructs a UnsupportedCacheObjectException with a message string, and a base exception.
	 * @param code
	 * @param cause
	 */public UnsupportedCacheObjectException(String code, Throwable cause) {
		super(code, cause);
	}

	/**
	 * Constructs a new UnsupportedCacheObjectException message string and with detail message of cause.
	 * @param code
	 * @param exceptionMessage
	 */public UnsupportedCacheObjectException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	/**
	 * Constructs a new UnsupportedCacheObjectException with the message string,detail message of cause and a base exception.
	 * @param code
	 * @param exceptionMessage
	 * @param cause
	 */public UnsupportedCacheObjectException(String code,
			String exceptionMessage, Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
