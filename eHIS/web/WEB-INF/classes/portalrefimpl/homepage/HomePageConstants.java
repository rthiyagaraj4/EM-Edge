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
package portalrefimpl.homepage;

/**
 * @author GRamamoorthy
 *
 */
public class HomePageConstants {

	public static final int PATIENTDETAILS_REQUESTINVALID_ERRORCODE = 501;
	
	
	public static final int HOSPITALDETAILS_REQUESTINVALID_ERRORCODE = 502;
	
	/**
	 * 
	 */
	public static final int CONNECTION_FAIL_ERRORCODE = 503;
	
	/**
	 * 
	 */
	public static final int SQLEXCEPTION_HOSPITALDETAILS_ERRORCODE = 504;
	
	/**
	 * 
	 */
	public static final int DATA_NOTOBTAINED_ERRORCODE = 505;
	
	/**
	 * constants denoting the error codes to be used for the patient 
	 * details service 
	 */
	public static final int PATIENT_DETAILS_NULL_RESULTSET_ERRORCODE = 571;
	
	public static final int PATIENT_DETAILS_SQLEXCEPTION_ERRORCODE = 572;
	
	public static final int PATIENT_DETAILS_DATA_NOT_FOUND_ERRORCODE = 573;
	
	public static final int PATIENT_DETAILS_INVALID_PATIENTID_ERRORCODE = 551;
	
	/**
	 * 
	 */
	public static final String METHOD_NAME = "methodName";
	
	/**
	 * 
	 */
	public static final String GETPATIENTDETAILS_METHOD_KEY = "GetPatientDetails"; 
	
	/**
	 * 
	 */
	public static final String GETHOSPITALDETAILS_METHOD_KEY = "GetHospitalDetails";
	
	/**
	 * constants denoting the xml tags for representing patient
	 * details response
	 */
	public static final String PATIENT_DETAILS_XML_TAG = "PatientDetails";
	
	public static final String PATIENTID_XML_TAG = "PatientId";
	
	public static final String NATIIONALID_XML_TAG = "NationalId";
	
	public static final String NAME_PREFIX_XML_TAG = "NamePrefix";
	
	public static final String NAME_SUFFIX_XML_TAG = "NameSuffix";
	
	public static final String PATIENTNAME_XML_TAG = "PatientName";
	
	public static final String PATIENT_DISPLAYNAME_XML_TAG = "PatientDisplayName";
	
	public static final String PATIENTSEX_XML_TAG = "Sex";
	
	public static final String DATEOFBIRTH_XML_TAG = "DateOfBirth";
	
	public static final String PATIENT_AGE_XML_TAG = "Age";
	
	/**
	 * constants denoting the xml tags for representing data in hospital
	 * details response
	 */
	public static final String HOSPITALDETAILS_XML_TAG = "HospitalDetails";
	
	public static final String HOSPITALDETAILS_SITEID_XML_TAG = "SiteId";
	
	public static final String HOSPITALDETAILS_SITENAME_XML_TAG = "SiteName";
	
	public static final String FACILITYID_XML_TAG = "FacilityId";
	
	public static final String FACILITYNAME_XML_TAG = "FacilityName";
	
	/**
	 * Constant denoting the date format to be used for representing 
	 * patient details 
	 */
	public static final String PATIENTDETAILS_DATEFORMAT = "yyyy-MM-dd";
	
	/**
	 * Constant denoting the error codes to be used for the hospital
	 * details
	 */
	public static final int HOSPITALDETAILS_NULLRESULTSET_ERRORCODE = 521;
	
	public static final int HOSPITALDETAILS_SQLEXCEPTION_ERRORCODE = 522;
	
	public static final int HOSPITALDETAILS_DATANOTFOUND_ERRORCODE = 523;
	
	
}
