/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.iba.framework.core.util.Constants;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class VODOMapReader {
	static PropertyResourceBundle bundle;

	private final static String APP_PREFIX = "ehis";

	private final static String DELIMITER = ".";

	private final static String MASTER_QUERY = "masterQuery";

	static Logger logger = LogFactory.getApplicationLogger();
	static {
		bundle = (PropertyResourceBundle) ResourceBundle
				.getBundle(Constants.VODOMAP_BUNDLE_FILENAME);
	}

	/**
	 * Returns Fully-qualified class name of Data Object
	 * 
	 * @param moduleId
	 * @param functionId
	 * @return
	 */
	public static String getFqnDOString(String moduleId, String functionId) {
		return bundle.getString(APP_PREFIX + DELIMITER + moduleId + DELIMITER
				+ functionId + DELIMITER + "do");
	}

	public static String getFqnVOString(String moduleId, String functionId) {
		return bundle.getString(APP_PREFIX + DELIMITER + moduleId + DELIMITER
				+ functionId + DELIMITER + "vo");
	}

	public static Class getFqnDOClass(String moduleId, String functionId) {
		String strDOClass = bundle.getString(APP_PREFIX + DELIMITER + moduleId
				+ DELIMITER + functionId + DELIMITER + "do");
		Class oDOClass = null;
		try {
			oDOClass = Class.forName(strDOClass);
		} catch (ClassNotFoundException e) {
			logger.error("com.iba.ehis.core.util.VODOMapReader",
					"Data Object not found for \"" + strDOClass + "\".", null);
		}
		return oDOClass;
	}

	public static Class getFqnVOClass(String moduleId, String functionId) {
		String tt = APP_PREFIX + DELIMITER + moduleId + DELIMITER + functionId
				+ DELIMITER + "vo";
		logger.error("com.iba.ehis.core.util.VODOMapReader***", "" + tt, null);
		String strDOClass = bundle.getString(APP_PREFIX + DELIMITER + moduleId
				+ DELIMITER + functionId + DELIMITER + "vo");

		Class oDOClass = null;
		try {
			oDOClass = Class.forName(strDOClass);
		} catch (ClassNotFoundException e) {
			logger.error("com.iba.ehis.core.util.DOVOMapReader",
					"Data Object not found for \"" + strDOClass + "\".", null);
		}
		return oDOClass;
	}

	public static String getQueryId(String moduleId, String functionId) {
		String queryId = (APP_PREFIX + DELIMITER + moduleId + DELIMITER
				+ functionId + DELIMITER + MASTER_QUERY);
		return queryId;
	}

	/**
	 * Testing purpose - will be deleted later
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "mealtypevo")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "mealclassvo")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "deliveryinstructionvo")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "complaints")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "nutrients")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "feedtype")
				+ "", null);
		logger.debug("com.iba.ehis.core.util.VODOMapReader", getFqnDOClass(
				"ds", "dswardsforkitchen")
				+ "", null);

	}
}
