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
package portalrefimpl.schedule.viewappointment.svc;

import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;

/**
 * @author GRamamoorthy
 *
 */
public interface AppointmentSvc{

	/**
	 * This method retrieves the list of future appointments for a patient.
	 * This method takes as input AppointmentDetailsRequest object
	 * and returns AppointmentDetailsResponse object
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(AppointmentDetailsRequest request);
		
}
