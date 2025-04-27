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
package portalrefimpl.schedule.createappointment;


/**
 * @author GRamamoorthy
 *
 */
public class CreateAppointmentConstants {

	/**
	 * Constants denoting the column names obtained
	 * after executing the SQL query to get list of practitioners
	 * in the book appointment request flow
	 */
	public static final String PRACTITIONERID_KEY = "PRACTITIONER_ID";
	
	public static final String PRACTITIONERNAME_KEY = "PRACTITIONER_NAME";
	
	public static final String PRACTITIONERFULLNAME_KEY = "PRACTITIONER_FULL_NAME";
	
	public static final String PRACTITIONERTYPE_KEY = "PRACTITIONER_TYPE";
	
	public static final String POSITION_KEY = "JOB_TITLE_DESC";
	
	public static final String PRIMARYSPECIALITY_KEY = "PRIMARY_SPECIALITY";
	
	public static final String JOBTITLE_KEY = "JOB_TITLE";
	
	public static final String GENDER_KEY = "GENDER";
	
	public static final String MIN_SLOTSLAB_START_TIME = "MIN_SLOT_SLAB_START_TIME";
	
	public static final String MIN_SLOTSLAB_END_TIME = "MIN_SLOT_SLAB_END_TIME";
	
	public static final String MAX_PATIENT_DAY = "MAX_PATIENTS_PER_DAY";
	
	public static final String CLINIC_DATE = "CLINIC_DATE";
	
	public static final String CLINIC_CODE = "CLINIC_CODE";
	
	/**
	 * Constants denoting the request parameter used in the
	 * book appointment GUI flow  
	 * 
	 */
	public static final String SPECIALITY_PARAMETER_KEY = "Speciality";
	
	public static final String APPT_PREFERREDDATE_PARAMETER_KEY = "ApptPreferredDate";
	
	public static final String APPT_PREFERREDFROMTIME_PARAMETER_KEY = "ApptPreferredFromTime";
	
	public static final String APPT_PREFERREDTOTIME_PARAMETER_KEY = "ApptPreferredToTime";
	
	public static final String APPT_PREFERREDFACILITY_PARAMETER_KEY = "Facility";
	
	public static final String APPT_PREFERREDFACILITYID_PARAMETER_KEY = "FacilityId";
	
	public static final String APPT_PREFERREDFACILITYDESC_PARAMETER_KEY = "FacilityDesc";
	
	public static final String APPT_PREFERREDSPECIALITYID_PARAMETER_KEY = "SpecialityId";
	
	public static final String APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY = "SpecialityDesc";
	
	public static final String APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY = "PractitionerId";
	
	public static final String APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY = "PractitionerName";
	
	public static final String APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY = "PreferredDateInTimeSlot";
	
	public static final String TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY = "TimeSlotPreferredFromTime";
	
	public static final String TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY = "TimeSlotPreferredToTime";
	
	
	/**
	 * Constants denoting the error codes to be used for practitioner list
	 * request validation
	 */
	public static final int PRACTITIONER_REQUEST_INVALIDSPECIALITY_ERRORCODE = 721;
	
	public static final int PRACTITIONER_REQUEST_INVALIDFACILITY_ERRORCODE = 722;
	
	public static final int PRACTITIONER_REQUEST_INVALIDOPRSTNID_ERRORCODE = 723;
	
	public static final int PRACTITIONER_REQUEST_INVALIDRESOURCECLASS_ERRORCODE = 724;
	
	public static final int PRACTITIONER_REQUEST_INVALIDPREFERREDDATE_ERRORCODE = 725;
	
	public static final int PRACTITIONER_REQUEST_PASTPREFERREDDATE_ERRORCODE = 726;
	
	public static final int PRACTITIONER_REQUEST_PREFERREDDATE_RANGE_OVERSHOOT_ERRORCODE = 727;
	
	public static final int PRACTITIONER_REQUEST_INVALIDPREFERREDTSTARTTIME_ERRORCODE = 728;
	
	public static final int PRACTITIONER_REQUEST_INVALIDPREFERREDTENDTIME_ERRORCODE = 729;
	
	public static final int PRACTITIONER_REQUEST_INVALIDPRACTITIONERID_ERRORCODE = 730;
	
	public static final int PRACTITIONER_REQUEST_PASTPREFERREDENDDATE_ERRORCODE = 741;
	
	public static final int PRACTITIONER_REQUEST_PREFERREDENDDATE_RANGE_OVERSHOOT_ERRORCODE = 742;
	
	
	/**
	 * Constants denoting the error codes to be used for practitioner list
	 * service execution
	 */
	public static final int PRACTITIONER_CONNECTION_PROBLEM_ERRORCODE = 731;
	
