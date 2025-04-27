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
package portalrefimpl.schedule.viewappointment.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.response.BaseResponse;




/**
 * This class represents the response object which will be sent from the view
 * appointment details service.
 * 
 * This contains the data which will be sent back from the DAC to all the preceding
 * layers until the UI
 * @author GRamamoorthy
 * 
 *
 */
@XmlRootElement(name = "AppointmentDetails")
public class AppointmentDetailsResponse extends BaseResponse{

	private List<AppointmentDetails> appointmentDetailsList = null;
	
	/**
	 * 
	 */
	public AppointmentDetailsResponse() {
	}

	/**
	 * @return the appointmentDetailsList
	 */
	@XmlElementWrapper(name = "Appointments")
	@XmlElement(name = "Appointment")
	public List<AppointmentDetails> getAppointmentDetailsList() {
		return appointmentDetailsList;
	}

	/**
	 * @param appointmentDetailsList the appointmentDetailsList to set
	 */
	public void setAppointmentDetailsList(
			List<AppointmentDetails> appointmentDetailsList) {
		this.appointmentDetailsList = appointmentDetailsList;
	}

}
