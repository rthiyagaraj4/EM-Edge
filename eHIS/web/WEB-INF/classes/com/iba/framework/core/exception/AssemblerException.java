/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.framework.core.exception;

/**
 * @author sabarinathans
 * 
 */
public class AssemblerException extends ApplicationException {
	public AssemblerException() {
		// TODO Auto-generated constructor stub
	}

	public AssemblerException(String code, Throwable cause) {
		super(code, cause);
	}

	public AssemblerException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	public AssemblerException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
