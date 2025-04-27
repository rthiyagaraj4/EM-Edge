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
package portalrefimpl.common;

/**
 * @author GRamamoorthy
 *
 */
public class CommonConstants {

	/**
	 * constant denoting the names of individual module names
	 * in the messages xml
	 */
	public static final String HOMEPAGE_MODULE_NAME = "Home Page";
	
	public static final String COMMON_MODULE_NAME = "Common";
	
	public static final String DETAILED_TESTRESULT_MODULE_NAME = "View Detailed Test Results";
	
	public static final String VIEWAPPTDETAILS_MODULE_NAME = "View Appointment Details";
	
	public static final String UPCOMING_APPOINTMENTS_MODULE_NAME = "View Upcoming Appointment Details";
	
	public static final String VIEWTESTRESULTS_MODULE_NAME = "View Test Results";
	
	public static final String TESTRESULT_MODULE_NAME = "View Test Result";
	
	public static final String CREATE_APPOINTMENT_MODULE_NAME = "Create Appointment";

	public static final String CANCEL_APPOINTMENT_MODULE_NAME = "Cancel Appointment";
	
	public static final String LOGIN_MODULE_NAME = "Login";
	
	public static final String FACILITY_MODULE_NAME = "Facility";
	
	public static final String CONTACT_REASON_MODULE_NAME = "Contact Reason";
	
	public static final String FACILITY_FORCONTACT_MODULE_NAME = "Facility For Contact";
	
	public static final String RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME = "Reschedule Appointment";
	
	/**
	 * Constant denoting the error code to be used when
	 * the response from a service is null
	 */
	public static final int NULLRESPONSE_ERROR_CODE = 13;
	
	/**
	 * constant denoting the xml tags to be used for representing
	 * address and contact details object
	 */
	public static final String ADDRESS_XML_TAG = "Address";
	
	public static final String CONTACTDETAILS_XML_TAG = "ContactDetails";
	
	/**
	 * constant denoting the xml tags to be used inside address object
	 * 
	 */
	public static final String ADDRESSLINES_XML_TAG = "Lines";
	
	public static final String ADDRESSLINE_XML_TAG = "Line";
	
	public static final String CITY_XML_TAG = "City";
	
	public static final String AREANAME_XML_TAG = "AreaName";
	
	public static final String TOWNNAME_XML_TAG = "TownName";
	
	public static final String COUNTRY_XML_TAG = "Country";
	
	public static final String PINCODE_XML_TAG = "Pincode";
	
	public static final String REGIONNAME_XML_TAG = "RegionName";
	
	public static final String AREACODE_XML_TAG = "AreaCode";
	
	public static final String REGIONCODE_XML_TAG = "RegionCode";
			
	public static final String TOWNCODE_XML_TAG = "TownCode";
	
	/**
	 * all the xml tags for contact details
	 */
	public static final String COUNTRYCODE_XML_TAG = "CountryCode";
	
	public static final String TELEPHONE_NUMBERS_XML_TAG = "TelephoneNumbers";
	
	public static final String TELEPHONE_NUMBER_XML_TAG = "TelephoneNumber";
	
	public static final String FAX_XML_TAG = "Fax";
	
	public static final String EMAILID_XML_TAG = "EmailId";
	
	public static final String WEBSITE_XML_TAG = "WebSite";
	
	/**
	 * constants denoting the number of appointments and test results 
	 * that should be shown in the home page
	 */
	public static final int HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT = 3;
	
	public static final int HOMEPAGE_TESTRESULTLIST_RECORDCOUNT = 3;
	
	/**
	 * constant denoting the connection failure scenario
	 */
	public static final int DBCONNECTION_FAILURE_ERRORCODE = 14;
	
	/**
	 * Constant denoting the parameter key used for supplying
	 * language information to individual web service request
	 */
	public static final String LANGUAGE_WS_PARAMETER_KEY = "Language";
	
	/**
	 * Constant denoting the error code to be used when
	 * service invoker implementation is not able to invoke
	 * the underlying web service 
	 */
	public static final int WEBSERVICE_INVOKE_ERRORCODE = 4;
	
	/**
	 * Constant denoting the error code to be used when
	 * a web service encounters an exception during its execution
	 */
	public static final int	WEBSERVICE_EXCEPTION_ERRORCODE = 15;
	
	/**
	 * Constant denoting the error code to be used when
	 * the web service response xml is not converted to a stream
	 * source properly
	 */
	public static final int WEBSERVICE_RESPONSE_STREAMSOURCE_EXCEPTION_ERRORCODE = 16;
	
	/**
	 * Constants denoting the short name of the web services
	 * written for this portal application
	 */
	public static final String LOGIN_SVC_NAME_KEY = "Login";
	
	public static final String PATIENT_DETAILS_SVC_NAME_KEY = "Patient Details";
	
	public static final String HOSPITAL_DETAILS_SVC_NAME_KEY = "Hospital Details";
	
	public static final String TESTRESULTS_RECENT_SVC_NAME_KEY = "Recent Test Results";
	
	public static final String APPOINTMENTS_RECENT_SVC_NAME_KEY = "Future Appointments";
	
	public static final String DETAILED_TESTRESULTS_SVC_NAME_KEY = "Detailed Test Results";
	
	public static final String TESTRESULT_SVC_NAME_KEY = "Test Result";
	
	public static final String UPCOMING_APPOINTMENTS_SVC_NAME_KEY = "Upcoming Appointments";
	
	public static final String FACILITY_LIST_SVC_NAME_KEY = "Facility List";
	
	public static final String SPECIALITY_LIST_SVC_NAME_KEY = "Specialty List";
	
	public static final String APPTREQUEST_SPECIALITY_LIST_SVC_NAME_KEY = "Get Specialty List";
	
	public static final String APPTREQUEST_PRACT_LIST_SVC_NAME_KEY = "Practitioner List";
	
	public static final String APPTREQUEST_PRACT_SCHEDULE_SVC_NAME_KEY = "Practitioner Schedule";
	
	public static final String APPTREQUEST_PRACT_SCHEDULE_STATUS_SVC_NAME_KEY = "Schedule Status";
	
	public static final String APPTREQUEST_TIMESLOT_SVC_NAME_KEY = "Timeslot";
	
	public static final String APPTREQUEST_BOOK_SVC_NAME_KEY = "Book Appointment Request";
	
	public static final String CANCEL_APPPOINTMENT_SVC_NAME_KEY = "Cancel Appointment";
	
	public static final String CANCEL_APPT_REASON_SVC_NAME_KEY = "Cancellation Reason";
	
	public static final String RESCHEDULE_APPTREQUEST_DETAILS_SVC_NAME_KEY = "Get Appointment Request Details";
	
	public static final String RESCHEDULE_APPTREQUEST_SVC_NAME_KEY = "Reschedule Appointment Request";
	
	public static final String FACILITY_DETAILS_SVC_NAME_KEY = "Facility Details";
	
	public static final String RESCHEDULE_APPTREQUEST_CONTACTREASON_SVC_NAME_KEY = "Reason for reschedule appointment request";
	
	
}
