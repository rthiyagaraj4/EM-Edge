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
package portalrefimpl.contactreason.rescheduleapptrequest.bc;

import portalrefimpl.contactreason.rescheduleapptrequest.dac.ContactReasonDAC;
import portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest;
import portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse;

/**
 * This is the BC layer class used in getting the contact reason
 * for reschedule appointment request service
 * @author GRamamoorthy
 *
 */
public class ContactReasonBC {

	/**
	 * This method gets the contact reason
	 * for reschedule appointment request service
	 * @param request
	 * @return
	 */
	public ContactReasonResponse getContactReasons(ContactReasonRequest request){
		ContactReasonDAC dacInst = new ContactReasonDAC();
		return dacInst.getContactReasons(request);
	}
	
}
