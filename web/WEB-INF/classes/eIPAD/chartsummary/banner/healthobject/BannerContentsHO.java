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
package eIPAD.chartsummary.banner.healthobject;

/**
 * @author GaneshkumarC 
 *
 */
public class BannerContentsHO implements java.io.Serializable {
	private String patientId;
	private String patientName;
	private String age;
	private String gender;
	private String dob;
	private String encounterId;
	private String nationality;
	private String bedNum;
	private String nursingUnit;
	private String patientNameLocal;
	private String attendPractName;
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
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the bedNum
	 */
	public String getBedNum() {
		return bedNum;
	}
	/**
	 * @param bedNum the bedNum to set
	 */
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}
	/**
	 * @return the nursingUnit
	 */
	public String getNursingUnit() {
		return nursingUnit;
	}
	/**
	 * @param nursingUnit the nursingUnit to set
	 */
	public void setNursingUnit(String nursingUnit) {
		this.nursingUnit = nursingUnit;
	}
	/**
	 * @return the patientNameLocal
	 */
	public String getPatientNameLocal() {
		return patientNameLocal;
	}
	/**
	 * @param patientNameLocal the patientNameLocal to set
	 */
	public void setPatientNameLocal(String patientNameLocal) {
		this.patientNameLocal = patientNameLocal;
	}
	/**
	 * @return the attendPractName
	 */
	public String getAttendPractName() {
		return attendPractName;
	}
	/**
	 * @param attendPractName the attendPractName to set
	 */
	public void setAttendPractName(String attendPractName) {
		this.attendPractName = attendPractName;
	}
	
}
