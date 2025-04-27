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
package portalrefimpl.facility.facilityforpatient.request;

import portalrefimpl.common.request.BaseRequest;

/**
 * This is the request class for getting the list of facilities
 * that a patient has access to.
 * This class extends BaseRequest and does not have any data members
 * defined in it
 * @author GRamamoorthy
 *
 */
public class FacilityListRequest extends BaseRequest {

	private int recordCount = 0;

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
