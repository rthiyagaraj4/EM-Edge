/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class PendingSchedules implements java.io.Serializable {
	
	private String sPendingScheduleCount;
	private String sApptDate;
	private String sLocationDesc;
	private String sResourceName;
	private String sFromTime;
	private String sToTime;
	private String sDateTime;
	private String sLocation;
	private String sSpeciality;
	private String sVisitType;
	private String sAppointmentNumber;
	/**
	 * @return the sApptDate
	 */
	public String getsApptDate() {
		return sApptDate;
	}

	/**
	 * @param sApptDate the sApptDate to set
	 */
	public void setsApptDate(String sApptDate) {
		this.sApptDate = sApptDate;
	}

	/**
	 * @return the sLocationDesc
	 */
	public String getsLocationDesc() {
		return sLocationDesc;
	}

	/**
	 * @param sLocationDesc the sLocationDesc to set
	 */
	public void setsLocationDesc(String sLocationDesc) {
		this.sLocationDesc = sLocationDesc;
	}

	/**
	 * @return the sResourceName
	 */
	public String getsResourceName() {
		return sResourceName;
	}

	/**
	 * @param sResourceName the sResourceName to set
	 */
	public void setsResourceName(String sResourceName) {
		this.sResourceName = sResourceName;
	}

	/**
	 * @return the sPendingScheduleCount
	 */
	public String getsPendingScheduleCount() {
		return sPendingScheduleCount;
	}

	/**
	 * @param sPendingScheduleCount the sPendingScheduleCount to set
	 */
	public void setsPendingScheduleCount(String sPendingScheduleCount) {
		this.sPendingScheduleCount = sPendingScheduleCount;
	}

	/**
	 * @return the sFromTime
	 */
	public String getsFromTime() {
		return sFromTime;
	}

	/**
	 * @param sFromTime the sFromTime to set
	 */
	public void setsFromTime(String sFromTime) {
		this.sFromTime = sFromTime;
	}

	/**
	 * @return the sToTime
	 */
	public String getsToTime() {
		return sToTime;
	}

	/**
	 * @param sToTime the sToTime to set
	 */
	public void setsToTime(String sToTime) {
		this.sToTime = sToTime;
	}

	/**
	 * @return the sDateTime
	 */
	public String getsDateTime() {
		return sDateTime;
	}

	/**
	 * @param sDateTime the sDateTime to set
	 */
	public void setsDateTime(String sDateTime) {
		this.sDateTime = sDateTime;
	}

	/**
	 * @return the sLocation
	 */
	public String getsLocation() {
		return sLocation;
	}

	/**
	 * @param sLocation the sLocation to set
	 */
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}

	/**
	 * @return the sSpeciality
	 */
	public String getsSpeciality() {
		return sSpeciality;
	}

	/**
	 * @param sSpeciality the sSpeciality to set
	 */
	public void setsSpeciality(String sSpeciality) {
		this.sSpeciality = sSpeciality;
	}

	/**
	 * @return the sVisitType
	 */
	public String getsVisitType() {
		return sVisitType;
	}

	/**
	 * @param sVisitType the sVisitType to set
	 */
	public void setsVisitType(String sVisitType) {
		this.sVisitType = sVisitType;
	}

	/**
	 * @return the sAppointmentNumber
	 */
	public String getsAppointmentNumber() {
		return sAppointmentNumber;
	}

	/**
	 * @param sAppointmentNumber the sAppointmentNumber to set
	 */
	public void setsAppointmentNumber(String sAppointmentNumber) {
		this.sAppointmentNumber = sAppointmentNumber;
	}
}
