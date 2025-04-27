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
package portalrefimpl.schedule.createappointment.appointmentrequest;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;

/**
 * This is the listener interface which will be set with the response object
 * obtained from executing the specific appointment functionality
 * This listener will be set to the appointment request object
 * 
 * @author GRamamoorthy
 *
 */
public interface ResponseContainer {

	/**
	 * This method gets the appointment response object
	 * @return
	 */
	public AppointmentResponse getAppointmentResponse();
	
	/**
	 * This method sets the appointment response object
	 * @param bookAppointmentResponse
	 */
	public void setAppointmentResponse(AppointmentResponse appointmentResponse);
	
}
