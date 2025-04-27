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
package eIP.advbedmgmt.common.bedlegend;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * this is constants file for resource bundle messages
 * @author GRamamoorthy
 *
 */
public class BedLegendResourceConstants {

	/**
	 * Constants denoting the error message keys used in the resource
	 * bundle properties file
	 */
	public static final String SQLEXCEPTION_MESSAGE_KEY = "BedLegend.SQLExceptionErrorMessage";
	
	public static final String DISPLAY_SQLEXCEPTION_MESSAGE_KEY = "DisplayMessage.BedLegend.SQLExceptionErrorMessage";
	
	public static final String NULL_RS_MESSAGE_KEY = "BedLegend.NullResultSetErrorMessage";
	
	public static final String DISPLAY_NULL_RS_MESSAGE_KEY = "DisplayMessage.BedLegend.NullResultSetErrorMessage";
	
	public static final String NO_DATA_MESSAGE_KEY = "BedLegend.NoDataErrorMessage";
	
	public static final String DISPLAY_NO_DATA_MESSAGE_KEY = "DisplayMessage.BedLegend.NoDataErrorMessage";
	
	public static final String CONNECTION_ERROR_KEY = "BedLegend.ConnectionError";
	
	public static final String DISPLAY_CONNECTION_ERROR_KEY = "DisplayMessage.BedLegend.ConnectionError";
	
	
	/**
	 * constant to denote the bundle resources file for bed color
	 */
	public static final String RESOURCE_MESSAGE_FILE_PATH = "eIP.advbedmgmt.common.bedlegend.resourcebundle.Messages";
	
	/**
	 * This method should always be placed at the bottom of this file
	 */
	public static void initialize(){
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.BED_LEGEND_SQLEXCEPTION_ERROR_CODE,
				SQLEXCEPTION_MESSAGE_KEY, DISPLAY_SQLEXCEPTION_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.BED_LEGEND_NULL_RESULTSET_ERROR_CODE,
				NULL_RS_MESSAGE_KEY, DISPLAY_NULL_RS_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				ErrorConstants.BED_LEGEND_DATA_NOT_OBTAINED_ERROR_CODE,
				NO_DATA_MESSAGE_KEY, DISPLAY_NO_DATA_MESSAGE_KEY);
	}
	
}
