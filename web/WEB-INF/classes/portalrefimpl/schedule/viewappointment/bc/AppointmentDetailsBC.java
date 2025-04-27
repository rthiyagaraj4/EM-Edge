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
package portalrefimpl.schedule.viewappointment.bc;

import portalrefimpl.schedule.viewappointment.dac.AppointmentDetailsDAC;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;


/**
 * @author GRamamoorthy
 *
 */
public class AppointmentDetailsBC {

	/**
	 * 
	 */
	public AppointmentDetailsBC() {
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(AppointmentDetailsRequest request){
		// first step
		// validate the request - this is just a sample so no validation
		
		// second step
		// initialize the DAC class and get the data from it
		AppointmentDetailsDAC dacInst = new AppointmentDetailsDAC();
		AppointmentDetailsResponse response = dacInst.getAppointmentDetails(request);
				
		return response;
	}
	

}
