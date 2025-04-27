/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.vo;

import java.io.Serializable;

import com.iba.framework.core.util.Constants;

/*
 * @author Swetha
 * */
public abstract class BaseVO implements Serializable {
	private String sessionId = Constants.NOT_AVAILABLE;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public BaseVO() {
		// TODO Auto-generated constructor stub
	}
}
