/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class IBADate extends Date {

	public static Logger logger = LogFactory.getApplicationLogger();

	protected String sessionId;

	protected String pattern;
	
	private String toLocale;

	private String fromLocale;
	
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionKey) {
		this.sessionId = sessionKey;
	}

	public IBADate() {
		super();
	}

	public IBADate(String sessionKey) {
		super();
		this.sessionId = sessionKey;
		this.pattern = getPattern();
	}

	public IBADate(Date date, String sessionKey) {
		super(date.getTime());
		this.sessionId = sessionKey;		
		this.pattern = getPattern();
	}

	public IBADate(Date date) {
		
		super(date.getTime());		
	}

	public String toString() {
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String dateString = getFormatter().format(this);
		if(fromLocale != null && toLocale != null ){			
			dateString = ibaDateValidation.convertDateJS(dateString,fromLocale,toLocale,pattern);
		}
		return dateString;
	}

	public SimpleDateFormat getFormatter() {
		if (pattern == null) {
			pattern = new SimpleDateFormat().toPattern();
			logger.warn(this.getClass(),"Null pattern was provided, defaulting to: " + pattern,sessionId);
		}
		SimpleDateFormat format = new SimpleDateFormat(this.pattern);
		return format;
	}

	public SimpleDateFormat getFormatter(String pattern) {
		if (pattern == null) {
			pattern = new SimpleDateFormat().toPattern();
			logger.warn(this.getClass(), "Null pattern was provided, defaulting to: " + pattern, sessionId);
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format;
	}
	
	public String getIBADate() {
		return getFormatter().format(this);
	}

	public String getPattern() {
		if(this.pattern == null){
			pattern="dd/MM/yyyy";
		}
		IBALogger.getLogger().debug(this.getClass(),"pattern--getPattern--aaa--->"+pattern,null);
		return pattern;
	}

	private String getPattern(String sessionId) {
		String dateFormate=null;
				
		if(this.pattern == null){
			dateFormate = "dd/MM/yyyy";
		}
		IBALogger.getLogger().debug(this.getClass(),"dateFormate---getPattern-sessionId--->"+dateFormate,null);
		return dateFormate;
	}
	
	public void setPattern(String pattern) {
		logger.warn(this.getClass(), "Null pattern was provided, defaulting to: " + pattern, sessionId);
		if(pattern == null){
			pattern="dd/MM/yyyy";
		}
		IBALogger.getLogger().debug(this.getClass(),"pattern---setPattern---->"+pattern,null);
		this.pattern = pattern;
	}

	public String getFromLocale() {
		return fromLocale;
	}

	public void setFromLocale(String fromLocale) {
		this.fromLocale = fromLocale;
	}

	public String getToLocale() {
		return toLocale;
	}

	public void setToLocale(String toLocale) {
		this.toLocale = toLocale;
	}
	
}
