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

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import portalrefimpl.schedule.common.request.AppointmentRequest;

/**
 * This class is the wrapper class for storing a queue which in turn stores the
 * appointment request objects
 * 
 * @author GRamamoorthy
 * 
 */
public class AppointmentRequestEnabler {

	/**
	 * instance of the controller in this class
	 */
	private AppointmentRequestController controller = null;

	/**
	 * instance of the queue in this class
	 */
	private LinkedBlockingQueue<AppointmentRequest> appointmentRequestQueue = new LinkedBlockingQueue<AppointmentRequest>();

	/**
	 * @param controller
	 */
	public AppointmentRequestEnabler(AppointmentRequestController controller) {
		this.controller = controller;
	}

	/**
	 * This method returns a boolean flag which indicates whether the queue is
	 * empty or not
	 * 
	 * @return
	 */
	public boolean hasRequestsInQueue() {
		boolean hasRequests = false;
		synchronized (appointmentRequestQueue) {
			hasRequests = appointmentRequestQueue.size() > 0;
		}
		return hasRequests;
	}

	/**
	 * This method returns the first request object in the queue
	 * 
	 * @return
	 */
	public AppointmentRequest getHeadRequest() {
		AppointmentRequest request = null;
		synchronized (appointmentRequestQueue) {
			request = appointmentRequestQueue.peek();
		}
		return request;
	}

	/**
	 * This method removes the first request object from the queue
	 */
	public void removeHeadRequest() {
		synchronized (appointmentRequestQueue) {
			appointmentRequestQueue.poll();
		}
	}

	/**
	 * This method adds the appointment request object to the queue
	 * 
	 * @param bookAppointmentRequest
	 */
	public void addAppointmentRequest(AppointmentRequest appointmentRequest) {
		synchronized (appointmentRequestQueue) {
			try {
				appointmentRequestQueue.offer(appointmentRequest, 1,
						TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
