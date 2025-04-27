/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.svc;

import portal.schedule.viewupcomingappointment.request.UpcomingAppointmentDetailsRequest;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetailsResponse;

/**
 * This class defines all the abstract methods used in Upcoming Appointment Service
 * This method takes as input UpcomingAppointmentDetailsRequest object
 * and returns UpcomingAppointmentDetailsResponse object
 * @author vkodancha
 *
 */
public interface UpcomingAppointmentDetailsSvc {

	/**
	 * This method retrieves the list of future appointments for a patient.
	 * This method takes as input AppointmentDetailsRequest object
	 * and returns AppointmentDetailsResponse object
	 * @param request
	 * @return
	 */
	public UpcomingAppointmentDetailsResponse getUpcomingAppointmentDetails(UpcomingAppointmentDetailsRequest request);
}
