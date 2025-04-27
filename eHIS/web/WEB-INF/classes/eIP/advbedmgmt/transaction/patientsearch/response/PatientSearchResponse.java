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
package eIP.advbedmgmt.transaction.patientsearch.response;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for patient search sub module
 * Holds the output data that is, nursing unit for the given patient id
 * @author gramamoorthy
 *
 */
public class PatientSearchResponse extends BaseResponse{

	/**
	 * Data members in this class
	 */
	private String patientId = null;
	
	private String nursingUnitCode = null;
	
	private String roomNumber = null;
	
	private String bedNumber = null;
	
	private String encounterId = null;
	
	private PatientStatus patientStatus = null;
	

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
	 * @return the nursingUnitCode
	 */
	public String getNursingUnitCode() {
		return nursingUnitCode;
	}

	/**
	 * @param nursingUnitCode the nursingUnitCode to set
	 */
	public void setNursingUnitCode(String nursingUnitCode) {
		this.nursingUnitCode = nursingUnitCode;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the bedNumber
	 */
	public String getBedNumber() {
		return bedNumber;
	}

	/**
	 * @param bedNumber the bedNumber to set
	 */
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
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
	 * @return the patientStatus
	 */
	public PatientStatus getPatientStatus() {
		return patientStatus;
	}

	/**
	 * @param patientStatus the patientStatus to set
	 */
	public void setPatientStatus(PatientStatus patientStatus) {
		this.patientStatus = patientStatus;
	}
	
}
