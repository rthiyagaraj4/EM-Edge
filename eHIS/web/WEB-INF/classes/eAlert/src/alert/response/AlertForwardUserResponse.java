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

import eAlert.src.databeans.AlertForwardUsers;

/**
 * @author PrasannaR 
 *
 */
public class AlertForwardUserResponse {

	private List<AlertForwardUsers> forwardUserList;

	/**
	 * @return the forwardUserList
	 */
	public List<AlertForwardUsers> getForwardUserList() {
		return forwardUserList;
	}

	/**
	 * @param forwardUserList the forwardUserList to set
	 */
	public void setForwardUserList(List<AlertForwardUsers> forwardUserList) {
		this.forwardUserList = forwardUserList;
	}
}
