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
public class AlertsByUser {

	private long patientAlertSeqId;
	
	private long patientRecipientSeqId;
	
	private String alertName;
	
	private String patientId;
	
	private String patientName;
	
	private String location;
	
	private String standardText;
	
	private String dateTimeDisplay;
	
	private String flagged;
	
	private String reviewed;
	
	private String forwarded;
	
	private String received;
	
	private String recFromUser;
	
	private String archived;
	
	private Date intStartTime;
	
	private int reminderInterval;
	
	private String reminderIntervalUnit;
	
	private String intervalDisplay;
	
	private String modifiedDate;
	
	private String forwardedUserId;
	
	private String alertAck;
	
	private String alertPriority;
	
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
	 * @return the patientId-
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
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the standardText
	 */
	public String getStandardText() {
		return standardText;
	}

	/**
	 * @param standardText the standardText to set
	 */
	public void setStandardText(String standardText) {
		this.standardText = standardText;
	}

	/**
	 * @return the dateTimeDisplay
	 */
	public String getDateTimeDisplay() {
		return dateTimeDisplay;
	}

	/**
	 * @param dateTimeDisplay the dateTimeDisplay to set
	 */
	public void setDateTimeDisplay(String dateTimeDisplay) {
		this.dateTimeDisplay = dateTimeDisplay;
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

	public String getRecFromUser() {
		return recFromUser;
	}

	public void setRecFromUser(String recFromUser) {
		this.recFromUser = recFromUser;
	}

	public String getArchived() {
		return archived;
	}

	public void setArchived(String archived) {
		this.archived = archived;
	}

	public Date getIntStartTime() {
		return intStartTime;
	}

	public void setIntStartTime(Date intStartTime) {
		this.intStartTime = intStartTime;
	}

	public int getReminderInterval() {
		return reminderInterval;
	}

	public void setReminderInterval(int reminderInterval) {
		this.reminderInterval = reminderInterval;
	}

	public String getForwardedUserId() {
		return forwardedUserId;
	}

	public void setForwardedUserId(String forwardedUserId) {
		this.forwardedUserId = forwardedUserId;
	}

	public String getAlertAck() {
		return alertAck;
	}

	public void setAlertAck(String alertAck) {
		this.alertAck = alertAck;
	}

	public long getPatientAlertSeqId() {
		return patientAlertSeqId;
	}

	public void setPatientAlertSeqId(long patientAlertSeqId) {
		this.patientAlertSeqId = patientAlertSeqId;
	}

	public String getAlertPriority() {
		return alertPriority;
	}

	public void setAlertPriority(String alertPriority) {
		this.alertPriority = alertPriority;
	}

	/**
	 * @return the reminderIntervalUnit
	 */
	public String getReminderIntervalUnit() {
		return reminderIntervalUnit;
	}

	/**
	 * @param reminderIntervalUnit the reminderIntervalUnit to set
	 */
	public void setReminderIntervalUnit(String reminderIntervalUnit) {
		this.reminderIntervalUnit = reminderIntervalUnit;
	}

	/**
	 * @return the intervalDisplay
	 */
	public String getIntervalDisplay() {
		return intervalDisplay;
	}

	/**
	 * @param intervalDisplay the intervalDisplay to set
	 */
	public void setIntervalDisplay(String intervalDisplay) {
		this.intervalDisplay = intervalDisplay;
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
}
