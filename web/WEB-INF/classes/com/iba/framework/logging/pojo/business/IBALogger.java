/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 13, 2006
 */
package com.iba.framework.logging.pojo.business;

import org.apache.log4j.Logger;

import com.iba.framework.core.util.Constants;

/**
 * @author S Sabarinathan
 * 
 */
public final class IBALogger extends BaseLog4jLogger {
	private static IBALogger logger;

	private IBALogger() {
		setLog4jLogger(Logger.getLogger(Constants.GENERAL_LOG));
	}

	public static com.iba.framework.logging.pojo.business.Logger getLogger() {
		if (logger == null) {
			logger = new IBALogger();
		}
		return (com.iba.framework.logging.pojo.business.Logger) logger;
	}
}
