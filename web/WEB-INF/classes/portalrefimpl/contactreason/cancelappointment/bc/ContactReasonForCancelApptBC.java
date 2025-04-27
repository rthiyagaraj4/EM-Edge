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
package portalrefimpl.contactreason.cancelappointment.bc;

import portalrefimpl.contactreason.cancelappointment.dac.ContactReasonForCancelApptDAC;
import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;

/**
 * This is the BC layer class for the contact reason for cancel appointment
 * service
 * 
 * @author GRamamoorthy
 * 
 */
public class ContactReasonForCancelApptBC {

	/**
	 * This method gets the contact reasons for cancel appointment functionality
	 * 
	 * @param request
	 * @return
	 */
	public ContactReasonForCancelApptResponse getContactReasons(
			ContactReasonForCancelApptRequest request) {
		ContactReasonForCancelApptDAC dacInst = new ContactReasonForCancelApptDAC();
		return dacInst.getContactReasons(request);
	}

}
