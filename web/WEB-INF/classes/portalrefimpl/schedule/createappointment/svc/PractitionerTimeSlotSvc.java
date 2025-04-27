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

import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;

/**
 * This is the interface for practitioner time slot service
 * @author GRamamoorthy
 *
 */
public interface PractitionerTimeSlotSvc {

	/**
	 * This method gets the time slots for a practitioner
	 * based on the practitioner time slot request object
	 * @param practitionerTimeSlotRequest
	 * @return
	 */
	public PractitionerTimeSlotResponse getPractitionerTimeSlot(
			PractitionerTimeSlotRequest practitionerTimeSlotRequest);
	
}