	public static final int PRACTITIONER_SQLEXCEPTION_PROBLEM_ERRORCODE = 732;
	
	public static final int PRACTITIONER_RESULTSET_NULL_ERRORCODE = 733;
	
	public static final int PRACTITIONER_LIST_EMPTY_DATA_CODE = 734;
	
	public static final int PRACTITIONER_LIST_XMLPARSE_EXCEPTION_ERRORCODE = 735;
	
	/**
	 * This constant denotes the URL parameter used to pass to the 
	 * practitioner web service - this web service expects a specialty
	 * and the specialty value is passed to the service with this key
	 */
	public static final String SPECIALITY_WS_PARAMETER_KEY = "Specialty";
	
	/**
	 * This constant denotes the maximum number of practitioner records
	 * which should be shown in the display
	 */
	public static final int PRACTITIONER_DISPLAY_RECORD_COUNT = 6;
	
	/**
	 * constants denoting the number of milliseconds in a second,
	 * number of minutes in hour, number of seconds in minute
	 */
	public static final int NUMBER_OF_MILLIS_IN_SEC = 1000;
	public static final int NUMBER_OF_MIN_IN_HR = 60;
	public static final int NUMBER_OF_SEC_IN_MIN = 60;
	
	/**
	 * constant to denote the number of milli seconds in a hour
	 */
	public static final int NUMBER_OF_MILLIS_IN_HR = (NUMBER_OF_MILLIS_IN_SEC * NUMBER_OF_SEC_IN_MIN * NUMBER_OF_MIN_IN_HR);
	
	/**
	 * constant to denote the error codes for practitioner schedule service
	 */
	public static final int PRACTITIONERSCHEDULE_SQLEXCEPTION_ERRORCODE = 751;
	
	public static final int PRACTITIONERSCHEDULE_NULLRESULTSET_ERRORCODE = 752;
	
	public static final int PRACTITIONERSCHEDULE_NOSCHEDULE_ERRORCODE = 753;
	
	/**
	 * constant denoting the time delimiter
	 */
	public static final String TIME_DISPLAY_DELIMITER = ":";
	
	public static final String TIME_DISPLAY_FORMAT = "HH:mm";
	
	/**
	 * Constant denoting the value that the operation standard id parameter
	 * should have for the practitioner list service and the practitioner
	 * schedule service
	 */
	public static final String PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE = "ALL";
	
	/**
	 * Constant denoting the default value for the resource class request parameter
	 * needed in the practitioner list and the practitioner schedule service
	 */
	public static final String PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE = "P";
	
	/**
	 * Constant denoting the date format which is used for converting the 
	 * preferred date value specified in the practitioner list and 
	 * practitioner schedule services
	 * The preferred date is taken as a string once passed in the service request
	 * and hence needs conversion to date - this format is useful in converting
	 * the string to date
	 */
	public static final String PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Constant denoting the key used in the configuration file to represent the 
	 * preferred date's range
	 */
	public static final String BOOKAPPT_PREFERREDDATE_RANGE_KEY = "BookAppointmentPreferredDateRange";
	
	/**
	 * Constant denoting the default value which is to be used for
	 * validating the preferred date specified in the practitioner list and practitioner
	 * schedule service
	 * Current date + this constant value should be greater than the specified
	 * preferred date
	 */
	public static final int BOOKAPPT_PREFERREDDATE_DEFAULT_RANGE = 90;
	
	/**
	 * Constant denoting the number of days from the start date for getting
	 * the practitioner list and the practitioner schedule
	 * in the book appointment functionality
	 */
	public static final int BOOKAPPT_PREFERREDENDDATE_RANGE = 30;
	
	/**
	 * Constant denoting the number of days to be shown in a single
	 * view in the practitioner schedule popup window
	 */
	public static final int BOOKAPPT_SCHEDULE_VIEW_RANGE = 7;
	
	/**
	 * constants denoting the extra request parameters needed in the 
	 * practitioner list and practitioner schedule services
	 */
	/*public static final String PRACTITIONER_FACILITYID_PARAMETER_KEY = "FacilityId";*/
	
	public static final String PRACTITIONER_PREFERRED_DATE_PARAMETER_KEY = "PreferredDate";
	
	public static final String PRACTITIONER_PREFERRED_STARTTIME_PARAMETER_KEY = "PreferredStartTime";
	
