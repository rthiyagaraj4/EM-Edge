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

/**
 * Constants file for patient search sub module
 * @author gramamoorthy
 *
 */
public class PatientSearchConstants {

	/**
	 * Constants denoting the request parameter keys to be used
	 * when invoking the patient search servlet
	 */
	public static final String PATIENTID_REQUEST_KEY = "patientId";
	
	public static final String FACILITYID_REQUEST_KEY = "facilityId";

	/**
	 * Constant denoting the error code to be used for
	 * SQL exception, null result set and data not obtained for 
	 * patient's nursing unit
	 * 
	 */
	/*public static final int PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE = 201;
	
	public static final int PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE = 202;
	
	public static final int PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE = 203;*/
	
	
	/**
	 * Constants denoting the column keywords to be used
	 * to retrieve the admitted status, nursing unit, room number
	 * and bed number 
	 */
	public static final String ADMITTED_STATUS_KEYWORD = "ADT_STATUS";
	
	public static final String NURSING_UNIT_KEYWORD = "NURSING_UNIT_CODE";
	
	public static final String ROOM_NUMBER_KEYWORD = "ROOM_NUM";
	
	public static final String BED_NUMBER_KEYWORD = "BED_NUM";
	
	public static final String ENCOUNTERID_KEYWORD = "ENCOUNTER_ID";
	
	
	/**
	 * Constants denoting the keywords to be used when returning
	 * a patients nursing unit in patient search sub module
	 */
	public static final String RESPONSE_ERRORMESSAGE_KEYWORD = "errorMessage";
	
	public static final String RESPONSE_PATIENTID_KEYWORD = "patientId";
	
	public static final String RESPONSE_NURSINGUNIT_CODE_KEYWORD = "nursingUnitCode";
	
	public static final String RESPONSE_ROOM_NUMBER_KEYWORD = "roomNumber";
	
	public static final String RESPONSE_BED_NUMBER_KEYWORD = "bedNumber";
	
	public static final String RESPONSE_ADMISSION_STATUS_KEYWORD = "admissionStatus";
	
	/**
	 * Constant denoting the enabled status key for nursing units
	 */
	public static final String ENABLED_NURSING_UNIT_KEY = "E";
	
	/**
	 * Constants denoting the request parameters passed to the bed managment
	 * main GUI in addition to the nursing unit
	 */
	public static final String PATIENT_SRCH_REQUEST_PARAM_KEY = "patientSearch";
	
	public static final String PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY = "patientIdInSearch";
	
	public static final String PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY = "roomNumInSearch";
	
	public static final String PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY = "bedNumInSearch";
	
	/**
	 * Constant denoting the value of the patient search request parameter
	 * passed to the bed management main GUI
	 * This value is passed when user has performed patient search
	 */
	public static final String PATIENT_SRCH_REQUEST_VALUE = "Y";
	
}
