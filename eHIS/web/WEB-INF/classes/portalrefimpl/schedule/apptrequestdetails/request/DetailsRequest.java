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
package portalrefimpl.schedule.apptrequestdetails.request;

import portalrefimpl.common.request.BaseRequest;

/**
 * This is the request class for obtaining details of an appointment request
 * @author GRamamoorthy
 *
 */
public class DetailsRequest extends BaseRequest {

	private String apptRequestReferenceNumber = null;

	/**
	 * @return the apptRequestReferenceNumber
	 */
	public String getApptRequestReferenceNumber() {
		return apptRequestReferenceNumber;
	}

	/**
	 * @param apptRequestReferenceNumber the apptRequestReferenceNumber to set
	 */
	public void setApptRequestReferenceNumber(String apptRequestReferenceNumber) {
		this.apptRequestReferenceNumber = apptRequestReferenceNumber;
	}
		
}
