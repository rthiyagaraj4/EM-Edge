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
03/10/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EncSummApplicabilityBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sSummCode; 
	private String sSummDesc;
	
	private String sPatientClassCode; 
	private String sPatientClassDesc;
	
	private String sSpecialtyCode; 
	private String sSpecialtyDesc;
	
	private String sAgeGroupCode; 
	private String sAgeGroupDesc;		
	
	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the Summary Code
	 */
	public String getsSummCode() {
		return sSummCode;
	}
	/**
	 * @param sSummCode the sSummCode to set
	 */
	public void setsSummCode(String sSummCode) {
		this.sSummCode = sSummCode;
	}

	/**
	 * @return the Summary Description 
	 */
	public String getsSummDesc() {
		return sSummDesc;
	}
	/**
	 * @param sSummDesc the sSummDesc to set
	 */
	public void setsSummDesc(String sSummDesc) {
		this.sSummDesc = sSummDesc;
	}

	/**
	 * @return the Patient Class Code 
	 */
	public String getsPatientClassCode() {
		return sPatientClassCode;
	}
	/**
	 * @param sPatientClassCode the sPatientClassCode to set
	 */
	public void setsPatientClassCode(String sPatientClassCode) {
		this.sPatientClassCode = sPatientClassCode;
	}

	/**
	 * @return the Patient Class Description
	 */
	public String getsPatientClassDesc() {
		return sPatientClassDesc;
	}
	/**
	 * @param sPatientClassDesc the sPatientClassDesc to set
	 */
	public void setsPatientClassDesc(String sPatientClassDesc) {
		this.sPatientClassDesc = sPatientClassDesc;
	}
	
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
	 * @return the Specialty Description
	 */
	public String getsSpecialtyDesc() {
		return sSpecialtyDesc;
	}
	/**
	 * @param sSpecialtyDesc the sSpecialtyDesc to set
	 */
	public void setsSpecialtyDesc(String sSpecialtyDesc) {
		this.sSpecialtyDesc = sSpecialtyDesc;
	}

	/**
	 * @return the Age Group Code 
	 */
	public String getsAgeGroupCode() {
		return sAgeGroupCode;
	}
	/**
	 * @param sAgeGroupCode the sAgeGroupCode to set
	 */
	public void setsAgeGroupCode(String sAgeGroupCode) {
		this.sAgeGroupCode = sAgeGroupCode;
	}
	
	/**
	 * @return the Age Group Description
	 */
	public String getsAgeGroupDesc() {
		return sAgeGroupDesc;
	}
	/**
	 * @param sAgeGroupDesc the sAgeGroupDesc to set
	 */
	public void setsAgeGroupDesc(String sAgeGroupDesc) {
		this.sAgeGroupDesc = sAgeGroupDesc;
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