	public static final String PRACTITIONER_PREFERRED_ENDTIME_PARAMETER_KEY = "PreferredEndTime";
	
	public static final String PRACTITIONER_OPRSTN_ID_PARAMETER_KEY = "OprStndId";
	
	public static final String PRACTITIONER_RESOURCECLASS_PARAMETER_KEY = "ResourceClass";
	
	public static final String PRACTITIONER_PRACTITIONERID_PARAMETER_KEY = "PractitionerId";

	/**
	 * Constants denoting the root elements for the practitioner list and
	 * practitioner schedule service
	 */
	public static final String PRACTITIONERLIST_SERVICE_ROOTELEMENT_KEY = "Practitioners";
	
	public static final String PRACTITIONERSCHEDULE_SERVICE_ROOTELEMENT_KEY = "Practitioner";
	
	/**
	 * Constant denoting the invalid practitioner identifier
	 * This is used for filtering such practitioners in the practitioner list service
	 */
	public static final String INVALID_PRACTITIONER_IDENTIFIER = "Not Identified";
	
	/**
	 * Constants denoting the format in which the day of week, the date
	 * value and the number of time zones 
	 * is to be displayed in view practitioner schedule GUI
	 */
	public static final String PRACTITIONERSCHEDULE_DAYOFWEEK_FORMAT = "EEE";
	
	public static final String PRACTITIONERSCHEDULE_DATE_FORMAT = "dd-MM-yy";
	
	public static final int PRACTITIONERSCHEDULE_DISPLAY_TIME_ZONE = 3;
	
	/**
	 * constants denoting the error codes to be used during validation
	 * of practitioner time slot and practitioner schedule status service
	 */
	public static final int PRACTITIONERSTATUS_PRACTITIONERID_MISSING_ERRORCODE = 761;
	
	public static final int PRACTITIONERSTATUS_FACILITYID_MISSING_ERRORCODE = 762;
	
	public static final int PRACTITIONERSTATUS_RESOURCETYPE_MISSING_ERRORCODE = 763;
	
	public static final int PRACTITIONERTIMESLOT_PREFERREDDATE_MISSING_ERRORCODE = 764;
	
	public static final int PRACTITIONERSTATUS_PREFERREDDATE_PASTDATE_ERRORCODE = 765;
	
	public static final int PRACTITIONERSTATUS_PREFERREDDATE_OUTSIDERANGE_ERRORCODE = 766;
	
	public static final int PRACTITIONERSTATUS_CLINICCODE_MISSING_ERRORCODE = 767;
	
	
	/**
	 * Constants denoting the error codes to be used for
	 * the practitioner time slot service
	 */
	public static final int PRACTITIONERTIMESLOT_SQLEXCEPTION_ERRORCODE = 771;
	
	public static final int PRACTITIONERTIMESLOT_DATANOTVALID_ERRORCODE = 772;
	
	public static final int PRACTITIONERTIMESLOT_EMPTYDATA_ERRORCODE = 773;
	
	/**
	 * Constants denoting the indexes from which results have to be
	 * obtained from callable statement object for the practitioner 
	 * time slot services
	 */
	public static final int PRACTITIONER_NAME_INDEX = 8;
	
	public static final int MAXPATIENTS_INDEX = 9;
	
	public static final int TIMESLOT_STATUS_INDEX = 15;
	
	public static final int FROMTIME_INDEX = 16;
	
	public static final int TOTIME_INDEX = 17;
	
	public static final int APPOINTMENTS_ENDTIME_INDEX = 25;
	
	public static final String TOKEN_DELIMITER = "|";
	
	public static final String FREE_TIMESLOT_IDENTIFIER = "FL";
	
	/**
	 * Constant denoting the root element key used in the output XML
	 * in the practitioner time slot service
	 */
	public static final String PRACTITIONERTIMESLOT_SERVICE_ROOTELEMENT_KEY = "Practitioner";
	
	/**
	 * Constants denoting the keys to be used for specifying common request parameters 
	 * to practitioner schedule status and practitioner time slot service
	 */
	public static final String PRACTITIONERSTATUS_PRACTITIONERID_REQUEST_PARAMETER = "PractitionerId";
	
	public static final String PRACTITIONERSTATUS_FACILITYID_REQUEST_PARAMETER = "FacilityId";
	
	public static final String PRACTITIONERSTATUS_RESOURCETYPE_REQUEST_PARAMETER = "ResourceType";
	
	public static final String PRACTITIONERSTATUS_CLINICCODE_REQUEST_PARAMETER = "ClinicCode";
	
	public static final String PRACTITIONERSTATUS_CLINICTYPE_REQUEST_PARAMETER = "ClinicType";
	
