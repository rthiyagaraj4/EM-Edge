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
 * @author PrasannaR 
 *
 */
public class AlertsByGroup {

	private String header;
	
	private int groupCount;
	
	private List<AlertsByUser> userAlertList;

	public int getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	public List<AlertsByUser> getUserAlertList() {
		return userAlertList;
	}

	public void setUserAlertList(List<AlertsByUser> userAlertList) {
		this.userAlertList = userAlertList;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
}
