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
public class HL7Logger extends BaseLog4jLogger {
	private static HL7Logger logger;

	private HL7Logger() {
		setLog4jLogger(Logger.getLogger(Constants.HL7_LOG));
	}

	public static com.iba.framework.logging.pojo.business.Logger getLogger() {
		if (logger == null) {
			logger = new HL7Logger();
		}
		return (com.iba.framework.logging.pojo.business.Logger) logger;
	}
}
