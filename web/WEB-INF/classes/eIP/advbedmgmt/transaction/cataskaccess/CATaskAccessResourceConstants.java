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
package eIP.advbedmgmt.transaction.cataskaccess;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * Constants file for storing resource bundle related constants
 * 
 * @author GRamamoorthy
 *
 */
public class CATaskAccessResourceConstants {

	/**
	 * Constants denoting the resource bundle message keys for exceptional
	 * scenarios
	 */
	public static final String SQLEXCEPTION_MESSAGE_KEY = "SQLExceptionMessage";
	
	public static final String DISPLAYMESSAGE_SQLEXCEPTION_MESSAGE_KEY = "DisplayMessage.SQLExceptionMessage";
	
	public static final String NULL_RESULTSET_MESSAGE_KEY = "NullResultSetMessage";
	
	public static final String DISPLAYMESSAGE_NULL_RESULTSET_MESSAGE_KEY = "DisplayMessage.NullResultSetMessage";
	
	public static final String INVALID_ACCESS_MESSAGE_KEY = "InvalidAccessMessage";
	
	public static final String DISPLAYMESSAGE_INVALID_ACCESS_MESSAGE_KEY = "DisplayMessage.InvalidAccessMessage";
	
	public static final String CONNECTION_FAILURE_KEY = "ConnectionFailureErrorMessage";
	
	public static final String DISPLAYMESSAGE_CONNECTION_FAILURE_KEY = "DisplayMessage.ConnectionFailureErrorMessage";
	
	
	public static final String RESOURCE_MESSAGES_FILE_PATH = "eIP.advbedmgmt.transaction.cataskaccess.resourcebundle.Messages";
	
	/**
	 * This method adds the resource messages to the common bundle 
	 * This method should always be the last code block in this class
	 */
	public static void initialize(){
		BundleManager.getInstance().addToResourceBundleMap(
				/*CATaskAccessConstants.SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.CA_TASKACCESS_SQLEXCEPTION_ERRORCODE,
				SQLEXCEPTION_MESSAGE_KEY,
				DISPLAYMESSAGE_SQLEXCEPTION_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*CATaskAccessConstants.NULL_RESULTSET_ERRORCODE,*/
				ErrorConstants.CA_TASKACCESS_NULL_RESULTSET_ERRORCODE,
				NULL_RESULTSET_MESSAGE_KEY,
				DISPLAYMESSAGE_NULL_RESULTSET_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*CATaskAccessConstants.INVALID_ACCESS_ERRORCODE,*/
				ErrorConstants.CA_TASKACCESS_INVALID_ACCESS_ERRORCODE,
				INVALID_ACCESS_MESSAGE_KEY,
				DISPLAYMESSAGE_INVALID_ACCESS_MESSAGE_KEY);
	}
	
	
}
