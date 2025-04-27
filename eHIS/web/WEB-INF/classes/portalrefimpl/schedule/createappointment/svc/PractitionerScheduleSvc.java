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

import portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;

/**
 * This service is used to retrieve the schedule for a practitioner
 * @author GRamamoorthy
 *
 */
public interface PractitionerScheduleSvc {

	/**
	 * This method gets the practitioner schedule
	 * based on the request object
	 * @param practitionerScheduleRequest
	 * @return
	 */
	public PractitionerScheduleResponse getPractitionerSchedule(
			PractitionerScheduleRequest practitionerScheduleRequest);
	
}
