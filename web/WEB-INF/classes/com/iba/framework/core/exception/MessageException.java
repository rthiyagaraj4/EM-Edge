/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 12, 2006
 */
package com.iba.framework.core.exception;

/**
 * @author S Sabarinathan
 * 
 */
public class MessageException extends ApplicationException {
	public MessageException(String code) {
		super(code);
	}

	public MessageException(String code, Throwable cause) {
		super(code, cause);
	}

	public MessageException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	public MessageException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
