/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

import java.util.Date;

import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

public class IBADateTime extends IBADate {
	
	private static final String TIME_DELIMITER = " ";

	public IBADateTime() {

	}

	public IBADateTime(Date date) {
		super(date);
		IBALogger.getLogger().debug(this.getClass(),"date in ibadatetime ==========================>:"+ date, null);
	}

	public IBADateTime(String sessionId) {
		super();
		this.pattern = getPattern(sessionId);
	}

	public IBADateTime(Date date, String sessionKey) {
		super(date);
		this.sessionId = sessionKey;
		this.pattern = getPattern(sessionKey);
	}

	private String getPattern(String sessionId) {
		//UserPreferences preferences = null;
		String dateTimeFormate =null;
		//preferences = AppUtil.getUserPrefs(sessionId);
		dateTimeFormate = "dd/MM/yyyy HH:mm";
					
		return dateTimeFormate;
	}

	public String fetchTime() {
		// TODO: Works only for pattern dd/MM/yyyy HH:mm, MM/dd/yyyy HH:mm.
		// This has to be enhanced for other patterns as well.
		String[] fragments = pattern.split(TIME_DELIMITER);
		String strTime = null;
		if (fragments.length > 1)
			strTime = getFormatter(fragments[1]).format(this);
		return strTime;
	}
	
	public String getTimePattern() {
		return new UserPreferences().getTimeFormat();

	}
	
	
}
