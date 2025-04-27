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
package eIPAD.common;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author GRamamoorthy
 *
 */
public class SeverityIconsRequest implements Serializable {

	/**
	 * Stores the servlet request
	 */
	private HttpServletRequest request = null;
	
	/**
	 * stores the session
	 */
	private HttpSession session = null;
	
	/**
	 * Stores the patientId
	 */
	private String patientId = null;
	
	
	/**
	 * Default constructor of the class
	 */
	public SeverityIconsRequest() {
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
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}


	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

}
