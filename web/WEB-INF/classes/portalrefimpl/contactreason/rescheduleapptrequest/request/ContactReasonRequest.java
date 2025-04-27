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
package portalrefimpl.contactreason.rescheduleapptrequest.request;

import portalrefimpl.common.request.BaseRequest;

/**
 * This request class is used in getting the contact reason
 * for reschedule appointment request service
 * This class extends BaseRequest and does not contain any
 * data member of its own
 * @author GRamamoorthy
 *
 */
public class ContactReasonRequest extends BaseRequest {

	/**
	 * data members in this class
	 */
	private String reasonCode = null;
	
	private String reasonDescription = null;

	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the reasonDescription
	 */
	public String getReasonDescription() {
		return reasonDescription;
	}

	/**
	 * @param reasonDescription the reasonDescription to set
	 */
	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}
	
	
}
