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
package eIP.advbedmgmt.transaction.patientfinancial;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This constants class is for resource messages in the financial info
 * sub module
 * @author GRamamoorthy
 *
 */
public class FinancialInfoResourceConstants {

	/**
	 * Constants denoting the keys to be used to get the string values
	 * from resource bundle properties file
	 */
	public static final String SQLEXCEPTION_KEY = "SQLExceptionErrorMessage";
	
	public static final String DISPLAYMESSAGE_SQLEXCEPTION_KEY = "DisplayMessage.SQLExceptionErrorMessage";
	
	public static final String NULL_RESULTSET_KEY = "NullResultsetErrorMessage";
	
	public static final String DISPLAYMESSAGE_NULL_RESULTSET_KEY = "DisplayMessage.NullResultsetErrorMessage";
	
	public static final String NO_DATA_KEY = "NoDataErrorMessage";
	
	public static final String DISPLAYMESSAGE_NO_DATA_KEY = "DisplayMessage.NoDataErrorMessage";
	
	public static final String CONNECTION_FAILURE_KEY = "ConnectionFailureErrorMessage";
	
	public static final String DISPLAYMESSAGE_CONNECTION_FAILURE_KEY = "DisplayMessage.ConnectionFailureErrorMessage";
	
	
	/**
	 * Constant to denote the path of the resource bundle file
	 */
	public static final String FINANCIAL_INFO_RESOURCE_MESSAGES_FILE_PATH = "eIP.advbedmgmt.transaction.patientfinancial.resourcebundle.Messages";
	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize(){
		BundleManager.getInstance().addToResourceBundleMap(
				/*FinancialInfoConstants.SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.FINANCIAL_INFO_SQLEXCEPTION_ERRORCODE,
				SQLEXCEPTION_KEY,
				DISPLAYMESSAGE_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*FinancialInfoConstants.NULL_RESULTSET_ERRORCODE,*/
				ErrorConstants.FINANCIAL_INFO_NULL_RESULTSET_ERRORCODE,
				NULL_RESULTSET_KEY,
				DISPLAYMESSAGE_NULL_RESULTSET_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*FinancialInfoConstants.NO_DATA_ERRORCODE,*/
				ErrorConstants.FINANCIAL_INFO_NO_DATA_ERRORCODE,
				NO_DATA_KEY,
				DISPLAYMESSAGE_NO_DATA_KEY);
	}
	
	
}
