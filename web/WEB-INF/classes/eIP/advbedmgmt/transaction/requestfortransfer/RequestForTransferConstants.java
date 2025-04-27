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
package eIP.advbedmgmt.transaction.requestfortransfer;

/**
 * This is the constants file for the request for transfer functionality
 * @author GRamamoorthy
 *
 */
public class RequestForTransferConstants {

	/**
	 * Constants denoting the table fields used to retrieve
	 * meta data for request for transfer functionality
	 */
	public static final String BL_INTERFACED_YN_KEY = "bl_interfaced_yn";
	
	public static final String SETUP_BILL_DTLS_IP_YN_KEY = "setup_bl_dtls_in_ip_yn";
	
	public static final String PATIENT_CHECKIN_ALLOWED_YN_KEY = "pat_check_in_allowed_yn";
	
	public static final String PRIORITY_STATUS_KEY = "priority_applicable_yn";
	
	public static final String CHANGE_BEDCLASS_YN_KEY = "change_bed_class_yn";
	
	public static final String DEACTIVATE_PSEUDOBED_YN_KEY = "deactivate_pseudo_bed_yn";
	
	public static final String DEFAULT_BLOCK_PERIOD_TRANSFER_OUT = "dflt_blk_prd_for_tfr_out";
	
	public static final String BED_BLOCK_PERIOD_NORMAL_KEY = "bed_block_period_normal";
	
	public static final String RESERVE_BED_ON_TRANSFER_YN_KEY = "reserve_bed_on_tfr_yn";
	
	public static final String BED_BLOCK_PERIOD_MAX_KEY = "bed_block_period_max";
	
	public static final String BED_BLOCK_PERIOD_MAX_TYPE_KEY = "bed_block_period_max_type";
	
	public static final String ALLOW_MULTIPLE_BED_FOR_RESERVATION_YN_KEY = "allow_multiple_bed_for_resv_yn";
	
	public static final String MAX_DISCHARGE_PERIOD_FOR_DC = "max_disch_period_for_dc";
	
	/**
	 * Constant to denote the request for transfer functionality name
	 * it is used for logging purpose to denote the functionality name
	 */
	public static final String REQUEST_FOR_TRANSFER_TRANSACTION_KEYWORD = "Request for transfer";
	
	/**
	 * constants used to denote the request parameter keys passed
	 * to the servlet in the request for transfer functionality
	 */
	public static final String FACILITYID_REQ_PARAM_KEY = "facilityId";
	
	public static final String ENCOUNTERID_REQ_PARAM_KEY = "encounterId";
	
	public static final String PATIENTID_REQ_PARAM_KEY = "patientId";
	
	public static final String PRACTITIONERID_REQ_PARAM_KEY = "practionerId";
	
	public static final String NURSING_UNIT_REQ_PARAM_KEY = "nursingUnit";
	
	public static final String SEX_PARAM_KEY = "sex";
	
	public static final String BEDNUMBER_PARAM_KEY = "bedNumber";
	
	public static final String MODE_PARAM_KEY = "mode";
	
	/**
	 * Constant to denote the request for transfer functionality identifier
	 * This value is passed as a request parameter value to the main page
	 */
	public static final String REQUEST_FOR_TRANSFER_FUNC_IDENTIFIER = "BED_TRANS_BOOKING";
	
	/**
	 * constants used to denote the request parameter keys passed
	 * to the main page in the request for transfer functionality
	 */
	public static final String NURSING_UNIT_PARAM_KEYWORD = "location_code";
	
	public static final String FUNCTIONID_PARAM_KEYWORD = "function_id";
	
	public static final String FUNCTIONNAME_PARAM_KEYWORD = "function_name";
	
	public static final String PRACTITIONERID_PARAM_KEYWORD = "Practitioner_Id";
	
	public static final String CALLFROM_PARAM_KEYWORD = "callfrom";
	
	public static final String CALLFUNCTION_PARAM_KEYWORD = "call_function";
	
