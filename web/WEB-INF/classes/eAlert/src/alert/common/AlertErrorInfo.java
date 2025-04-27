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
package eAlert.src.alert.common;

/**
 * @author prasannar
 *
 */
public class AlertErrorInfo {

	/* common success code */
	public static final int SUCCESS_CODE = 1; 
	
	public static final int CONNECTION_FAILURE_CODE = 2;
	
	public static final int SQLEXCEPTION_CODE = 3;
	
	
	private int errorCode = 0;
	
	private String errorMessage = null;
	
	/**
	 * 
	 */
	public AlertErrorInfo() {
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
