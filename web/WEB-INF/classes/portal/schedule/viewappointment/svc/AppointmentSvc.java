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
package portal.schedule.viewappointment.svc;

import portal.schedule.viewappointment.request.AppointmentDetailsRequest;
import portal.schedule.viewappointment.response.AppointmentDetailsResponse;


/**
 * This class defines all the abstract methods used in Appointment Service
 * This method takes as input AppointmentDetailsRequest object
 * and returns AppointmentDetailsResponse object
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
