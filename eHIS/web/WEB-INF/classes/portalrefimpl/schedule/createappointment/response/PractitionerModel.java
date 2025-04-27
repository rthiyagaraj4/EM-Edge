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
package portalrefimpl.schedule.createappointment.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the model class to store information about one practitioner.
 * 
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "PractitionerDetail")
public class PractitionerModel {

	private String practitionerId = null;
	
	private String practitionerName = null;
	
	private String practitionerFullName = null;
	
	private String practitionerType = null;
	
	private String specialityCode = null;
	
	private String position = null;
	
	private String jobTitle = null;
	
	private String gender = null;
	
	private String specialityLongDesc = null;
	
	private String specialityShortDesc = null;
	
	private String specialityDesc = null;
	
	private String facilityDesc = null;
	
	private String clinicCode = null;
	
	/**
	 * Default constructor of the class
	 */
	public PractitionerModel(){
		// does nothing
	}
	
	/**
	 * Constructor taking arguements
	 *//*
	public PractitionerModel(String practitionerId, String practitionerName,
			String practitionerType, String primarySpeciality,String position,
			String jobTitle, String gender) {
		this.practitionerId = practitionerId;
		this.practitionerName = practitionerName;
		this.practitionerType = practitionerType;
		this.specialityCode = primarySpeciality;
		this.position = position;
		this.jobTitle = jobTitle;
		this.gender = gender;
	}*/

	/**
	 * @return the practitionerId
	 */
	@XmlElement(name = "PractitionerId")
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @return the practitionerName
	 */
	@XmlElement(name = "PractitionerName")
	public String getPractitionerName() {
		return practitionerName;
	}

	/**
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}

	/**
	 * @return the practitionerType
	 */
	@XmlElement(name = "PractitionerType")
	public String getPractitionerType() {
		return practitionerType;
	}

	/**
	 * @param practitionerType the practitionerType to set
	 */
	public void setPractitionerType(String practitionerType) {
		this.practitionerType = practitionerType;
	}

	/**
	 * @return the speciality
	 */
	@XmlElement(name = "SpecialityCode")
	public String getSpecialityCode() {
		return specialityCode;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpecialityCode(String speciality) {
		this.specialityCode = speciality;
	}

	/**
	 * @return the position
	 */
	@XmlElement(name = "Position")
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	
	/**
	 * @return the jobTitle
	 */
	@XmlElement(name = "JobTitle")
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the gender
	 */
	@XmlElement(name = "Gender")
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public void printResult(){
		System.out.println("practitioner id="+practitionerId);
		System.out.println("practitioner name="+practitionerName);
		System.out.println("practitioner full name="+practitionerFullName);
		//System.out.println("practitioner type="+practitionerType);
		System.out.println("specialty="+specialityCode);
		System.out.println("specialty desc="+specialityDesc);
		System.out.println("specialty Long Desc="+specialityLongDesc);
		System.out.println("specialty Short Desc="+specialityShortDesc);
		System.out.println("gender="+gender);
		System.out.println("position="+position);
		System.out.println("job title="+jobTitle);
		System.out.println("clinic code="+clinicCode);
		System.out.println("-------------------------------------------------");
	}

	/**
	 * @return the practitionerFullName
	 */
	@XmlElement(name = "PractitionerFullName")
	public String getPractitionerFullName() {
		return practitionerFullName;
	}

	/**
	 * @param practitionerFullName the practitionerFullName to set
	 */
	public void setPractitionerFullName(String practitionerFullName) {
		this.practitionerFullName = practitionerFullName;
	}

	/**
	 * @return the specialityLongDesc
	 */
	@XmlElement(name = "SpecialtyLongDescription")
	public String getSpecialityLongDesc() {
		return specialityLongDesc;
	}

	/**
	 * @param specialityLongDesc the specialityLongDesc to set
	 */
	public void setSpecialityLongDesc(String specialityLongDesc) {
		this.specialityLongDesc = specialityLongDesc;
	}

	/**
	 * @return the specialityShortDesc
	 */
	@XmlElement(name = "SpecialtyShortDescription")
	public String getSpecialityShortDesc() {
		return specialityShortDesc;
	}

	/**
	 * @param specialityShortDesc the specialityShortDesc to set
	 */
	public void setSpecialityShortDesc(String specialityShortDesc) {
		this.specialityShortDesc = specialityShortDesc;
	}

	/**
	 * @return the specialityDesc
	 */
	public String getSpecialityDesc() {
		return specialityDesc;
	}

	/**
	 * @param specialityDesc the specialityDesc to set
	 */
	public void setSpecialityDesc(String specialityDesc) {
		this.specialityDesc = specialityDesc;
	}

	/**
	 * @return the facilityDesc
	 */
	public String getFacilityDesc() {
		return facilityDesc;
	}

	/**
	 * @param facilityDesc the facilityDesc to set
	 */
	public void setFacilityDesc(String facilityDesc) {
		this.facilityDesc = facilityDesc;
	}

	/**
	 * @return the clinicCode
	 */
	@XmlElement(name = "ClinicCode")
	public String getClinicCode() {
		return clinicCode;
	}

	/**
	 * @param clinicCode the clinicCode to set
	 */
	public void setClinicCode(String clinicCode) {
		this.clinicCode = clinicCode;
	}
	
}
