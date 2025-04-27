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
package portalrefimpl.schedule.rescheduleappointment.bc;

import portalrefimpl.schedule.rescheduleappointment.dac.RescheduleAppointmentDAC;
import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;

/**
 * This is the BC layer class for reschedule appointment service
 * @author GRamamoorthy
 *
 */
public class RescheduleAppointmentBC {
	/**
	 * This method reschedules an appointment which is referred in the reschedule appointment
	 * request object
	 * This method returns an instance of reschedule appointment response object
	 * @param request
	 * @return
	 */
	public RescheduleAppointmentResponse rescheduleAppointmentRequest(RescheduleAppointmentRequest request){
		// now do the manipulation for the selected from and to time
		String preferredDate = request.getPreferredDate();
		String preferredFromTime = request.getPreferredFromTime();
		if(preferredDate != null && !preferredDate.trim().equals("")){
			preferredFromTime = preferredDate + " " + preferredFromTime;
		}
		request.setPreferredFromTime(preferredFromTime);
		String preferredToTime = request.getPreferredToTime();
		if(preferredDate != null && !preferredDate.trim().equals("")){
			preferredToTime = preferredDate + " " + preferredToTime;
		}
		request.setPreferredToTime(preferredToTime);
		
		RescheduleAppointmentDAC dacInst = new RescheduleAppointmentDAC();
		/*RescheduleAppointmentResponse response = null;*/
		return dacInst.rescheduleAppointmentRequest(request);
	}
}
