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
package portalrefimpl.facility.facilityforcontact.request;

import java.util.List;

import portalrefimpl.common.request.BaseRequest;

/**
 * This is the request class for the facility for contact
 * service
 * This class extends BaseRequest
 * @author GRamamoorthy
 *
 */
public class FacilityForContactRequest extends BaseRequest {

	/**
	 * Stores the number of facilities to retrieve
	 * This is optional
	 */
	private int facilityCount = 0;

	/**
	 * Stores the facility ids which can be used for
	 * querying - this is optional
	 */
	private List<String> facilityIds = null;
	
	/**
	 * @return the facilityCount
	 */
	public int getFacilityCount() {
		return facilityCount;
	}

	/**
	 * @param facilityCount the facilityCount to set
	 */
	public void setFacilityCount(int facilityCount) {
		this.facilityCount = facilityCount;
	}

	/**
	 * @return the facilityIds
	 */
	public List<String> getFacilityIds() {
		return facilityIds;
	}

	/**
	 * @param facilityIds the facilityIds to set
	 */
	public void setFacilityIds(List<String> facilityIds) {
		this.facilityIds = facilityIds;
	}
	
	
}
