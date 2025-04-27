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
package portalrefimpl.schedule.rescheduleappointment.svc;

import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;


/**
 * This is the business interface for reschedule appointment service
 * @author GRamamoorthy
 *
 */
public interface RescheduleAppointmentSvc {

	/**
	 * This method reschedules an appointment which is referred in the reschedule appointment
	 * request object
	 * This method returns an instance of reschedule appointment response object
	 * @param request
	 * @return
	 */
	public RescheduleAppointmentResponse rescheduleAppointmentRequest(RescheduleAppointmentRequest request);
	
}
