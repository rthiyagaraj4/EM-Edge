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

/**
 * This class is the factory class used for retrieving a specific implementation
 * for appointment related functionalities - book appointment and reschedule 
 * appointment
 * This class is a singleton class
 * @author GRamamoorthy
 *
 */
public class AppointmentHandlerFactory {

	/**
	 * static instance of the class
	 */
	private static AppointmentHandlerFactory s_instance = null;
	
	/**
	 * private constructor of the class
	 */
	private AppointmentHandlerFactory(){
		// does nothing
	}
	
	/**
	 * This method returns the instance of this class
	 * @return
	 */
	public static AppointmentHandlerFactory getInstance(){
		if(s_instance == null){
			s_instance = new AppointmentHandlerFactory();
		}
		return s_instance;
	}
	
	/**
	 * This method returns the instance of the appointmenthandler implementation
	 * 
	 * @param appointmentRequest
	 * @return
	 */
	public AppointmentHandler getAppointmentHandler(
			AppointmentRequest appointmentRequest) {
		AppointmentHandler appointmentHandler = null;
		// here the implementation class instance is returned
		// based on the 
		int requestObjType = appointmentRequest.getRequestObjectType();
		switch (requestObjType){
		case AppointmentRequest.BOOKAPPOINTMENT_TYPE:
					appointmentHandler = new BookAppointmentHandlerImpl(); 
					break;
		case AppointmentRequest.RESCHEDULEAPPOINTMENT_TYPE:
					break;
		default:
			appointmentHandler = new BookAppointmentHandlerImpl();
			break;
		}
		
		return appointmentHandler;
	}
	
}
