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
package portalrefimpl.schedule.rescheduleappointment.request;

import portalrefimpl.schedule.common.request.AppointmentRequest;

/**
 * this is the request class for reschedule appointment service
 * @author GRamamoorthy
 *
 */
public class RescheduleAppointmentRequest extends AppointmentRequest {

	/**
	 * Data members in this class
	 */
	private String appointmentReferenceNumber = null;
	
	private String modifiedFacilityId = null;
	
	private String careLocationTypeIndicator = null;
	
	private String modifyReasonCode = null;
	
	
	/**
	 * @return the appointmentReferenceNumber
	 */
	public String getAppointmentReferenceNumber() {
		return appointmentReferenceNumber;
	}

	/**
	 * @param appointmentReferenceNumber the appointmentReferenceNumber to set
	 */
	public void setAppointmentReferenceNumber(String appointmentReferenceNumber) {
		this.appointmentReferenceNumber = appointmentReferenceNumber;
	}

	/**
	 * @return the modifiedFacilityId
	 */
	public String getModifiedFacilityId() {
		return modifiedFacilityId;
	}

	/**
	 * @param modifiedFacilityId the modifiedFacilityId to set
	 */
	public void setModifiedFacilityId(String modifiedFacilityId) {
		this.modifiedFacilityId = modifiedFacilityId;
	}

	/**
	 * @return the careLocationTypeIndicator
	 */
	public String getCareLocationTypeIndicator() {
		return careLocationTypeIndicator;
	}

	/**
	 * @param careLocationTypeIndicator the careLocationTypeIndicator to set
	 */
	public void setCareLocationTypeIndicator(String careLocationTypeIndicator) {
		this.careLocationTypeIndicator = careLocationTypeIndicator;
	}

	/**
	 * @return the modifyReasonCode
	 */
	public String getModifyReasonCode() {
		return modifyReasonCode;
	}

	/**
	 * @param modifyReasonCode the modifyReasonCode to set
	 */
	public void setModifyReasonCode(String modifyReasonCode) {
		this.modifyReasonCode = modifyReasonCode;
	}

}
