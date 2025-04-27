/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.facility.response;

import java.util.List;

import portal.common.response.BaseResponse;

/**
 * This class is used as the response object by Facility service
 * 
 * @author vkodancha
 * 
 */
public class FacilityResponse extends BaseResponse {
	private List<Facility> facilityList;

	/**
	 * @return the facilityList
	 */
	public List<Facility> getFacilityList() {
		return facilityList;
	}

	/**
	 * @param facilityList
	 *            the facilityList to set
	 */
	public void setFacilityList(List<Facility> facilityList) {
		this.facilityList = facilityList;
	}

	/**
	 * over ridden for logging purpose
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (facilityList == null || facilityList.isEmpty()) {
			sb.append("facilityList is empty");
		} else {
			for (Facility facility : facilityList) {
				sb.append(facility.toString());
			}
		}
		return sb.toString();

	}
}
