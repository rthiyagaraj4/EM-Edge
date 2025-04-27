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
package eAlert.src.transactionbeans;

/**
 * @author PrasannaR
 *
 */
public class AlertForwarded {

	private long forwardedSeqID;
	
	private long patientAlertSeqID;
	
	private String forwardedUserID;
	
	private String comments;

	/**
	 * @return the forwardedSeqID
	 */
	public long getForwardedSeqID() {
		return forwardedSeqID;
	}

	/**
	 * @param forwardedSeqID the forwardedSeqID to set
	 */
	public void setForwardedSeqID(long forwardedSeqID) {
		this.forwardedSeqID = forwardedSeqID;
	}

	/**
	 * @return the patientAlertSeqID
	 */
	public long getPatientAlertSeqID() {
		return patientAlertSeqID;
	}

	/**
	 * @param patientAlertSeqID the patientAlertSeqID to set
	 */
	public void setPatientAlertSeqID(long patientAlertSeqID) {
		this.patientAlertSeqID = patientAlertSeqID;
	}

	/**
	 * @return the forwardedUserID
	 */
	public String getForwardedUserID() {
		return forwardedUserID;
	}

	/**
	 * @param forwardedUserID the forwardedUserID to set
	 */
	public void setForwardedUserID(String forwardedUserID) {
		this.forwardedUserID = forwardedUserID;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}
