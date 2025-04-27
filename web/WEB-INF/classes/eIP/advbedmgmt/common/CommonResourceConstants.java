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
package eIP.advbedmgmt.common;

import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;

/**
 * This constants file is used to store the resource bundle key and error codes
 * for the common sub module
 * 
 * @author gramamoorthy
 * 
 */
public class CommonResourceConstants {

	/**
	 * constants denoting database connection failure keys
	 */
	public static final String DATABASE_CONN_FAILURE_KEY = "DatabaseConnectionFailure";

	public static final String DISPLAY_DATABASE_CONN_FAILURE_KEY = "DisplayMessage.DatabaseConnectionFailure";

	/**
	 * constant to denote the bundle resources file for common module
	 */
	public static final String COMMON_RESOURCES_FILE_CLASSPATH = "eIP.advbedmgmt.common.resourcebundle.CommonResources";
	/**
	 * This code is written to initialize the map with resource bundle keys
	 * this block should always be the last in this class
	 */
	/*static {
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
				DATABASE_CONN_FAILURE_KEY, DISPLAY_DATABASE_CONN_FAILURE_KEY);
	}*/
	
	
	/**
	 * This method is written to initialize the map with resource bundle keys
	 * this block should always be the last in this class
	 */
	public static void initialize(){
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
				DATABASE_CONN_FAILURE_KEY, DISPLAY_DATABASE_CONN_FAILURE_KEY);
	}

}
