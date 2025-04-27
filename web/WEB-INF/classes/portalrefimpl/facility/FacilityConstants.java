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
package portalrefimpl.facility;

/**
 * @author GRamamoorthy
 *
 */
public class FacilityConstants {

	/**
	 * Constants denoting the XML tag names for facility list
	 */
	public static final String FACILITIES_XML_TAG = "Facilities";
	
	public static final String FACILITY_XML_TAG = "Facility";
	
	public static final String FACILITYID_XML_TAG = "FacilityId";
	
	public static final String FACILITYNAME_XML_TAG = "FacilityName";
	
	public static final int	FACILITYLIST_SQLEXCEPTION_ERRORCODE = 421;
	
	public static final int FACILITYLIST_NULLRESULTSET_ERRORCODE = 422;
	
	public static final int FACILITYLIST_NODATA_FOUND_ERRORCODE = 423;
	
	/**
	 * Constants denoting the error codes to be used for 
	 * facility for contact service
	 */
	public static final int FACILITY_FORCONTACT_NULL_RESULTSET_ERRORCODE = 2251;
	
	public static final int FACILITY_FORCONTACT_SQLEXCEPTION_ERRORCODE = 2252;
	
	public static final int FACILITY_FORCONTACT_NODATA_FOUND_ERRORCODE = 2253;
	
	public static final int FACILITY_FORCONTACT_INVALID_RECORDCOUNT_ERRORCODE = 2201;
	
	/**
	 * Constants denoting the keys used in the request parameters passed
	 * in the facility for contact web service
	 */
	public static final String FACILITY_FORCONTACT_FACILITYIDS_REQUEST_PARAM_KEY = "facilityIds";
	
	public static final String FACILITY_FORCONTACT_FACILITY_RECORD_COUNT_REQUEST_PARAM_KEY = "facilityRecordCount";
	
	/**
	 * Constant denoting the default value to be used for the record count
	 * in facility for contact service
	 */
	public static final int FACILITY_FORCONTACT_FACILITY_RECORDCOUNT_DEFAULT_VALUE = 0;
	
	/**
	 * Constant denoting the delimiter used in the facility ids passed
	 * to the facility for contact service
	 */
	public static final String FACILITY_FORCONTACT_FACILITYIDS_DELIMITER = "##";
	
	/**
	 * Constants denoting the request parameters used for the facility for patient
	 * service
	 */
	public static final String FACILITY_FORPATIENT_RECORDCOUNT_REQUEST_PARAM = "recordCount";
	
	/**
	 * Constants denoting the parameter key values read from portalrefconfig.properties
	 * file
	 */
	public static final String FACILITY_FORCONTACT_CONSIDER_ALL_PARAM = "FacilityForContactConsiderAll";
	
	public static final String FACILITY_FORCONTACT_COUNT_PARAM = "FacilityForContactRecordCount";
	
	/**
	 * Constants denoting the values of the consider all param
	 */
	public static final String FACILITY_FORCONTACT_CONSIDER_YES = "Y";
	
	public static final String FACILITY_FORCONTACT_CONSIDER_NOT = "N";
	
	/**
	 * Constant denoting the default value of the record count to be used
	 * while retrieving facilities for contact
	 */
	public static final int FACILITY_FORCONTACT_DEFAULT_COUNT_VALUE = 5;
	
	/**
	 * Constant denoting the parameter key to be used while specifying
	 * the order of the address contents to be shown in the contact us page
	 */
	public static final String ADDRESS_CONTENTS_ORDER_PARAM = "FacilityAddressContentsOrder";
	
	/**
	 * Constant denoting the parameter key to be used while specifying
	 * the order of the contact details contents to be shown in the contact us page
	 */
	public static final String CONTACTDETAILS_CONTENTS_ORDER_PARAM = "FacilityContactDetailsContentsOrder";
	
	/**
	 * Default constants for the address and contact details configuration
	 * 
	 */
	public static final String DEFAULT_ADDRESS_CONTENTS_ORDER_PARAM = "AddressLines##Area##Town##Region##Country##Pincode";
	
	public static final String DEFAULT_CONTACTDETAILS_ORDER_PARAM = "TelephoneLines##FaxNumber##Email##Website";
	
	/**
	 * Constant denoting the delimiter used between the different identifiers
	 * in the address and contact details order configuration parameter
	 */
	public static final String ADDRESS_CONTACTDETAILS_ORDER_DELIMITER = "##";
	
	/**
	 * Constants denoting the identifiers used in the address configuration
	 * parameter
	 */
	public static final String ADDRESS_LINES_PARAM = "AddressLines";
	
	public static final String AREA_PARAM = "Area";
			
	public static final String TOWN_PARAM = "Town";
	
	public static final String REGION_PARAM = "Region";
	
	public static final String COUNTRY_PARAM = "Country";
	
	public static final String PINCODE_PARAM = "Pincode";
	
	/**
	 * Constants denoting the identifiers used in the contact details configuration
	 * parameter
	 */
	public static final String TELEPHONE_LINES_PARAM = "TelephoneLines";
	
	public static final String FAXNUMBER_PARAM = "FaxNumber";
	
	public static final String EMAIL_PARAM = "Email";
	
	public static final String WEBSITE_PARAM = "Website";
}
