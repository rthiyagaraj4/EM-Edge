/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.response;

import java.util.List;

import portal.common.response.BaseResponse;

/**
 * This class represents the response object which will be sent from the view
 * upcoming appointment details service.
 * 
 * This contains the data which will be sent back from the DAC to all the preceding
 * layers until the UI
 * @author vkodancha
 * 
 *
 */
public class UpcomingAppointmentDetailsResponse  extends BaseResponse{
	private List<UpcomingAppointmentDetails> upcomingAppointmentDetails;

	/**
	 * @return the upcomingAppointmentDetails
	 */
	public List<UpcomingAppointmentDetails> getUpcomingAppointmentDetails() {
		return upcomingAppointmentDetails;
	}

	/**
	 * @param upcomingAppointmentDetails the upcomingAppointmentDetails to set
	 */
	public void setUpcomingAppointmentDetails(
			List<UpcomingAppointmentDetails> upcomingAppointmentDetails) {
		this.upcomingAppointmentDetails = upcomingAppointmentDetails;
	}
	
	/**
	 * over ridden for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		if(upcomingAppointmentDetails == null || upcomingAppointmentDetails.isEmpty()){
			sb.append("List is empty");
		}else {
			for (UpcomingAppointmentDetails appointmentDetails : upcomingAppointmentDetails) {
				sb.append(appointmentDetails.toString());
			}
		}
		return sb.toString();
	}
}
