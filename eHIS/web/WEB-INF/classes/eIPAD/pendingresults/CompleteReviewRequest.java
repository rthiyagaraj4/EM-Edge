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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author GRamamoorthy
 *
 */
public class CompleteReviewRequest implements Serializable {

	/**
	 * Stores the servlet request
	 */
	private HttpServletRequest request = null;
	
	/**
	 * stores the session
	 */
	private HttpSession session = null;
	
	private Map<String, Object> dataMap = null;
	
	private Map<String, String> sqlMap = null;
	
	/**
	 * Default constructor of the class
	 */
	public CompleteReviewRequest() {
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
	 * @return the dataMap
	 */
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * @return the sqlMap
	 */
	public Map<String, String> getSqlMap() {
		return sqlMap;
	}

	/**
	 * @param sqlMap the sqlMap to set
	 */
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

}
