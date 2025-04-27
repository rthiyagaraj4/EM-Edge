/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.framework.core.util;

import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * @author S Sabarinathan
 * 
 */
public class ApplicationPropertyReader {
	static PropertyResourceBundle bundle;

	static Logger logger = LogFactory.getApplicationLogger();
	static {
		bundle = (PropertyResourceBundle) ResourceBundle
				.getBundle(Constants.APPLICATION_BUNDLE_FILENAME);
	}

	public static long getUserCacheTimeoutInMills() {
		return (getUserCacheTimeout() * (60 * 1000));
	}

	public static long getUserCacheTimeout() {
		return (Long.parseLong(bundle.getString("user_session_cache_timeout")));
	}

	public static long getPatientCacheTimeoutInMills() {
		return (getPatientCacheTimeout() * (24 * 60 * 60 * 1000));
	}

	public static long getPatientCacheTimeout() {
		return (Long.parseLong(bundle.getString("user_session_cache_timeout")));
	}

	public static String getApplicationName() {
		return (bundle.getString("application_name"));
	}

	public static int getPageSize() {
		return (Integer.parseInt(bundle.getString("records_per_page")));
	}

	public static String getEvent() {
		return (bundle.getString("discreteMeaure.Event"));
	}

	/**
	 * This method is added to dynamically load the queries
	 */
	public static String getQueryLoadType() {
		return bundle.getString("query_load_type");
	}

	public static String getWebRoot() {
		return bundle.getString("webroot_name");
	}
	public static String[] getConfigFiles()
    {
        String configFiles = bundle.getString("config_files");
        MissingResourceException e;
        if(configFiles != null)
            return configFiles.split(",");
        else
            return null;
      
    }

   
}
