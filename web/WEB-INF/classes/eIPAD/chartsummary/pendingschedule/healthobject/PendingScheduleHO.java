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
package eIPAD.chartsummary.pendingschedule.healthobject;

/**
 * @author SaraswathiR 
 *
 */
public class PendingScheduleHO {
	
	private String appointmentDate;
	private String fromTime;
	private String toTime;
	private String locationDesc;
	private String specialityDesc;
	private String resourceName;
	private String appointmentRefNo;
	private int secResourceCount;
	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}
	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	/**
	 * @return the fromTime
	 */
	public String getFromTime() {
		return fromTime;
	}
	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * @return the toTime
	 */
	public String getToTime() {
		return toTime;
	}
	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	/**
	 * @return the locationDesc
	 */
	public String getLocationDesc() {
		return locationDesc;
	}
	/**
	 * @param locationDesc the locationDesc to set
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	/**
	 * @return the specialityDesc
	 */
	public String getSpecialityDesc() {
		return specialityDesc;
	}
	/**
	 * @param specialityDesc the specialityDesc to set
	 */
	public void setSpecialityDesc(String specialityDesc) {
		this.specialityDesc = specialityDesc;
	}
	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/**
	 * @return the appointmentRefNo
	 */
	public String getAppointmentRefNo() {
		return appointmentRefNo;
	}
	/**
	 * @param appointmentRefNo the appointmentRefNo to set
	 */
	public void setAppointmentRefNo(String appointmentRefNo) {
		this.appointmentRefNo = appointmentRefNo;
	}
	/**
	 * @return the secResourceCount
	 */
	public int getSecResourceCount() {
		return secResourceCount;
	}
	/**
	 * @param secResourceCount the secResourceCount to set
	 */
	public void setSecResourceCount(int secResourceCount) {
		this.secResourceCount = secResourceCount;
	}
	

}
