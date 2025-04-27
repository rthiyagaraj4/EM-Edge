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

public class EncSummTemplateTypeBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sTemplateType; 
	private String sTemplateDesc; 
		
	public HttpServletRequest request;
	public HttpSession session;

	
	/**
	 * @return the Template Type
	 */
	public String getsTemplateType() {
		return sTemplateType;
	}
	/**
	 * @param sTemplateType the sTemplateType to set
	 */
	public void setsTemplateType(String sTemplateType) {
		this.sTemplateType = sTemplateType;
	}

	/**
	 * @return the Template Description
	 */
	public String getsTemplateDesc() {
		return sTemplateDesc;
	}
	/**
	 * @param sTemplateDesc the sTemplateDesc to set
	 */
	public void setsTemplateDesc(String sTemplateDesc) {
		this.sTemplateDesc = sTemplateDesc;
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
