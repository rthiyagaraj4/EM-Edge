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
package eIP.advbedmgmt.transaction.patientsearch;

import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This constants file is for storing the resource bundle keys and constants for
 * error codes in patient search sub module
 * 
 * @author gramamoorthy
 * 
 */
public class PatientSearchResourceConstants {

	/**
	 * Constants denoting the resource bundle keys for exception when retrieving
	 * patient's nursing unit
	 */
	public static final String PATIENT_SEARCH_SQLEXCEPTION_KEY = "PatientSearch.SQLException";

	public static final String DISPLAY_PATIENT_SEARCH_SQLEXCEPTION_KEY = "DisplayMessage.PatientSearch.SQLException";

	/**
	 * Constants denoting the resource bundle keys for null result set when
	 * retrieving patient's nursing unit
	 */
	public static final String PATIENT_SEARCH_NULL_RESULTSET_KEY = "PatientSearch.NullResultSet";

	public static final String DISPLAY_PATIENT_SEARCH_NULL_RESULTSET_KEY = "DisplayMessage.PatientSearch.NullResultSet";

	/**
	 * Constants denoting the resource bundle keys for data not available
	 * scenario when retrieving patient's nursing unit
	 */
	public static final String PATIENT_SEARCH_NO_DATA_KEY = "PatientSearch.DataNotObtained";

	public static final String DISPLAY_PATIENT_SEARCH_NO_DATA_KEY = "DisplayMessage.PatientSearch.DataNotObtained";

	public static final String CONNECTION_FAILURE_KEY = "ConnectionFailureErrorMessage";
	
	public static final String DISPLAYMESSAGE_CONNECTION_FAILURE_KEY = "DisplayMessage.ConnectionFailureErrorMessage";
	
	/**
	 * constant to denote the bundle resources file for floor layout module
	 */
	public static final String PATIENT_SEARCH_RESOURCE_MESSAGES_FILE_PATH = "eIP.advbedmgmt.transaction.patientsearch.resourcebundle.Messages";

	/**
	 * This code is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	/*static {
		BundleManager.getInstance().addToResourceBundleMap(
				PatientSearchConstants.PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE,
				PATIENT_SEARCH_SQLEXCEPTION_KEY,
				DISPLAY_PATIENT_SEARCH_SQLEXCEPTION_KEY);

		BundleManager
				.getInstance()
				.addToResourceBundleMap(
						PatientSearchConstants.PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE,
						PATIENT_SEARCH_NULL_RESULTSET_KEY,
						DISPLAY_PATIENT_SEARCH_NULL_RESULTSET_KEY);

		BundleManager
				.getInstance()
				.addToResourceBundleMap(
						PatientSearchConstants.PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE,
						PATIENT_SEARCH_NO_DATA_KEY,
						DISPLAY_PATIENT_SEARCH_NO_DATA_KEY);
	}*/

	
	/**
	 * This method is written to add the resource messages to the bundle manager
	 * this block should always be the last in this class
	 */
	public static void initialize() {
		BundleManager.getInstance().addToResourceBundleMap(
				/*PatientSearchConstants.PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE,*/
				ErrorConstants.PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE,
				PATIENT_SEARCH_SQLEXCEPTION_KEY,
				DISPLAY_PATIENT_SEARCH_SQLEXCEPTION_KEY);

		BundleManager
				.getInstance()
				.addToResourceBundleMap(
						/*PatientSearchConstants.PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE,*/
						ErrorConstants.PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE,
						PATIENT_SEARCH_NULL_RESULTSET_KEY,
						DISPLAY_PATIENT_SEARCH_NULL_RESULTSET_KEY);

		BundleManager
				.getInstance()
				.addToResourceBundleMap(
						/*PatientSearchConstants.PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE,*/
						ErrorConstants.PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE,
						PATIENT_SEARCH_NO_DATA_KEY,
						DISPLAY_PATIENT_SEARCH_NO_DATA_KEY);
	}

}
