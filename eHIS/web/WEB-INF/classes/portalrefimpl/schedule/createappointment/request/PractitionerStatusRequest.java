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
 * This is the base request class for the practitioner schedule status 
 * and the practitioner time slot service
 * @author GRamamoorthy
 *
 */
public class PractitionerStatusRequest extends BaseRequest {

	/**
	 * Data members in this class
	 */
	protected String facilityId = null;
	
	protected String clinicCode = null;
	
	protected String practitionerId = null;
	
	protected String clinicType = null;
	
	protected String resourceType = null;
	

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
	 * @return the clinicCode
	 */
	public String getClinicCode() {
		return clinicCode;
	}

	/**
	 * @param clinicCode the clinicCode to set
	 */
	public void setClinicCode(String clinicCode) {
		this.clinicCode = clinicCode;
	}

	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @return the clinicType
	 */
	public String getClinicType() {
		return clinicType;
	}

	/**
	 * @param clinicType the clinicType to set
	 */
	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}

	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	
}