	/**
	 * constant denoting the specific request parameter for the practitioner time slot
	 * service
	 */
	public static final String PRACTITIONERTIMESLOT_PREFERREDDATE_REQUEST_PARAMETER = "PreferredDate";
	
	/**
	 * constant denoting the date format to be used for the practitioner schedule
	 * status and the practitioner time slot service
	 */
	public static final String PRACTITIONERSTATUS_DATEFORMAT = "dd/MM/yyyy";
	
	/**
	 * Constants denoting the error codes to be used when validation for
	 * practitioner schedule status service fails
	 */
	public static final int PRACTITIONERSCHEDULESTATUS_FROMDATE_MISSING_ERRORCODE = 781;
	
	public static final int PRACTITIONERSCHEDULESTATUS_TODATE_MISSING_ERRORCODE = 782;
	
	public static final int PRACTITIONERSCHEDULESTATUS_TODATE_PASTDATE_ERRORCODE = 783;
	
	public static final int PRACTITIONERSCHEDULESTATUS_TODATE_BEFORE_FROMDATE_ERRORCODE = 784;
	
	
	/**
	 * constant denoting the error codes to be used for practitioner schedule
	 * status service
	 */
	public static final int PRACTITIONERSTATUS_SQLEXCEPTION_ERRORCODE = 791;
	
	/**
	 * Constant denoting the root element of the xml response for practitioner
	 * schedule status service
	 */
	public static final String PRACTITIONERSCHEDULESTATUS_SERVICE_ROOTELEMENT_KEY = "Practitioner";
	
	/**
	 * Constants denoting the request parameters to be used for specifying
	 * from date and to date properties in practitioner schedule status service
	 */
	public static final String PRACTITIONERSCHEDULESTATUS_PREFERREDFROMDATE_PARAMETER_KEY = "FromDate";
	
	public static final String PRACTITIONERSCHEDULESTATUS_PREFERREDTODATE_PARAMETER_KEY = "ToDate";

	/**
	 * Constant denoting the default value of clinic type which needs to be
	 * passed to the practitioner schedule status service
	 */
	public static final String PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE = "C";
	
	/**
	 * Constant denoting the format to be used for showing the preferred date
	 * in the time slot GUI frame which is part of the book appointment functionality 
	 */
	public static final String PRACTITIONERTIMESLOT_DATE_DISPLAY_FORMAT = "dd MMM yyyy";
	
	/**
	 * Constant denoting the delimiter used for separating the hour component
	 * in a time value - the time value will be in the format HH:MM
	 */
	public static final String TIMESLOT_HOUR_DELIMITER = ":";

	/**
	 * Constant denoting the value of the web request parameter 
	 * for the book appointment functionality 
	 */
	public static final String APPOINTMENT_WEBREQUEST_PARAM_VALUE = "Y";
	
	/**
	 * Constants denoting the error code for appointment related functionality
	 * These error codes will be used in common code for appointment
	 * this code will be applicable for book appointment and reschedule appointment
	 */
	public static final int APPOINTMENT_COMMON_RESULTSET_NULL_ERRORCODE = 1051;
	
	public static final int APPOINTMENT_COMMON_DUPLICATE_RECORD_ERRORCODE = 1052;
	
	/**
	 * Constants denoting the error code for book appointment functionality
	 */
	public static final int BOOKAPPOINTMENT_INSERT_ROW_ERRORCODE = 1053;
	
	public static final int BOOKAPPOINTMENT_INSERT_ROW_SQLEXCEPTION_ERRORCODE = 1054;
	
	public static final int BOOKAPPOINTMENT_INSERT_RETRIES_EXCEEDED_ERRORCODE = 1055;
	
	public static final int BOOKAPPOINTMENT_ABORT_INSERT_ERRORCODE = 1056;
	
	/**
	 * Constant denoting the value of wait list priority to be used
	 * for book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_WAIT_LIST_PRIORITY_VALUE = "N";
	
	/**
	 * Constant denoting the value of care location type indicator to be used
	 * for book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_CARE_LOCATION_TYPE_INDICATOR_VALUE = "C";
	
	/**
	 * Constant denoting the value of wait list status to be used
	 * for book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_WAITLIST_STATUS_VALUE = "O";
	
	/**
	 * Constant denoting the value that will be used for the cancelled when death
	 * yn field in book appointment and reschedule appointment
	 */
	public static final String APPOINTMENT_CANCELLED_WHEN_DEATH_YN_VALUE = "N";
	
