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

/**
 * Constants file for role based access sub module
 * @author GRamamoorthy
 *
 */
public class TransactionListConstants {

	/**
	 * Constant denoting the value for the location type
	 * to be used in retrieving role based transactions
	 * This value signifies Nursing Unit as the default
	 * location type
	 */
	public static final String NU_LOCATION_TYPE = "N";
	
	/**
	 * Constants denoting the index position at which
	 * respective data is present in the output data
	 * for role based transaction list
	 */
	public static final int MODULE_ID_INDEX = 0;
	
	public static final int FUNCTION_ID_INDEX = 1;
	
	public static final int DESCRIPTION_INDEX = 2;
	
	public static final int EXECUTABLE_INDEX = 3;
	
	public static final int INSERT_ACCESS_INDEX = 4;
	
	public static final int UPDATE_ACCESS_INDEX = 5;
	
	public static final int DELETE_ACCESS_INDEX = 6;
	
	public static final int PRINT_ACCESS_INDEX = 7;
	
	public static final int QUERY_ACCESS_INDEX = 8;
	
	/**
	 * Constant denoting the total number of columns
	 * present in the output of role based transactions
	 */
	public static final int TOTAL_DATA_COUNT = 9;
	
	/**
	 * constant denoting the IP module keyword
	 */
	public static final String INPATIENT_MGMT_MODULE = "IP";
	
	/**
	 * constant denoting the bean class key
	 */
	public static final String BEAN_CLASS_KEY = "rbtList";
	
	/**
	 * constant denoting the allowed function ids in IP module
	 */
	// create booking is a work in progress
	/*public static final String BOOKING_FUNC_ID = "BOOKING";*/
	
	public static final String ASSIGN_TREAT_PRACT_FUNC_ID = "ASSIGN_TREAT_PRACT";
	
	public static final String CANCEL_ADM_FUNC_ID = "CANCEL_ADMN";
	
	// this is also a work in progress
	/*public static final String REQ_FOR_TRANSFER_FUNC_ID = "BED_TRANS_BOOKING";*/
	
	public static final String PREP_DISCH_ADV_FUNC_ID = "PRE_DIS_ADVICE";
	
	public static final String CANC_DISCH_ADV_FUNC_ID = "CAN_DIS_ADVICE";
	
	public static final String DISCH_PATIENT_FUNC_ID = "DISCHARGE_PATIENT";
	
	public static final String ADM_PATIENT_FUNC_ID = "ADMISSION";
	
	public static final String ASSIGN_BED_FUNC_ID = "ASSIGN_BED";
	
	
	
}
