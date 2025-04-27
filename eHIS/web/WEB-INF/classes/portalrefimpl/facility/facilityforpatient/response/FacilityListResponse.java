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
package portalrefimpl.facility.facilityforpatient.response;

import java.util.List;

import portalrefimpl.common.model.Facility;
import portalrefimpl.common.response.BaseResponse;

/**
 * This is the response class holding the list of facilities
 * which a patient can access
 * @author GRamamoorthy
 *
 */
public class FacilityListResponse extends BaseResponse {

	/**
	 * Stores the list of facilities
	 */
	private List<Facility> facilityList = null;

	/**
	 * @return the facilityList
	 */
	public List<Facility> getFacilityList() {
		return facilityList;
	}

	/**
	 * @param facilityList the facilityList to set
	 */
	public void setFacilityList(List<Facility> facilityList) {
		this.facilityList = facilityList;
	}
	
	
}
