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
package portalrefimpl.schedule.upcomingappointments.bc;

import portalrefimpl.schedule.upcomingappointments.dac.UpcomingAppointmentsDAC;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;

/**
 * @author SaraswathiR
 * 
 */
public class UpcomingAppointmentsBC {

	/**
	 * 
	 */
	public UpcomingAppointmentsBC() {

	}

	public UpcomingAppointmentsResponse getUpcomingAppointmentDetails(UpcomingAppointmentsRequest request) {

		// initialize the DAC class and get the data from it
		UpcomingAppointmentsDAC dacInst = new UpcomingAppointmentsDAC();
		UpcomingAppointmentsResponse response = dacInst.getUpcomingAppointmentDetails(request);

		return response;
	}
}
