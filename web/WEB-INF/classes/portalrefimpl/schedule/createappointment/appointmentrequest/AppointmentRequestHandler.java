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
import portalrefimpl.schedule.createappointment.appointmentrequest.handler.AppointmentHandler;
import portalrefimpl.schedule.createappointment.appointmentrequest.handler.AppointmentHandlerFactory;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;

/**
 * This class is the thread class which keeps checking the request enabler object
 * for request objects and then takes the first request object and executes 
 * a logic specific to that request object
 * This class implements Runnable interface
 * 
 * @author GRamamoorthy
 *
 */
public class AppointmentRequestHandler implements Runnable{
	
	/**
	 * Instance of request enabler instance
	 */
	private AppointmentRequestEnabler requestEnabler = null;
	
	/**
	 * boolean flag to enable aborting this thread
	 */
	private boolean abortFlag = false;
	
	/**
	 * @param requestEnabler
	 */
	public AppointmentRequestHandler(AppointmentRequestEnabler requestEnabler) {
		this.requestEnabler = requestEnabler;
	}

	/**
	 * This is the main method of this class - performs the
	 * checking of the request enabler's queue for request objects
	 * Once request objects are present, takes the first request object and
	 * executes a logic specific to the request object
	 * If there is an abort software ping is given, then this thread execution
	 * is aborted
	 */
	public void run() {
		while(true){
			if(requestEnabler.hasRequestsInQueue()){
				AppointmentRequest appointmentRequest = requestEnabler
						.getHeadRequest();
				if(appointmentRequest != null){
					handleAppointmentRequest(appointmentRequest);
					requestEnabler.removeHeadRequest();
				}
			}
			
			if(abortFlag){
				break;
			}
		}
	}
	
	/**
	 * Boolean method to return the aborted status of this thread
	 * @return
	 */
	public boolean isAborted(){
		return abortFlag;
	}
	
	/**
	 * This method executes a logic specific to the request object
	 * This is done by getting the handler instance and then calling
	 * performOperation method in the handler
	 * The response object is then set to the request object
	 * by setting it in the response container implementation
	 * @param bookAppointmentRequest
	 */
	private void handleAppointmentRequest(
			AppointmentRequest appointmentRequest) {
				
		AppointmentHandler handler = AppointmentHandlerFactory.getInstance()
				.getAppointmentHandler(appointmentRequest);
		AppointmentResponse response = handler.performOperation(appointmentRequest);
		ResponseContainer responseContainer = new ResponseContainerImpl(response);
		appointmentRequest.setResponseContainer(responseContainer);
		//appointmentRequest.setResponseListener(response);
	}
	
	/**
	 * This method is a software ping to abort this thread execution
	 */
	public void abortOperation(){
		abortFlag = true;
	}


}
