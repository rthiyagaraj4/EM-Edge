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

import com.iba.ehis.core.util.AppConstants;
import com.iba.framework.core.util.Constants;

public class UserPreferences extends BaseVO implements Serializable {
	private String dateFormat = Constants.DEFAULT_DATE_FORMAT;

	private String timeFormat = Constants.DEFAULT_TIME_FORMAT;

	private String locale;

	private String skin;

	private String currency;

	private String workStationNumber = Constants.NOT_AVAILABLE;

	private String workStationName = Constants.NOT_AVAILABLE;

	private String currentFacilityId = Constants.NOT_AVAILABLE;

	private String currentResponsibilityId;

	private String resourceBundle;

	private long loginTime;

	private String userId = Constants.NOT_AVAILABLE;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDateFormat() {
		if (dateFormat == null)
			dateFormat = AppConstants.DEFAULT_DATE_FORMAT;
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getCurrentFacilityId() {
		return currentFacilityId;
	}

	public void setCurrentFacilityId(String facilityId) {
		this.currentFacilityId = facilityId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public String getCurrentResponsibilityId() {
		return currentResponsibilityId;
	}

	public void setCurrentResponsibilityId(String responsibilityId) {
		this.currentResponsibilityId = responsibilityId;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getWorkStationName() {
		return workStationName;
	}

	public void setWorkStationName(String workStationName) {
		this.workStationName = workStationName;
	}

	public String getWorkStationNumber() {
		return workStationNumber;
	}

	public void setWorkStationNumber(String workStationNumber) {
		this.workStationNumber = workStationNumber;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(String resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
