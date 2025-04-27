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
package portalrefimpl.contactreason.cancelappointment.request;

import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.schedule.common.request.AppointmentType;

/**
 * This is the request class for the getting the contact reason
 * for cancel appointment
 * @author GRamamoorthy
 *
 */
public class ContactReasonForCancelApptRequest extends BaseRequest {

	private AppointmentType appointmentType = null;

	/**
	 * @return the appointmentType
	 */
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	
}
