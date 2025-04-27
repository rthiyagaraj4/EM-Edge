/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.response;

import portal.common.model.Address;
import portal.common.response.BaseResponse;

public class HospitalInfoResponse extends BaseResponse {

	private String hospitalName;
	private Address addressDetails;

	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * @param hospitalName
	 *            the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	/**
	 * @return the addressDetails
	 */
	public String getAddressDetails() {
		return addressDetails.getAddressLine1() + " , "
				+ addressDetails.getAddressLine2() + " , "
				+ addressDetails.getAddressLine3();
	}

	/**
	 * @param addressDetails
	 *            the addressDetails to set
	 */
	public void setAddressDetails(Address addressDetails) {
		this.addressDetails = addressDetails;
	}

	/**
	 * @return the residentAreaName
	 */
	public String getResidentAreaName() {
		return this.addressDetails.getResAreaName();
	}

	/**
	 * @return the residentTownName
	 */
	public String getResidentTownName() {
		return this.addressDetails.getResTownName();
	}

	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return this.addressDetails.getRegionName();
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return this.addressDetails.getPincode();
	}

	/**
	 * over riding for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("hospitalName :" + hospitalName);
		sb.append("addressDetails :" + addressDetails);
		sb.append("residentAreaName :" + getResidentAreaName());
		sb.append("residentTownName :" + getResidentTownName());
		sb.append("regionName :" + getRegionName());
		sb.append("pincode :" + getPincode());
		return sb.toString();
	}

}
