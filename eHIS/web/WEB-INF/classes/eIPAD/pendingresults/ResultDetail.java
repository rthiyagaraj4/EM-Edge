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
package eIPAD.pendingresults;

import java.io.Serializable;

/**
 * This bean is used for storing the result details
 * for pending result for review
 * @author GRamamoorthy
 *
 */
public class ResultDetail implements Serializable {

	
	private String eventName = null;
	
	private String reportedBy = null;
	
	private String reportedAt = null;
	
	private String resultNum = null;
	
	private String resultNumUom = null;
	
	private String result = null;
	
	private String resultStr = null;
		
	/**
	 * Stores the type of notes
	 */
	private String notesType = null;
	
	/**
	 * 
	 */
	private String accessionNum = null;
	
	private String orderingPractitioner = null;
	
	private String practitionerId = null;
	
	private String eventCode = null;
	
	private String orderId = null;
	
	private String sysId = null;
	
	private String normalLow = null;
	
	private String normalHigh = null;
	
	private String historyRecTypeDesc = null;
	
	private String eventGroup = null;
	
	private String contrSysEventCode = null;
	
	private String eventClass = null;
	
	private String patientId = null;
	
	private String histDataType = null;
	
	private String historyRecType = null;
	
	private String normalcyInd = null;
	
	private String reviewType = null;
	
	private String createDateTime = null;
	
	private String encounterId = null;
	
	/**
	 * Default constructor of the class
	 */
	public ResultDetail() {
	}


	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}


	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	/**
	 * @return the reportedBy
	 */
	public String getReportedBy() {
		return reportedBy;
	}


	/**
	 * @param reportedBy the reportedBy to set
	 */
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}


	/**
	 * @return the reportedAt
	 */
	public String getReportedAt() {
		return reportedAt;
	}


	/**
	 * @param reportedAt the reportedAt to set
	 */
	public void setReportedAt(String reportedAt) {
		this.reportedAt = reportedAt;
	}


	/**
	 * @return the resultNum
	 */
	public String getResultNum() {
		return resultNum;
	}


	/**
	 * @param resultNum the resultNum to set
	 */
	public void setResultNum(String resultNum) {
		this.resultNum = resultNum;
	}


	/**
	 * @return the resultNumUom
	 */
	public String getResultNumUom() {
		return resultNumUom;
	}


	/**
	 * @param resultNumUom the resultNumUom to set
	 */
	public void setResultNumUom(String resultNumUom) {
		this.resultNumUom = resultNumUom;
	}


	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the notesType
	 */
	public String getNotesType() {
		return notesType;
	}


	/**
	 * @param notesType the notesType to set
	 */
	public void setNotesType(String notesType) {
		this.notesType = notesType;
	}


	/**
	 * @return the resultStr
	 */
	public String getResultStr() {
		return resultStr;
	}


	/**
	 * @param resultStr the resultStr to set
	 */
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
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
	 * @return the orderingPractitioner
	 */
	public String getOrderingPractitioner() {
		return orderingPractitioner;
	}


	/**
	 * @param orderingPractitioner the orderingPractitioner to set
	 */
	public void setOrderingPractitioner(String orderingPractitioner) {
		this.orderingPractitioner = orderingPractitioner;
	}


	/**
	 * @return the practitionerId
	 */
	public String getPractitionerId() {
		return practitionerId;
	}


	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}


	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}


	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}


	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	/**
	 * @return the sysId
	 */
	public String getSysId() {
		return sysId;
	}


	/**
	 * @param sysId the sysId to set
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}


	/**
	 * @return the normalLow
	 */
	public String getNormalLow() {
		return normalLow;
	}


	/**
	 * @param normalLow the normalLow to set
	 */
	public void setNormalLow(String normalLow) {
		this.normalLow = normalLow;
	}


	/**
	 * @return the normalHigh
	 */
	public String getNormalHigh() {
		return normalHigh;
	}


	/**
	 * @param normalHigh the normalHigh to set
	 */
	public void setNormalHigh(String normalHigh) {
		this.normalHigh = normalHigh;
	}


	/**
	 * @return the historyRecTypeDesc
	 */
	public String getHistoryRecTypeDesc() {
		return historyRecTypeDesc;
	}


	/**
	 * @param historyRecTypeDesc the historyRecTypeDesc to set
	 */
	public void setHistoryRecTypeDesc(String historyRecTypeDesc) {
		this.historyRecTypeDesc = historyRecTypeDesc;
	}


	/**
	 * @return the eventGroup
	 */
	public String getEventGroup() {
		return eventGroup;
	}


	/**
	 * @param eventGroup the eventGroup to set
	 */
	public void setEventGroup(String eventGroup) {
		this.eventGroup = eventGroup;
	}


	/**
	 * @return the contrSysEventCode
	 */
	public String getContrSysEventCode() {
		return contrSysEventCode;
	}


	/**
	 * @param contrSysEventCode the contrSysEventCode to set
	 */
	public void setContrSysEventCode(String contrSysEventCode) {
		this.contrSysEventCode = contrSysEventCode;
	}


	/**
	 * @return the eventClass
	 */
	public String getEventClass() {
		return eventClass;
	}


	/**
	 * @param eventClass the eventClass to set
	 */
	public void setEventClass(String eventClass) {
		this.eventClass = eventClass;
	}


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
	 * @return the histDataType
	 */
	public String getHistDataType() {
		return histDataType;
	}


	/**
	 * @param histDataType the histDataType to set
	 */
	public void setHistDataType(String histDataType) {
		this.histDataType = histDataType;
	}


	/**
	 * @return the historyRecType
	 */
	public String getHistoryRecType() {
		return historyRecType;
	}


	/**
	 * @param historyRecType the historyRecType to set
	 */
	public void setHistoryRecType(String historyRecType) {
		this.historyRecType = historyRecType;
	}


	/**
	 * @return the normalcyInd
	 */
	public String getNormalcyInd() {
		return normalcyInd;
	}


	/**
	 * @param normalcyInd the normalcyInd to set
	 */
	public void setNormalcyInd(String normalcyInd) {
		this.normalcyInd = normalcyInd;
	}


	/**
	 * @return the reviewType
	 */
	public String getReviewType() {
		return reviewType;
	}


	/**
	 * @param reviewType the reviewType to set
	 */
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}


	/**
	 * @return the createDateTime
	 */
	public String getCreateDateTime() {
		return createDateTime;
	}


	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
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
