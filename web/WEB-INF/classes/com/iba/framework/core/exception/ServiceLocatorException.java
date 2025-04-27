/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on May 25, 2006
 */
package com.iba.framework.core.exception;

/**
 * This class implements an exception which can wrapped a lower-level exception.
 * 
 */
public class ServiceLocatorException extends SystemException {
	/**
	 * Creates a ServiceLocatorException with the specified error code.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ServiceLocatorException(String code) {
		super(code);
	}

	/**
	 * Creates a new ServiceLocatorException wrapping another exception, and
	 * with a error code.
	 * 
	 * @param message
	 *            the detail message.
	 * @param exception
	 *            the wrapped exception.
	 */
	public ServiceLocatorException(String code, Throwable cause) {
		super(code, cause);
	}

	public ServiceLocatorException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	public ServiceLocatorException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
