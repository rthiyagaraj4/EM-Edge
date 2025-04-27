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
package portal.schedule.viewappointment.request;

import portal.common.request.BaseRequest;



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
	
	private String facilityId;
	private int resultSetSize;
	/**
	 * @return the facitlityId
	 */
	public String getFacilityId() {
		return facilityId;
	}
	/**
	 * @return the resultSetSize
	 */
	public int getResultSetSize() {
		return resultSetSize;
	}
	/**
	 * @param facitlityId the facitlityId to set
	 */
	public void setFacilityId(String facitlityId) {
		this.facilityId = facitlityId;
	}
	/**
	 * @param resultSetSize the resultSetSize to set
	 */
	public void setResultSetSize(int resultSetSize) {
		this.resultSetSize = resultSetSize;
	}

}
