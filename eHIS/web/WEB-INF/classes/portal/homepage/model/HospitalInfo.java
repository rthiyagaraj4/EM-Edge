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

public class HospitalInfo {
	private String hospitalName;
	private String hospitalId;
	private String specialty;
	private Address address;
	
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
		this.hospitalName = hospitalName;
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
		this.hospitalId = hospitalId;
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
		this.specialty = specialty;
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

}
