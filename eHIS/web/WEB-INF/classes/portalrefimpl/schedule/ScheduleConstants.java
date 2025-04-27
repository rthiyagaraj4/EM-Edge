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
package portalrefimpl.schedule;

/**
 * @author SaraswathiR
 * 
 */
public class ScheduleConstants {

	/**
	 * The different error codes used in the appointments module
	 */
	public static final int UPCOMING_APPTS_NULLRESULTSET_ERRORCODE = 2021;

	public static final int UPCOMING_APPTS_SQLEXCEPTION_ERRORCODE = 2022;

	public static final int UPCOMING_APPTS_NOTOBTAINED_ERRORCODE = 2023;
	
	public static final int UPCOMING_APPTREQ_NULLRESULTSET_ERRORCODE = 2024;
	
	public static final int UPCOMING_APPTREQ_SQLEXCEPTION_ERRORCODE = 2025;
	
	public static final int UPCOMING_APPTREQ_NOTOBTAINED_ERRORCODE = 2026;

	/**
	 * The different error codes used in the upcoming appointments module
	 */

	public static final int UPCOMING_APPOINTMENTS_PATIENTID_ABSENT_ERRORCODE = 2001;

	public static final int UPCOMING_APPOINTMENTS_FACILITYID_ABSENT_ERRORCODE = 2002;

	public static final int UPCOMING_APPOINTMENTS_STARTRECORDNUM_ABSENT_ERRORCODE = 2003;

	public static final int UPCOMING_APPOINTMENTS_ENDRECORDNUM_ABSENT_ERRORCODE = 2004;

	public static final int UPCOMING_APPOINTMENTS_FROMDATE_ABSENT_ERRORCODE = 2005;

	public static final int UPCOMING_APPOINTMENTS_TODATE_ABSENT_ERRORCODE = 2006;

	public static final int UPCOMING_APPOINTMENTS_START_GREATER_THAN_END_ERRORCODE = 2007;

	public static final int UPCOMING_APPOINTMENTS_START_END_RECORDNUM_INVALID_ERRORCODE = 2008;

	public static final int UPCOMING_APPOINTMENTS_FROM_DATE_INVALIDFORMAT_ERRORCODE = 2009;

	public static final int UPCOMING_APPOINTMENTS_TODATE_BEFORE_FROMDATE_ERRORCODE = 2010;

	public static final int UPCOMING_APPOINTMENTS_FROMDATE_BEFORE_CURRENTDATE_ERRORCODE = 2013;

	public static final int UPCOMING_APPOINTMENTS_SQLEXCEPTION_ERRORCODE = 2011;

	public static final int UPCOMING_APPOINTMENTS_XMLPARSE_EXCEPTION_ERRORCODE = 2012;
	
	public static final int UPCOMING_APPOINTMENTS_TODATE_INVALIDFORMAT_ERRORCODE = 2014;

	/**
	 * these are constants denoting the request parameter key values to be used
	 * for getting upcoming appointments
	 */
	public static final String UPCOMINGAPPOINTMENTS_STARTRECORDNUM_REQUEST_PARAM_KEY = "startRecordNum";

	public static final String UPCOMINGAPPOINTMENTS_ENDRECORDNUM_REQUEST_PARAM_KEY = "endRecordNum";

	public static final String UPCOMINGAPPOINTMENTS_FACILITYID_REQUEST_PARAM_KEY = "facilityId";

	public static final String UPCOMINGAPPOINTMENTS_FROMDATE_REQUEST_PARAM_KEY = "fromDate";

	public static final String UPCOMINGAPPOINTMENTS_TODATE_REQUEST_PARAM_KEY = "toDate";

	/**
	 * Constant denoting the date format to be used for upcoming appointments
	 * module
	 */
	public static final String UPCOMINGAPPOINTMENTS_DATE_FORMAT = "dd/MM/yyyy";

	public static final String UPCOMINGAPPOINTMENTS_TABLE_DATE_FORMAT = "dd-MMM-yy";

	/**
	 * constants denoting the xml tags used for detailed test result response
	 */
	public static final String UPCOMINGAPPOINTMENTS_ROOT_XML_TAG = "UpcomingAppointments";
	
	
	/**
	 * The different error codes used in the create appointment module 
	 */
	
	public static final int SPECIALITY_LIST_EMPTY_DATA_CODE = 701;
	
	public static final int SPECIALITY_LIST_XMLPARSE_EXCEPTION_ERRORCODE = 702;
	
	
	
	
	/**
	 * constant denoting the xml tags used for create appointments response
	 */
	public static final String SPECIALITY_LIST_ROOT_XML_TAG = "Specialities";
	
