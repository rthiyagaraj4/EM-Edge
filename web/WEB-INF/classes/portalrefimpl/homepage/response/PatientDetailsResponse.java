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
package portalrefimpl.homepage.response;

import java.util.Calendar;
import java.util.Date;

import portalrefimpl.common.response.BaseResponse;

/**
 * This class is the response class which contains patient details
 * to be used in the home page
 * @author gramamoorthy
 *
 */
public class PatientDetailsResponse extends BaseResponse {

	/**
	 * Data members in this class
	 */
	private String patientId = null;
	private String nationalId = null;
	/*private String namePrefix = null;
	private String nameSuffix = null;*/
	private String patientName = null;
	private String patientDisplayName = null;
	private String sex = null;
	private Date dateOfBirth = null;
	
	
	/**
	 * @return the nationalId
	 */
	public String getNationalId() {
		return nationalId;
	}
	/**
	 * @param nationalId the nationalId to set
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	
	/**
	 * @return the namePrefix
	 */
	/*public String getNamePrefix() {
		return namePrefix;
	}
	*//**
	 * @param namePrefix the namePrefix to set
	 *//*
	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}
	*//**
	 * @return the nameSuffix
	 *//*
	public String getNameSuffix() {
		return nameSuffix;
	}
	*//**
	 * @param nameSuffix the nameSuffix to set
	 *//*
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}*/
	
	
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * 
	 * @return
	 */
	/*public String getCompletePatientName(){
		String completeName = patientName;
		if(namePrefix != null && !namePrefix.trim().equals("")){
			completeName = namePrefix + completeName;
		}
		
		if(nameSuffix != null && !nameSuffix.trim().equals("")){
			completeName = completeName + nameSuffix;
		}
		
		return completeName;
	}*/
	
	/**
	 * 
	 * @return
	 */
	public String getPatientAge(){
		String patientAge = "";
		if(dateOfBirth != null){
			Date currentDate = new Date(System.currentTimeMillis());
			Calendar currentCal = Calendar.getInstance();
			currentCal.setTime(currentDate);
			
			Calendar dateOfBirthCal = Calendar.getInstance();
			dateOfBirthCal.setTime(dateOfBirth);
			
			int years = currentCal.get(Calendar.YEAR) - dateOfBirthCal.get(Calendar.YEAR);
			int totalMonths = years * 12;
			int months = currentCal.get(Calendar.MONTH) - dateOfBirthCal.get(Calendar.MONTH);
			totalMonths += months;
			
			months = totalMonths % 12;
			years = (totalMonths - months) / 12;
			
			patientAge += years;
			patientAge += "yr ";
			if(months > 0){
				patientAge += months;
				patientAge += "m";
			}
		}
		
		return patientAge;
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
	 * @return the patientDisplayName
	 */
	public String getPatientDisplayName() {
		return patientDisplayName;
	}
	/**
	 * @param patientDisplayName the patientDisplayName to set
	 */
	public void setPatientDisplayName(String patientDisplayName) {
		this.patientDisplayName = patientDisplayName;
	}
	
}
