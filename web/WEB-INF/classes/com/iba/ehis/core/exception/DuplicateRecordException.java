/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.exception;

import com.iba.framework.core.exception.ApplicationException;

/**
 * @author Sabarinathan S
 * @version
 */
public class DuplicateRecordException extends ApplicationException {
	public DuplicateRecordException(String code) {
		super(code);
	}

	public DuplicateRecordException(String code, Throwable cause) {
		super(code, cause);
	}

	public DuplicateRecordException(String code, String exceptionMessage) {
		super(code, exceptionMessage);
	}

	public DuplicateRecordException(String code, String exceptionMessage,
			Throwable cause) {
		super(code, exceptionMessage, cause);
	}
}
