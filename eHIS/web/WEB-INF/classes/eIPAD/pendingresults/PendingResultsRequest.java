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
package eIPAD.pendingresults;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This model class represents the request class
 * for retrieving pending results for review
 * @author GRamamoorthy
 *
 */
public class PendingResultsRequest implements Serializable {

	/**
	 * Stores the servlet request
	 */
	private HttpServletRequest request = null;
	
	/**
	 * stores the session
	 */
	private HttpSession session = null;
	
	/**
	 * Stores the normalcy indicator
	 * which is calculated at run time
	 * 
	 */
	private String normalcyIndicator = null;
	
	/**
	 * Stores the locale
	 */
	private String locale = null;
	
	/**
	 * Default constructor of the class
	 */
	public PendingResultsRequest() {
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

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the normalcyIndicator
	 */
	public String getNormalcyIndicator() {
		return normalcyIndicator;
	}

	/**
	 * @param normalcyIndicator the normalcyIndicator to set
	 */
	public void setNormalcyIndicator(String normalcyIndicator) {
		this.normalcyIndicator = normalcyIndicator;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

}
