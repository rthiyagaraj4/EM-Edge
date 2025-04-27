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
public class AlertReviewMangRequest extends BaseRequest{

	private long alertId;
	
	private long patRecipientId;
	
	private String commentText;
	
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
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
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
