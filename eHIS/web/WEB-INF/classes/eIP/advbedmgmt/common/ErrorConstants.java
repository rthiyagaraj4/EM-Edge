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

/**
 * This constants file will have all the error codes
 * 
 * @author GRamamoorthy
 *
 */
public class ErrorConstants {

	/**
	 * Constants denoting the error codes for the exceptional scenarios
	 * in CA task access functionality
	 */
	public static final int CA_TASKACCESS_SQLEXCEPTION_ERRORCODE = 301;
	
	public static final int CA_TASKACCESS_NULL_RESULTSET_ERRORCODE = 302;
	
	public static final int CA_TASKACCESS_INVALID_ACCESS_ERRORCODE = 303;
	
	/**
	 * Constants denoting the error code for the financial info 
	 * operation 
	 */
	public static final int FINANCIAL_INFO_SQLEXCEPTION_ERRORCODE = 401;
	
	public static final int FINANCIAL_INFO_NULL_RESULTSET_ERRORCODE = 402;
	
	public static final int FINANCIAL_INFO_NO_DATA_ERRORCODE = 403;
	
	/**
	 * Constant denoting the error code to be used for
	 * SQL exception, null result set and data not obtained for 
	 * patient's nursing unit
	 * 
	 */
	public static final int PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE = 201;
	
	public static final int PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE = 202;
	
	public static final int PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE = 203;
	
	/**
	 * Constant denoting the error code to be used for
	 * SQL exception and null result set obtained when getting basic bed details
	 */
	public static final int BASIC_BED_DETAILS_SQLEXCEPTION_ERRORCODE = 101;
	
	public static final int BASIC_BED_DETAILS_NULL_RESULTSET_ERRORCODE = 102;
	
	/**
	 * Constants denoting error codes for bed status retrieval
	 */
	public static final int BED_STATUS_SP_EXECUTE_ERRORCODE = 131;
	
	public static final int BED_STATUS_EMPTY_ROOMLIST_ERRORCODE = 132;
	
	public static final int BED_STATUS_SQLEXCEPTION_ERRORCODE = 133;
	
	/**
	 * Error codes for bed icon section
	 */
	public static final int BED_ICON_SECTION_SQLEXCEPTION_ERRORCODE = 161;
	
	public static final int BED_ICON_SECTION_NO_DATA_ERRORCODE = 162;
	
	public static final int BED_ICON_SECTION_SP_EXECUTE_ERRORCODE = 163;
	
	/**
	 * Constants denoting the error codes while getting bed color
	 */
	public static final int BED_COLOR_SQLEXCEPTION_ERRORCODE = 501;
	
	public static final int BED_COLOR_NULLRESULTSET_ERRORCODE = 502;
	
	public static final int BED_COLOR_NODATA_ERRORCODE = 503;
	
	/**
	 * Error codes for bed legend
	 */
	public static final int BED_LEGEND_SQLEXCEPTION_ERROR_CODE = 601;
	
	public static final int BED_LEGEND_NULL_RESULTSET_ERROR_CODE = 602;
	
	public static final int BED_LEGEND_DATA_NOT_OBTAINED_ERROR_CODE = 603;
	
	
	/**
	 * Error codes for bed dimensions
	 * RETRIEVE DIMENSIONS -- 701 - 750
	 * SAVE DIMENSIONS -- 751 - 800 
	 */
	public static final int RETRIEVE_DIM_SQLEXCEPTION_CODE = 701;
	
	public static final int RETRIEVE_DIM_NULLRESULTSET_CODE = 702;
	
	public static final int RETRIEVE_DIM_NODATA_CODE = 703;
	
	
	public static final int SAVE_DIM_SQLEXCEPTION_CODE = 751;
	
	public static final int SAVE_DIM_UPDATE_FAIL_CODE = 752;
	
	
	/**
	 * Error codes for role based transactions
	 */
	public static final int RBT_SQLEXCEPTION_CODE = 901;
	
	public static final int RBT_NODATA_CODE = 902;
	
	/**
	 * Error codes for Operator station id retrieval
	 */
	public static final int OS_RETR_SQLEXCEPTION_CODE = 1001;
	
	public static final int OS_RETR_NULL_RS_CODE = 1002;
	
	public static final int OS_RETR_NO_DATA_CODE = 1003;
	
	
}
