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

public class InPatientContext {
private String sPatientId = "";
private  String sNursingUnitCode = "";
private  String sNursingUnit = "";
private  String sClinicianId = "";
private  String sClinicianDesc = "";
private String sSpecialityCode = "";
private String sSpeciality = "";
private String sOrderBy = "";
private String sFacilityId = "";
private String sPractionerId = "";
private String sPractionerDesc = "";
private HttpServletRequest request;
private HttpSession session;
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
 * @return the sNursingUnitCode
 */
public String getNursingUnitCode() {
	return sNursingUnitCode;
}
/**
 * @param sNursingUnitCode the sNursingUnitCode to set
 */
public void setNursingUnitCode(String sNursingUnitCode) {
	this.sNursingUnitCode = sNursingUnitCode;
}
/**
 * @return the sNursingUnit
 */
public String getNursingUnit() {
	return sNursingUnit;
}
/**
 * @param sNursingUnit the sNursingUnit to set
 */
public void setNursingUnit(String sNursingUnit) {
	this.sNursingUnit = sNursingUnit;
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
 * @return the sClinicianDesc
 */
public String getClinicianDesc() {
	return sClinicianDesc;
}
/**
 * @param sClinicianDesc the sClinicianDesc to set
 */
public void setClinicianDesc(String sClinicianDesc) {
	this.sClinicianDesc = sClinicianDesc;
}
/**
 * @return the sSpecialityCode
 */
public String getSpecialityCode() {
	return sSpecialityCode;
}
/**
 * @param sSpecialityCode the sSpecialityCode to set
 */
public void setSpecialityCode(String sSpecialityCode) {
	this.sSpecialityCode = sSpecialityCode;
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
public void setSpeciality(String sSpeciality) {
	this.sSpeciality = sSpeciality;
}
/**
 * @return the sOrderBy
 */
public String getOrderBy() {
	return sOrderBy;
}
/**
 * @param sOrderBy the sOrderBy to set
 */
public void setOrderBy(String sOrderBy) {
	this.sOrderBy = sOrderBy;
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
 * @return the sPractionerId
 */
public String getPractionerId() {
	return sPractionerId;
}
/**
 * @param sPractionerId the sPractionerId to set
 */
public void setPractionerId(String sPractionerId) {
	this.sPractionerId = sPractionerId;
}
/**
 * @return the sPractionerDesc
 */
public String getPractionerDesc() {
	return sPractionerDesc;
}
/**
 * @param sPractionerDesc the sPractionerDesc to set
 */
public void setPractionerDesc(String sPractionerDesc) {
	this.sPractionerDesc = sPractionerDesc;
}
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


}
