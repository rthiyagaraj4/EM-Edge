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
package portalrefimpl;

/**
 * Constants file at portal application level
 * @author GRamamoorthy
 *
 */
public class PortalConstants {

	/**
	 * constants denoting the keys to be used for retrieving
	 * the HTTP URL of the various web services 
	 */
	public static final String APPOINTMENTDETAILS_WS_URL_KEY = "AppointmentDetailsServiceURL";
	
	public static final String UPCOMINGAPPOINTMENTDETAILS_WS_URL_KEY = "UpcomingAppointmentDetailsServiceURL";
	
	public static final String TESTDETAILS_WS_URL_KEY = "TestDetailsServiceURL";
	
	public static final String LOGIN_WS_URL_KEY = "LoginServiceURL";
	
	public static final String HOMEPAGE_WS_URL_KEY = "HomePageServiceURL";
	
	public static final String DETAILED_TESTRESULT_WS_URL_KEY = "DetailedTestResultsServiceURL";
	
	public static final String TESTRESULT_WS_URL_KEY = "TestResultServiceURL";
	
	public static final String FACILITY_LIST_WS_URL_KEY = "FacilityListServiceURL";
	
	public static final String CREATEAPPOINTMENT_GETSPECIALITY_WS_URL_KEY = "CreateAppointmentGetSpecialityServiceURL";
	
	public static final String CREATEAPPOINTMENT_GETPRACTITIONER_WS_URL_KEY = "CreateAppointmentGetPractitionerServiceURL";
	
	public static final String CREATEAPPOINTMENT_GETPRACTITIONERSCHEDULE_WS_URL_KEY = "CreateAppointmentGetPractitionerScheduleServiceURL";
	
	public static final String CREATEAPPOINTMENT_GETPRACTITIONERTIMESLOT_WS_URL_KEY = "CreateAppointmentGetPractitionerTimeSlotServiceURL";
	
	public static final String CREATEAPPOINTMENT_GETPRACTITIONERSCHEDULESTATUS_WS_URL_KEY = "CreateAppointmentGetPractitionerScheduleStatusServiceURL";
	
	public static final String CREATEAPPOINTMENT_WS_URL_KEY = "CreateAppointmentServiceURL";
	
	public static final String CONTACTREASON_CANCELAPPT_WS_URL_KEY = "ContactReasonForCancelAppointmentURL";
	
	public static final String FACILITY_FOR_CONTACT_WS_URL_KEY = "FacilityForContactURL";
	
	public static final String CANCEL_APPOINTMENT_WS_URL_KEY = "CancelAppointmentURL";
	
	public static final String GET_APPTREQDETAILS_WS_URL_KEY = "GetApptRequestDetailsURL";
	
	public static final String RESCHEDULE_APPT_REQ_WS_URL_KEY = "RescheduleApptRequestDetailsURL";
	
	public static final String RESCHEDULE_APPT_REQ_CONTACT_REASON_WS_URL_KEY = "RescheduleApptRequestContactReasonURL";
	
	public static final String ERRORINFO_KEY = "ErrorInfo";
	
	public static final String ERRORCODE_KEY = "ErrorCode";
	
	public static final String ERRORMESSAGE_KEY = "ErrorMessage";
	
	public static final String ERRORS_WRAPPER_KEY = "Errors";
	
	public static final String ERROR_KEY = "Error";
	
	
	/**
	 * Constant denoting the patient id request parameter
	 */
	public static final String PATIENTID_REQUEST_PARAM_KEY = "patientId";
	
	/**
	 * Constants denoting the parameter and value 
	 * used for authenticating web service
	 */
	public static final String PORTALUSER_REQUEST_PARAM_KEY = "portalUser";
	
	public static final String PORTALUSER_REQUEST_PARAM_VALUE = "portalUser";
	
	/**
	 * 
	 */
	public static final String FACILITYID_REQUEST_PARAM_KEY = "facilityId";
	
	public static final String OPEN_XML_TAG = "<";
	
	public static final String XML_CLOSE_TAG = ">";
	
	public static final String CLOSE_XML_TAG = "</";
	
	

	/**
	 * 
	 */
	public static final String LOGINRESPONSE_SESSION_KEY = "loginResponse";
	
	/**
	 * 
	 */
	public static final String USEWEBSERVICE_SESSION_KEY = "useWebService";
	
	public static final String PATIENTNAME_SESSION_KEY = "patientName";

	/**
	 * 
	 */
	public static final String DEFAULT_LOCALE = "en";
	
	/**
	 * 
	 */
	public static final String CHARDATA_START_KEY = "<![CDATA[";
	
	public static final String CHARDATA_END_KEY = "]]>";
	
	public static final int HOMEPAGE_TESTRESULT_RECORDCOUNT = 3;
	
	public static final int HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT = 3;

	public static final String DATABASE_CONNECTION_URL_KEY = "DatabaseConnectionURL";
	
	public static final String DATABASE_CONNECTION_CLASS_KEY = "DatabaseConnectionClass";
	
	public static final String DATABASE_USER_KEY = "DatabaseUser";
	
	public static final String DATABASE_PASSWORD_KEY = "DatabasePassword";
	
}
