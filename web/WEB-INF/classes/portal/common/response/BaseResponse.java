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
package portal.common.response;

/**
 * This class defines basic information that is returned 
 * for all the responses. All Response classes will extend 
 * this class
 *  
 * @author GRamamoorthy
 *
 */
public class BaseResponse extends ValidationResponse{

	/**
	 * 
	 */
	protected ErrorInfo errorInfo = null;

	/**
	 * @return the errorInfo
	 */
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	/**
	 * @param errorInfo2 the errorInfo to set
	 */
	public void setErrorInfo(ErrorInfo errorInfo2) {
		this.errorInfo = errorInfo2;
	}
	
}
