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
package portalrefimpl.schedule.createappointment.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This class is the response class for the book appointment functionality
 * This class extends the AppointmentResponse class
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "BookAppointmentResponse")
public class BookAppointmentResponse extends AppointmentResponse {

	private String AppointmentRequestReferrenceNumber = null;

	/**
	 * @return the waitListNumber
	 */
	@XmlElement(name="AppointmentRequestReferrenceNumber")
	public String getWaitListNumber() {
		return AppointmentRequestReferrenceNumber;
	}

	/**
	 * @param waitListNumber the waitListNumber to set
	 */
	public void setWaitListNumber(String waitListNumber) {
		this.AppointmentRequestReferrenceNumber = waitListNumber;
	}
	
}
