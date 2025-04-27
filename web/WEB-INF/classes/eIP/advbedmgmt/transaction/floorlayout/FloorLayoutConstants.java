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

/**
 * This is a constants class for the floor layout sub module
 * Should contain all the constants to be used in floor layout sub module
 * @author gramamoorthy
 *
 */
public class FloorLayoutConstants {

	/**
	 * Constant denoting the error code to be used for
	 * SQL exception and null result set obtained when getting basic bed details
	 */
	/*
	public static final int BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE = 101;
	
	public static final int BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE = 102;*/
	
	/**
	 * Constant denoting the bed number to be used to get basic bed details
	 */
	public static final String BASIC_BED_DETAILS_BED_NUMBER_ESC_SEQ = "%%";
	
	/**
	 * Constant used to delimit one input value from another in the 
	 * encounter id string passed to get bed status
	 */
	public static final String STATUS_INPUT_DELIMITER = "||";
	
	/**
	 * Constants denoting error codes for bed status retrieval
	 */
	/*public static final int BED_STATUS_SP_EXECUTE_ERRORCODE = 131;
	
	public static final int BED_STATUS_EMPTY_ROOMLIST_ERRORCODE = 132;
	
	public static final int BED_STATUS_SQLEXCEPTION_ERRORCODE = 133;*/
	
	/**
	 * Constants denoting the request param keys to be used
	 * for bed status
	 */
	public static final String NURSINGUNIT_REQUEST_PARAM_KEY = "nursingUnitCode";
	
	public static final String BEDCOUNT_REQUEST_PARAM_KEY = "bedCount";
	
	/**
	 * Constants denoting the identifiers used for representing 
	 * individual data in bed status JSON response
	 * 
	 */
	public static final String ERRORMESSAGE_RESPONSE_KEY = "errorMessage";
	
	public static final String BEDNUMBER_RESPONSE_KEY = "bedNumber";
	
	public static final String ROOMNUMBER_RESPONSE_KEY = "roomNumber";
	
	public static final String BEDSTATUS_RESPONSE_KEY = "bedStatus";
	
	public static final String BEDCOLOR_RESPONSE_KEY = "bedColor";

	public static final String BED_TXT_COLOR_RESPONSE_KEY = "bedTxtColor";
	
	/**
	 * Error codes for bed icon section
	 */
	/*public static final int BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE = 161;
	
	public static final int BED_ICON_SECTION_NO_DATA_ERRORCODE = 162;
	
	public static final int BED_ICON_SECTION_SP_EXECUTE_ERRORCODE = 163;*/
	
	
	/**
	 * constants to denote the index at which individual data elements
	 * are located - this is used for bed icon section
	 */
	public static final int BED_ICON_SECTION_TOT_INDEX = 9;
	
	public static final int BED_ICON_SECTION_ENC_ID_INDEX = 0;
	
	public static final int BED_ICON_SECTION_BED_NUM_INDEX = 1;
	
	public static final int BED_ICON_SECTION_ROOM_NUM_INDEX = 2;
	
	public static final int BED_ICON_SECTION_K_ALLERGY_INDEX = 3;
	
	public static final int BED_ICON_SECTION_BILL_EXIST_INDEX = 4;
	
	public static final int BED_ICON_SECTION_FUTURE_BOOK_INDEX = 5;
	
	public static final int BED_ICON_SECTION_MED_OVERDUE_INDEX = 6;
	
	public static final int BED_ICON_SECTION_ABNORMAL_RESULTS_INDEX = 7;
	
	public static final int BED_ICON_SECTION_PUB_RESULTS_INDEX = 8;
	
	public static final int BED_ICON_SECTION_ORDERS_INDEX = 9;
	
	/**
	 * constant denoting the default value of bill operational value
	 */
	public static final String BILL_OPERATIONAL_DEFAULT_VALUE = "N";
	
	/**
	 * constant denoting the response keys for bed icon section JSON data
	 * 
	 */
	public static final String ENCOUNTERID_RESPONSE_KEY = "encounterId";
	
	public static final String KNOWN_ALLERGY_RESPONSE_KEY = "knownAllergy";
	
	public static final String BILL_EXISTS_RESPONSE_KEY = "billExists";
	
	public static final String FUTURE_BOOKING_RESPONSE_KEY = "futureBookingCnt";
	
	public static final String MED_OVER_DUE_RESPONSE_KEY = "medOverDueCnt";
	
	public static final String ABNORMAL_RESULTS_RESPONSE_KEY = "abnormalResultsCnt";
	
	public static final String PUBLISHED_RESULTS_RESPONSE_KEY = "pubResultsCnt";
	
	public static final String ORDERS_RESPONSE_KEY = "ordersCnt";
	
	/**
	 * Constant denoting the parameter key for total bed count
	 */
	public static final String TOTAL_BED_COUNT_COMP_KEY = "totalBedCount";
	
	/**
	 * Constant denoting the bed details bc name used in the spring
	 * beans configuration file
	 */
	public static final String BED_DETAILS_BC_NAME = "basicBedDetails";
	
	/**
	 * Constant denoting the default background color of a room in a nursing unit
	 */
	public static final String ROOM_DEFAULT_BACKGND_COLOR = "FFFFFF";
	
	/**
	 * Constant denoting the room background column name
	 */
	public static final String ROOM_BACKGROUND_COL_NAME = "BACKGNDCOLOR";
	
}
