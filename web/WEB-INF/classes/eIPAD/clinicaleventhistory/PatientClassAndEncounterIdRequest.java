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
package eIPAD.clinicaleventhistory;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This is the request class for getting the list of patient class
 * and encounter id based on a time period.
 * @author GRamamoorthy 
 *
 */
public class PatientClassAndEncounterIdRequest implements Serializable {

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
	 * Stores the facility Id
	 */
	private String facilityId = null;
	
	/**
	 * Stores the selected time period
	 */
	private String selectedTimePeriod = null;
	
	/**
	 * 
	 */
	private String patientClass = null;
	
	/**
	 * default constructor of the class
	 */
	public PatientClassAndEncounterIdRequest() {
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


	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}


	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}


	/**
	 * @return the selectedTimePeriod
	 */
	public String getSelectedTimePeriod() {
		return selectedTimePeriod;
	}


	/**
	 * @param selectedTimePeriod the selectedTimePeriod to set
	 */
	public void setSelectedTimePeriod(String selectedTimePeriod) {
		this.selectedTimePeriod = selectedTimePeriod;
	}


	/**
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}


	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}

}
