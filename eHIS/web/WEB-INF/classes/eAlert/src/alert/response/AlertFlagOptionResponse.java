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

import eAlert.src.databeans.AlertFlagOptions;

/**
 * @author prasannar 
 *
 */
public class AlertFlagOptionResponse {

	private List<AlertFlagOptions> alertFlagOptionList;

	/**
	 * @return the alertFlagOptionList
	 */
	public List<AlertFlagOptions> getAlertFlagOptionList() {
		return alertFlagOptionList;
	}

	/**
	 * @param alertFlagOptionList the alertFlagOptionList to set
	 */
	public void setAlertFlagOptionList(List<AlertFlagOptions> alertFlagOptionList) {
		this.alertFlagOptionList = alertFlagOptionList;
	} 
}
