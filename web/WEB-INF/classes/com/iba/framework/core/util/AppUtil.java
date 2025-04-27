/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 8, 2006
 */
package com.iba.framework.core.util;

import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.vo.UserPreferences;

/**
 * Helper class
 * 
 * @author Sabarinathan S
 * @version
 */
public class AppUtil {
	public static UserPreferences getUserPrefs(String sessionId) throws DataNotFoundException {
		/*return(UserPreferences)CacheManager.getCache().getObject(
				Constants.USER_SESSION_CACHE, sessionId, Constants.USER_PREFS);*/
		UserPreferences userPreferences = new UserPreferences();
		userPreferences.setDateFormat("dd/MM/yyyy");
		userPreferences.setTimeFormat("HH:mm");
		return userPreferences;
	}
	
	public static String getFacilityId(String sessionId)
			throws DataNotFoundException{
		/*return getUserPrefs(sessionId).getCurrentFacilityId();*/
		
		UserPreferences userPreferences = new UserPreferences();
		
		return null;
	}
}
