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
package portalrefimpl.contactreason;

/**
 * Constants file for contact reason package
 * @author GRamamoorthy
 *
 */
public class ContactReasonConstants {

	/**
	 * Constants denoting the defaults string values to be
	 * used for the reason code and reason description
	 */
	public static final String DEFAULT_REASON_CODE = "%";
	
	public static final String DEFAULT_REASON_DESCRIPTION = "%";
	
	/**
	 * Constants denoting the error codes to be used for 
	 * getting the contact reason in reschedule appointment request
	 * service
	 */
	public static final int APPT_REQ_NULLRESULTSET_ERRORCODE = 2161;
	
	public static final int APPT_REQ_SQLEXCEPTION_ERRORCODE = 2162;
	
	public static final int APPT_REQ_DATANOTFOUND_ERRORCODE = 2163;
	
	/**
	 * Constants denoting the request parameters for the reason code
	 * and reason description fields which is used in getting the 
	 * reasons in reschedule appointment request
	 */
	public static final String APPT_REQ_REASONCODE_PARAM = "reasonCode";
	
	public static final String APPT_REQ_REASONDESCRIPTION_PARAM = "reasonDescription";
	
}
