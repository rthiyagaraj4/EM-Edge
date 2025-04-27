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
public class AlertRecipient {

	private long recipientID;
	
	private String userID;
	
	private String recipientRole;

	/**
	 * @return the recipientID
	 */
	public long getRecipientID() {
		return recipientID;
	}

	/**
	 * @param recipientID the recipientID to set
	 */
	public void setRecipientID(long recipientID) {
		this.recipientID = recipientID;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRecipientRole() {
		return recipientRole;
	}

	public void setRecipientRole(String recipientRole) {
		this.recipientRole = recipientRole;
	}
}
