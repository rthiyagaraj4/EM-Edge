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

import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.response.BaseResponse;

/**
 * @author gramamoorthy
 *
 */
public class HospitalDetailsResponse extends BaseResponse {

	/**
	 * data members in this class
	 */
	private String siteId;
	
	private String siteName;
	
	private Address address;
	
	private ContactDetails contactDetails;

	/**
	 * @return the facilityId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the facilityName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
