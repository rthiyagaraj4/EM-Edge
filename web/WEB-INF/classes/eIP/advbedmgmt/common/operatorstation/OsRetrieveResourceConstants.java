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
package eIP.advbedmgmt.common.operatorstation;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This constants file is for resource bundle messages
 * @author GRamamoorthy
 *
 */
public class OsRetrieveResourceConstants {

	/**
	 * Constants denoting the resource bundle key 
	 */
	public static final String SQLEXCEPTION_KEY = "OsRetrieval.SQLException";
	
	public static final String DISPLAY_SQLEXCEPTION_KEY = "Display.OsRetrieval.SQLException";
	
	public static final String NULL_RS_KEY = "OsRetrieval.NullResultSet";
	
	public static final String DISPLAY_NULL_RS_KEY = "Display.OsRetrieval.NullResultSet";
	
	public static final String NO_DATA_KEY = "OsRetrieval.NoData";
	
	public static final String DISPLAY_NO_DATA_KEY = "Display.OsRetrieval.NoData";
	
	public static final String CONNECTION_ISSUE_KEY = "OsRetrieval.ConnectionError";
	
	public static final String DISPLAY_CONNECTION_ISSUE_KEY = "DisplayMessage.OsRetrieval.ConnectionError";
	
	/**
	 * constant to denote the bundle resources file for role based transaction
	 */
	public static final String OS_RETR_RESOURCE_MESSAGE_FILE_PATH = "eIP.advbedmgmt.common.operatorstation.resourcebundle.Messages";
	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize() {
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.OS_RETR_SQLEXCEPTION_CODE, SQLEXCEPTION_KEY,
				DISPLAY_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.OS_RETR_NULL_RS_CODE, NULL_RS_KEY,
				DISPLAY_NULL_RS_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.OS_RETR_NO_DATA_CODE, NO_DATA_KEY,
				DISPLAY_NO_DATA_KEY);
	}
	
	
}
