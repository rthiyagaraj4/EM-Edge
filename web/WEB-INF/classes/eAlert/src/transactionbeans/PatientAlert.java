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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author PrasannaR
 *
 */
public class PatientAlert {

	private long patientAlertSeqID;
	
	private long processedAlertSeqID;
	
	private String AlertCode;
	
	private String AlertTitle;
	
	private Date AlertRecordedDate;
	
	private String isFlagged;
	
	private String isReviewed;
	
	private String isForwarded;
	
	private String isReceived;
	
	private String isArchived;
	
	private int reminderInterval;
	
	private String reviewedComments;
	
	private List<AlertForwarded> forwardedList = new ArrayList<AlertForwarded>();
	/**
	 * TODO check for attributes for received from user and received comments;
	 */

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
	 * @return the processedAlertSeqID
	 */
	public long getProcessedAlertSeqID() {
		return processedAlertSeqID;
	}

	/**
	 * @param processedAlertSeqID the processedAlertSeqID to set
	 */
	public void setProcessedAlertSeqID(long processedAlertSeqID) {
		this.processedAlertSeqID = processedAlertSeqID;
	}

	/**
	 * @return the alertCode
	 */
	public String getAlertCode() {
		return AlertCode;
	}

	/**
	 * @param alertCode the alertCode to set
	 */
	public void setAlertCode(String alertCode) {
		AlertCode = alertCode;
	}

	/**
	 * @return the alertTitle
	 */
	public String getAlertTitle() {
		return AlertTitle;
	}

	/**
	 * @param alertTitle the alertTitle to set
	 */
	public void setAlertTitle(String alertTitle) {
		AlertTitle = alertTitle;
	}

	/**
	 * @return the alertRecordedDate
	 */
	public Date getAlertRecordedDate() {
		return AlertRecordedDate;
	}

	/**
	 * @param alertRecordedDate the alertRecordedDate to set
	 */
	public void setAlertRecordedDate(Date alertRecordedDate) {
		AlertRecordedDate = alertRecordedDate;
	}

	/**
	 * @return the isFlagged
	 */
	public String getIsFlagged() {
		return isFlagged;
	}

	/**
	 * @param isFlagged the isFlagged to set
	 */
	public void setIsFlagged(String isFlagged) {
		this.isFlagged = isFlagged;
	}

	/**
	 * @return the isReviewed
	 */
	public String getIsReviewed() {
		return isReviewed;
	}

	/**
	 * @param isReviewed the isReviewed to set
	 */
	public void setIsReviewed(String isReviewed) {
		this.isReviewed = isReviewed;
	}

	/**
	 * @return the isForwarded
	 */
	public String getIsForwarded() {
		return isForwarded;
	}

	/**
	 * @param isForwarded the isForwarded to set
	 */
	public void setIsForwarded(String isForwarded) {
		this.isForwarded = isForwarded;
	}

	/**
	 * @return the isReceived
	 */
	public String getIsReceived() {
		return isReceived;
	}

	/**
	 * @param isReceived the isReceived to set
	 */
	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	/**
	 * @return the isArchived
	 */
	public String getIsArchived() {
		return isArchived;
	}

	/**
	 * @param isArchived the isArchived to set
	 */
	public void setIsArchived(String isArchived) {
		this.isArchived = isArchived;
	}

	/**
	 * @return the reminderInterval
	 */
	public int getReminderInterval() {
		return reminderInterval;
	}

	/**
	 * @param reminderInterval the reminderInterval to set
	 */
	public void setReminderInterval(int reminderInterval) {
		this.reminderInterval = reminderInterval;
	}

	/**
	 * @return the reviewedComments
	 */
	public String getReviewedComments() {
		return reviewedComments;
	}

	/**
	 * @param reviewedComments the reviewedComments to set
	 */
	public void setReviewedComments(String reviewedComments) {
		this.reviewedComments = reviewedComments;
	}

	/**
	 * @return the forwardedList
	 */
	public List<AlertForwarded> getForwardedList() {
		return forwardedList;
	}

	/**
	 * @param forwardedList the forwardedList to set
	 */
	public void setForwardedList(List<AlertForwarded> forwardedList) {
		this.forwardedList = forwardedList;
	}
}
