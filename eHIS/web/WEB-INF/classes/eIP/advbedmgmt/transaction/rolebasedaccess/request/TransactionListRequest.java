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
package eIP.advbedmgmt.transaction.rolebasedaccess.request;

import eIP.advbedmgmt.common.request.BaseRequest;

/**
 * This is the request class for getting transaction list for a user
 * 
 * @author gramamoorthy
 *
 */
public class TransactionListRequest extends BaseRequest {

	/**
	 * Data members in the class
	 */
	private String responsibilityId = null;
	
	private String facilityId = null;
	
	private String nursingUnitCode = null;
	
	//private String menuId = null;
	
	private String userId = null;
	
	private String locationType = null;
	
	private String locationCode = null;
	
	private String patientId = null;
	
	private String encounterId = null;
	
	private String bedNumber = null;

	/**
	 * @return the responsibilityId
	 */
	public String getResponsibilityId() {
		return responsibilityId;
	}

	/**
	 * @param responsibilityId the responsibilityId to set
	 */
	public void setResponsibilityId(String responsibilityId) {
		this.responsibilityId = responsibilityId;
	}

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
	 * @return the nursingUnitCode
	 */
	public String getNursingUnitCode() {
		return nursingUnitCode;
	}

	/**
	 * @param nursingUnitCode the nursingUnitCode to set
	 */
	public void setNursingUnitCode(String nursingUnitCode) {
		this.nursingUnitCode = nursingUnitCode;
	}

	/**
	 * @return the menuId
	 */
	/*public String getMenuId() {
		return menuId;
	}

	*//**
	 * @param menuId the menuId to set
	 *//*
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}*/

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}

	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	/**
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}

	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}

	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}

	/**
	 * @return the bedNumber
	 */
	public String getBedNumber() {
		return bedNumber;
	}

	/**
	 * @param bedNumber the bedNumber to set
	 */
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	
}
