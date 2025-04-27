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

/**
 * @author GRamamoorthy 
 *
 */
public class PatientLineDetailResponse implements Serializable {

	
	private String patientLine = null;
	
	private String confAccess = null;
	
	/**
	 * Default constructor of the class
	 */
	public PatientLineDetailResponse() {
	}

	/**
	 * @return the patientLine
	 */
	public String getPatientLine() {
		return patientLine;
	}

	/**
	 * @param patientLine the patientLine to set
	 */
	public void setPatientLine(String patientLine) {
		this.patientLine = patientLine;
	}

	/**
	 * @return the confAccess
	 */
	public String getConfAccess() {
		return confAccess;
	}

	/**
	 * @param confAccess the confAccess to set
	 */
	public void setConfAccess(String confAccess) {
		this.confAccess = confAccess;
	}

}
