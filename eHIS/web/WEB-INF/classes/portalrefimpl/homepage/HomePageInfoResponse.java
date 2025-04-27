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
package portalrefimpl.homepage;

import java.util.Calendar;
import java.util.Date;

import portalrefimpl.common.response.BaseResponse;



/**
 * @author GRamamoorthy
 *
 */
public class HomePageInfoResponse extends BaseResponse {

	private String nricId = null;
	
	private String patientNamePrefix = null;
	
	private String patientNameSuffix = null;
	
	private String patientName = null;
	
	private String sex = null;
	
	private Date dateOfBirth = null;
	

	/**
	 * @return the patientNamePrefix
	 */
	public String getPatientNamePrefix() {
		return patientNamePrefix;
	}

	/**
	 * @param patientNamePrefix the patientNamePrefix to set
	 */
	public void setPatientNamePrefix(String patientNamePrefix) {
		this.patientNamePrefix = patientNamePrefix;
	}

	/**
	 * @return the patientNameSuffix
	 */
	public String getPatientNameSuffix() {
		return patientNameSuffix;
	}

	/**
	 * @param patientNameSuffix the patientNameSuffix to set
	 */
	public void setPatientNameSuffix(String patientNameSuffix) {
		this.patientNameSuffix = patientNameSuffix;
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
		final String MALE = "m";
		final String FEMALE = "f";
		String sexValue = "";
		if(MALE.equalsIgnoreCase(sex)){
			sexValue = "Male";
		}else if(FEMALE.equalsIgnoreCase(sex)){
			sexValue = "Female";
		}
		return sexValue;
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
	public String getCompletePatientName(){
		String completeName = patientName;
		if(patientNamePrefix != null && !patientNamePrefix.trim().equals("")){
			completeName = patientNamePrefix + completeName;
		}
		
		if(patientNameSuffix != null && !patientNameSuffix.trim().equals("")){
			completeName = completeName + patientNameSuffix;
		}
		
		return completeName;
	}
	
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
	 * @return the nricId
	 */
	public String getNricId() {
		return nricId;
	}

	/**
	 * @param nricId the nricId to set
	 */
	public void setNricId(String nricId) {
		this.nricId = nricId;
	}
	
	
}
