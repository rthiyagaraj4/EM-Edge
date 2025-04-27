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
package portalrefimpl.schedule.apptrequestdetails.bc;

import portalrefimpl.schedule.apptrequestdetails.dac.DetailsDAC;
import portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest;
import portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse;

/**
 * This is the BC layer class for getting the appointment request details
 * @author GRamamoorthy
 *
 */
public class DetailsBC {

	/**
	 * This method gets the details of an appointment request
	 * This method takes as input an instance of DetailsRequest
	 * This method in turn calls the DAC class to get the details
	 * @param request
	 * @return
	 */
	public DetailsResponse getApptRequestDetails(DetailsRequest request){
		DetailsDAC dacInst = new DetailsDAC();
		return dacInst.getApptRequestDetails(request);
	}
	
}