	/**
	 * Constant denoting the key used in the configuration file to store
	 * the maximum number of retries
	 */
	public static final String BOOKAPPOINTMENT_MAX_RETRIES_KEY = "BookAppointmentMaxRetries";
	
	/**
	 * Constant denoting the default value of max retries for book appointment
	 * functionality
	 */
	public static final int BOOKAPPOINTMENT_DEFAULT_MAX_RETRIES = 5;
	
	/**
	 * Constant denoting the key used in the configuration file to store
	 * the retry interval for querying whether the book appointment response
	 * has been obtained  
	 */
	public static final String BOOKAPPOINTMENT_RETRY_INTERVAL_MILLIS_KEY = "BookAppointmentRetryInMillis";
	
	/**
	 * Constant denoting the default value of retry interval for book appointment
	 * functionality
	 */
	public static final int BOOKAPPOINTMENT_DEFAULT_RETRY_INTERVAL_MILLIS = 500;

	/**
	 * Constant denoting the error codes to be used when
	 * appointment services - book appointment and reschedule appointment
	 * are validated
	 */
	public static final int APPOINTMENT_INVALID_FACILITYID_ERRORCODE = 1001;
	
	public static final int APPOINTMENT_INVALID_SPECIALITYID_ERRORCODE = 1002;
	
	public static final int APPOINTMENT_INVALID_PRACTITIONERID_ERRORCODE = 1003;
	
	public static final int APPOINTMENT_INVALID_PREFERREDDATE_ERRORCODE = 1004;
	
	public static final int APPOINTMENT_PAST_PREFERREDDATE_ERRORCODE = 1005;
	
	public static final int APPOINTMENT_PREFERREDDATE_EXCEED_RANGE_ERRORCODE = 1006;
	
	public static final int APPOINTMENT_INVALID_PREFERREDFROMTIME_ERRORCODE = 1007;
	
	public static final int APPOINTMENT_PAST_PREFERREDFROMTIME_ERRORCODE = 1008;
	
	public static final int APPOINTMENT_PREFERREDFROMTIME_EXCEED_RANGE_ERRORCODE = 1009;
	
	public static final int APPOINTMENT_INVALID_PREFERREDTOTIME_ERRORCODE = 1010;
	
	public static final int APPOINTMENT_PAST_PREFERREDTOTIME_ERRORCODE = 1011;
	
	public static final int APPOINTMENT_PREFERREDTOTIME_EXCEED_RANGE_ERRORCODE = 1012;
	
	public static final int APPOINTMENT_FROMTIME_LATERTHAN_TOTIME_ERRORCODE = 1013;
	
	/**
	 * Constant denoting the error code for patient id invalid scenario
	 * during book appointment request
	 */
	public static final int BOOKAPPOINTMENT_PATIENTID_INVALID_ERRORCODE = 1014;
	
	/**
	 * Constants denoting the request parameter to be used for
	 * book appointment web service client code
	 */
	public static final String APPOINTMENT_FACILITYID_REQUEST_PARAM = "FacilityId";
	
	public static final String APPOINTMENT_SPECIALITYID_REQUEST_PARAM = "SpecialtyId";
	
	public static final String APPOINTMENT_PRACTITIONERID_REQUEST_PARAM = "PractitionerId";
	
	public static final String APPOINTMENT_PREFERREDDATE_REQUEST_PARAM = "PreferredDate";
	
	public static final String APPOINTMENT_PREFERREDFROMTIME_REQUEST_PARAM = "PreferredFromTime";
	
	public static final String APPOINTMENT_PREFERREDTOTIME_REQUEST_PARAM = "PreferredToTime";
	
	public static final String APPOINTMENT_LOCATION_CODE_REQUEST_PARAM = "LocationCode";
	
	/**
	 * Constants denoting the request parameter key values used in
	 * the book appointment request service - these are used in the GUI code
	 */
	public static final String BOOKAPPOINTMENT_PREFERREDDATE_REQUEST_PARAM = "hdnPreferredDateInTimeSlotFrame";
	
	public static final String BOOKAPPOINTMENT_PRACTITIONERID_REQUEST_PARAM = "hdnPractitionerId";
	
	public static final String BOOKAPPOINTMENT_SELECTEDSPECIALTY_REQUEST_PARAM = "hdnSelectedSpeciality";
	
	public static final String BOOKAPPOINTMENT_CLINICCODE_REQUEST_PARAM = "hdnClinicCode";
	
	public static final String BOOKAPPOINTMENT_SELECTEDTIMESLOT_REQUEST_PARAM = "hdnSelectedTimeSlot";
	
}
