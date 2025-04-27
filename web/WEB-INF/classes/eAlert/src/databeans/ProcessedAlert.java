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
package eAlert.src.databeans;

/**
 * @author PrasannaR
 *
 */
public class ProcessedAlert {

	private long processedAlertID;
	
	private String patientID;
	
	private String ruleCode;
	
	private String alertCode;
	
	private String ruleTransactionData;
	
	/**
	 * @return the processedAlertID
	 */
	public long getProcessedAlertID() {
		return processedAlertID;
	}

	/**
	 * @param processedAlertID the processedAlertID to set
	 */
	public void setProcessedAlertID(long processedAlertID) {
		this.processedAlertID = processedAlertID;
	}

	/**
	 * @return the patientID
	 */
	public String getPatientID() {
		return patientID;
	}

	/**
	 * @param patientID the patientID to set
	 */
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	/**
	 * @return the ruleCode
	 */
	public String getRuleCode() {
		return ruleCode;
	}

	/**
	 * @param ruleCode the ruleCode to set
	 */
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	/**
	 * @return the alertCode
	 */
	public String getAlertCode() {
		return alertCode;
	}

	/**
	 * @param alertCode the alertCode to set
	 */
	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}

	/**
	 * @return the ruleTransactionData
	 */
	public String getRuleTransactionData() {
		return ruleTransactionData;
	}

	/**
	 * @param ruleTransactionData the ruleTransactionData to set
	 */
	public void setRuleTransactionData(String ruleTransactionData) {
		this.ruleTransactionData = ruleTransactionData;
	}
}
