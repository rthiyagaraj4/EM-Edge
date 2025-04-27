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
package portalrefimpl.schedule.createappointment.svc;

import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;

/**
 * @author SaraswathiR
 *
 */
public interface PractitionerSvc {

	/**
	 * This service method gets the list of practitioners
	 * for a given speciality - this service method is needed
	 * in the create appointment functionality
	 * @param practitionerRequest
	 * @return
	 */
	public PractitionerResponse getPractitionerList(PractitionerRequest practitionerRequest);
	
}
