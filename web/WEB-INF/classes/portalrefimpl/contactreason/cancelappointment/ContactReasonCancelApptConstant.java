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
package portalrefimpl.contactreason.cancelappointment;

/**
 * This is the constant file for the contact reason for cancel
 * appointment service
 * This file will hold the constants used in the service code
 * @author GRamamoorthy
 *
 */
public class ContactReasonCancelApptConstant {

	/**
	 * constants denoting the error codes to be used when
	 * getting the contact reasons for EM appointments
	 */
	public static final int APPT_TYPE_INVALID_ERRORCODE = 2101;
	
	public static final int CANCEL_EM_APPT_NULLRESULTSET_ERRORCODE = 2151;
	
	public static final int CANCEL_EM_APPT_SQLEXCEPTION_ERRORCODE = 2152;
	
	public static final int CANCEL_EM_APPT_NO_DATA_FOUND_ERRORCODE = 2153;
	
	/**
	 * constants denoting the error codes to be used when
	 * getting the contact reasons for portal appointment requests
	 */
	public static final int CANCEL_APPTREQ_NULLRESULTSET_ERRORCODE = 2251;
	
	public static final int CANCEL_APPTREQ_SQLEXCEPTION_ERRORCODE = 2252;
	
	public static final int CANCEL_APPTREQ_NO_DATA_FOUND_ERRORCODE = 2253;

	/**
	 * Constant denoting the key to be used for specifying the appointment type
	 * in the HTTP URL request passed to the contact reason for cancel
	 * appointment web service
	 */
	public static final String APPOINTMENT_TYPE_REQUEST_PARAM_KEY = "AppointmentType";
		
}
