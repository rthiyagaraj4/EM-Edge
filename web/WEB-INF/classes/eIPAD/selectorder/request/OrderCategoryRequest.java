/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.request;

import javax.servlet.http.HttpServletRequest;

public class OrderCategoryRequest implements java.io.Serializable {
	 private String languageID;
	 private String calledFrom;
	 private HttpServletRequest request;
	/**
	 * @return the languageID
	 */
	public String getLanguageID() {
		return languageID;
	}
	/**
	 * @param languageID the languageID to set
	 */
	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}
	/**
	 * @return the calledFrom
	 */
	public String getCalledFrom() {
		return calledFrom;
	}
	/**
	 * @param calledFrom the calledFrom to set
	 */
	public void setCalledFrom(String calledFrom) {
		this.calledFrom = calledFrom;
	}
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


}
