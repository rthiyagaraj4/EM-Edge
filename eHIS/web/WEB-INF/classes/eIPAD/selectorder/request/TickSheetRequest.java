/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.request;

import javax.servlet.http.*;
public class TickSheetRequest implements java.io.Serializable {
	
	private HttpServletRequest request;
	private HttpSession session;
	private String clinicianID;
	private String orderCategory;
	private String serviceCode;
	private String facilityId;
	private String locationType;
	private String locationCode;
	private String languageID;
	private String orderTypeCode;
	private String tickSheetId;
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
	 * @return the clinicianID
	 */
	public String getClinicianID() {
		return clinicianID;
	}
	/**
	 * @param clinicianID the clinicianID to set
	 */
	public void setClinicianID(String clinicianID) {
		this.clinicianID = clinicianID;
	}
	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}
	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
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
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	/**
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * @return the languageID
	 */
	public String getLanguageID() {
		return languageID;
	}
	/**
	 * @param languageID the languageID to set
	 */
	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}
	/**
	 * @return the orderTypeCode
	 */
	public String getOrderTypeCode() {
		return orderTypeCode;
	}
	/**
	 * @param orderTypeCode the orderTypeCode to set
	 */
	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}
	/**
	 * @return the tickSheetId
	 */
	public String getTickSheetId() {
		return tickSheetId;
	}
	/**
	 * @param tickSheetId the tickSheetId to set
	 */
	public void setTickSheetId(String tickSheetId) {
		this.tickSheetId = tickSheetId;
	}
	
}
