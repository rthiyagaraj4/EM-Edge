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
package eIP.advbedmgmt.transaction.floorlayout;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This constants file is for storing the resource bundle keys and constants for
 * error codes in floor layout sub module
 * 
 * @author gramamoorthy
 * 
 */
public class FloorLayoutResourceConstants {

	/**
	 * Constants denoting the resource bundle keys for exception when retrieving
	 * basic bed details
	 */
	public static final String BASIC_BED_DETAILS_SQLEXCEPTION_KEY = "BasicBedDetails.SQLException";

	public static final String DISPLAY_BASIC_BED_DETAILS_SQLEXCEPTION_KEY = "DisplayMessage.BasicBedDetails.SQLException";

	/**
	 * Constants denoting the resource bundle keys for null result set when
	 * retrieving basic bed details
	 */
	public static final String BASIC_BED_DETAILS_NULL_RESULTSET_KEY = "BasicBedDetails.NullResultSet";

	public static final String DISPLAY_BASIC_BED_DETAILS_NULL_RESULTSET_KEY = "DisplayMessage.BasicBedDetails.NullResultSet";

	/**
	 * Constants denoting the resource bundle keys for connection error when
	 * retrieving basic bed details
	 */
	public static final String BASIC_BED_DETAILS_CONNECTION_ERROR_KEY = "BasicBedDetails.ConnectionError";
	
	public static final String DISPLAY_BASIC_BED_DETAILS_CONNECTION_ERROR_KEY = "DisplayMessage.BasicBedDetails.ConnectionError";
	
	/**
	 * Constants denoting the resource bundle keys for bed status related
	 * messages
	 */
	public static final String BED_STAT_SQLEXCEPTION_KEY = "BedStatus.SQLException";
	
	public static final String DISPLAY_BED_STAT_SQLEXCEPTION_KEY = "DisplayMessage.BedStatus.SQLException";
	
	public static final String BED_STAT_SP_EXECUTE_FAILURE_KEY = "BedStatus.SPExecuteError";
	
	public static final String DISPLAY_BED_STAT_SP_EXECUTE_FAILURE_KEY = "DisplayMessage.BedStatus.SPExecuteError";
	
	public static final String BED_STAT_EMPTY_ROOMLIST_KEY = "BedStatus.EmptyRoomListError";
	
	public static final String DISPLAY_BED_STAT_EMPTY_ROOMLIST_KEY = "DisplayMessage.BedStatus.EmptyRoomListError";
	
	public static final String BED_STAT_CONNECTION_ERROR_KEY = "BedStatus.ConnectionError";
	
	public static final String DISPLAY_BED_STAT_CONNECTION_ERROR_KEY = "DisplayMessage.BedStatus.ConnectionError";
	
	
	/**
	 * constants denoting the message keys for bed icon section
	 */
	public static final String BED_ICON_SECT_SQLEXCEPTION_KEY = "BedIconSection.SQLException";
	
	public static final String DISPLAY_BED_ICON_SECT_SQLEXCEPTION_KEY = "BedIconSection.SQLException";
	
	public static final String BED_ICON_SECT_EXECUTE_FAILURE_KEY = "BedIconSection.SPExecuteError";
	
	public static final String DISPLAY_BED_ICON_SECT_EXECUTE_FAILURE_KEY = "DisplayMessage.BedIconSection.SPExecuteError";
	
	public static final String BED_ICON_SECT_NO_DATA_KEY = "BedIconSection.EmptyRoomListError";
	
	public static final String DISPLAY_BED_ICON_SECT_NO_DATA_KEY = "DisplayMessage.BedIconSection.EmptyRoomListError";
	
	public static final String BED_ICON_SECT_CONNECTION_ERROR_KEY = "BedIconSection.ConnectionError";
	
	public static final String DISPLAY_BED_ICON_SECT_CONNECTION_ERROR_KEY = "BedIconSection.ConnectionError";
	
	/**
	 * constant to denote the bundle resources file for floor layout module
	 */
	public static final String FLOOR_LAYOUT_RESOURCE_MESSAGE_FILE_PATH = "eIP.advbedmgmt.transaction.floorlayout.resourcebundle.Messages";

	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize() {
		// basic bed messages
		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE,
				BASIC_BED_DETAILS_SQLEXCEPTION_KEY,
				DISPLAY_BASIC_BED_DETAILS_SQLEXCEPTION_KEY);

		BundleManager
				.getInstance()
				.addToResourceBundleMap(
						/*FloorLayoutConstants.BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE,*/
						ErrorConstants.BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE,
						BASIC_BED_DETAILS_NULL_RESULTSET_KEY,
						DISPLAY_BASIC_BED_DETAILS_NULL_RESULTSET_KEY);
		// bed status messages
		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_STATUS_SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.BED_STATUS_SQLEXCEPTION_ERRORCODE,
				BED_STAT_SQLEXCEPTION_KEY, DISPLAY_BED_STAT_SQLEXCEPTION_KEY);

		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_STATUS_SP_EXECUTE_ERRORCODE,*/
				ErrorConstants.BED_STATUS_SP_EXECUTE_ERRORCODE,
				BED_STAT_SP_EXECUTE_FAILURE_KEY,
				DISPLAY_BED_STAT_SP_EXECUTE_FAILURE_KEY);

		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_STATUS_EMPTY_ROOMLIST_ERRORCODE,*/
				ErrorConstants.BED_STATUS_EMPTY_ROOMLIST_ERRORCODE,
				BED_STAT_EMPTY_ROOMLIST_KEY,
				DISPLAY_BED_STAT_EMPTY_ROOMLIST_KEY);
		
		// bed icon section messages
		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE,*/
				ErrorConstants.BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE,
				BED_ICON_SECT_SQLEXCEPTION_KEY,
				DISPLAY_BED_ICON_SECT_SQLEXCEPTION_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_ICON_SECTION_SP_EXECUTE_ERRORCODE,*/
				ErrorConstants.BED_ICON_SECTION_SP_EXECUTE_ERRORCODE,
				BED_ICON_SECT_EXECUTE_FAILURE_KEY,
				DISPLAY_BED_ICON_SECT_EXECUTE_FAILURE_KEY);
		
		BundleManager.getInstance().addToResourceBundleMap(
				/*FloorLayoutConstants.BED_ICON_SECTION_NO_DATA_ERRORCODE,*/
				ErrorConstants.BED_ICON_SECTION_NO_DATA_ERRORCODE,
				BED_ICON_SECT_NO_DATA_KEY,
				DISPLAY_BED_ICON_SECT_NO_DATA_KEY);
		
	}

}
