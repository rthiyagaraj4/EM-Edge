/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.response;

import portal.common.response.BaseResponse;

/**
 * This class is bean containing
 *  the patient details response
 * @author vkodancha
 *
 */
public class PatientDetailsResponse extends BaseResponse {
	private String patientName;
	private String nationalIdNo;
	private String sex;
	//private String dateOfBirth;
	private int age;
	
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
	 * @return the nationalIdNo
	 */
	public String getNationalIdNo() {
		return nationalIdNo;
	}
	/**
	 * @param nationalIdNo the nationalIdNo to set
	 */
	public void setNationalIdNo(String nationalIdNo) {
		this.nationalIdNo = nationalIdNo;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @return the dateOfBirth
	 *//*
	public String getDateOfBirth() {
		return dateOfBirth;
	}*/
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 *//*
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/
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
}
