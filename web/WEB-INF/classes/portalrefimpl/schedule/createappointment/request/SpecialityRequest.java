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
package portalrefimpl.schedule.createappointment.request;

import portalrefimpl.common.request.BaseRequest;



/**
 * This is the request class for getting the 
 * list of specialities to be obtained during
 * create appointment requirement
 * 
 * @author GRamamoorthy
 *
 */
public class SpecialityRequest extends BaseRequest {

	/**
	 * Stores the facility id needed for getting the list of
	 * specialities 
	 */
	private String facilityId = null;
	

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	
}
