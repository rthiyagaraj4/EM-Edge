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

import portalrefimpl.schedule.createappointment.dac.PractitionerScheduleDAC;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;

/**
 * This is the business component class for the practitioner schedule service
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleBC {

	/**
	 * 
	 * @param practitionerScheduleRequest
	 * @return
	 */
	public PractitionerScheduleResponse getPractitionerSchedule(
			PractitionerScheduleRequest practitionerScheduleRequest) {
		PractitionerScheduleDAC dacInst = new PractitionerScheduleDAC();
		return dacInst.getPractitionerSchedule(practitionerScheduleRequest);
	}
}
