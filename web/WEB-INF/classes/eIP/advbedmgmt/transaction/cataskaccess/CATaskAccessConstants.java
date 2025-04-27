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

/**
 * This is the constants file for the CA task access checking sub module
 * @author GRamamoorthy
 *
 */
public class CATaskAccessConstants {

	/**
	 * Constants denoting the error codes for the exceptional scenarios
	 */
	/*public static final int SQLEXCEPTION_ERRORCODE = 301;
	
	public static final int NULL_RESULTSET_ERRORCODE = 302;
	
	public static final int INVALID_ACCESS_ERRORCODE = 303;*/
	
	/**
	 * Constant denoting the key word used for CA module
	 */
	public static final String CA_MODULE_KEYWORD = "Clinician Access";
	
	/**
	 * Constant denoting the name of the output column
	 */
	public static final String OUTPUT_COLUMN_KEYWORD = "COUNT";
	
	/**
	 * Constant denoting the name of the privilege status column
	 */
	public static final String PRIVILEGE_STATUS_COLUMN_KEYWORD = "PRIVILEGE_STATUS";
	
	/**
	 * Constant denoting the privilege status's value when
	 * a CA task cannot be accessed
	 */
	public static final String PRIVILEGE_STATUS_INVALID_IDENTIFIER = "X";
	
	/**
	 * Constant denoting the privilege status's value when
	 * a CA module task can be accessed
	 */
	public static final String PRIVILEGE_STATUS_VALID_IDENTIFIER = "A";
	
	
	/**
	 * Constant denoting the keyword used for manage specimen task
	 */
	public static final String MANAGE_SPECIMEN_TASK_KEYWORD = "CA_TASK_LIST_MSPECI";
	
	/**
	 * Constants denoting the keywords used as request parameters to servlet call 
	 */
	public static final String RESPONSIBILITY_ID_REQUEST_KEY = "responsibilityId";
	
	public static final String TASK_ID_REQUEST_KEY = "taskId";
	
	public static final String FACILITYID_REQUEST_KEY = "facilityId";
	
	/**
	 * Constants denoting the keywords to be used when returning
	 * the task access result
	 */
	public static final String RESPONSE_ERRORMESSAGE_KEYWORD = "errorMessage";
	
	public static final String RESPONSE_ACCESSRESULT_KEYWORD = "taskAccessResult";
}
