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
package portalrefimpl.schedule.upcomingappointments.svc;

import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;

/**
 * @author SaraswathiR
 * 
 */
public interface UpcomingAppointmentsSvc {

	/**
	 * This method retrieves the list of upcoming appointments for a patient.
	 * This method takes as input AppointmentDetailsRequest object and returns
	 * AppointmentDetailsResponse object
	 * 
	 * @param request
	 * @return
	 */
	public UpcomingAppointmentsResponse getUpcomingAppointmentDetails(UpcomingAppointmentsRequest request);

}
