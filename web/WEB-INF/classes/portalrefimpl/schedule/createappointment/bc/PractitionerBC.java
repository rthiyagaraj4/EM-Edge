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
package portalrefimpl.schedule.createappointment.bc;

import portalrefimpl.schedule.createappointment.dac.PractitionerDAC;
import portalrefimpl.schedule.createappointment.request.PractitionerRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerResponse;

/**
 * @author GRamamoorthy
 *
 */
public class PractitionerBC {

	/**
	 * 
	 * @param practitionerRequest
	 * @return
	 */
	public PractitionerResponse getPractitionerList(PractitionerRequest practitionerRequest){
		// initialize the dac instance and get the data
		PractitionerDAC dacInst = new PractitionerDAC();
		PractitionerResponse practitionerResponse = dacInst
				.getPractitionerList(practitionerRequest);
		return practitionerResponse;
	}
	
}
