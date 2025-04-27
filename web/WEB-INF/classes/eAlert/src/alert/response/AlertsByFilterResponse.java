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
public class AlertsByFilterResponse {

	private AlertCountResponse countResponse;
	
	private List<AlertsByUser> userAlertList;
	
	private String filtered;

	public AlertCountResponse getCountResponse() {
		return countResponse;
	}

	public void setCountResponse(AlertCountResponse countResponse) {
		this.countResponse = countResponse;
	}

	public List<AlertsByUser> getUserAlertList() {
		return userAlertList;
	}

	public void setUserAlertList(List<AlertsByUser> userAlertList) {
		this.userAlertList = userAlertList;
	}

	public String getFiltered() {
		return filtered;
	}

	public void setFiltered(String filtered) {
		this.filtered = filtered;
	}

	
	
}
