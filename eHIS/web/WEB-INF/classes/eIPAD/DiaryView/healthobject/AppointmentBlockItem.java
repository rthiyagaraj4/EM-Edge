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
package eIPAD.DiaryView.healthobject;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * @author Vivek C 
 *
 */
public class AppointmentBlockItem {
	/*private  String patientId;
	private String patientName;
	private String patientSex;
	private String patientAge;*/
	private Date bookingDate;
	private Date startTime;// to change name to startTime
	private Date endTime;// to change to endTime
	private Date appointmentDuration;// aaptDuration
	private String facilityId;
	private String faciltityDesc;
	/*private String visitType; // it is first visit or follow up(type_code)
	private String visitDesc;*/
	private String locationId;
	private String locationDesc;
	private String appointmentType; // ot or op
	/*private ArrayList<AppointmentDetailItem> appointmentDetail;*/
	private int apptDetailCount;
	private int hourCount;
	private int minCount;
	private String specialityDesc;
	private String timeTableType;
	private ArrayList<OPApptDetailItem> opapptDetailList;
	private ArrayList<OTApptDetailItem> otapptDetailList;
	/*private String procedureDetail;
	private String practRole;
	private String operationType;*/
	/**
	 * @return the patientId
	 *//*
	public String getPatientId() {
		return patientId;
	}
	*//**
	 * @param patientId the patientId to set
	 *//*
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	*//**
	 * @return the patientName
	 *//*
	public String getPatientName() {
		return patientName;
	}
	*//**
	 * @param patientName the patientName to set
	 *//*
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	*//**
	 * @return the patientSex
	 *//*
	public String getPatientSex() {
		return patientSex;
	}
	*//**
	 * @param patientSex the patientSex to set
	 *//*
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	*//**
	 * @return the patientAge
	 *//*
	public String getPatientAge() {
		return patientAge;
	}
	*//**
	 * @param patientAge the patientAge to set
	 *//*
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	*//**
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
	 * @return the faciltityDesc
	 */
	public String getFaciltityDesc() {
		return faciltityDesc;
	}
	/**
	 * @param faciltityDesc the faciltityDesc to set
	 */
	public void setFaciltityDesc(String faciltityDesc) {
		this.faciltityDesc = faciltityDesc;
	}
/*	*//**
	 * @return the visitType
	 *//*
	public String getVisitType() {
		return visitType;
	}
	*//**
	 * @param visitType the visitType to set
	 *//*
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}*/
	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
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
	 * @return the appointmentType
	 */
	public String getAppointmentType() {
		return appointmentType;
	}
	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	/**
	 * @return the appointmentDuration
	 */
	public Date getAppointmentDuration() {
		return appointmentDuration;
	}
	/**
	 * @param appointmentDuration the appointmentDuration to set
	 */
	public void setAppointmentDuration(Date appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}
	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
/*	*//**
	 * @return the visitDesc
	 *//*
	public String getVisitDesc() {
		return visitDesc;
	}
	*//**
	 * @param visitDesc the visitDesc to set
	 *//*
	public void setVisitDesc(String visitDesc) {
		this.visitDesc = visitDesc;
	}*/
	/**
	 * @return the appointmentDetail
	 */
	/*public ArrayList<AppointmentDetailItem> getAppointmentDetail() {
		return appointmentDetail;
	}*/
	/**
	 * @param appointmentDetail the appointmentDetail to set
	 */
	/*public void setAppointmentDetail(ArrayList<AppointmentDetailItem> appointmentDetail) {
		this.appointmentDetail = appointmentDetail;
	}*/
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the apptDetailCount
	 */
	public int getApptDetailCount() {
		return apptDetailCount;
	}
	/**
	 * @param apptDetailCount the apptDetailCount to set
	 */
	public void setApptDetailCount(int apptDetailCount) {
		this.apptDetailCount = apptDetailCount;
	}
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the hourCount
	 */
	public int getHourCount() {
		return hourCount;
	}
	/**
	 * @param hourCount the hourCount to set
	 */
	public void setHourCount(int hourCount) {
		this.hourCount = hourCount;
	}
	/**
	 * @return the minCount
	 */
	public int getMinCount() {
		return minCount;
	}
	/**
	 * @param minCount the minCount to set
	 */
	public void setMinCount(int minCount) {
		this.minCount = minCount;
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
	 * @return the timeTableType
	 */
	public String getTimeTableType() {
		return timeTableType;
	}
	/**
	 * @param timeTableType the timeTableType to set
	 */
	public void setTimeTableType(String timeTableType) {
		this.timeTableType = timeTableType;
	}
	/**//**
	 * @return the procedureDetail
	 *//*
	public String getProcedureDetail() {
		return procedureDetail;
	}
	*//**
	 * @param procedureDetail the procedureDetail to set
	 *//*
	public void setProcedureDetail(String procedureDetail) {
		this.procedureDetail = procedureDetail;
	}

	*//**
	 * @return the practRole
	 *//*
	public String getPractRole() {
		return practRole;
	}
	*//**
	 * @param practRole the practRole to set
	 *//*
	public void setPractRole(String practRole) {
		this.practRole = practRole;
	}
	*//**
	 * @return the operationType
	 *//*
	public String getOperationType() {
		return operationType;
	}
	*//**
	 * @param operationType the operationType to set
	 *//*
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}*/
	/**
	 * @return the opapptDetailList
	 */
	public ArrayList<OPApptDetailItem> getOpapptDetailList() {
		return opapptDetailList;
	}
	/**
	 * @param opapptDetailList the opapptDetailList to set
	 */
	public void setOpapptDetailList(ArrayList<OPApptDetailItem> opapptDetailList) {
		this.opapptDetailList = opapptDetailList;
	}
	/**
	 * @return the otapptDetailList
	 */
	public ArrayList<OTApptDetailItem> getOtapptDetailList() {
		return otapptDetailList;
	}
	/**
	 * @param otapptDetailList the otapptDetailList to set
	 */
	public void setOtapptDetailList(ArrayList<OTApptDetailItem> otapptDetailList) {
		this.otapptDetailList = otapptDetailList;
	}
	
}
