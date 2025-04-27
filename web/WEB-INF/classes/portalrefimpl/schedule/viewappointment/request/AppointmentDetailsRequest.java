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
package portalrefimpl.schedule.viewappointment.request;

import portalrefimpl.common.request.BaseRequest;





/**
 * This class is the request class for the view appointment details
 * service
 * This class extends the BaseRequest class.
 * This class does not contain
 * any other data member since for view appointment details only
 * the patientId is needed and patientId is present inside BaseRequest
 * @author GRamamoorthy
 *
 */
public class AppointmentDetailsRequest extends BaseRequest{
	
	private int recordCount = 0;
	
	/**
	 * Default constructor of the class
	 */
	public AppointmentDetailsRequest() {
	}

	/**
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

}
