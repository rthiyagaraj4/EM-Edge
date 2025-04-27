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
package eIP.advbedmgmt.setup.request;

/**
 * This is a request class used to get floor layout information
 * @author GRamamoorthy
 *
 */
public class FloorLayoutRequest {

	/**
	 * data members in this class
	 */
	private String facilityId = null;
	
	private String nursingUnit = null;

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

	/**
	 * @return the nursingUnit
	 */
	public String getNursingUnit() {
		return nursingUnit;
	}

	/**
	 * @param nursingUnit the nursingUnit to set
	 */
	public void setNursingUnit(String nursingUnit) {
		this.nursingUnit = nursingUnit;
	}		
}
