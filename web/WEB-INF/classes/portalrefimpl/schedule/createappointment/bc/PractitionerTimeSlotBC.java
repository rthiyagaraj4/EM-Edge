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

import portalrefimpl.schedule.createappointment.dac.PractitionerTimeSlotDAC;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;

/**
 * This is the BC class for the practitioner time slot service
 * @author GRamamoorthy
 *
 */
public class PractitionerTimeSlotBC {

	/**
	 * This method gets the practitioner time slot information
	 * by calling the practitioner time slot dac class in turn
	 * @param practitionerTimeSlotRequest
	 * @return
	 */
	public PractitionerTimeSlotResponse getPractitionerTimeSlot(
			PractitionerTimeSlotRequest practitionerTimeSlotRequest) {
		PractitionerTimeSlotDAC dacInst = new PractitionerTimeSlotDAC();
		return dacInst.getPractitionerTimeSlot(practitionerTimeSlotRequest);
	}
	
}
