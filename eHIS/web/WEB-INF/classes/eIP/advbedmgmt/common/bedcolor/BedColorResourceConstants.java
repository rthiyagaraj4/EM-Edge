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
package eIP.advbedmgmt.common.bedcolor;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This is the constants file for resource messages
 * @author GRamamoorthy
 *
 */
public class BedColorResourceConstants {
	
	/**
	 * Constants denoting the resource bundle message keys
	 */
	public static final String SQLEXCEPTION_MESSAGE_KEY = "BedColor.SQLException";
	
	public static final String DISPLAY_SQLEXCEPTION_MESSAGE_KEY = "Display.BedColor.SQLException";
	
	public static final String NULLRESULTSET_MESSAGE_KEY = "BedColor.NullResultSet";
	
	public static final String DISPLAY_NULLRESULTSET_MESSAGE_KEY = "Display.BedColor.NullResultSet";
	
	public static final String NODATA_MESSAGE_KEY = "BedColor.NoDataError";
	
	public static final String DISPLAY_NODATA_MESSAGE_KEY = "Display.BedColor.NoDataError";

	/**
	 * constant to denote the bundle resources file for bed color
	 */
	public static final String RESOURCE_MESSAGE_FILE_PATH = "eIP.advbedmgmt.common.bedcolor.resourcebundle.Messages";
	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize() {
		BundleManager.getInstance().addToResourceBundleMap(
				/*BedColorConstants.BED_COLOR_SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.BED_COLOR_SQLEXCEPTION_ERRORCODE,
				SQLEXCEPTION_MESSAGE_KEY,
				DISPLAY_SQLEXCEPTION_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*BedColorConstants.BED_COLOR_NULLRESULTSET_ERRORCODE,*/
				ErrorConstants.BED_COLOR_NULLRESULTSET_ERRORCODE,
				NULLRESULTSET_MESSAGE_KEY,
				DISPLAY_NULLRESULTSET_MESSAGE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*BedColorConstants.BED_COLOR_NODATA_ERRORCODE,*/
				ErrorConstants.BED_COLOR_NODATA_ERRORCODE,
				NODATA_MESSAGE_KEY,
				DISPLAY_NODATA_MESSAGE_KEY);
	}
	
}
