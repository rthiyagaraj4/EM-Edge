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

public class PatientEncounterBean implements java.io.Serializable
{	
	private static final long serialVersionUID = 1L; 
	
	private String sPatientID; 
	private String sEncounterID; 
	private String sVisitDateTime;
	private String sPatientClass; 
	private String sSpecialtyCode;
	private String sSpecialtyDesc;
	private String sCareLocnType; 
	private String sCareLocnCode;
	private String sCareLocnDesc; 
	
	private String sGender; 
	private String sPractID; 
	private String sPractName;	
	private String sPatientName;		
	
	private String sCurrEncID; 
		
	public HttpServletRequest request;
	public HttpSession session;

	
	/**
	 * @return the Patient ID
	 */
	public String getsPatientID() {
		return sPatientID;
	}
	/**
	 * @param sPatientID the sPatientID to set
	 */
	public void setsPatientID(String sPatientID) {
		this.sPatientID = sPatientID;
	}

	/**
	 * @return the Encounter ID
	 */
	public String getsEncounterID() {
		return sEncounterID;
	}
	/**
	 * @param sEncounterID the sEncounterID to set
	 */
	public void setsEncounterID(String sEncounterID) {
		this.sEncounterID = sEncounterID;
	}

	/**
	 * @return the Visit Date and Time
	 */
	public String getsVisitDateTime() {
		return sVisitDateTime;
	}
	/**
	 * @param sVisitDateTime the sVisitDateTime to set
	 */
	public void setsVisitDateTime(String sVisitDateTime) {
		this.sVisitDateTime = sVisitDateTime;
	}	
	
	/**
	 * @return the Patient Class
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
	 * @return the  Specialty Description
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
	 * @return the Care Location Type
	 */
	public String getsCareLocnType() {
		return sCareLocnType;
	}
	/**
	 * @param sCareLocnType the sCareLocnType to set
	 */
	public void setsCareLocnType(String sCareLocnType) {
		this.sCareLocnType = sCareLocnType;
	}

	/**
	 * @return the Care Location Code
	 */
	public String getsCareLocnCode() {
		return sCareLocnCode;
	}
	/**
	 * @param sCareLocnCode the sCareLocnCode to set
	 */
	public void setsCareLocnCode(String sCareLocnCode) {
		this.sCareLocnCode = sCareLocnCode;
	}

	/**
	 * @return the Care Location Description
	 */
	public String getsCareLocnDesc() {
		return sCareLocnDesc;
	}
	/**
	 * @param sCareLocnDesc the sCareLocnDesc to set
	 */
	public void setsCareLocnDesc(String sCareLocnDesc) {
		this.sCareLocnDesc = sCareLocnDesc;
	}	
	
	/**
	 * @return the Gender
	 */
	public String getsGender() {
		return sGender;
	}
	/**
	 * @param sGender the sGender to set
	 */
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	/**
	 * @return the Practitioner ID
	 */
	public String getsPractID() {
		return sPractID;
	}
	/**
	 * @param sPractID the sPractID to set
	 */
	public void setsPractID(String sPractID) {
		this.sPractID = sPractID;
	}

	/**
	 * @return the Practitioner Name
	 */
	public String getsPractName() {
		return sPractName;
	}
	/**
	 * @param sPractName the sPractName to set
	 */
	public void setsPractName(String sPractName) {
		this.sPractName = sPractName;
	}	
	
	/**
	 * @return the Patient Name
	 */
	public String getsPatientName() {
		return sPatientName;
	}
	/**
	 * @param sPatientName the sPatientName to set
	 */
	public void setsPatientName(String sPatientName) {
		this.sPatientName = sPatientName;
	}	
	
	/**
	 * @return the Current Encounter ID
	 */
	public String getsCurrEncId() {
		return sCurrEncID;
	}
	/**
	 * @param sCurrEncID the sCurrEncID to set
	 */
	public void setsCurrEncID(String sCurrEncID) {
		this.sCurrEncID = sCurrEncID;
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
