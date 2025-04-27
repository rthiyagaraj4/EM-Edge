/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
public class CreateNotesRequest implements java.io.Serializable {
	private HttpServletRequest request;
	private HttpSession session;	
	private String sFacilityId;
	private String sEncounterId;
	private String sPatientId;
	private String sClinicianId;
	private String sPracType;
	private String sLocale;
	private String sFromDate;
	private String sTodate;
	private String sPeriod;
	private String sEncounterCheck;
	private String sChartId;
	private String sAge;
	private String sGender;
	private String sDob;
	private String sPatientClass;
	private String sFilterBy;
	private String applTaskID;
	private String sRespId;
	private String sNoteType;
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
	/**
	 * @return the sFacilityId
	 */
	public String getFacilityId() {
		return sFacilityId;
	}
	/**
	 * @param sFacilityId the sFacilityId to set
	 */
	public void setFacilityId(String sFacilityId) {
		this.sFacilityId = sFacilityId;
	}
	/**
	 * @return the sEncounterId
	 */
	public String getEncounterId() {
		return sEncounterId;
	}
	/**
	 * @param sEncounterId the sEncounterId to set
	 */
	public void setEncounterId(String sEncounterId) {
		this.sEncounterId = sEncounterId;
	}
	/**
	 * @return the sPatientId
	 */
	public String getPatientId() {
		return sPatientId;
	}
	/**
	 * @param sPatientId the sPatientId to set
	 */
	public void setPatientId(String sPatientId) {
		this.sPatientId = sPatientId;
	}
	/**
	 * @return the sClinicianId
	 */
	public String getClinicianId() {
		return sClinicianId;
	}
	/**
	 * @param sClinicianId the sClinicianId to set
	 */
	public void setClinicianId(String sClinicianId) {
		this.sClinicianId = sClinicianId;
	}
	/**
	 * @return the sPracType
	 */
	public String getPracType() {
		return sPracType;
	}
	/**
	 * @param sPracType the sPracType to set
	 */
	public void setPracType(String sPracType) {
		this.sPracType = sPracType;
	}
	/**
	 * @return the sLocale
	 */
	public String getLocale() {
		return sLocale;
	}
	/**
	 * @param sLocale the sLocale to set
	 */
	public void setLocale(String sLocale) {
		this.sLocale = sLocale;
	}
	/**
	 * @return the sFromDate
	 */
	public String getFromDate() {
		return sFromDate;
	}
	/**
	 * @param sFromDate the sFromDate to set
	 */
	public void setFromDate(String sFromDate) {
		this.sFromDate = sFromDate;
	}
	/**
	 * @return the sTodate
	 */
	public String getTodate() {
		return sTodate;
	}
	/**
	 * @param sTodate the sTodate to set
	 */
	public void setTodate(String sTodate) {
		this.sTodate = sTodate;
	}
	/**
	 * @return the sPeriod
	 */
	public String getPeriod() {
		return sPeriod;
	}
	/**
	 * @param sPeriod the sPeriod to set
	 */
	public void setPeriod(String sPeriod) {
		this.sPeriod = sPeriod;
	}
	/**
	 * @return the sEncounterCheck
	 */
	public String getEncounterCheck() {
		return sEncounterCheck;
	}
	/**
	 * @param sEncounterCheck the sEncounterCheck to set
	 */
	public void setEncounterCheck(String sEncounterCheck) {
		this.sEncounterCheck = sEncounterCheck;
	}
	/**
	 * @return the sChartId
	 */
	public String getChartId() {
		return sChartId;
	}
	/**
	 * @param sChartId the sChartId to set
	 */
	public void setChartId(String sChartId) {
		this.sChartId = sChartId;
	}
	/**
	 * @return the sAge
	 */
	public String getAge() {
		return sAge;
	}
	/**
	 * @param sAge the sAge to set
	 */
	public void setAge(String sAge) {
		this.sAge = sAge;
	}
	/**
	 * @return the sGender
	 */
	public String getGender() {
		return sGender;
	}
	/**
	 * @param sGender the sGender to set
	 */
	public void setGender(String sGender) {
		this.sGender = sGender;
	}
	/**
	 * @return the sDob
	 */
	public String getDob() {
		return sDob;
	}
	/**
	 * @param sDob the sDob to set
	 */
	public void setDob(String sDob) {
		this.sDob = sDob;
	}
	/**
	 * @return the sPatientClass
	 */
	public String getPatientClass() {
		return sPatientClass;
	}
	/**
	 * @param sPatientClass the sPatientClass to set
	 */
	public void setPatientClass(String sPatientClass) {
		this.sPatientClass = sPatientClass;
	}
	/**
	 * @return the sFilterBy
	 */
	public String getFilterBy() {
		return sFilterBy;
	}
	/**
	 * @param sFilterBy the sFilterBy to set
	 */
	public void setFilterBy(String sFilterBy) {
		this.sFilterBy = sFilterBy;
	}
	/**
	 * @return the applTaskID
	 */
	public String getApplTaskID() {
		return applTaskID;
	}
	/**
	 * @param applTaskID the applTaskID to set
	 */
	public void setApplTaskID(String applTaskID) {
		this.applTaskID = applTaskID;
	}
	/**
	 * @return the sRespId
	 */
	public String getRespId() {
		return sRespId;
	}
	/**
	 * @param sRespId the sRespId to set
	 */
	public void setRespId(String sRespId) {
		this.sRespId = sRespId;
	}
	/**
	 * @return the sNoteType
	 */
	public String getNoteType() {
		return sNoteType;
	}
	/**
	 * @param sNoteType the sNoteType to set
	 */
	public void setNoteType(String sNoteType) {
		this.sNoteType = sNoteType;
	}

}
