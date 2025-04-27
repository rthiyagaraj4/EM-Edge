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

import eCommon.Common.CommonBean;

/**
 * This class is the model class for getting the event history
 * records for a patient
 * @author GRamamoorthy 
 *
 */
public class EventHistoryRequest implements Serializable {

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
	 * Stores the encounterId
	 */
	private String encounterId = null;
	
	/**
	 * Stores the selected time period
	 */
	private String selectedTimePeriod = null;
	
	/**'
	 * Stores the patient class
	 */
	private String patientClass = null;
	
	/**
	 * Stores the locale information
	 */
	private String locale = null;
	
	
	/**
	 * Default constructor of the class
	 */
	public EventHistoryRequest() {
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
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}


	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
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


	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}


	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEventDate(){
		String eventDate = "";
		if(request != null){
			eventDate = request.getParameter("event_date");
			eventDate = CommonBean.checkForNull(eventDate);
		}
		return eventDate;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getViewedBy(){
		String viewBy = "";
		if(request != null){
			viewBy = request.getParameter("viewby");
			viewBy = CommonBean.checkForNull(viewBy);
		}
		return viewBy;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSelectedHistoryRecordType(){
		String selectedhisrectype = "";
		if(request != null){
			selectedhisrectype = request.getParameter("hist_type");
			selectedhisrectype = CommonBean.checkForNull(selectedhisrectype);
		}
		return selectedhisrectype;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSelectedEventClass(){
		String selectedEventClass = "";
		if(request != null){
			selectedEventClass = request.getParameter("event_class");
			selectedEventClass = CommonBean.checkForNull(selectedEventClass);
		}
		return selectedEventClass;
	}

}
