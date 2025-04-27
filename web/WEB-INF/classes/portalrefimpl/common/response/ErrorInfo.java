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
package portalrefimpl.common.response;



/**
 * This class represents an error information which could be encountered
 * in the application
 * 
 * @author GRamamoorthy
 *
 */
public class ErrorInfo {

	public static final int SUCCESS_CODE = 1;
	
	public static final int CONNECTION_FAILURE_CODE = 2;
	
	public static final int SQLEXCEPTION_CODE = 3;
	
	public static final int WEBSVC_CONN_ERROR_CODE = 4;
	
	public static final int INVALID_REQUEST_ERROR_CODE = 5;
	
	public static final int NODATA_ERROR_CODE = 6;
	
	public static final int FAILURE_CODE = 7;
	
	public static final int WEBSVC_READ_ERROR_CODE = 8;
	
	public static final String CONNECTION_FAILURE_MESSAGE = "Could not get connection";
	
	public static final String EXCEPTION_MESSAGE = "Could not get data. Exception message={0}";
	
	public static final String WEBSVC_CONN_ERROR_MESSAGE = "Could not connect to web service. Exception message={0}";
	
	public static final String INVALID_REQUEST_ERROR_MESSAGE = "Invalid request";
	
	public static final String NODATA_ERROR_MESSAGE = "Could not get data";
	
	/**
	 * 
	 */
	public static final int NULL_REQUEST_ERRORCODE = 11;
	
	public static final int PORTALUSER_NOTPRESENT_ERRORCODE = 12;
	
	/**
	 * data members in the class
	 */
	private int errorCode = 0;
	
	private String errorMessage = null;
	
	/**
	 * default constructor of the class
	 */
	public ErrorInfo() {
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
