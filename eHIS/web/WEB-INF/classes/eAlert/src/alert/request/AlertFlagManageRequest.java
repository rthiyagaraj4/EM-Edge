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
package eAlert.src.alert.request;

/**
 * @author prasannar
 *
 */
public class AlertFlagManageRequest extends BaseRequest{

	private long alertId; 
	
	private long patRecipientId;
	
	private String timeCode;
	
	private String flagged;
	
	private int count;

	/**
	 * @return the alertId
	 */
	public long getAlertId() {
		return alertId;
	}

	/**
	 * @param alertId the alertId to set
	 */
	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}

	/**
	 * @return the timeCode
	 */
	public String getTimeCode() {
		return timeCode;
	}

	/**
	 * @param timeCode the timeCode to set
	 */
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the flagged
	 */
	public String getFlagged() {
		return flagged;
	}

	/**
	 * @param flagged the flagged to set
	 */
	public void setFlagged(String flagged) {
		this.flagged = flagged;
	}

	/**
	 * @return the patRecipientId
	 */
	public long getPatRecipientId() {
		return patRecipientId;
	}

	/**
	 * @param patRecipientId the patRecipientId to set
	 */
	public void setPatRecipientId(long patRecipientId) {
		this.patRecipientId = patRecipientId;
	}
}
