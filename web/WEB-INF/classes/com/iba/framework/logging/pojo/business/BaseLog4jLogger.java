/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on May 25, 2006
 */
package com.iba.framework.logging.pojo.business;

import org.apache.log4j.Logger;

import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.util.AppUtil;
import com.iba.framework.core.vo.UserPreferences;

/**
 * @author S Sabarinathan
 * 
 */
public abstract class BaseLog4jLogger implements
		com.iba.framework.logging.pojo.business.Logger {
	private org.apache.log4j.Logger log4jLogger;

	public BaseLog4jLogger() {
	}

	/**
	 * @return Returns the log4jLogger.
	 */
	protected Logger getLog4jLogger() {
		return log4jLogger;
	}

	/**
	 * @param log4jLogger
	 *            The log4jLogger to set.
	 */
	protected void setLog4jLogger(Logger log4jLogger) {
		this.log4jLogger = log4jLogger;
	}

	private String format(String classname, String message, String sessionKey) {
		StringBuffer sb = new StringBuffer();
		if (sessionKey != null) {
			UserPreferences userPrefs = null;
			try {
				userPrefs = AppUtil.getUserPrefs(sessionKey);
				sb.append("[");
				if (userPrefs.getWorkStationName() == null)
					sb.append(userPrefs.getWorkStationNumber());
				else
					sb.append(userPrefs.getWorkStationName());
				sb.append(":");
				sb.append(userPrefs.getUserId());
				sb.append(":");
				sb.append(userPrefs.getCurrentFacilityId());
				sb.append("]");
			} catch (DataNotFoundException e) {
				// TODO Auto-generated catch block
			}
		} else {
			sb.append("[NA:NA:NA]");
		}
		if (classname != null)
			sb.append(classname);
		sb.append(" - ");
		sb.append(message);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#debug(java.lang.String,
	 *      java.lang.String)
	 */
	public void debug(String className, String message, String sessionKey) {
		getLog4jLogger().debug(format(className, message, sessionKey));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#debug(java.lang.Class,
	 *      java.lang.String)
	 */
	public void debug(Class oClass, String message, String sessionKey) {
		debug(oClass.getName(), message, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#debug(java.lang.String,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void debug(String className, String message, Throwable t,
			String sessionKey) {
		getLog4jLogger().debug(format(className, message, sessionKey), t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#debug(java.lang.Class,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void debug(Class oClass, String message, Throwable t,
			String sessionKey) {
		debug(oClass.getName(), message, t, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#warn(java.lang.String,
	 *      java.lang.String)
	 */
	public void warn(String className, String message, String sessionKey) {
		getLog4jLogger().warn(format(className, message, sessionKey));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#warn(java.lang.Class,
	 *      java.lang.String)
	 */
	public void warn(Class oClass, String message, String sessionKey) {
		warn(oClass.getName(), message, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#warn(java.lang.String,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void warn(String className, String message, Throwable t,
			String sessionKey) {
		getLog4jLogger().warn(format(className, message, sessionKey), t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#warn(java.lang.Class,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void warn(Class oClass, String message, Throwable t,
			String sessionKey) {
		warn(oClass.getName(), message, t, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#info(java.lang.String,
	 *      java.lang.String)
	 */
	public void info(String className, String message, String sessionKey) {
		getLog4jLogger().info(format(className, message, sessionKey));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#info(java.lang.Class,
	 *      java.lang.String)
	 */
	public void info(Class oClass, String message, String sessionKey) {
		info(oClass.getName(), message, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#info(java.lang.String,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void info(String className, String message, Throwable t,
			String sessionKey) {
		getLog4jLogger().info(format(className, message, sessionKey), t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#info(java.lang.Class,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void info(Class oClass, String message, Throwable t,
			String sessionKey) {
		info(oClass.getName(), message, t, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#error(java.lang.String,
	 *      java.lang.String)
	 */
	public void error(String className, String message, String sessionKey) {
		getLog4jLogger().error(format(className, message, sessionKey));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#error(java.lang.Class,
	 *      java.lang.String)
	 */
	public void error(Class oClass, String message, String sessionKey) {
		error(oClass.getName(), message, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#error(java.lang.String,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void error(String className, String message, Throwable t,
			String sessionKey) {
		getLog4jLogger().error(format(className, message, sessionKey));
		if (t != null && isDebugEnabled())
			getLog4jLogger().debug(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#error(java.lang.Class,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void error(Class oClass, String message, Throwable t,
			String sessionKey) {
		error(oClass.getName(), message, t, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#fatal(java.lang.String,
	 *      java.lang.String)
	 */
	public void fatal(String className, String message, String sessionKey) {
		getLog4jLogger().fatal(format(className, message, sessionKey));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#fatal(java.lang.Class,
	 *      java.lang.String)
	 */
	public void fatal(Class oClass, String message, String sessionKey) {
		fatal(oClass.getName(), message, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#fatal(java.lang.String,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void fatal(String className, String message, Throwable t,
			String sessionKey) {
		getLog4jLogger().fatal(format(className, message, sessionKey), t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#fatal(java.lang.Class,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void fatal(Class oClass, String message, Throwable t,
			String sessionKey) {
		fatal(oClass.getName(), message, t, null);
	}

	// public abstract com.iba.framework.logging.Logger getLogger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.logging.Logger#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return log4jLogger.isDebugEnabled();
	}
}
