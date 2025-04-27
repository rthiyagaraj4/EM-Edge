/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultdetails.response;

/**
 * This ENUM is used to denote the set of Status
 * @author vkodancha
 *
 */
public enum TestResultStatus {
	Y("Y"), N("N");
	private String statusCode;
	 
	private TestResultStatus(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}

}
