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

import java.util.List;

/**
 * @author prasannar 
 *
 */
public class AlertUserResponse {

	private AlertCountResponse countResponse;
	
	private List<AlertsByUser> userAlertList;

	/**
	 * @return the countResponse
	 */
	public AlertCountResponse getCountResponse() {
		return countResponse;
	}

	/**
	 * @param countResponse the countResponse to set
	 */
	public void setCountResponse(AlertCountResponse countResponse) {
		this.countResponse = countResponse;
	}

	/**
	 * @return the userAlertList
	 */
	public List<AlertsByUser> getUserAlertList() {
		return userAlertList;
	}

	/**
	 * @param userAlertList the userAlertList to set
	 */
	public void setUserAlertList(List<AlertsByUser> userAlertList) {
		this.userAlertList = userAlertList;
	}
}
