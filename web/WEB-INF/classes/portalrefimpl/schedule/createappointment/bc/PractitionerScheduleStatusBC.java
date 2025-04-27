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

import portalrefimpl.schedule.createappointment.dac.PractitionerScheduleStatusDAC;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;

/**
 * This is the BC layer class for practitioner schedule status service
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleStatusBC {

	/**
	 * This method gets the practitioner schedule status information
	 * given the practitioner schedule status request object
	 * @param request
	 * @return
	 */
	public PractitionerScheduleStatusResponse getPractitionerScheduleStatus(PractitionerScheduleStatusRequest request){
		PractitionerScheduleStatusDAC dacInst = new PractitionerScheduleStatusDAC();
		return dacInst.getPractitionerScheduleStatus(request);
	}
	
}
