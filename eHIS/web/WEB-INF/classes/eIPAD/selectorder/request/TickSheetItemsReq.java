/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.request;


import javax.servlet.http.*;

public class TickSheetItemsReq implements java.io.Serializable {
	private HttpServletRequest request;
	private HttpSession session;
	private String pracType;
	private String languageId;
	private String facilityID;
	private String locationType;
	private String locationCode;
	private String privApplicabilityYN;
	private String tickSheetId;
	private String sectionCode;
	private String clinicianID;
	private String patientClass;
	private String gender;
	private String DOB;
	private String encounterID;
	private String admitDate;
	private String dischargeDateTime;
	private String orderCategory;
	private String orderType;
	private String activityType;
	private String responsibilityID;
	private String orderCatalogNature;
	/**
	 * @return the pracType
	 */
	public String getPracType() {
		return pracType;
	}
	/**
	 * @param pracType the pracType to set
	 */
	public void setPracType(String pracType) {
		this.pracType = pracType;
	}
	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	/**
	 * @return the facilityID
	 */
	public String getFacilityID() {
		return facilityID;
	}
	/**
	 * @param facilityID the facilityID to set
	 */
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	/**
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * @return the privApplicabilityYN
	 */
	public String getPrivApplicabilityYN() {
		return privApplicabilityYN;
	}
	/**
	 * @param privApplicabilityYN the privApplicabilityYN to set
	 */
	public void setPrivApplicabilityYN(String privApplicabilityYN) {
		this.privApplicabilityYN = privApplicabilityYN;
	}
	/**
	 * @return the tickSheetId
	 */
	public String getTickSheetId() {
		return tickSheetId;
	}
	/**
	 * @param tickSheetId the tickSheetId to set
	 */
	public void setTickSheetId(String tickSheetId) {
		this.tickSheetId = tickSheetId;
	}
	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}
	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}
	/**
	 * @return the clinicianID
	 */
	public String getClinicianID() {
		return clinicianID;
	}
	/**
	 * @param clinicianID the clinicianID to set
	 */
	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * @return the encounterID
	 */
	public String getEncounterID() {
		return encounterID;
	}
	/**
	 * @param encounterID the encounterID to set
	 */
	public void setEncounterID(String encounterID) {
		this.encounterID = encounterID;
	}
	/**
	 * @return the admitDate
	 */
	public String getAdmitDate() {
		return admitDate;
	}
	/**
	 * @param admitDate the admitDate to set
	 */
	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}
	/**
	 * @return the dischargeDateTime
	 */
	public String getDischargeDateTime() {
		return dischargeDateTime;
	}
	/**
	 * @param dischargeDateTime the dischargeDateTime to set
	 */
	public void setDischargeDateTime(String dischargeDateTime) {
		this.dischargeDateTime = dischargeDateTime;
	}
	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}
	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	/**
	 * @return the responsibilityID
	 */
	public String getResponsibilityID() {
		return responsibilityID;
	}
	/**
	 * @param responsibilityID the responsibilityID to set
	 */
	public void setResponsibilityID(String responsibilityID) {
		this.responsibilityID = responsibilityID;
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
	 * @return the orderCatalogNature
	 */
	public String getOrderCatalogNature() {
		return orderCatalogNature;
	}
	/**
	 * @param orderCatalogNature the orderCatalogNature to set
	 */
	public void setOrderCatalogNature(String orderCatalogNature) {
		this.orderCatalogNature = orderCatalogNature;
	}
	
}
