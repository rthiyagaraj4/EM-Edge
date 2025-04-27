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
package eIPAD.pendingresults;

import java.io.Serializable;

/**
 * Bean class to store the detail of a patient
 * @author GRamamoorthy
 *
 */
public class PatientDetail implements Serializable {

	/**
	 * Stores the patient Id
	 */
	private String patientId = null;
	
	/**
	 * Stores the patient name
	 */
	private String patientName = null;
	
	/**
	 * Stores the sex
	 */
	private String sex = null;
	
	/**
	 * Stores the age
	 */
	private int age = 0;
		
	
	/**
	 * default constructor of the class
	 */
	public PatientDetail() {
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}


	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * 
	 */
	public int hashCode() {
		int hash = 101;
		if(patientId != null){
			hash = 20 * hash;
		}
		return hash;
	}


	/**
	 * Two PatientDetail objects are equal if
	 * the patient id is equal
	 * 
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		
		if(!(obj instanceof PatientDetail)){
			return equals;
		}
		
		String tempPatientId = ((PatientDetail)obj).getPatientId();
		if(tempPatientId != null && tempPatientId.equals(this.patientId)){
			equals = true;
		}
		
		return equals;
	}

}
