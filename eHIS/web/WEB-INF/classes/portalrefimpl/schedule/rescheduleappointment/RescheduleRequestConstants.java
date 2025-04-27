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
package portalrefimpl.schedule.rescheduleappointment;

/**
 * @author GRamamoorthy
 *
 */
public class RescheduleRequestConstants {

	/**
	 * Constant denoting the error codes obtained from validation of
	 * reschedule appointment request
	 */
	public static final int RESCHEDULE_APPT_APPTREFNUMBER_MISSING_ERRORCODE = 3701;
	
	public static final int RESCHEDULE_APPT_PRACTITIONERID_INVALID_ERRORCODE = 3702;
	
	public static final int RESCHEDULE_APPT_PREFERREDDATE_INVALID_ERRORCODE = 3703;
	
	public static final int RESCHEDULE_APPT_PREFERREDDATE_INVALIDFORMAT_ERRORCODE = 3704;
	
	public static final int RESCHEDULE_APPT_PREFERREDDATE_PASTDATE_ERRORCODE = 3705;
	
	public static final int RESCHEDULE_APPT_PREFERREDDATE_OUTOFRANGE_ERRORCODE = 3706;
	
	public static final int RESCHEDULE_APPT_PREFERREDFROMTIME_INVALID_ERRORCODE = 3707;
	
	public static final int RESCHEDULE_APPT_PREFERREDFROMTIME_INVALIDFORMAT_ERRORCODE = 3708;
	
	public static final int RESCHEDULE_APPT_PREFERREDFROMTIME_PASTDATE_ERRORCODE = 3709;
	
	public static final int RESCHEDULE_APPT_PREFERREDFROMTIME_OUTOFRANGE_ERRORCODE = 3710;
	
	public static final int RESCHEDULE_APPT_PREFERREDTOTIME_INVALID_ERRORCODE = 3711;
	
	public static final int RESCHEDULE_APPT_PREFERREDTOTIME_INVALIDFORMAT_ERRORCODE = 3712;
	
	public static final int RESCHEDULE_APPT_PREFERREDTOTIME_PASTDATE_ERRORCODE = 3713;
	
	public static final int RESCHEDULE_APPT_PREFERREDTOTIME_OUTOFRANGE_ERRORCODE = 3714;
	
	public static final int RESCHEDULE_APPT_PREFERREDDATE_TIME_MISMATCH_ERRORCODE = 3715;
	
	public static final int RESCHEDULE_APPT_PREFERREDFROMTIME_LATER_PREFERREDTOTIME_ERRORCODE = 3716;
	
	public static final int RESCHEDULE_APPT_PREFERREDTIMES_EQUAL_ERRORCODE = 3717;
	
	/**
	 * Constants denoting execution error codes during reschedule appointment service
	 * 
	 */
	public static final int RESCHEDULE_APPT_RESULTSET_NULL_ERRORCODE = 3751;
	
	public static final int RESCHEDULE_APPT_SQLEXCEPTION_ERRORCODE = 3752;
	
	public static final int RESCHEDULE_APPT_FAILURE_ERRORCODE = 3753;
	
	public static final int RESCHEDULE_APPT_PREFERREDTIMES_SCHEDULE_MISMATCH_ERRORCODE = 3754;
	
	public static final int RESCHEDULE_APPT_DUPLICATE_RECORDEXISTS_ERRORCODE = 3755;
	
	/**
	 * Constants denoting the execution error codes for get appointment request details
	 * service
	 */
	public static final int GET_APPTREQUESTDETAILS_SQLEXCEPTION_ERRORCODE = 3051;
	
	public static final int GET_APPTREQUESTDETAILS_NULLRESULTSET_ERRORCODE = 3052;
	
	public static final int GET_APPTREQUESTDETAILS_DATA_NOTFOUND_ERRORCODE = 3053;
	
	public static final int GET_APPTREQUESTDETAILS_INVALIDPATIENTID_ERRORCODE = 3001;
	
	public static final int GET_APPTREQUESTDETAILS_INVALIDREFNUMBER_ERRORCODE = 3002;
	
	/**
	 * Constant to denote the request parameter key for appointment request reference
	 * number - this is used in the get appointment request details web service
	 */
	public static final String GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY = "referenceNumber"; 
	
	/**
	 * Constant denoting the date format to be used for
	 * displaying preferred date value in the reschedule appointment request main
	 * page - this is used for setting the date to the date component
	 */
	public static final String APPTREQ_DETAILS_DATE_DISPLAY_FORMAT = "dd/MM/yyyy";
	
	/**
	 * Constant denoting the date format to be used for
	 * displaying preferred date value as a label in the 
	 * reschedule appointment request main page
	 */
	public static final String APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2 = "dd MMM yyyy";
	
	/**
	 * Constant denoting the date time format for storing the 
	 * preferred from and to time in the reschedule appointment request
	 * main page
	 */
	public static final String APPTREQ_DETAILS_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";
	
	/**
	 * Constant denoting the time format to be used for displaying
	 * time value as a label in the reschedule appointment request main page
	 */
	public static final String APPTREQ_DETAILS_TIME_FORMAT = "HH:mm";
	
