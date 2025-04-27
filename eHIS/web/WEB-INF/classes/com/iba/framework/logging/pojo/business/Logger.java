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

/**
 * @author S Sabarinathan
 * 
 */
public interface Logger {
	/**
	 * @param className
	 * @param message
	 * @param sessionKey
	 */
	public void debug(String className, String message, String sessionKey);

	/**
	 * @param aClass
	 * @param message
	 * @param sessionKey
	 */
	public void debug(Class aClass, String message, String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void debug(String className, String message, Throwable t,
			String sessionKey);

	/**
	 * @param oClass
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void debug(Class oClass, String message, Throwable t,
			String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param sessionKey
	 */
	public void warn(String className, String message, String sessionKey);

	/**
	 * @param aClass
	 * @param message
	 * @param sessionKey
	 */
	public void warn(Class aClass, String message, String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void warn(String className, String message, Throwable t,
			String sessionKey);

	/**
	 * @param oClass
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void warn(Class oClass, String message, Throwable t,
			String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param sessionKey
	 */
	public void info(String className, String message, String sessionKey);

	/**
	 * @param aClass
	 * @param message
	 * @param sessionKey
	 */
	public void info(Class aClass, String message, String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void info(String className, String message, Throwable t,
			String sessionKey);

	/**
	 * @param oClass
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void info(Class oClass, String message, Throwable t,
			String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param sessionKey
	 */
	public void error(String className, String message, String sessionKey);

	/**
	 * @param aClass
	 * @param message
	 * @param sessionKey
	 */
	public void error(Class aClass, String message, String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void error(String className, String message, Throwable t,
			String sessionKey);

	/**
	 * @param oClass
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void error(Class oClass, String message, Throwable t,
			String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param sessionKey
	 */
	public void fatal(String className, String message, String sessionKey);

	/**
	 * @param aClass
	 * @param message
	 * @param sessionKey
	 */
	public void fatal(Class aClass, String message, String sessionKey);

	/**
	 * @param className
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void fatal(String className, String message, Throwable t,
			String sessionKey);

	/**
	 * @param oClass
	 * @param message
	 * @param t
	 * @param sessionKey
	 */
	public void fatal(Class oClass, String message, Throwable t,
			String sessionKey);

	/**
	 * @return
	 */
	public boolean isDebugEnabled();
}