	public static final String PRACTITIONER_LIST_ROOT_XML_TAG = "Practitioners";
	
	/**
	 * 
	 */
	public static final int BOOKAPPT_START_TIME_IDENTIFIER = 1;
	
	public static final int BOOKAPPT_TO_TIME_IDENTIFIER = 2;
	
	public static final String BOOKAPPT_START_TIME_PROP_KEY = "BookAppointmentStartTime";
	
	public static final String BOOKAPPT_TO_TIME_PROP_KEY = "BookAppointmentToTime";
	
	/**
	 * Constants denoting the delimiters used to identify
	 * the time values to be used while booking appointments
	 * a time value would be like 10.30#10:30|11.30#11:30
	 * here value 10.30 is display value in GUI and 10:30 is data value
	 * here to get the total number of time tokens "|" is used
	 * and for getting the display and data value the delimiter is "#"
	 */
	public static final String BOOKAPPT_TIME_DELIMITER = "|";
	
	public static final String BOOKAPPT_DISPLAY_DATA_TIME_DELIMITER = "#";
	
	/**
	 * Constant used to denote the date format in the book appointment GUI
	 * screen
	 */
	public static final String BOOKAPPT_DATE_DISPLAY_FORMAT = "dd MMM yyyy";
	
	/**
	 * Constant denoting the value that will be used for the added by id and
	 * the modified by id for book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_PORTAL_USER_ID = "PortalUser";
	
	/**
	 * Constant denoting the value that will be used for the work station
	 * column in book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_PORTAL_SYSTEM_VALUE = "PortalSystem";
	
	/**
	 * Constants denoting the error codes for validation/failures 
	 * in cancel appointment functionality
	 */
	public static final int CANCEL_APPT_INVALIDAPPTNUMBER_ERRORCODE = 2301;
	
	public static final int CANCEL_APPT_INVALIDAPPTSTATUS_ERRORCODE = 2302;
	
	public static final int CANCEL_APPT_INVALIDFACILITYID_ERRORCODE = 2303;
	
	public static final int CANCEL_APPT_INVALIDREASONCODE_ERRORCODE = 2304;
	
	public static final int CANCEL_APPT_INVALIDPATIENTID_ERRORCODE = 2305;
	
	public static final int CANCEL_APPTREQ_SQLEXCEPTION_ERRORCODE = 2351;
	
	public static final int CANCEL_APPTREQ_FAILURE_ERRORCODE = 2352;
	
	/**
	 * Constant denoting the static key for representing the status
	 * of an appointment request
	 * this is used in the upcoming appointment service and GUI 
	 */
	public static final String APPOINTMENT_REQUEST_STATUS_KEY = "Appointment Request";

	/**
	 * Constant denoting the bundle class for upcoming appointments module
	 */
	public static final String UPCOMING_APPOINTMENT_BUNDLE_CLASS = "portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages";
	/**
	 * Constant denoting the bundle key which stores the message
	 * when appointments and appointment requests have been successfully retrieved
	 */
	public static final String UPCOMING_APPOINTMENT_RETRIEVE_SUCCESS_DISPLAYMESSAGE_KEY = "DisplayMessage.AppointmentsRetrievedSuccessMessage";
	
	/**
	 * Constants denoting the request parameter keys used in the cancel
	 * appointment functionality
	 */
	public static final String CANCELAPPT_APPT_NUMBER_REQUEST_PARAM_KEY = "appointmentNumber";
	
	public static final String CANCELAPPT_APPT_STATUS_REQUEST_PARAM_KEY = "appointmentStatus";
	
	public static final String CANCELAPPT_REASONCODE_REQUEST_PARAM_KEY = "cancelReasonCode";
	
	public static final String CANCELAPPT_FACILITYID_REQUEST_PARAM_KEY = "FacilityId";

	public static final String CANCELAPPT_RESPONSE_ATTRIBUTE_KEY = "AppointmentResponse";

	/**
	 * Constant denoting the status value supplied as request parameter
	 * for an appointment request and an appointment
	 */
	public static final String CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER = "Request";
	
	public static final String CANCELAPPT_APPT_IDENTIFIER = "Appointment";

	/**
	 * Constant denoting the request parameter key to be used for record count parameter
	 * in the appointment details web service - this service returns the upcoming
	 * appointments 
	 */
	public static final String APPOINTMENT_DETAILS_RECORDCOUNT_REQUEST_PARAM_KEY = "recordCount";

	/**
	 * constant denoting the time delimiter
	 */
	public static final String TIME_DELIMITER = ":";
	
}
