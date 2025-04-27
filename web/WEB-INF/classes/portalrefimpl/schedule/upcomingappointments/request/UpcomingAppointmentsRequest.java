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
package portalrefimpl.schedule.upcomingappointments.request;

import portalrefimpl.common.request.BaseRequest;

/**
 * This class is the request class for the view upcoming appointment details
 * service This class extends the BaseRequest class. The patientId data member
 * is needed and patientId is present inside BaseRequest itself hence it does
 * not include patientId
 * 
 * @author SaraswathiR
 * 
 */
public class UpcomingAppointmentsRequest extends BaseRequest {

	private int startRecordNum;

	private int endRecordNum;

	private String facilityId;

	private String fromDate;

	private String toDate;

	/**
	 * Default constructor of the class
	 */
	public UpcomingAppointmentsRequest() {

	}

	/**
	 * @return the startRecordNum
	 */
	public int getStartRecordNum() {
		return startRecordNum;
	}

	/**
	 * @param startRecordNum
	 *            the startRecordNum to set
	 */
	public void setStartRecordNum(int startRecordNum) {
		this.startRecordNum = startRecordNum;
	}

	/**
	 * @return the endRecordNum
	 */
	public int getEndRecordNum() {
		return endRecordNum;
	}

	/**
	 * @param endRecordNum
	 *            the endRecordNum to set
	 */
	public void setEndRecordNum(int endRecordNum) {
		this.endRecordNum = endRecordNum;
	}

	/**
	 * @return the facilityName
	 */
	public String getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityName
	 *            the facilityName to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
