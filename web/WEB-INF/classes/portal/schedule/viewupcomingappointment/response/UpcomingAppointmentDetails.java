/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.response;

import portal.schedule.viewappointment.response.AppointmentDetails;

/**
 * This class is contains upcoming appointment 
 * information of a given upcoming appointment
 * @author vkodancha
 *
 */
public class UpcomingAppointmentDetails extends AppointmentDetails{
	private String location;
	private String facilityName;
	private String facilityId;
	private String status;
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}
	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Over riding for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Appointment Date "+getAppointmentDate());
		sb.append("Practitioner "+getPractitioner());
		sb.append("Speciality "+getApptSpeciality());
		sb.append("Appointment start Time "+getApptStartTime());
		sb.append("Appointment end Time "+getApptEndTime());
		sb.append("Appt Number "+getApptNumber());
		sb.append("Location "+getLocation());
		sb.append("facility Name "+getFacilityName());
		sb.append("facility Id "+getFacilityId());
		sb.append("status : "+getStatus());
		return sb.toString();
	}
}
