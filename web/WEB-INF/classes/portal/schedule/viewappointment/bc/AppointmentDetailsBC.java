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
package portal.schedule.viewappointment.bc;

import org.apache.log4j.Logger;

import portal.schedule.viewappointment.dac.AppointmentDetailsDAC;
import portal.schedule.viewappointment.request.AppointmentDetailsRequest;
import portal.schedule.viewappointment.response.AppointmentDetailsResponse;


/**
 * This method invokes the DAC class to get the appointment details for the home page 
 * @author vkodancha
 *
 */
public class AppointmentDetailsBC {

	private static Logger logger = Logger
			.getLogger(AppointmentDetailsBC.class.getName());
	AppointmentDetailsResponse response;
	AppointmentDetailsDAC dacInst;
	/**
	 * @param response the response to set
	 */
	public void setResponse(AppointmentDetailsResponse response) {
		logger.debug("setting the AppointmentDetailsResponse");
		this.response = response;
	}

	/**
	 * @param dacInst the dacInst to set
	 */
	public void setDacInst(AppointmentDetailsDAC dacInst) {
		logger.debug("setting the AppointmentDetailsDAC");
		this.dacInst = dacInst;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(AppointmentDetailsRequest request){
		logger.debug("inside the method getAppointmentDetails");
		response = dacInst.getAppointmentDetails(request);
				
		return response;
	}
	

}
