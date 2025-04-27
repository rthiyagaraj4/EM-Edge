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
package portalrefimpl.facility.facilityforcontact.svc;

import portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest;
import portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse;

/**
 * This is the business interface for facility for contact service
 * @author GRamamoorthy
 *
 */
public interface FacilityForContactSvc {

	/**
	 * This method gets the facilities with their details
	 * Details like facility address, facility contact details will be retrieved
	 * @param request
	 * @return
	 */
	public FacilityForContactResponse getFacilitiesForContact(FacilityForContactRequest request);
	
}
