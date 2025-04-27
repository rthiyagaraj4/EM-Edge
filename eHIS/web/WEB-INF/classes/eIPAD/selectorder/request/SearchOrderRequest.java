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
public class SearchOrderRequest implements java.io.Serializable {
	private String patientId;
	private String encounterId;
	private String facilityId;
	private String patientClass;
	private String episodeVisitNum;
	private String clinicianId;
	private String responisibilityId;
	private String privilegeYN;
	private String languageId;
	private String synonymType;
	private String practionerType;
	private String orderCategory;
	private String orderCatalogNature;
	private String orderText;
	private String gender;
	private String DOB;
	private String admitDate;
	private String dischargeDateTime;
	private String dischargeAdviceDateTime;
	private String servicecode;
	private String locationCode;
	private String locationType;
	private String restrictBy;
	private String medicoLegalYN;
	private String callingFrom;
	private HttpServletRequest request;
	private HttpSession session;
	private String episodeId;
	private String criteria;
	private String orderType;
	private String activityType;
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
	 * @return the encounterId
	 */
	public String getEncounterId() {
		return encounterId;
	}
	/**
	 * @param encounterId the encounterId to set
	 */
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
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
	 * @return the patientClass
	 */
	public String getPatientClass() {
		return patientClass;
	}
	/**
	 * @param patientClass the patientClass to set
	 */
	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}
	/**
	 * @return the episodeVisitNum
	 */
	public String getEpisodeVisitNum() {
		return episodeVisitNum;
	}
	/**
	 * @param episodeVisitNum the episodeVisitNum to set
	 */
	public void setEpisodeVisitNum(String episodeVisitNum) {
		this.episodeVisitNum = episodeVisitNum;
	}
	/**
	 * @return the clinicianId
	 */
	public String getClinicianId() {
		return clinicianId;
	}
	/**
	 * @param clinicianId the clinicianId to set
	 */
	public void setClinicianId(String clinicianId) {
		this.clinicianId = clinicianId;
	}
	/**
	 * @return the responisibilityId
	 */
	public String getResponisibilityId() {
		return responisibilityId;
	}
	/**
	 * @param responisibilityId the responisibilityId to set
	 */
	public void setResponisibilityId(String responisibilityId) {
		this.responisibilityId = responisibilityId;
	}
	
	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	/**
	 * @return the synonymType
	 */
	public String getSynonymType() {
		return synonymType;
	}
	/**
	 * @param synonymType the synonymType to set
	 */
	public void setSynonymType(String synonymType) {
		this.synonymType = synonymType;
	}
	/**
	 * @return the practionerType
	 */
	public String getPractionerType() {
		return practionerType;
	}
	/**
	 * @param practionerType the practionerType to set
	 */
	public void setPractionerType(String practionerType) {
		this.practionerType = practionerType;
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
	 * @return the orderCatalogNature
	 */
	public String getOrderCatalogNature() {
		return orderCatalogNature;
	}
	/**
	 * @param orderCatalogNature the orderCatalogNature to set
	 */
	public void setOrderCatalogNature(String orderCatalogNature) {
		this.orderCatalogNature = orderCatalogNature;
	}
	/**
	 * @return the orderText
	 */
	public String getOrderText() {
		return orderText;
	}
	/**
	 * @param orderText the orderText to set
	 */
	public void setOrderText(String orderText) {
		this.orderText = orderText;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * @return the admitDate
	 */
	public String getAdmitDate() {
		return admitDate;
	}
	/**
	 * @param admitDate the admitDate to set
	 */
	public void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}
	/**
	 * @return the dischargeDateTime
	 */
	public String getDischargeDateTime() {
		return dischargeDateTime;
	}
	/**
	 * @param dischargeDateTime the dischargeDateTime to set
	 */
	public void setDischargeDateTime(String dischargeDateTime) {
		this.dischargeDateTime = dischargeDateTime;
	}
	/**
	 * @return the dischargeAdviceDateTime
	 */
	public String getDischargeAdviceDateTime() {
		return dischargeAdviceDateTime;
	}
	/**
	 * @param dischargeAdviceDateTime the dischargeAdviceDateTime to set
	 */
	public void setDischargeAdviceDateTime(String dischargeAdviceDateTime) {
		this.dischargeAdviceDateTime = dischargeAdviceDateTime;
	}
	/**
	 * @return the servicecode
	 */
	public String getServicecode() {
		return servicecode;
	}
	/**
	 * @param servicecode the servicecode to set
	 */
	public void setServicecode(String servicecode) {
		this.servicecode = servicecode;
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
	 * @return the restrictBy
	 */
	public String getRestrictBy() {
		return restrictBy;
	}
	/**
	 * @param restrictBy the restrictBy to set
	 */
	public void setRestrictBy(String restrictBy) {
		this.restrictBy = restrictBy;
	}
	/**
	 * @return the medicoLegalYN
	 */
	public String getMedicoLegalYN() {
		return medicoLegalYN;
	}
	/**
	 * @param medicoLegalYN the medicoLegalYN to set
	 */
	public void setMedicoLegalYN(String medicoLegalYN) {
		this.medicoLegalYN = medicoLegalYN;
	}
	/**
	 * @return the callingFrom
	 */
	public String getCallingFrom() {
		return callingFrom;
	}
	/**
	 * @param callingFrom the callingFrom to set
	 */
	public void setCallingFrom(String callingFrom) {
		this.callingFrom = callingFrom;
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
	/**
	 * @return the privilegeYN
	 */
	public String getPrivilegeYN() {
		return privilegeYN;
	}
	/**
	 * @param privilegeYN the privilegeYN to set
	 */
	public void setPrivilegeYN(String privilegeYN) {
		this.privilegeYN = privilegeYN;
	}
	/**
	 * @return the episodeId
	 */
	public String getEpisodeId() {
		return episodeId;
	}
	/**
	 * @param episodeId the episodeId to set
	 */
	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}
	/**
	 * @return the criteria
	 */
	public String getCriteria() {
		return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the activityType
	 */
	public String getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

}
