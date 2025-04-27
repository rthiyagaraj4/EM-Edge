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
package portalrefimpl.schedule.cancelappointment.bc;

import portalrefimpl.schedule.cancelappointment.dac.CancelAppointmentDAC;
import portalrefimpl.schedule.cancelappointment.request.CancelAppointmentRequest;
import portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse;

/**
 * This is the BC layer class for cancel appointment service
 * @author gramamoorthy
 *
 */
public class CancelAppointmentBC {

	/**
	 * This method cancels an appointment represented by the request object
	 * @param request
	 * @return
	 */
	public CancelAppointmentResponse cancelAppointment(CancelAppointmentRequest request){
		CancelAppointmentDAC dacInst = new CancelAppointmentDAC();
		return dacInst.cancelAppointment(request);
	}
	
}
