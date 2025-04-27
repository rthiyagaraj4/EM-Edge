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

public class PatientClassBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sPatientClass; 
	private String sLongDesc; 
	private String sShortDesc;
	private int iPrefix;	
		
	public HttpServletRequest request;
	public HttpSession session;

	
	/**
	 * @return the Patient class
	 */
	public String getsPatientClass() {
		return sPatientClass;
	}
	/**
	 * @param sPatientClass the sPatientClass to set
	 */
	public void setsPatientClass(String sPatientClass) {
		this.sPatientClass = sPatientClass;
	}

	/**
	 * @return the sLongDesc
	 */
	public String getsLongDesc() {
		return sLongDesc;
	}
	/**
	 * @param sLongDesc the sLongDesc to set
	 */
	public void setsLongDesc(String sLongDesc) {
		this.sLongDesc = sLongDesc;
	}

	/**
	 * @return the sShortDesc
	 */
	public String getsShortDesc() {
		return sShortDesc;
	}
	/**
	 * @param sShortDesc the sShortDesc to set
	 */
	public void setsShortDesc(String sShortDesc) {
		this.sShortDesc = sShortDesc;
	}	
	
	/**
	 * @return the iPrefix
	 */
	public int getiPrefix() {
		return iPrefix;
	}
	/**
	 * @param iPrefix the iPrefix to set
	 */
	public void setiPrefix(int iPrefix) {
		this.iPrefix = iPrefix;
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
