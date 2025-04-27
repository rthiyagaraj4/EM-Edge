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

import java.util.ArrayList;
import java.util.List;

/**
 * @author PrasannaR
 *
 */
public class AlertMaster {

	private long alertID;
	
	private String alertCode;
	
	private String alertTitle;
	
	private String alertDescription;
	
	private int alertPriority;
	
	private String alertRecipientType;
	
	private List<AlertRecipient> recipientList = new ArrayList<AlertRecipient>();

	/**
	 * @return the alertID
	 */
	public long getAlertID() {
		return alertID;
	}

	/**
	 * @param alertID the alertID to set
	 */
	public void setAlertID(long alertID) {
		this.alertID = alertID;
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
	 * @return the alertTitle
	 */
	public String getAlertTitle() {
		return alertTitle;
	}

	/**
	 * @param alertTitle the alertTitle to set
	 */
	public void setAlertTitle(String alertTitle) {
		this.alertTitle = alertTitle;
	}

	/**
	 * @return the alertDescription
	 */
	public String getAlertDescription() {
		return alertDescription;
	}

	/**
	 * @param alertDescription the alertDescription to set
	 */
	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}

	/**
	 * @return the alertPriority
	 */
	public int getAlertPriority() {
		return alertPriority;
	}

	/**
	 * @param alertPriority the alertPriority to set
	 */
	public void setAlertPriority(int alertPriority) {
		this.alertPriority = alertPriority;
	}

	/**
	 * @return the recipientList
	 */
	public List<AlertRecipient> getRecipientList() {
		return recipientList;
	}

	/**
	 * @param recipientList the recipientList to set
	 */
	public void setRecipientList(List<AlertRecipient> recipientList) {
		this.recipientList = recipientList;
	}

	public String getAlertRecipientType() {
		return alertRecipientType;
	}

	public void setAlertRecipientType(String alertRecipientType) {
		this.alertRecipientType = alertRecipientType;
	}
	
	/**
	 * Check if recipient type is required
	 */
}
