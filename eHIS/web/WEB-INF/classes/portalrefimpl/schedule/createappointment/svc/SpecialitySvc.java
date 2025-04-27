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

import portalrefimpl.schedule.createappointment.request.SpecialityRequest;
import portalrefimpl.schedule.createappointment.response.SpecialityResponse;

/**
 * @author SaraswathiR
 *
 */
public interface SpecialitySvc {

	
	/**
	 * This service method gets the list of specialities
	 * needed in the create appointment functionality
	 * 
	 * @param specialityRequest
	 * @return
	 */
	public SpecialityResponse getSpecialities(SpecialityRequest specialityRequest);
	
}
