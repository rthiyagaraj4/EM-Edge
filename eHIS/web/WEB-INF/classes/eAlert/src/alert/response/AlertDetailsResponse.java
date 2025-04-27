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
package eAlert.src.alert.response;

import java.util.Date;

/**
 * @author prasannar 
 *
 */
public class AlertDetailsResponse {

	private long patientAlertSeqId;
	
	private long patientRecipientSeqId;
	
	private String alertName;
	
	private String alertDescription;
	
	private String patientId;
	
	private String patientName;
	
	private String dateTimeDisplay;
	
	private String details;
	
	private int totalCount;
	
	private String alertPriority;
	
	private String alertAck;
	
	private String flagged;
	
	private String reviewed;
	
	private String forwarded;
	
	private String received;
	
	private String comments;
	
	private String modifiedDate;
	
	private String receivedUserId;
	
	private String forwardedUserId;

	/**
	 * @return the alertName
	 */
	public String getAlertName() {
		return alertName;
	}

	/**
	 * @param alertName the alertName to set
	 */
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAlertDescription() {
		return alertDescription;
	}

	/**
	 * 
	 * @param alertDescription
	 */
	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	/**
	 * 
	 * @return
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * 
	 * @param patientId
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDateTimeDisplay() {
		return dateTimeDisplay;
	}

	/**
	 * 
	 * @param dateTimeDisplay
	 */
	public void setDateTimeDisplay(String dateTimeDisplay) {
		this.dateTimeDisplay = dateTimeDisplay;
	}

	/**
	 * 
	 * @return
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * 
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * 
	 * @return
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * 
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getAlertPriority() {
		return alertPriority;
	}

	public void setAlertPriority(String alertPriority) {
		this.alertPriority = alertPriority;
	}

	public long getPatientAlertSeqId() {
		return patientAlertSeqId;
	}

	public void setPatientAlertSeqId(long patientAlertSeqId) {
		this.patientAlertSeqId = patientAlertSeqId;
	}

	public String getAlertAck() {
		return alertAck;
	}

	public void setAlertAck(String alertAck) {
		this.alertAck = alertAck;
	}

	public String getFlagged() {
		return flagged;
	}

	public void setFlagged(String flagged) {
		this.flagged = flagged;
	}

	public String getReviewed() {
		return reviewed;
	}

	public void setReviewed(String reviewed) {
		this.reviewed = reviewed;
	}

	public String getForwarded() {
		return forwarded;
	}

	public void setForwarded(String forwarded) {
		this.forwarded = forwarded;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
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

	/**
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the receivedUserId
	 */
	public String getReceivedUserId() {
		return receivedUserId;
	}

	/**
	 * @param receivedUserId the receivedUserId to set
	 */
	public void setReceivedUserId(String receivedUserId) {
		this.receivedUserId = receivedUserId;
	}

	/**
	 * @return the patientRecipientSeqId
	 */
	public long getPatientRecipientSeqId() {
		return patientRecipientSeqId;
	}

	/**
	 * @param patientRecipientSeqId the patientRecipientSeqId to set
	 */
	public void setPatientRecipientSeqId(long patientRecipientSeqId) {
		this.patientRecipientSeqId = patientRecipientSeqId;
	}

	/**
	 * @return the forwardedUserId
	 */
	public String getForwardedUserId() {
		return forwardedUserId;
	}

	/**
	 * @param forwardedUserId the forwardedUserId to set
	 */
	public void setForwardedUserId(String forwardedUserId) {
		this.forwardedUserId = forwardedUserId;
	}
}
