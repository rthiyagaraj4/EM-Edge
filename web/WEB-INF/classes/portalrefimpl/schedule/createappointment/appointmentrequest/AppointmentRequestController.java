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

import portalrefimpl.schedule.common.request.AppointmentRequest;

/**
 * This is the controller class which directs the flow of objects and data
 * in the appointment functionality - book appointment and reschedule appointment
 * This class initializes the request enabler object which in turn stores a 
 * queue for storing the appointment request objects
 * and the thread which will read from the queue and execute the specific
 * logic for appointment functionality
 * @author GRamamoorthy
 *
 */
public class AppointmentRequestController {

	/**
	 * static instance of the class
	 */
	private static AppointmentRequestController s_instance = null;
	
	/**
	 * stores the instance of appointment request enabler object
	 */
	private AppointmentRequestEnabler requestEnabler = null;
	
	/**
	 * stores the instance of appointment request handler object
	 */
	private AppointmentRequestHandler requestHandler = null;
	
	/**
	 * private constructor of the class
	 */
	private AppointmentRequestController(){
		// does nothing
	}
	
	/**
	 * This method gets the instance of this class
	 * this method also calls the initialize method only for the first time
	 * @return
	 */
	public static AppointmentRequestController getInstance(){
		if(s_instance == null){
			s_instance = new AppointmentRequestController();
			s_instance.initialize();
		}
		return s_instance;
	}
	
	/**
	 * This method will initialize the request enabler object
	 * and the thread which will read this request enabler
	 */
	private void initialize(){
		requestEnabler = new AppointmentRequestEnabler(
				s_instance);
		requestHandler = new AppointmentRequestHandler(
				requestEnabler);
		Thread handlerThread = new Thread(requestHandler);
		handlerThread.start();
	}
	
	/**
	 * This method adds the appointment request object
	 * to the queue represented by the request enabler
	 * @param bookAppointmentRequest
	 */
	public void addAppointmentRequest(
			AppointmentRequest appointmentRequest) {
		requestEnabler.addAppointmentRequest(appointmentRequest);
	}
	
	
}
