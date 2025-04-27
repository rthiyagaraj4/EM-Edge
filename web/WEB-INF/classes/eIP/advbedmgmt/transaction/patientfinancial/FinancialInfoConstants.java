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

/**
 * This constants file is for the financial info sub module
 * @author GRamamoorthy
 *
 */
public class FinancialInfoConstants {

	/**
	 * Constants denoting the error code for the financial info 
	 * operation
	 */
	/*public static final int SQLEXCEPTION_ERRORCODE = 401;
	
	public static final int NULL_RESULTSET_ERRORCODE = 402;
	
	public static final int NO_DATA_ERRORCODE = 403;*/
	
	/**
	 * Constant denoting the resultset column to refer
	 * while getting financial info meta data
	 */
	public static final String ENCOUNTER_VISIT_NUM_KEY = "OP_EPISODE_VISIT_NUM";
	
	/**
	 * Constants denoting the attributes used in JSON representation
	 * these constants are used to send data back to the GUI in JSON format
	 */
	public static final String RESPONSE_ERRORMESSAGE_KEY = "errorMessage";
	
	public static final String RESPONSE_ENCOUNTER_VISIT_NUM_KEY = "encounterVisitNum";
	
	/**
	 * Constants denoting request parameter key used for patient id and 
	 * encounter id
	 */
	public static final String PATIENTID_KEY = "patientId";
	
	public static final String ENCOUNTERID_KEY = "encounterId";
	
}
