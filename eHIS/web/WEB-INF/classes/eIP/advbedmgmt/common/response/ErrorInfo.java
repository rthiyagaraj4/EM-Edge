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
package eIP.advbedmgmt.common.response;

import java.io.Serializable;

/**
 * This class represents an error information which could be encountered
 * in the application
 * @author gramamoorthy
 *
 */
public class ErrorInfo implements Serializable {

	/**
	 * constant to denote success state
	 */
	public static int SUCCESS_CODE = 1;
	
	/**
	 * constant to denote the database connection failure code
	 */
	public static int DATABASE_CONNECTION_FAILURE_CODE = 11;
	
	
	/**
	 * data members in the class
	 */
	private int errorCode = 0;
	
	private String errorMessage = null;
	
	
	/**
	 * default empty constructor
	 */
	public ErrorInfo(){
		// does nothing
	}
	
	/**
	 * Constructor taking error code and error message as input
	 * @param errorCode
	 * @param errorMessage
	 */
	public ErrorInfo(int errorCode,String errorMessage){
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
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
