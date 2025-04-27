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
 * @author GRamamoorthy
 *
 */
public class TaskApplicablityRequest  implements Serializable {

	/**
	 * Stores the servlet request
	 */
	private HttpServletRequest request = null;
	
	/**
	 * stores the session
	 */
	private HttpSession session = null;
	
	/**
	 * 
	 */
	private String menu = null;
	
	private String responsibilityId = null;
	
	private String pract_relationId = null;
	
	
	/**
	 * Default constructor of the class
	 */
	public TaskApplicablityRequest() {
	}


	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}


	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}


	/**
	 * @return the responsibilityId
	 */
	public String getResponsibilityId() {
		return responsibilityId;
	}


	/**
	 * @param responsibilityId the responsibilityId to set
	 */
	public void setResponsibilityId(String responsibilityId) {
		this.responsibilityId = responsibilityId;
	}


	/**
	 * @return the pract_relationId
	 */
	public String getPract_relationId() {
		return pract_relationId;
	}


	/**
	 * @param pract_relationId the pract_relationId to set
	 */
	public void setPract_relationId(String pract_relationId) {
		this.pract_relationId = pract_relationId;
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

}
