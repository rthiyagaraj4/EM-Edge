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
package portalrefimpl.schedule.createappointment.appointmentrequest.handler;

import portalrefimpl.schedule.common.request.AppointmentRequest;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;

/**
 * This is the interface for handling appointment specific operations
 * This interface will be implemented by specific classes for book appointment
 * and reschedule appointment functionalities
 * @author GRamamoorthy
 *
 */
public interface AppointmentHandler {

	/**
	 * This method performs the operation given the AppointmentRequest object
	 * 
	 * @param appointmentRequest
	 * @return
	 */
	public AppointmentResponse performOperation(AppointmentRequest appointmentRequest);
	
}
