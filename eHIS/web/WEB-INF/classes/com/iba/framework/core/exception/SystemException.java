/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 7, 2006
 */
package com.iba.framework.core.exception;

import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * @author S Sabarinathan
 * 
 */
public class SystemException extends RuntimeException {
	protected String errorCode;

	protected String originalCause;

	static Logger logger = LogFactory.getApplicationLogger();

	public SystemException() {
		super();
	}

	public SystemException(String code) {
		this.errorCode = code;
	}

	public SystemException(String code, String exceptionMessage) {
		super(exceptionMessage);
		logger.error(this.getClass(), exceptionMessage, null);
		if (logger.isDebugEnabled())
			logger.debug(this.getClass(), exceptionMessage, this, null);
		this.originalCause = exceptionMessage;
		this.errorCode = code;
	}

	public SystemException(String code, Throwable cause) {
		super(cause);
		this.errorCode = code;
		if (cause != null && !(cause instanceof SystemException))
			this.originalCause = cause.getMessage();

	}

	public SystemException(String code, String exceptionMessage, Throwable cause) {
		super(exceptionMessage, cause);
		logger.error(this.getClass(), exceptionMessage, null);
		if (logger.isDebugEnabled())
			logger.debug(this.getClass(), exceptionMessage, cause, null);
		logger.error(SystemException.class, exceptionMessage, cause, null);
		if (cause != null && !(cause instanceof SystemException))
			this.originalCause = cause.getMessage();
		else
			this.originalCause = exceptionMessage;
		this.errorCode = code;
	}

	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return Returns the originalCause.
	 */
	public String getOriginalCause() {
		return originalCause;
	}

	/**
	 * @param message
	 *            The message to set.
	 */
	public void setOriginalCause(String message) {
		this.originalCause = message;
	}
}
