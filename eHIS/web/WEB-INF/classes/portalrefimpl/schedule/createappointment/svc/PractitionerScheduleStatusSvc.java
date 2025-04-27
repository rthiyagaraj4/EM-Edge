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

import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;

/**
 * This is the interface for the practitioner schedule status service
 * @author GRamamoorthy
 *
 */
public interface PractitionerScheduleStatusSvc {

	
	/**
	 * This method gets the practitioner schedule status
	 * given the practitioner schedule status request 
	 * The practitioner schedule status
	 * @param practitionerScheduleStatusRequest
	 * @return
	 */
	public PractitionerScheduleStatusResponse getPractitionerScheduleStatus(
			PractitionerScheduleStatusRequest practitionerScheduleStatusRequest);
	
}
