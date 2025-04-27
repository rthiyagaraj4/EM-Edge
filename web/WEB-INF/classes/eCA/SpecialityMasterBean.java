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

public class SpecialityMasterBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sSpecialtyCode; 
	private String sSpecialtyLongDesc;
	private String sSpecialtyShortDesc;
	private String sStatus; 
	
	private String sLocale; 
	private String sFacilityId;
	private String sLoginId;
	private String sOperStnId; 

	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Specialty Code
	 */
	public String getsSpecialtyCode() {
		return sSpecialtyCode;
	}
	/**
	 * @param sSpecialtyCode the sSpecialtyCode to set
	 */
	public void setsSpecialtyCode(String sSpecialtyCode) {
		this.sSpecialtyCode = sSpecialtyCode;
	}

	/**
	 * @return the Specialty Long Description
	 */
	public String getsSpecialtyLongDesc() {
		return sSpecialtyLongDesc;
	}
	/**
	 * @param sSpecialtyLongDesc the sSpecialtyLongDesc to set
	 */
	public void setsSpecialtyLongDesc(String sSpecialtyLongDesc) {
		this.sSpecialtyLongDesc = sSpecialtyLongDesc;
	}

	/**
	 * @return the Specialty SHort Description
	 */
	public String getsSpecialtyShortDesc() {
		return sSpecialtyShortDesc;
	}
	/**
	 * @param sSpecialtyShortDesc the sSpecialtyShortDesc to set
	 */
	public void setsSpecialtyShortDesc(String sSpecialtyShortDesc) {
		this.sSpecialtyShortDesc = sSpecialtyShortDesc;
	}

	/**
	 * @return the Status
	 */
	public String getsStatus() {
		return sStatus;
	}
	/**
	 * @param sStatus the sStatus to set
	 */
	public void setsStatus(String sStatus) {
		this.sStatus = sStatus;
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
	 * @return the Facility ID Code
	 */
	public String getsOperStnId() {
		return sOperStnId;
	}
	/**
	 * @param sOperStnId the sOperStnId to set
	 */
	public void setsOperStnId(String sOperStnId) {
		this.sOperStnId = sOperStnId;
	}
	
	/**
	 * @return the Login ID
	 */
	public String getsLoginId() {
		return sLoginId;
	}
	/**
	 * @param sLoginId the sLoginId to set
	 */
	public void setsLoginId(String sLoginId) {
		this.sLoginId = sLoginId;
	}
	
	/**
	 * @return the Facility ID Code
	 */
	public String getsFacilityId() {
		return sFacilityId;
	}
	/**
	 * @param sFacilityId the sFacilityId to set
	 */
	public void setsFacilityId(String sFacilityId) {
		this.sFacilityId = sFacilityId;
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
