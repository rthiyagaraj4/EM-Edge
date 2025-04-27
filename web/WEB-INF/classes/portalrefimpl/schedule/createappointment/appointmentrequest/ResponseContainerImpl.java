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
 * This class is the implementation of ResponseContainer interface
 * This class basically holds an instance of the response object
 * which is obtained by executing a logic specific to an appointment
 * request object
 * @author GRamamoorthy
 *
 */
public class ResponseContainerImpl implements ResponseContainer {

	/**
	 * instance of the appointment response object
	 */
	private AppointmentResponse response = null;
	
	/**
	 * Default constructor of the class
	 */
	public ResponseContainerImpl(){
		// does nothing
	}
	
	/**
	 * @param response
	 */
	public ResponseContainerImpl(AppointmentResponse response) {
		this.response = response;
	}


	/**
	 * 
	 */
	public AppointmentResponse getAppointmentResponse() {
		return response;
	}

	/**
	 * 
	 */
	public void setAppointmentResponse(
			AppointmentResponse appointmentResponse) {
		this.response = appointmentResponse;
	}

}
