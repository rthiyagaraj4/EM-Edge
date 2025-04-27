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
package eIP.advbedmgmt.transaction.canceladmission;

/**
 * This class is used as the response class to store
 * patient checked in status 
 * @author GRamamoorthy
 *
 */
public class PatientCheckInStatusResponse {

	private String patientCheckedInStatus = null;

	/**
	 * @return the patientCheckedInStatus
	 */
	public String getPatientCheckedInStatus() {
		return patientCheckedInStatus;
	}

	/**
	 * @param patientCheckedInStatus the patientCheckedInStatus to set
	 */
	public void setPatientCheckedInStatus(String patientCheckedInStatus) {
		this.patientCheckedInStatus = patientCheckedInStatus;
	}		
	
}
