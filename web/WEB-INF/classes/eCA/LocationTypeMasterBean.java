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
11/10/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationTypeMasterBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sLocationType; 
	private String sLocationLongDesc;
	private String sLocationShortDesc;
	private String sCareLocnTypeInd; 
	private String sSysUserDefInd;
	
	private String sLocale; 

	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Location Type
	 */
	public String getsLocationType() {
		return sLocationType;
	}
	/**
	 * @param sLocationType the sLocationType to set
	 */
	public void setsLocationType(String sLocationType) {
		this.sLocationType = sLocationType;
	}

	/**
	 * @return the Location Type Long Description
	 */
	public String getsLocationLongDesc() {
		return sLocationLongDesc;
	}
	/**
	 * @param sLocationLongDesc the sLocationLongDesc to set
	 */
	public void setsLocationLongDesc(String sLocationLongDesc) {
		this.sLocationLongDesc = sLocationLongDesc;
	}

	/**
	 * @return the Location Type Short Description
	 */
	public String getsLocationShortDesc() {
		return sLocationShortDesc;
	}
	/**
	 * @param sLocationShortDesc the sLocationShortDesc to set
	 */
	public void setsLocationShortDesc(String sLocationShortDesc) {
		this.sLocationShortDesc = sLocationShortDesc;
	}

	/**
	 * @return the Care Location Type Ind
	 */
	public String getsCareLocnTypeInd() {
		return sCareLocnTypeInd;
	}
	/**
	 * @param sCareLocnTypeInd the sCareLocnTypeInd to set
	 */
	public void setsCareLocnTypeInd(String sCareLocnTypeInd) {
		this.sCareLocnTypeInd = sCareLocnTypeInd;
	}
	
	/**
	 * @return the System User Defined Ind
	 */
	public String getsSysUserDefInd() {
		return sSysUserDefInd;
	}
	/**
	 * @param sSysUserDefInd the sSysUserDefInd to set
	 */
	public void setsSysUserDefInd(String sSysUserDefInd) {
		this.sSysUserDefInd = sSysUserDefInd;
	}


	/**
	 * @return the Locale Code
	 */
	public String getsLocale() {
		return sLocale;
	}
	/**
	 * @param sLocale the sLocale to set
	 */
	public void setsLocale(String sLocale) {
		this.sLocale = sLocale;
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
