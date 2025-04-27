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
package portalrefimpl.schedule.upcomingappointments.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author SaraswathiR
 * 
 */
@XmlRootElement(name = "AppointmentDetail")
@XmlType(propOrder = { "practitionerName", "apptSpeciality", "facilityName", "locationName", "appointmentNumber", "appointmentDate",
		"appointmentStartTime", "appointmentEndTime", "facilityId", "appointmentStatus" })
public class UpcomingAppointmentDetails {

	private String practitionerName;

	private String apptSpeciality;

	private String facilityName;

	private String locationName;

	private String appointmentNumber;

	private String appointmentDate;

	private String appointmentStartTime;

	private String appointmentEndTime;

	private String facilityId;

	private String appointmentStatus;

	/**
	 * Default constructor
	 */
	public UpcomingAppointmentDetails() {
	}

	/**
	 * @return the practitionerName
	 */
	@XmlElement(name = "practitioner")
	public String getPractitionerName() {
		return practitionerName;
	}

	/**
	 * @param practitionerName
	 *            the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}

	/**
	 * @return the apptSpeciality
	 */
	@XmlElement(name = "speciality")
	public String getApptSpeciality() {
		return apptSpeciality;
	}

	/**
	 * @param apptSpeciality
	 *            the apptSpeciality to set
	 */
	public void setApptSpeciality(String apptSpeciality) {
		this.apptSpeciality = apptSpeciality;
	}

	/**
	 * @return the facilityName
	 */
	@XmlElement(name = "facility")
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName
	 *            the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * @return the locationName
	 */
	@XmlElement(name = "location")
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the appointmentNumber
	 */
	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	/**
	 * @param appointmentNumber
	 *            the appointmentNumber to set
	 */
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	/**
	 * @return the appointmentStartTime
	 */
	@XmlElement(name = "startTime")
	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}

	/**
	 * @param appointmentStartTime
	 *            the appointmentStartTime to set
	 */
	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	/**
	 * @return the appointmentEndTime
	 */
	@XmlElement(name = "endTime")
	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}

	/**
	 * @param appointmentEndTime
	 *            the appointmentEndTime to set
	 */
	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId
	 *            the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate
	 *            the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the appointmentStatus
	 */
	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	/**
	 * @param appointmentStatus
	 *            the appointmentStatus to set
	 */
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

}
