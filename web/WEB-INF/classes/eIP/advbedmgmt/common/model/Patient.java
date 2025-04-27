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
package eIP.advbedmgmt.common.model;

import java.util.Date;
import java.util.Locale;

import webbeans.eCommon.MessageManager;

/**
 * This model class represents the details of a patient occupying a bed
 * @author gramamoorthy
 *
 */
public class Patient {

	private String patientId = null;
	
	private String patientName = null;
	
	/**
	 * locale specific patient name
	 */
	private String displayName = null;
	
	private Date occupiedUntilDateTime = null;
	
	private String gender = null;
	
	private String age = null;
	
	private String encounterId = null;
	
	private Practitioner practitionerDetails = null;
	
	/**
	 * Default empty constructor
	 */
	public Patient(){
		// does nothing
	}

	/**
	 * @param patientId
	 * @param patientName
	 * @param displayName
	 */
	public Patient(String patientId, String patientName, String displayName) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.displayName = displayName;
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
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the occupiedUntilDateTime
	 */
	public Date getOccupiedUntilDateTime() {
		return occupiedUntilDateTime;
	}

	/**
	 * @param occupiedUntilDateTime the occupiedUntilDateTime to set
	 */
	public void setOccupiedUntilDateTime(Date occupiedUntilDateTime) {
		this.occupiedUntilDateTime = occupiedUntilDateTime;
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
	 * @return the practitionerDetails
	 */
	public Practitioner getPractitionerDetails() {
		return practitionerDetails;
	}

	/**
	 * @param practitionerDetails the practitionerDetails to set
	 */
	public void setPractitionerDetails(Practitioner practitionerDetails) {
		this.practitionerDetails = practitionerDetails;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getShortDisplayName(){
		String shortenedName = "";
		final int NAME_LENGTH = 20;
		int len = 0;
		if(patientName != null && !patientName.trim().equals("")){
			shortenedName = patientName;
		}else if(displayName != null && !displayName.trim().equals("")){
			shortenedName = displayName;
		} 
		
		len = shortenedName.length();
		if(len > 20){
			len = NAME_LENGTH;
		}
		shortenedName = shortenedName.substring(0,len);
		
		return shortenedName;
	}
	
	
}
