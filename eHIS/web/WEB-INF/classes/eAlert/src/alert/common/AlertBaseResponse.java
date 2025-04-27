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
public class AlertBaseResponse {

	private AlertErrorInfo errorInfo = null; 

	/**
	 * @return the errorInfo
	 */
	public AlertErrorInfo getErrorInfo() {
		return errorInfo;
	}

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(AlertErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
}
