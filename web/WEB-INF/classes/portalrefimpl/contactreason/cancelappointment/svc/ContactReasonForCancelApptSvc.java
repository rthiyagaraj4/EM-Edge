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
package portalrefimpl.contactreason.cancelappointment.svc;

import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;

/**
 * This is the business interface for getting the contact reasons
 * during cancel appointment functionality
 * @author GRamamoorthy
 *
 */
public interface ContactReasonForCancelApptSvc {

	/**
	 * This method gets the contact reasons during the 
	 * cancel appointment functionality
	 * @param request
	 * @return
	 */
	public ContactReasonForCancelApptResponse getContactReasons(
			ContactReasonForCancelApptRequest request);
	
	
}
