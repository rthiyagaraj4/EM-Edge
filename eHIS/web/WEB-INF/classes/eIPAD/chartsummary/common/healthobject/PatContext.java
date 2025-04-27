/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.common.healthobject;
/**
* @author GaneshkumarC
 * This class is used to hold the context information of the patient. 
 * This class gets instantiated when the user intends to view the chart summary details of the patient.
 */

public class PatContext implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String facilityId;
	private String encounterId;
	private String patientId;
	private String clinicianId;
	private String pracType;
	private String locale;
	private String age;
	private String gender;
	private String dob;
	private String patientClass;
	private String loggedInUser;
	private String responsibilityID;
	private String selectedEncounterId;
	private String locationCode;
	private String locationType;
	
	/**
	 * gets the facilityId for the patient
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}
	/**
	 * sets the facilityId for the patient
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	/**
	 * gets the encounter for the patient
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
	 * @return the clinicianId
	 */
	public String getClinicianId() {
		return clinicianId;
	}
	/**
	 * @param clinicianId the clinicianId to set
	 */
	public void setClinicianId(String clinicianId) {
		this.clinicianId = clinicianId;
	}
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
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
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
	 * @return the loggedInUser
	 */
	public String getLoggedInUser() {
		return loggedInUser;
	}
	/**
	 * @param loggedInUser the loggedInUser to set
	 */
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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
	 * @return the selectedEncounterId
	 */
	public String getSelectedEncounterId() {
		return selectedEncounterId;
	}
	/**
	 * @param selectedEncounterId the selectedEncounterId to set
	 */
	public void setSelectedEncounterId(String selectedEncounterId) {
		this.selectedEncounterId = selectedEncounterId;
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

}