	/**
	 * Constants denoting the parameters used in the reschedule appointment
	 * pages 
	 */
	public static final String APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM = "preferredDateFromPage";
	
	public static final String APPTREQ_DETAILS_FROM_TIME_PARAM = "fromTimeInPage";
	
	public static final String APPTREQ_DETAILS_TO_TIME_PARAM = "toTimeInPage";
	
	public static final String APPTREQ_DETAILS_PRACTITIONERID_PARAM = "selectedPractitionerIdInPage";
	
	public static final String APPTREQ_DETAILS_PRACTITIONERNAME_PARAM = "selectedPractitionerNameInPage";
	
	public static final String RESCHEDULE_TIMESLOT_SELECTEDDATE_PARAM = "timeslotSelectedDate";
	
	public static final String RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM = "timeslotSelectedFromTime";
	
	public static final String RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM = "timeslotSelectedToTime";
	
	public static final String SELECTED_TIMESLOT_PARAM = "hdnSelectedTimeSlot";
	
	public static final String HIDDEN_SPECIALTY_ID_PARAM = "hdnSpecialtyId";
	
	public static final String HIDDEN_FACILITY_ID_PARAM = "hdnFacilityId";
	
	public static final String HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM = "hdnPreferredDateInTimeSlotFrame";
	
	public static final String HIDDEN_CLINIC_CODE_PARAM = "hdnClinicCode";
	
	public static final String HIDDEN_SPECIALTY_DESC_PARAM = "hdnSpecialtyDesc";
	
	public static final String RESCHEDULE_REASON_CODE_PARAM = "rescheduleReasonCode";
	
	/**
	 * Constants denoting the request parameters to be used
	 * in the reschedule appointment request service
	 */
	public static final String APPTREQ_FACILITYID_PARAM_KEY = "facilityId";
	
	public static final String APPTREQ_REF_NUMBER_PARAM_KEY = "referenceNumber";
	
	public static final String APPTREQ_PREFERRED_DATE_PARAM_KEY = "preferredDate";
	
	public static final String APPTREQ_PREFERRED_FROMTIME_PARAM_KEY = "preferredFromTime";
	
	public static final String APPTREQ_PREFERRED_TOTIME_PARAM_KEY = "preferredToTime";
		
	public static final String APPTREQ_PRACTITIONERID_PARAM_KEY = "practitionerId";
	
	public static final String APPTREQ_LOCATIONCODE_PARAM_KEY = "locationCode";
	
	public static final String APPTREQ_CARELOCATIONINDICATOR_PARAM_KEY = "careLocationIndicator";
	
	public static final String APPTREQ_MODIFIED_FACILITYID_PARAM_KEY = "modifiedFacilityId";
	
	/**
	 * 
	 */
	public static final int APPTREQ_PATIENTID_INVALID_ERRORCODE = 3701;
	
	public static final int APPTREQ_FACILITYID_INVALID_ERRORCODE = 3702;
	
	public static final int APPTREQ_REF_NUMBER_INVALID_ERRORCODE = 3703;
	
	public static final int APPTREQ_PREFERRED_DATE_INVALID_ERRORCODE = 3704;
	
	public static final int APPTREQ_PREFERRED_DATE_INVALID_FORMAT_ERRORCODE = 3705;
	
	public static final int APPTREQ_PREFERRED_DATE_PAST_DATE_ERRORCODE = 3706;
	
	public static final int APPTREQ_PREFERRED_DATE_RANGE_EXCEED_ERRORCODE = 3707;
	
	public static final int APPTREQ_PREFERRED_FROMTIME_INVALID_ERRORCODE = 3708;
	
	public static final int APPTREQ_PREFERRED_FROMTIME_INVALID_FORMAT_ERRORCODE = 3709;
	
	public static final int APPTREQ_PREFERRED_TOTIME_INVALID_ERRORCODE = 3710;
	
	public static final int APPTREQ_PREFERRED_TOTIME_INVALID_FORMAT_ERRORCODE = 3711;
	
	public static final int APPTREQ_FROMTIME_EXCEEDS_TOTIME_ERRORCODE = 3712;
	
	public static final int APPTREQ_PRACTITIONERID_INVALID_ERRORCODE = 3713;
	
	public static final int APPTREQ_LOCATIONCODE_INVALID_ERRORCODE = 3714;
	
	public static final int APPTREQ_MODIFIED_FACILITYID_INVALID_ERRORCODE = 3715;
	
	public static final int APPTREQ_REASON_CODE_ERRORCODE = 3716;
	
	/**
	 * Constant denoting the regular expression pattern for the from and to times
	 * in an appointment request
	 */
	public static final String APPTREQ_TIME_REGEX_PATTERN1 = "([0-1][0-9][:][0-5][0-9])";
	
	public static final String APPTREQ_TIME_REGEX_PATTERN2 = "([2][0-3][:][0-5][0-9])";
	
	public static final String RESCHEDULE_APPTREQ_RESPONSE_PARAM = "RescheduleApptReqResponse";
}
