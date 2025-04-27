/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sLoginUserId; 
	private String sFacilityID; 
	private String sOperStnID;
		
		
	public HttpServletRequest request;
	public HttpSession session;
	
	/**
	 * @return the Login User Id
	 */
	public String getsLoginUserId() {
		return sLoginUserId;
	}
	/**
	 * @param sLoginUserId the sLoginUserId to set
	 */
	public void setsLoginUserId(String sLoginUserId) {
		this.sLoginUserId = sLoginUserId;
	}

	/**
	 * @return the facility Id
	 */
	public String getsFacilityID() {
		return sFacilityID;
	}
	/**
	 * @param sFacilityID the sFacilityID to set
	 */
	public void setsFacilityID(String sFacilityID) {
		this.sFacilityID = sFacilityID;
	}

	/**
	 * @return the Operator Station Id
	 */
	public String getsOperStnID() {
		return sOperStnID;
	}
	/**
	 * @param sOperStnID the sOperStnID to set
	 */
	public void setsOperStnID(String sOperStnID) {
		this.sOperStnID = sOperStnID;
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
