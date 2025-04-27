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
import java.util.ArrayList;

/**
 * @author vchoughule 
 *
 */
/**
 * @author vchoughule
 *
 */
public abstract class  AppointmentDetailItem {
	private  String patientId;
	private String patientName;
	private String patientSex;
	private String patientAge;
	private Date bookingDate;
	private Date startTime;// to change name to startTime
	private Date endTime;// to change to endTime
	private Date appointmentDuration;// aaptDuration
	private String facilityId;
	private String faciltityDesc;
	/*private String visitType; // it is first visit or follow up(type_code) TODO - Remove from here added in OPApptDeatilItem
	private String visitDesc; *///TODO - Remove from here added in OPApptDeatilItem
	private String locationId;
	private String locationDesc;
	private String appointmentType; // ot or op
	private ArrayList appointmentDetail;
	private String apptBlockCount;
	private String specialityDesc;
	/*private String procedureDetail;// TODO - Remove from here added in OTApptDeatilItem
	private String timeTableType; //TODO - Remove from here added in OPApptDeatilItem
	private String practRole;//TODO - Remove from here added in OTApptDeatilItem
	private String operationType; //TODO - Remove from here added in OPApptDeatilItem
*/	private String patientType ; // ip or op
	private String bookingNo; //for OP-booking number, for OT - Appt ref number
	private ArrayList<OPApptDetailItem> opApptDetailItemList ;
	private ArrayList<OTApptDetailItem> otApptDetailItemList;
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
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * @return the patientSex
	 */
	public String getPatientSex() {
		return patientSex;
	}
	/**
	 * @param patientSex the patientSex to set
	 */
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	/**
	 * @return the patientAge
	 */
	public String getPatientAge() {
		return patientAge;
	}
	/**
	 * @param patientAge the patientAge to set
	 */
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
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
	/**
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
	}
	*//**
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
	 * @return the appointmentDetail
	 */
	public ArrayList getAppointmentDetail() {
		return appointmentDetail;
	}
	/**
	 * @param appointmentDetail the appointmentDetail to set
	 */
	public void setAppointmentDetail(ArrayList appointmentDetail) {
		this.appointmentDetail = appointmentDetail;
	}
	/**
	 * @return the apptBlockCount
	 */
	public String getApptBlockCount() {
		return apptBlockCount;
	}
	/**
	 * @param apptBlockCount the apptBlockCount to set
	 */
	public void setApptBlockCount(String apptBlockCount) {
		this.apptBlockCount = apptBlockCount;
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
	 * @return the timeTableType
	 *//*
	public String getTimeTableType() {
		return timeTableType;
	}
	*//**
	 * @param timeTableType the timeTableType to set
	 *//*
	public void setTimeTableType(String timeTableType) {
		this.timeTableType = timeTableType;
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
	 * @return the patientType
	 */
	public String getPatientType() {
		return patientType;
	}
	/**
	 * @param patientType the patientType to set
	 */
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}
	/**
	 * @param bookingNo the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	/**
	 * @return the opApptDetailItemList
	 */
	public ArrayList<OPApptDetailItem> getOpApptDetailItemList() {
		return opApptDetailItemList;
	}
	/**
	 * @param opApptDetailItemList the opApptDetailItemList to set
	 */
	public void setOpApptDetailItemList(
			ArrayList<OPApptDetailItem> opApptDetailItemList) {
		this.opApptDetailItemList = opApptDetailItemList;
	}
	/**
	 * @return the otApptDetailItemList
	 */
	public ArrayList<OTApptDetailItem> getOtApptDetailItemList() {
		return otApptDetailItemList;
	}
	/**
	 * @param otApptDetailItemList the otApptDetailItemList to set
	 */
	public void setOtApptDetailItemList(
			ArrayList<OTApptDetailItem> otApptDetailItemList) {
		this.otApptDetailItemList = otApptDetailItemList;
	}


}
