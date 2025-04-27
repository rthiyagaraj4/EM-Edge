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
package portalrefimpl.schedule.common.request;

import portalrefimpl.common.request.BaseRequest;
import portalrefimpl.schedule.createappointment.appointmentrequest.ResponseContainer;
import portalrefimpl.schedule.createappointment.request.ExecutionStatus;

/**
 * This is the base class for the appointment features
 * This class extends BaseRequest
 * This class will be extended by specific request classes
 * for book appointment, cancel appointment and reschedule
 * appointment
 * @author GRamamoorthy
 *
 */
public class AppointmentRequest extends BaseRequest {

	/**
	 * Constants denoting the type of the request
	 */
	public static final int BOOKAPPOINTMENT_TYPE = 1;
	
	public static final int CANCELAPPOINTMENT_TYPE = 2;
	
	public static final int RESCHEDULEAPPOINTMENT_TYPE = 3;
	
	/**
	 * Stores the listener instance
	 */
	protected ResponseContainer responseContainer = null;

	/**
	 * Stores the type of the object
	 */
	protected int requestObjectType = -1;
	
	/**
	 * data members in this class
	 */
	protected String facilityId = null;
	
	protected String practitionerId = null;
	
	protected String preferredDate = null;
	
	protected String preferredFromTime = null;
	
	protected String preferredToTime = null;
	
	protected String specialityId = null;
	
	protected String locationCode = null;
	
	protected boolean abort = false;
	
	protected ExecutionStatus executionStatus = ExecutionStatus.IN_PROGRESS;
	
	protected AppointmentType appointmentType = AppointmentType.Appointment_Request;
	
	/**
	 * @return the responseListener
	 */
	public ResponseContainer getResponseContainer() {
		return responseContainer;
	}

	/**
	 * @param responseContainer the responseListener to set
	 */
	public void setResponseContainer(ResponseContainer responseContainer) {
		this.responseContainer = responseContainer;
	}

	/**
	 * @return the requestObjectType
	 */
	public int getRequestObjectType() {
		return requestObjectType;
	}

	/**
	 * @param requestObjectType the requestObjectType to set
	 */
	public void setRequestObjectType(int requestObjectType) {
		this.requestObjectType = requestObjectType;
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
	 * @return the preferredDate
	 */
	public String getPreferredDate() {
		return preferredDate;
	}

	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
		// adjust the preferred from time and to time
		/*if(preferredFromTime != null){
			preferredFromTime = this.preferredDate + " " + preferredFromTime; 
		}
		if(preferredToTime != null){
			preferredToTime = this.preferredDate + " " + preferredToTime;
		}*/
	}

	/**
	 * @return the preferredFromTime
	 */
	public String getPreferredFromTime() {
		return preferredFromTime;
	}

	/**
	 * @param preferredFromTime the preferredFromTime to set
	 */
	public void setPreferredFromTime(String preferredFromTime) {
		this.preferredFromTime = preferredFromTime;
		// adjust the preferred from time
		/*if(preferredDate != null){
			this.preferredFromTime = this.preferredDate + " " + preferredFromTime; 
		}*/
	}

	/**
	 * @return the preferredToTime
	 */
	public String getPreferredToTime() {
		return preferredToTime;
	}

	/**
	 * @param preferredToTime the preferredToTime to set
	 */
	public void setPreferredToTime(String preferredToTime) {
		this.preferredToTime = preferredToTime;
		// adjust the preferred from time
		/*if(preferredDate != null){
			this.preferredToTime = this.preferredDate + " " + preferredToTime; 
		}*/
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
	 * @return the specialityId
	 */
	public String getSpecialityId() {
		return specialityId;
	}

	/**
	 * @param specialityId the specialityId to set
	 */
	public void setSpecialityId(String specialityId) {
		this.specialityId = specialityId;
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
	 * @return the abort
	 */
	public boolean isAbort() {
		return abort;
	}

	/**
	 * @param abort the abort to set
	 */
	public void setAbort(boolean abort) {
		this.abort = abort;
	}

	/**
	 * @return the executionStatus
	 */
	public ExecutionStatus getExecutionStatus() {
		return executionStatus;
	}

	/**
	 * @param executionStatus the executionStatus to set
	 */
	public void setExecutionStatus(ExecutionStatus executionStatus) {
		this.executionStatus = executionStatus;
	}

	/**
	 * @return the appointmentType
	 */
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	
	
	
}
