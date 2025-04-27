/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.bc;

import org.apache.log4j.Logger;

import portal.schedule.viewupcomingappointment.dac.UpcomingAppointmentDetailsDAC;
import portal.schedule.viewupcomingappointment.request.UpcomingAppointmentDetailsRequest;
import portal.schedule.viewupcomingappointment.response.UpcomingAppointmentDetailsResponse;

/**
 * This method invokes the DAC class to get the appointment details for the
 * Upcoming appointment page
 * 
 * @author vkodancha
 * 
 */
public class UpcomingAppointmentDetailsBC {
	private static Logger logger = Logger.getLogger(UpcomingAppointmentDetailsBC.class.getName());
	private UpcomingAppointmentDetailsDAC dacInst;
	
	/**
	 * @param dacInst
	 *            the dacInst to set
	 */
	public void setDacInst(UpcomingAppointmentDetailsDAC dacInst) {
		this.dacInst = dacInst;
	}

	/**
	 * This method fetches the appointments from EM DB for patient portal
	 * application upcoming appointment page
	 * 
	 * @param request
	 * @return UpcomingAppointmentDetailsResponse
	 */
	public UpcomingAppointmentDetailsResponse getUpcomingAppointmentDetails(
			UpcomingAppointmentDetailsRequest request) {
		logger.debug("inside the method getUpcomingAppointmentDetails");
		return dacInst.getUpcomingAppointmentDetails(request);
	}	

}
