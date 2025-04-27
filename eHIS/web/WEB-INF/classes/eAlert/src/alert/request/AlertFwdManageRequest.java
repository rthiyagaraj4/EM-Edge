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

import java.util.List;

/**
 * @author prasannar 
 *
 */
public class AlertFwdManageRequest extends BaseRequest {

	private long alertId;
	
	private long patientAlertRecipientId;
	
	private List<String> userIdList;
	
	private int count;
	
	private String comment;

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
	 * @return the userIdList
	 */
	public List<String> getUserIdList() {
		return userIdList;
	}

	/**
	 * @param userIdList the userIdList to set
	 */
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the patientAlertRecipientId
	 */
	public long getPatientAlertRecipientId() {
		return patientAlertRecipientId;
	}

	/**
	 * @param patientAlertRecipientId the patientAlertRecipientId to set
	 */
	public void setPatientAlertRecipientId(long patientAlertRecipientId) {
		this.patientAlertRecipientId = patientAlertRecipientId;
	}
}
