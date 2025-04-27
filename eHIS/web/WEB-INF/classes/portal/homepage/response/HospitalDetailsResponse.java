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
 * This class is used as response for Hospital details
 * 
 * @author skrishnared2
 */
public class HospitalDetailsResponse extends BaseResponse {
	
	private String hospitalName;
	private String addressDetails;
	private String country;
	private String residentAreaName;
	private String residentTownName;
	private String regionName;
	private String pincode;
	private String primaryTelephoneNo;
	private String faxNumber;
	private String eMailId;
	private String websiteDetails;
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
	 * @return the addressDetails
	 */
	public String getAddressDetails() {
		return addressDetails;
	}
	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the residentAreaName
	 */
	public String getResidentAreaName() {
		return residentAreaName;
	}
	/**
	 * @param residentAreaName the residentAreaName to set
	 */
	public void setResidentAreaName(String residentAreaName) {
		this.residentAreaName = residentAreaName;
	}
	/**
	 * @return the residentTownName
	 */
	public String getResidentTownName() {
		return residentTownName;
	}
	/**
	 * @param residentTownName the residentTownName to set
	 */
	public void setResidentTownName(String residentTownName) {
		this.residentTownName = residentTownName;
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the primaryTelephoneNo
	 */
	public String getPrimaryTelephoneNo() {
		return primaryTelephoneNo;
	}
	/**
	 * @param primaryTelephoneNo the primaryTelephoneNo to set
	 */
	public void setPrimaryTelephoneNo(String primaryTelephoneNo) {
		this.primaryTelephoneNo = primaryTelephoneNo;
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	/**
	 * @return the eMailId
	 */
	public String geteMailId() {
		return eMailId;
	}
	/**
	 * @param eMailId the eMailId to set
	 */
	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}
	/**
	 * @return the websiteDetails
	 */
	public String getWebsiteDetails() {
		return websiteDetails;
	}
	/**
	 * @param websiteDetails the websiteDetails to set
	 */
	public void setWebsiteDetails(String websiteDetails) {
		this.websiteDetails = websiteDetails;
	}

}
