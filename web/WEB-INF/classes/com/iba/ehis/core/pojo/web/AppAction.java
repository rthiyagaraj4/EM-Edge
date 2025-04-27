/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iba.ehis.core.vo.AppVO;
import com.iba.framework.core.pojo.web.BaseAction;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.UserPreferences;

public abstract class AppAction extends BaseAction {

	public AppAction() {
		// TODO Auto-generated constructor stub

	}

	protected AppVO setDefaultSet(AppVO valueObject, HttpServletRequest request) {
		try {

			HttpSession session = request.getSession(true);
			java.util.Properties prop = null;
			prop = (java.util.Properties) session.getAttribute("jdbc");
			UserPreferences userPrefs = new UserPreferences();
			userPrefs.setWorkStationNumber(prop
					.getProperty("client_ip_address"));
			userPrefs.setUserId(prop.getProperty("login_user"));
			userPrefs.setCurrentFacilityId((String) session
					.getAttribute("facility_id"));

			// UserPreferences
			// userPrefs=(UserPreferences)(CacheManager.getCache()).getObject(Constants.USER_SESSION_CACHE,
			// sessionId, Constants.USER_PREFS);
			valueObject.setAddedAtWsNo(userPrefs.getWorkStationNumber());
			valueObject.setAddedById(userPrefs.getUserId());
			valueObject.setAddedDate(new IBADateTime());
			valueObject.setAddedFacilityId(userPrefs.getCurrentFacilityId());

			valueObject.setModifiedAtWsNo(userPrefs.getWorkStationNumber());
			valueObject.setModifiedById(userPrefs.getUserId());
			valueObject.setModifiedDate(new IBADateTime());
			valueObject.setModifiedFacilityId(userPrefs.getCurrentFacilityId());
			valueObject.setSessionId(session.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueObject;

	}
}
