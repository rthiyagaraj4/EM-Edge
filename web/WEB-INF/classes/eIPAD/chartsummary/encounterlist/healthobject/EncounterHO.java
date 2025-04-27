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
package eIPAD.chartsummary.encounterlist.healthobject;

/**
 * @author SaraswathiR  
 *
 */
public class EncounterHO {

	private String visitDate;
	private String fromDate;
	private String toDate;
	private String assignCareLocnType;
	private String assignCareLocnCode;
	private String attendPractitionerId;
	private String facilityDesc;
	private String serviceDesc;
	private String careLocationDesc;
	private String practFullName;
	private String practShortName;
	private String facilityId;
	private String patientClass;
	private String encounterId;
	private String relationshipId;
	private String specialtyCode;
	private String roomNum;
	private String bedNum;
	
	/**
	 * @return the roomNum
	 */
	public String getRoomNum() {
		return roomNum;
	}
	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	/**
	 * @return the bedNum
	 */
	public String getBedNum() {
		return bedNum;
	}
	/**
	 * @param bedNum the bedNum to set
	 */
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	/**
	 * @return the visitDate
	 */
	public boolean equals(Object o){
		EncounterHO encObj = (EncounterHO)o;
		String thisEncStr = this.encounterId + this.facilityId + this.visitDate;
		String objEncStr = encObj.getEncounterId() + encObj.getFacilityId() + encObj.getVisitDate();
		
		if(thisEncStr.equals(objEncStr)){
			return true;
		}else{
			return false;
		}
			
	}
	public String getVisitDate() {
		return visitDate;
	}
	/**
	 * @param visitDate the visitDate to set
	 */
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
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
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the assignCareLocnType
	 */
	public String getAssignCareLocnType() {
		return assignCareLocnType;
	}
	/**
	 * @param assignCareLocnType the assignCareLocnType to set
	 */
	public void setAssignCareLocnType(String assignCareLocnType) {
		this.assignCareLocnType = assignCareLocnType;
	}
	/**
	 * @return the assignCareLocnCode
	 */
	public String getAssignCareLocnCode() {
		return assignCareLocnCode;
	}
	/**
	 * @param assignCareLocnCode the assignCareLocnCode to set
	 */
	public void setAssignCareLocnCode(String assignCareLocnCode) {
		this.assignCareLocnCode = assignCareLocnCode;
	}
	/**
	 * @return the attendPractitionerId
	 */
	public String getAttendPractitionerId() {
		return attendPractitionerId;
	}
	/**
	 * @param attendPractitionerId the attendPractitionerId to set
	 */
	public void setAttendPractitionerId(String attendPractitionerId) {
		this.attendPractitionerId = attendPractitionerId;
	}
	/**
	 * @return the facilityDesc
	 */
	public String getFacilityDesc() {
		return facilityDesc;
	}
	/**
	 * @param facilityDesc the facilityDesc to set
	 */
	public void setFacilityDesc(String facilityDesc) {
		this.facilityDesc = facilityDesc;
	}
	/**
	 * @return the serviceDesc
	 */
	public String getServiceDesc() {
		return serviceDesc;
	}
	/**
	 * @param serviceDesc the serviceDesc to set
	 */
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	/**
	 * @return the careLocationDesc
	 */
	public String getCareLocationDesc() {
		return careLocationDesc;
	}
	/**
	 * @param careLocationDesc the careLocationDesc to set
	 */
	public void setCareLocationDesc(String careLocationDesc) {
		this.careLocationDesc = careLocationDesc;
	}
	/**
	 * @return the practFullName
	 */
	public String getPractFullName() {
		return practFullName;
	}
	/**
	 * @param practFullName the practFullName to set
	 */
	public void setPractFullName(String practFullName) {
		this.practFullName = practFullName;
	}
	/**
	 * @return the practShortName
	 */
	public String getPractShortName() {
		return practShortName;
	}
	/**
	 * @param practShortName the practShortName to set
	 */
	public void setPractShortName(String practShortName) {
		this.practShortName = practShortName;
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
	 * @return the relationshipId
	 */
	public String getRelationshipId() {
		return relationshipId;
	}
	/**
	 * @param relationshipId the relationshipId to set
	 */
	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}
	/**
	 * @return the specialtyCode
	 */
	public String getSpecialtyCode() {
		return specialtyCode;
	}
	/**
	 * @param specialtyCode the specialtyCode to set
	 */
	public void setSpecialtyCode(String specialtyCode) {
		this.specialtyCode = specialtyCode;
	}
	
}
