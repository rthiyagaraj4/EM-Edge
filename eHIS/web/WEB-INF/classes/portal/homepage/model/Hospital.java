/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.model;

import portal.common.model.Address;
import portal.common.model.ContactDetails;

/**
 * This class is contains the attributes of hospital
 * @author skrishnared2
 *
 */
public class Hospital {

	/**
	 * Instance variables
	 */
	private String hospitalName;
	private String hospitalId;
	private String specialty;
	private Address address;
	private ContactDetails contactDetails;
	
	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		if(hospitalName != null){
			this.hospitalName = hospitalName;
		} else {
			this.hospitalName = "";
		}
	}
	/**
	 * @return the hospitalId
	 */
	public String getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(String hospitalId) {
		if(hospitalId != null){
			this.hospitalId = hospitalId;
		} else {
			this.hospitalId = "";
		}
	}
	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}
	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		if(specialty != null){
			this.specialty = specialty;
		} else {
			this.specialty = "";
		}
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
}
