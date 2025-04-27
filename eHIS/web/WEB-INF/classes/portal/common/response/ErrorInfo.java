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
package portal.common.response;

/**
 * This object stores/defines all the error or success codes / messages
 * returned as a part of all Response objects
 * 
 * @author GRamamoorthy
 *
 */
public class ErrorInfo {
	
	/* common success code */
	public static final int SUCCESS_CODE = 1;
	
	/* for login */
	public static final int CONNECTION_FAILURE_CODE = 2;
	
	public static final int SQLEXCEPTION_CODE = 3;
	
	public static final int WEBSVC_CONN_ERROR_CODE = 4;
	
	public static final int NO_DB_DATA_RETURNED_CODE = 5;
	
	public static final int INVALID_LOGIN_CODE = 6;
	
	public static final int INSUFFICIENT_REQUEST_PARAMETERS_CODE = 7;
	
	
	/* for Hospital */
	public static final int HOSPITAL_CONNECTION_FAILURE_CODE = 102;
	
	public static final int HOSPITAL_SQLEXCEPTION_CODE = 103;
	
	public static final int HOSPITAL_WEBSVC_CONN_ERROR_CODE = 104;
	
	public static final int HOSPITAL_NO_DB_DATA_RETURNED_CODE = 105;
	
	public static final int HOSPITAL_INVALID_LOGIN_CODE = 106;
	
	public static final int HOSPITAL_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 107;
	
	/* for Patient Details */
	public static final int PATIENT_CONNECTION_FAILURE_CODE = 202;
	
	public static final int PATIENT_SQLEXCEPTION_CODE = 203;
	
	public static final int PATIENT_WEBSVC_CONN_ERROR_CODE = 204;
	
	public static final int PATIENT_NO_DB_DATA_RETURNED_CODE = 205;
	
	public static final int PATIENT_INVALID_LOGIN_CODE = 206;
	
	public static final int PATIENT_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 207;
	
	/* for View Home page Appointment Details */
	public static final int HOME_APPT_CONNECTION_FAILURE_CODE = 302;
	
	public static final int HOME_APPT_SQLEXCEPTION_CODE = 303;
	
	public static final int HOME_APPT_WEBSVC_CONN_ERROR_CODE = 304;
	
	public static final int HOME_APPT_NO_DB_DATA_RETURNED_CODE = 305;
	
	public static final int HOME_APPT_INVALID_LOGIN_CODE = 306;
	
	public static final int HOME_APPT_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 307;
	
	/* for View Home page Test Details */
	public static final int HOME_TEST_CONNECTION_FAILURE_CODE = 402;
	
	public static final int HOME_TEST_SQLEXCEPTION_CODE = 403;
	
	public static final int HOME_TEST_WEBSVC_CONN_ERROR_CODE = 404;
	
	public static final int HOME_TEST_NO_DB_DATA_RETURNED_CODE = 405;
	
	public static final int HOME_TEST_INVALID_LOGIN_CODE = 406;
	
	public static final int HOME_TEST_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 407;
	
	/* for View Test Result Details page */
	public static final int TESTRESULTDETAILS_CONNECTION_FAILURE_CODE = 502;
	
	public static final int TESTRESULTDETAILS_SQLEXCEPTION_CODE = 503;
	
	public static final int TESTRESULTDETAILS_WEBSVC_CONN_ERROR_CODE = 504;
	
	public static final int TESTRESULTDETAILS_NO_DB_DATA_RETURNED_CODE = 505;
	
	public static final int TESTRESULTDETAILS_INVALID_LOGIN_CODE = 506;
	
	public static final int TESTRESULTDETAILS_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 507;
	
	/* for View Test Report page */
	public static final int TESTREPORT_CONNECTION_FAILURE_CODE = 602;
	
	public static final int TESTREPORT_SQLEXCEPTION_CODE = 603;
	
	public static final int TESTREPORT_WEBSVC_CONN_ERROR_CODE = 604;
	
	public static final int TESTREPORT_NO_DB_DATA_RETURNED_CODE = 605;
	
	public static final int TESTREPORT_INVALID_LOGIN_CODE = 606;
	
	public static final int TESTREPORT_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 607;
	
	/* for View Upcoming Appointment Details */
	public static final int UPCOMING_APPT_CONNECTION_FAILURE_CODE = 702;
	
	public static final int UPCOMING_APPT_SQLEXCEPTION_CODE = 703;
	
	public static final int UPCOMING_APPT_WEBSVC_CONN_ERROR_CODE = 704;
	
	public static final int UPCOMING_APPT_NO_DB_DATA_RETURNED_CODE = 705;
	
	public static final int UPCOMING_APPT_INVALID_LOGIN_CODE = 706;
	
	public static final int UPCOMING_APPT_INSUFFICIENT_REQUEST_PARAMETERS_CODE = 707;
	
	/* for Facility Service */
	public static final int FACILITY_CONNECTION_FAILURE_CODE = 802;
	
	public static final int FACILITY_SQLEXCEPTION_CODE = 803;
	
	public static final int FACILITY_WEBSVC_CONN_ERROR_CODE = 804;
	
	public static final int FACILITY_NO_DB_DATA_RETURNED_CODE = 805;
	
	public static final int FACILITY_INVALID_LOGIN_CODE = 806;
	
	/* for Result Type Service */
	public static final int RESULTTYPE_CONNECTION_FAILURE_CODE = 902;
	
	public static final int RESULTTYPE_SQLEXCEPTION_CODE = 903;
	
	public static final int RESULTTYPE_WEBSVC_CONN_ERROR_CODE = 904;
	
	public static final int RESULTTYPE_NO_DB_DATA_RETURNED_CODE = 905;
	
	public static final int RESULTTYPE_INVALID_LOGIN_CODE = 906;
	
	
	/* called in invoker */
	public static final String WEBSVC_CONN_ERROR_MESSAGE = "Could not connect to web service. Exception message={0}";
	
	public static final String NO_DB_DATA_RETURNED_MESSAGE = "Could not get any record";

	
	private int errorCode = 0;
	
	private String errorMessage = null;
	
	/**
	 * 
	 */
	public ErrorInfo() {
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
