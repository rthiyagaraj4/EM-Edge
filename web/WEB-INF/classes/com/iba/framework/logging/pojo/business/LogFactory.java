/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.logging.pojo.business;

/**
 * @author S Sabarinathan
 * 
 */
public class LogFactory {
	public static Logger getApplicationLogger() {
		return IBALogger.getLogger();
	}

	public static Logger getHL7Logger() {
		return HL7Logger.getLogger();
	}
}
