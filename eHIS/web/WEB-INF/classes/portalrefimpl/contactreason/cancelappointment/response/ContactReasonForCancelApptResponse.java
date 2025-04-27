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
package portalrefimpl.contactreason.cancelappointment.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.contactreason.common.model.ContactReasonModel;

/**
 * This is the response class for the getting the contact reason
 * for cancel appointment
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "ContactReasonResponse")
public class ContactReasonForCancelApptResponse extends BaseResponse {

	private List<ContactReasonModel> contactReasonList = null;

	/**
	 * @return the contactReasonList
	 */
	@XmlElementWrapper(name = "ContactReasons")
	@XmlElement(name = "ContactReason")
	public List<ContactReasonModel> getContactReasonList() {
		return contactReasonList;
	}

	/**
	 * @param contactReasonList the contactReasonList to set
	 */
	public void setContactReasonList(List<ContactReasonModel> contactReasonList) {
		this.contactReasonList = contactReasonList;
	}
	
}
