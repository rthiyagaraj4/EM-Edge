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
 * This class is the response class for getting the patient class.
 * This class will contain the patient class data.
 * @author GRamamoorthy 
 *
 */
public class PatientClassResponse implements Serializable {

	/**
	 * Stores the patient class
	 */
	private String patientClass = null;
	
	/**
	 * default constructor
	 */
	public PatientClassResponse() {
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
	 * This method checks if the given object is same
	 * as this object
	 * The equality check is done for the patient class string
	 * stored in the class
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof PatientClassResponse)){
			return equals;
		}
		String tempPatientClass = ((PatientClassResponse)obj).getPatientClass();
		if(tempPatientClass != null && tempPatientClass.equals(this.patientClass)){
			equals = true;
		}
		return equals;
	}

}
