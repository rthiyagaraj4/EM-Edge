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
package eIP.advbedmgmt.transaction.rolebasedaccess;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * Constants file for resource bundle messages in
 * role based transaction sub module
 * @author GRamamoorthy
 *
 */
public class TransactionListResourceConstants {

	/**
	 * Constants denoting the keys used in resource bundle file
	 */
	public static final String CONNECTION_ERROR_KEY = "RBT.ConnectionError";
	
	public static final String DISPLAY_CONNECTION_ERROR_KEY = "DisplayMessage.RBT.ConnectionError";
	
	public static final String SQLEXCEPTION_KEY = "RBT.SQLException";
	
	public static final String DISPLAY_SQLEXCEPTION_KEY = "DisplayMessage.RBT.SQLException";
	
	public static final String NO_DATA_KEY = "RBT.NoDataError";
	
	public static final String DISPLAY_NO_DATA_KEY = "DisplayMessage.RBT.NoDataError";
	
	/**
	 * constant to denote the bundle resources file for role based transaction
	 */
	public static final String RBT_RESOURCE_MESSAGE_FILE_PATH = "eIP.advbedmgmt.transaction.rolebasedaccess.resourcebundle.Messages";
	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize() {
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.RBT_SQLEXCEPTION_CODE, SQLEXCEPTION_KEY,
				DISPLAY_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.RBT_NODATA_CODE, NO_DATA_KEY,
				DISPLAY_NO_DATA_KEY);
	}
	
	
}
