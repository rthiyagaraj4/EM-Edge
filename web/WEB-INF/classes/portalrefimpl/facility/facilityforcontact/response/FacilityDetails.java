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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.model.Address;
import portalrefimpl.common.model.ContactDetails;
import portalrefimpl.common.model.Facility;

/**
 * This is a model class which will contain facility information
 * like address and contact details
 * This class extends Facility class
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "FacilityDetail")
public class FacilityDetails extends Facility {

	private Address facilityAddress = null;
	
	private ContactDetails facilityContactDetails = null;

	/**
	 * @return the facilityAddress
	 */
	@XmlElement(name = "Address")
	public Address getFacilityAddress() {
		return facilityAddress;
	}

	/**
	 * @param facilityAddress the facilityAddress to set
	 */
	public void setFacilityAddress(Address facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	/**
	 * @return the facilityContactDetails
	 */
	@XmlElement(name = "ContactDetails")
	public ContactDetails getFacilityContactDetails() {
		return facilityContactDetails;
	}

	/**
	 * @param facilityContactDetails the facilityContactDetails to set
	 */
	public void setFacilityContactDetails(ContactDetails facilityContactDetails) {
		this.facilityContactDetails = facilityContactDetails;
	}
	
}
