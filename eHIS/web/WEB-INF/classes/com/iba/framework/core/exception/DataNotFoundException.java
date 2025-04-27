/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 21, 2006
 */
package com.iba.framework.core.exception;

/**
 * @author Sabarinathan S
 * @version
 */
public class DataNotFoundException extends ApplicationException {
	public DataNotFoundException(String code) {
		super(code);
	}

	public DataNotFoundException(String code, Throwable cause) {
		super(code, cause);
	}

	public DataNotFoundException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	public DataNotFoundException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
