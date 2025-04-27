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
public class RecentClinicalNotesHO implements java.io.Serializable {
	private String facilityId;
	private String accessionNum;
	private String noteType;
	private String noteTypeDesc;
	private String docLinkedNoteYN;
	private String serviceCode;
	private String serviceName;
	private String eventDateTime;
	private String performedById;
	private String performedByName;
	private String authorizedById;
	private String authorizedByName;
	private String noteContent;
	private String eventStatus;
	private String operationsAllowed;
	private String ammendmentType;
	private String privilegeType;
	private String modifiedId;
	private String docRefId;
	private String encline;
	private String encounterId;
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
	 * @return the accessionNum
	 */
	public String getAccessionNum() {
		return accessionNum;
	}
	/**
	 * @param accessionNum the accessionNum to set
	 */
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}
	/**
	 * @return the noteType
	 */
	public String getNoteType() {
		return noteType;
	}
	/**
	 * @param noteType the noteType to set
	 */
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	/**
	 * @return the noteTypeDesc
	 */
	public String getNoteTypeDesc() {
		return noteTypeDesc;
	}
	/**
	 * @param noteTypeDesc the noteTypeDesc to set
	 */
	public void setNoteTypeDesc(String noteTypeDesc) {
		this.noteTypeDesc = noteTypeDesc;
	}
	/**
	 * @return the docLinkedNoteYN
	 */
	public String getDocLinkedNoteYN() {
		return docLinkedNoteYN;
	}
	/**
	 * @param docLinkedNoteYN the docLinkedNoteYN to set
	 */
	public void setDocLinkedNoteYN(String docLinkedNoteYN) {
		this.docLinkedNoteYN = docLinkedNoteYN;
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
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the eventDateTime
	 */
	public String getEventDateTime() {
		return eventDateTime;
	}
	/**
	 * @param eventDateTime the eventDateTime to set
	 */
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	/**
	 * @return the performedById
	 */
	public String getPerformedById() {
		return performedById;
	}
	/**
	 * @param performedById the performedById to set
	 */
	public void setPerformedById(String performedById) {
		this.performedById = performedById;
	}
	/**
	 * @return the performedByName
	 */
	public String getPerformedByName() {
		return performedByName;
	}
	/**
	 * @param performedByName the performedByName to set
	 */
	public void setPerformedByName(String performedByName) {
		this.performedByName = performedByName;
	}
	/**
	 * @return the authorizedById
	 */
	public String getAuthorizedById() {
		return authorizedById;
	}
	/**
	 * @param authorizedById the authorizedById to set
	 */
	public void setAuthorizedById(String authorizedById) {
		this.authorizedById = authorizedById;
	}
	/**
	 * @return the authorizedByName
	 */
	public String getAuthorizedByName() {
		return authorizedByName;
	}
	/**
	 * @param authorizedByName the authorizedByName to set
	 */
	public void setAuthorizedByName(String authorizedByName) {
		this.authorizedByName = authorizedByName;
	}
	/**
	 * @return the noteContent
	 */
	public String getNoteContent() {
		return noteContent;
	}
	/**
	 * @param noteContent the noteContent to set
	 */
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	/**
	 * @return the eventStatus
	 */
	public String getEventStatus() {
		return eventStatus;
	}
	/**
	 * @param eventStatus the eventStatus to set
	 */
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	/**
	 * @return the operationsAllowed
	 */
	public String getOperationsAllowed() {
		return operationsAllowed;
	}
	/**
	 * @param operationsAllowed the operationsAllowed to set
	 */
	public void setOperationsAllowed(String operationsAllowed) {
		this.operationsAllowed = operationsAllowed;
	}
	/**
	 * @return the ammendmentType
	 */
	public String getAmmendmentType() {
		return ammendmentType;
	}
	/**
	 * @param ammendmentType the ammendmentType to set
	 */
	public void setAmmendmentType(String ammendmentType) {
		this.ammendmentType = ammendmentType;
	}
	/**
	 * @return the privilegeType
	 */
	public String getPrivilegeType() {
		return privilegeType;
	}
	/**
	 * @param privilegeType the privilegeType to set
	 */
	public void setPrivilegeType(String privilegeType) {
		this.privilegeType = privilegeType;
	}
	/**
	 * @return the modifiedId
	 */
	public String getModifiedId() {
		return modifiedId;
	}
	/**
	 * @param modifiedId the modifiedId to set
	 */
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	/**
	 * @return the docRefId
	 */
	public String getDocRefId() {
		return docRefId;
	}
	/**
	 * @param docRefId the docRefId to set
	 */
	public void setDocRefId(String docRefId) {
		this.docRefId = docRefId;
	}
	/**
	 * @return the encline
	 */
	public String getEncline() {
		return encline;
	}
	/**
	 * @param encline the encline to set
	 */
	public void setEncline(String encline) {
		this.encline = encline;
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

}
