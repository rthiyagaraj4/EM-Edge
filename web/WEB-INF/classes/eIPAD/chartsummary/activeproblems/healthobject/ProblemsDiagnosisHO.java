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
package eIPAD.chartsummary.activeproblems.healthobject;

/**
 * @author SaraswathiR 
 *
 */
public class ProblemsDiagnosisHO {
	
	String encounterId;
	String diagProbCode;
	String diagProbDesc;
	String recordedByPrac;
	String addedDate;
	int complCount;
	int encounterCount;
	String sensitiveYN;
	String onsetDate;
	String recordedDateTime;
	String severity;
	String accuracy;
	String termSetId;
	String termSetDesc;
	String currentAccuracyInd;
	String occurSrlNo;
	String encounterStage;
	String status;
	String currentState;

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
	 * @return the diagProbCode
	 */
	public String getDiagProbCode() {
		return diagProbCode;
	}
	/**
	 * @param diagProbCode the diagProbCode to set
	 */
	public void setDiagProbCode(String diagProbCode) {
		this.diagProbCode = diagProbCode;
	}
	/**
	 * @return the diagProbDesc
	 */
	public String getDiagProbDesc() {
		return diagProbDesc;
	}
	/**
	 * @param diagProbDesc the diagProbDesc to set
	 */
	public void setDiagProbDesc(String diagProbDesc) {
		this.diagProbDesc = diagProbDesc;
	}
	/**
	 * @return the recordedByPrac
	 */
	public String getRecordedByPrac() {
		return recordedByPrac;
	}
	/**
	 * @param recordedByPrac the recordedByPrac to set
	 */
	public void setRecordedByPrac(String recordedByPrac) {
		this.recordedByPrac = recordedByPrac;
	}
	/**
	 * @return the addedDate
	 */
	public String getAddedDate() {
		return addedDate;
	}
	/**
	 * @param addedDate the addedDate to set
	 */
	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}
	/**
	 * @return the complCount
	 */
	public int getComplCount() {
		return complCount;
	}
	/**
	 * @param complCount the complCount to set
	 */
	public void setComplCount(int complCount) {
		this.complCount = complCount;
	}
	/**
	 * @return the sensitiveYN
	 */
	public String getSensitiveYN() {
		return sensitiveYN;
	}
	/**
	 * @param sensitiveYN the sensitiveYN to set
	 */
	public void setSensitiveYN(String sensitiveYN) {
		this.sensitiveYN = sensitiveYN;
	}
	/**
	 * @return the onsetDate
	 */
	public String getOnsetDate() {
		return onsetDate;
	}
	/**
	 * @param onsetDate the onsetDate to set
	 */
	public void setOnsetDate(String onsetDate) {
		this.onsetDate = onsetDate;
	}
	/**
	 * @return the recordedDateTime
	 */
	public String getRecordedDateTime() {
		return recordedDateTime;
	}
	/**
	 * @param recordedDateTime the recordedDateTime to set
	 */
	public void setRecordedDateTime(String recordedDateTime) {
		this.recordedDateTime = recordedDateTime;
	}
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	/**
	 * @return the accuracy
	 */
	public String getAccuracy() {
		return accuracy;
	}
	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the currentState
	 */
	public String getCurrentState() {
		return currentState;
	}
	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	/**
	 * @return the currentAccuracyInd
	 */
	public String getCurrentAccuracyInd() {
		return currentAccuracyInd;
	}
	/**
	 * @param currentAccuracyInd the currentAccuracyInd to set
	 */
	public void setCurrentAccuracyInd(String currentAccuracyInd) {
		this.currentAccuracyInd = currentAccuracyInd;
	}
	/**
	 * @return the encounterStage
	 */
	public String getEncounterStage() {
		return encounterStage;
	}
	/**
	 * @param encounterStage the encounterStage to set
	 */
	public void setEncounterStage(String encounterStage) {
		this.encounterStage = encounterStage;
	}
	/**
	 * @return the encounterCount
	 */
	public int getEncounterCount() {
		return encounterCount;
	}
	/**
	 * @param encounterCount the encounterCount to set
	 */
	public void setEncounterCount(int encounterCount) {
		this.encounterCount = encounterCount;
	}
	/**
	 * @return the termSetDesc
	 */
	public String getTermSetDesc() {
		return termSetDesc;
	}
	/**
	 * @param termSetDesc the termSetDesc to set
	 */
	public void setTermSetDesc(String termSetDesc) {
		this.termSetDesc = termSetDesc;
	}
	/**
	 * @return the occurSrlNo
	 */
	public String getOccurSrlNo() {
		return occurSrlNo;
	}
	/**
	 * @param occurSrlNo the occurSrlNo to set
	 */
	public void setOccurSrlNo(String occurSrlNo) {
		this.occurSrlNo = occurSrlNo;
	}
	/**
	 * @return the termSetId
	 */
	public String getTermSetId() {
		return termSetId;
	}
	/**
	 * @param termSetId the termSetId to set
	 */
	public void setTermSetId(String termSetId) {
		this.termSetId = termSetId;
	}
	

}
