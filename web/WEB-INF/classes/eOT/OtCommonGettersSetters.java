/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.Serializable;

import eOT.Common.OTAdapter;

public class OtCommonGettersSetters  extends OTAdapter implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String patientId = "";
	private String patientShortName = "";
	private String patientSex = "";
	private String orderId = "";
	private String specialityCode = "";
	private String specialityDesc = "";
	private String surgeonCode = "";
	private String surgeonName = "";
	private String surgeryType = "";
	private String operCode = "";
	private String operShortDesc = "";
	private String operLongDesc = "";
	private String physicianId = "";
	private String fromTime = "";
	private String toTime = "";
	private String fromDateTime = "";
	private String anesthesiaRequired = "";
	private String languageId = "";
	private String patientClass = "";
	private String bookingNum = "";
	private String bookingDate = "";
	private String bookingTime = "";
	private String bookingDateTime = "";
	private String operRoomCode = "";
	private String operRoomDesc = "";
	
	//MMS-QH-CRF-186
	
	private String pref_surg_date="";
	private String EncounterId="";
	private String EncounterDateTime="";
	private String OverBookedStatus="";

	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientShortName() {
		return patientShortName;
	}
	public void setPatientShortName(String patientShortName) {
		this.patientShortName = patientShortName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSpecialityCode() {
		return specialityCode;
	}
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}
	public String getSpecialityDesc() {
		return specialityDesc;
	}
	public void setSpecialityDesc(String specialityDesc) {
		this.specialityDesc = specialityDesc;
	}
	public String getSurgeonCode() {
		return surgeonCode;
	}
	public void setSurgeonCode(String surgeonCode) {
		this.surgeonCode = surgeonCode;
	}
	public String getSurgeonName() {
		return surgeonName;
	}
	public void setSurgeonName(String surgeonName) {
		this.surgeonName = surgeonName;
	}
	public String getSurgeryType() {
		return surgeryType;
	}
	public void setSurgeryType(String surgeryType) {
		this.surgeryType = surgeryType;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public String getOperShortDesc() {
		return operShortDesc;
	}
	public void setOperShortDesc(String operShortDesc) {
		this.operShortDesc = operShortDesc;
	}
	public String getOperLongDesc() {
		return operLongDesc;
	}
	public void setOperLongDesc(String operLongDesc) {
		this.operLongDesc = operLongDesc;
	}
	public String getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public String getAnesthesiaRequired() {
		return anesthesiaRequired;
	}
	public void setAnesthesiaRequired(String anesthesiaRequired) {
		this.anesthesiaRequired = anesthesiaRequired;
	}
	public String getLanguageId() {
		return languageId;
	}
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	public String getPatientClass() {
		return patientClass;
	}
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	public String getBookingNum() {
		return bookingNum;
	}
	public void setBookingNum(String bookingNum) {
		this.bookingNum = bookingNum;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getBookingDateTime() {
		return bookingDateTime;
	}
	public void setBookingDateTime(String bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}
	public String getOperRoomCode() {
		return operRoomCode;
	}
	public void setOperRoomCode(String operRoomCode) {
		this.operRoomCode = operRoomCode;
	}
	public String getOperRoomDesc() {
		return operRoomDesc;
	}
	public void setOperRoomDesc(String operRoomDesc) {
		this.operRoomDesc = operRoomDesc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	//MMS-QH-CRF-186
	public void setPreferSurgeryDate(String pref_surg_date) {
		this.pref_surg_date = pref_surg_date;
	}
	public String getPreferSurgeryDate() {
		return pref_surg_date;
	}
	
	public void setEncounterId(String EncounterId) {
		this.EncounterId = EncounterId;
	}
	public String getEncounterId() {
		return EncounterId;
	}
	public void setEncounterDateTime(String EncounterDateTime) {
		this.EncounterDateTime = EncounterDateTime;
	}
	public String getEncounterDateTime() {
		return EncounterDateTime;
	}
	//MMS-QH-CRF-186
	//OverBookedStatus
	public void setOverBookedStatus(String OverBookedStatus) {
		this.OverBookedStatus = OverBookedStatus;
	}
	public String getOverBookedStatus() {
		return OverBookedStatus;
	}
}
