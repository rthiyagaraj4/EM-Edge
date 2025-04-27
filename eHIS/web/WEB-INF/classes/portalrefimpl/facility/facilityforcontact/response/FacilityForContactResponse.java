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
package portalrefimpl.facility.facilityforcontact.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.response.BaseResponse;

/**
 * This is the response class for facility for contact service
 * This class extends BaseResponse class
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Contact")
public class FacilityForContactResponse extends BaseResponse {

	private Address siteAddress = null;
	
	private ContactDetails siteContactDetails = null;
	
	private List<FacilityDetails> facilitiesList = null;

	/**
	 * @return the siteAddress
	 */
	@XmlElement(name = "SiteAddress")
	public Address getSiteAddress() {
		return siteAddress;
	}

	/**
	 * @param siteAddress the siteAddress to set
	 */
	public void setSiteAddress(Address siteAddress) {
		this.siteAddress = siteAddress;
	}

	/**
	 * @return the siteContactDetails
	 */
	@XmlElement(name = "SiteContactDetails")
	public ContactDetails getSiteContactDetails() {
		return siteContactDetails;
	}

	/**
	 * @param siteContactDetails the siteContactDetails to set
	 */
	public void setSiteContactDetails(ContactDetails siteContactDetails) {
		this.siteContactDetails = siteContactDetails;
	}

	/**
	 * @return the facilitiesList
	 */
	@XmlElementWrapper(name = "Facilities")
	@XmlElement(name = "FacilityDetail")
	public List<FacilityDetails> getFacilitiesList() {
		return facilitiesList;
	}

	/**
	 * @param facilitiesList the facilitiesList to set
	 */
	public void setFacilitiesList(List<FacilityDetails> facilitiesList) {
		this.facilitiesList = facilitiesList;
	}
	
	
	
}
