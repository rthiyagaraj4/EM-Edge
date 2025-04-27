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

public class PatientContext {
	public String sFacilityId = "";
	public String sPatientId = "";
	public String sEncounterId = "";
	public String sTestCode = "";

	public HttpServletRequest request;
	public HttpSession session;

	/**
	 * @return the sFacilityId
	 */
	public String getFacilityId() {
		return sFacilityId;
	}
	/**
	 * @param sFacilityId the sFacilityId to set
	 */
	public void setFacilityId(String sFacilityId) {
		this.sFacilityId = sFacilityId;
	}

	/**
	 * @return the sPatientId
	 */
	public String getPatientId() {
		return sPatientId;
	}
	/**
	 * @param sPatientId the sPatientId to set
	 */
	public void setPatientId(String sPatientId) {
		this.sPatientId = sPatientId;
	}

	/**
	 * @return the Encounter ID
	 */
	public String getEncounterId() {
		return sEncounterId;
	}
	/**
	 * @param Encounter ID the Encounter ID to set
	 */
	public void setEncounterId(String sEncounterId) {
		this.sEncounterId = sEncounterId;
	}

	/**
	 * @return the Test code
	 */
	public String getTestCode() {
		return sTestCode;
	}
	/**
	 * @param sTestCode the sTestCode to set
	 */
	public void setTestCode(String sTestCode) {
		this.sTestCode = sTestCode;
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