	public static final String SEX_PARAM_KEYWORD = "Sex";
	
	public static final String BLINSTAL_PARAM_KEYWORD = "bl_instal";
	
	public static final String STATUSVALUE_PARAM_KEYWORD = "status_value";
	
	public static final String CONFIRMIP_PARAM_KEYWORD = "confirmIP";
	
	public static final String SERVICETYPE_PARAM_KEYWORD = "p_service_type";
	
	public static final String CHANGE_NURSINGUNIT_PARAM_KEYWORD = "chg_nurs_unit_in_assign_bed_yn";
	
	public static final String OPER_STND_ID_PARAM_KEYWORD = "oper_stn_id";
	
	public static final String PATIENT_CHECKIN_PARAM_KEYWORD = "pat_check_in_allowed_yn";
	
	public static final String SETUP_BILLDETAILS_PARAM_KEYWORD = "setup_bl_dtls_in_ip_yn";
	
	public static final String BILL_INTERFACED_PARAM_KEYWORD = "bl_interfaced_yn";
	
	public static final String PRIORITY_STATUS_PARAM_KEYWORD = "priotity_status";
	
	public static final String CHANGE_BEDCLASS_PARAM_KEYWORD = "change_bed_class_yn";
	
	public static final String DEACTIVATE_PSEUDOBED_PARAM_KEYWORD = "deactivate_pseudo_bed_yn";
	
	public static final String DEFAULT_BLOCK_PERIOD_PARAM_KEYWORD = "dflt_blk_prd_for_tfr_out";
	
	public static final String BED_BLOCK_PERIOD_NORMAL_PARAM_KEYWORD = "bed_block_period_normal";
	
	public static final String RESERVE_BED_PARAM_KEYWORD = "reserve_bed_on_tfr_yn";
	
	public static final String BED_BLOCK_PERIOD_MAX_PARAM_KEYWORD = "bed_block_period_max";
	
	public static final String BED_BLOCK_PERIOD_MAXTYPE_PARAM_KEYWORD = "bed_block_period_max_type";
	
	public static final String ALLOW_MULTIPLE_BED_PARAM_KEYWORD = "allow_multiple_bed_for_resv_yn";
	
	public static final String MOTHER_CUTOFF_AGE_PARAM_KEYWORD = "mother_cut_off_age_pda";
	
	public static final String MOTHER_MAXAGE_PARAM_KEYWORD = "mother_max_age_pda";
	
	public static final String MAX_DISCHARGE_PERIOD_PARAM_KEYWORD = "max_disch_period_for_predc";
	
	public static final String CONTACT1_NAME_PARAM_KEYWORD = "contact1_name_pda";
	
	public static final String CONTACT2_NAME_PARAM_KEYWORD = "contact2_name_pda";
	
	/**
	 * constants denoting the value to be used for different parameters
	 * passed to the main page
	 */
	public static final String FUNCTION_NAME_PARAM_VALUE = "";
	
	public static final String STATUS_VALUE_PARAM_VALUE = "";
	
	public static final String CONFIRM_IP_PARAM_VALUE = "";
	
	public static final String SERVICE_TYPE_PARAM_VALUE = "";
	
	public static final String CHANGE_NURSINGUNIT_PARAM_VALUE = "N";
	
	public static final String OPER_STND_PARAM_VALUE = "ALL";
	
	public static final String MOTHER_CUTOFF_AGE_PARAM_VALUE = "";
	
	public static final String MOTHER_MAX_AGE_PARAM_VALUE = "";
	
	public static final String CONTACT1_NAME_PARAM_VALUE = "";
	
	public static final String CONTACT2_NAME_PARAM_VALUE = "";
	
	public static final String CALL_FUNCTION_PARAM_VALUE = "RequestforTransfer";
	
	/**
	 * Constant denoting the 
	 */
	public static final String REQUEST_PARAM_VALUE_DELIMITER = "=";	
	
}
