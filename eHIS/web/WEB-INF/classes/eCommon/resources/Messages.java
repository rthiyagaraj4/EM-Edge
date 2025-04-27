/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"CAN_NOT_BE_BLANK","APP-000001 $ cannot be blank."},
		{"REMARKS_CANNOT_EXCEED","APP-000002 $ cannot exceed # characters"},
		{"REMARKS_MUST_BE_GREATER","APP-000003 $ must be greater than # characters"},
		{"REMARKS_MUST_GR_EQUAL","APP-000004 $ should be greater than or equal to From #"},
		{"SHOULD_NOT_BE_BLANK","APP-000005 {1} Cannot be Blank"},
		{"NEG_AGE_CHECK","APP-000006 Age cannot be ZERO or Negative"},
		{"ANY_ONE_CRITERIA","APP-000007 Any one of the criteria should be specified"},
		{"ATLEAST_ONE_RECORD_ENTERED","APP-000008 Atleast One record should be entered"},
		{"ATLEAST_ONE_SELECTED","APP-000009 Atleast one record should be selected"},
		{"ATLEAST_ONE_REP_SELECT","APP-000010 Atleast one report should be selected"},
		{"BASE_SLOT_TIME_FOR_ZERO","APP-000011 Base/Slot Time for the clinic Should not be Zero"},
		{"CA_NOT_INSTALLED","APP-000012 CA module is not installed"},
		{"CANNOT_BE_ZERO","APP-000013 Cannot be zero"},
		{"CANNOT_BE_SPECIAL_CHAR","APP-000014 Cannot have special characters"},
		{"NO_CLINICS_FOR_USER","APP-000015 Clinics are not defined for this User. Cannot Proceed."},
		{"DATE_NOT_GREATER_SYSDATE","APP-000016 Date cannot be greater than System Date"},
		{"START_DATE_GREATER_SYSDATE","APP-000017 Date cannot be greater than system date"},
		{"TO_DATE_EQUAL_GREATER_FROM_DATE","APP-000017 To Date should be greater than or equal to From Date"}, // PMG2022-MMS-CRF-0002 [44346]
		{"DOB_CHECK","APP-000018 Date of Birth cannot be greater than TODAY"},
		{"DAYS_CHECK","APP-000019 Days cannot be greater than 31"},
		{"CONTINUE_REFERRAL","APP-000020 Do you want continue Referral Registration?"},
		{"REG_REFERRAL","APP-000021 Do you want Register Referral for this Patient?"},
		{"DELETE_RECORD","APP-000022 Do you want to Delete the Record?"},
		{"PRINT_CONFIRM","APP-000023 Do you want to print  #"},
		{"REGISTER_REFERRAL_YN","APP-000024 Do you want to Register Referral?"},
		{"APPT_REPRINT","APP-000025 Do you want to Reprint the Referral Letter?"},
		{"REFLETTER_REPRINT","APP-000026 Do you want to Reprint the Referral Letter??"},
		{"UPDATE_PAT_VAL","APP-000027 Do you want to update Patient Valuables ?"},
		{"DUPLICATE_CODE_EXISTS","APP-000028 Duplicate Code not allowed"},
		{"DR_NOT_INSTALLED","APP-000029 Duplicate Registration Check (DR) module is not installed"},
		{"RECORD_ALREADY_EXISTS","APP-000030 Duplication Not Possible..."},
		{"WELCOME","APP-000031 Welcome to eHIS"},
		{"EMER_CLINIC_NOT_ALLOWED","APP-000032 Emergency Clinic not allowed for Registration."},
		{"ENC_ID_REACHED_MAX","APP-000033 Encounter ID has reached the maximum value"},
		{"INVALID_MAX_NUMBER","APP-000034 Enter a valid max number"},
		{"INVALID_NEXT_NUMBER","APP-000035 Enter a valid next number, should be greater than zero"},
		{"FIT_FOR_DUTY_GR_END_DATE","APP-000036 Fit for Duty should be greater than or equals to Leave to Date"},
		{"INVALID_VALUE","APP-000037 Invalid #"},
		{"INVALID_DATE_RANGE","APP-000038 Invalid date range"},
		{"INVALID_NUMBER_FORMAT","APP-000039 Invalid number format"},
		{"INVALID_USER_ID","APP-000040 Invalid User ID"},
		{"LV_DATE_EQ_CURR_DATE","APP-000041 Leave $ Date should be Less than current Date"},
		{"LV_DATE_LESS_DOB","APP-000042 Leave From Date should be Greater than Date of Birth"},
		{"LV_END_DATE_EQ_FROM_DATE","APP-000043 Leave To Date should be Greater than Leave from Date"},
		{"LOCATION_CHG_FIN_DTLS","APP-000044 Location changed.Check Financial Details"},
		{"MONTH_IS_GR_12","APP-000045 Month cannot be greater than 12"},
		{"MONTHS_CHECK","APP-000046 Months cannot be greater than 11"},
		{"MORE_ALT_ID_FOUND","APP-000047 More than one # is present"},
		{"MULTI_OPER_STN_FOR_USER","APP-000048 Multiple Operation Stations are defined for this User. Cannot Proceed."},
		{"NEXT_NUM_GR_MAX_NUM","APP-000049 Next Number should not be greater than Max Number"},
		{"NO_CHANGE_TO_SAVE","APP-000050 No Changes to Save ...."},
		{"ENCOUNTER_NOT_FOUND","APP-000051 No Encounter found, cannot proceed"},
		{"NO_RECORD_FOUND","APP-000052 No Records Found...."},
		{"NOT_VALID","APP-000053 Not valid Facility/User ID"},
		{"INVALID_POSITIVE_NUMBER","APP-000054 Number must be greater than zero"},
		{"NO_OPER_STN_FOR_USER","APP-000055 Operator Station is not defined for this User"},
		{"ORDERBY_NOT_BLANK","APP-000056 Order By cannot be Blank"},
		{"PAT_VAL_MAX_2000","APP-000057 Patient valuables cannot exceed 2000 characters"},
		{"PRF_DATE_CHECK","APP-000058 Preferred Date must be greater than Referral Date"},
		{"PRF_DATE_NOT_GR_CURR_DATE","APP-000059 Preferred Date should be greater than or equal to current date"},
		{"PRINT_ROUTING_NOT_DEFINED","APP-000060 Printer / Print Routing not Defined. Contact System Administrator"},
		{"NO_RECORD_FOUND_FOR_CRITERIA","APP-000061 Query caused no records to be retrieved"},
		{"RECD_DATE_SYSDATE_CHECK","APP-000062 Received Date cannot be greater than Sysdate"},
		{"RECDDATE_REFLDATE_CHECK","APP-000063 Received Date must be greater than Referral Date"},
		{"CODE_ALREADY_EXISTS","APP-000064 Record Already Exists..."},
		{"REFL_DATE_CHECK","APP-000065 Referral Date cannot be greater than Sysdate"},
		{"REFERRAL_BOOKED","APP-000066 Register Referral Completed Successfully with Registration No."},
		{"REFERRAL_MODIFIED","APP-000067 Register Referral Modified Successfully with Registration No."},
		{"REPORT_SUBMIT_SERVER","APP-000068 Report has been submitted to the Report Server..."},
		{"REPORT_RULE_NOT_DEFINED","APP-000069 Report Rule not Defined. Cannot print. Contact System Administrator"},
		{"RESOURCE_NOT_WORK","APP-000070 Resource Not Working for the Day"},
		{"RESUME_ACTIVITY_GR_END_DATE","APP-000071 Resume Activity should be greater than or equal to Leave to Date"},
		{"ROOM_NOT_AVBL","APP-000072 Room Not Available for the Day"},
		{"SEARCH_TEXT_BLANK","APP-000073 Search Text cannot be blank..."},
		{"MSG_NOT_MAINTAINED","APP-000074 This message is not maintained"},
		{"CURRENTLY_IN_PATIENT","APP-000075 This patient is currently an Inpatient / Daycare Patient"},
		{"TO_TIME_LESS_FM_TIME","APP-000076 To time can not be less than From time"},
		{"MIN_ONE_DETAIL_REQUIRED","APP-000077 Transaction must have atleast one detail record"},
		{"OBJ_CANNOT_EXCEED","APP-000078 Value cannot exceed $ characters"},
		{"VALUE_SHOULD_BE_GR_ZERO","APP-000079 Value should be greater than ZERO"},
		{"VISIT_LESS_DATE","APP-000080 Visit Date should be Less than or equal to System Date"},
		{"VISIT_TYPE_CHG_FIN_DTLS","APP-000081 Visit Type changed.Check Financial Details"},
		{"VISIT_TYPE_NOT_APPL_PRACT","APP-000082 Visit Type is not applicable to this practitioner"},
		{"SECURED_NOT_ALLOWED","APP-000083 You do not have access to this Patient Record"},
		{"BL_NOT_INSTALLED","APP-000084 Billing module is not installed"},
		{"WANT_TO_SAVE","APP-000085 Do you want to save the changes?"},
		{"SWITCH_LANG_NOT_APPL","APP-000086 Switch Language option is not applicable"},
		{"MDS_NOT_ENTERED","APP-000087 MDS is not entered"},
		{"REGISTERED_IN_MORTUARY","APP-000088 This Patient is registered in Mortuary. Checkout cannot be cancelled."},
		{"CURRENTLY_IN_PATIENT1","APP-000089 This Patient is currently an Inpatient. Checkout cannot be cancelled."},
		{"ALREADY_VISITED_SAME_LOCN","APP-000090 This Patient is having an open encounter in the same Location/Service. Checkout cannot be cancelled."},
		{"CANCEL_CHECKOUT_NOT_ALL_OPERSTN","APP-000091 Cancel Check Out not allowed for Operator Station"},
		{"CAM_DRV_INS","APP-000092 Check whether Web Cam is installed properly or not"},
		{"INAVLID_RESPONSIBILITY","APP-000093 Invalid Responsibility."},
		{"INAVLID_FACILITY","APP-000094 Invalid Facility."},
		{"INAVLID_RESP_FACILITY","APP-000095 Invalid Responsibility/Facility."},
		{"NO_FACILITIES","APP-000096 NO Facilities Available."},
		{"FM_TIME_GR_TO_TIME","APP-000097 From Time cannot be greater than To Time"},
		{"ALL_MANDATORY_FIELDS","APP-000098 All mandatory fields should be entered"},
        {"SPECIFY_ANY_CRITERIA","APP-000099 Specify any one of $ or # criteria"},
		{"INVALID_BED","APP-000100 Invalid Bed"},
		{"MISMATCH_REFERRALID_CLINIC","APP-000101 Referral ID is mismatch with the selected Location"},
		{"MISMATCH_REFERRALID_PATIENTID","APP-000102 Referral ID is mismatch with PatientID "},
		{"MISMATCH_REFERRALID_LOCATION","APP-000103 Referral ID is mismatch with Location. Do you want to continue? "},
		{"INVALID_OPER_STN_ACCESS","APP-000104 Invalid Operator Station Access"},
		{"TRANS_MGR_NOT_APPL","APP-000105 Transalation Manager is not applicable"},
		{"CANNOT_SWITCH_LANG","APP-000106 One or More Patient charts oppened, Cannot Switch language"},
		{"LOCATION_RESOURCE_SHOULD_NOT_BE_BLANK","APP-000005 Either Location or Resource need to be selected"},
		{"PATIENT_IS_NOT_A_CITIZEN","APP-000107 Patient is not a Citizen. Create a Referral to proceed"},// Added By Dharma for Non-Citizen Validation on 27th Dec 2013
		{"DASHBOARD_URL_NOT_CONFIGURED","APP-000108 Dashboard url not configured. Cannot proceed."},
		{"REMARKS_SHOULD_GR_EQUAL","APP-000109 $ should be greater than or equal to  #"},//MMS44.1	
		{"REMARKS_SHOULD_LS_EQUAL","APP-000109 $ should be less than or equal to  #"},//MMS44.1	
		{"DOWNTIME_PATIENT_NOT_ALLOWED","APP-000110 Update the Registration Date Time for this patient from Change Patient Details and proceed"},
		{"REG_DATE_TIME_SHOULD_GR_EQUAL","APP-000111 $ should be greater than or equal to Patient's Registration Date Time"},/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835]*/
		{"PHOTO_UPLOAD_PATH","APP-000112 Please upload photo from file "}, // Selayang SmartKad
		{"YEAR_4_CHAR","APP-000113 Year should not be less than 4 characters"}, //Added by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702
		{"VALID_GSTIN","APP-000114 Please Enter a Valid GSTIN"}, //Added by Ashwini on 07-Jul-2017 for AMS-CRF-0132
		{"GST_ALREADY_EXISTS","APP-000115 GST Region Code Already Exists..."}, //Added by Ashwini on 07-Jul-2017 for AMS-CRF-0132
		{"REFER_REQ_PAT","APP-000113 Referral required for this patient?"}, // Added by Mano on July 12th 2017 against ML-MMOH-CRF-0611
		{"REQ_ID_GEN_CURNT_YR","APP-000116 Request cannot be placed as req id generation is not defined for current year"}, //Added by Ashwini on 17-Jul-2017 for ML-MMOH-CRF-0702
		{"NXT_NO_GR_MAX_NO","APP-000117 Request cannot be placed as maximum req id $ defined is exhausted "}, //Added by Ashwini on 17-Jul-2017 for ML-MMOH-CRF-0702
		{"MIGRATION_PRACTITIONER_ID","APP-000118 Migration Practitioner Id Already Exists..."}, //Added for this CRF ML-MMOH-CRF-0862
		{"CHANGE_BILLING_GROUP","APP-000119 Do you want to Confirm? "}, //Added by Subha for KDAH-SCF-0425 on V20180510
		{"DATE_CHECK","APP-000119 Date Range Cannot be Greater Than 31 Days "}, //Added by Suji Keerthi for MOHE-CRF-0031
		{"PAT_ID_MAND","APP-000120 Patient ID is mandatory."}, //Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
		{"PRIMARY_DIAG_NOT_RECORDED","APP-000124 Primary Diagnosis is not recorded. Cannot proceed further to record secondary diagnosis. Please record primary diagnosis"},//Added by Maheshwaran K for MMS-DM-CRF-0197.1
		{"UPDATE_MOB_NO_N_EMAIL","APP-000122 Please update Patient ? to proceed further."},//Added by Ajay Hatwate for ML-MMOH-CRF-1930
		{"DEATH_REG_FORM_HAS_TO_BE_SIGNED","APP-000123 Death Register Form has to be signed. Cannot Proceed"},//Added by Ajay Hatwate for AAKH-CRF-0179
		{"ACCESS_RESTRICTED_AUTH_PERSONAL","APP-000124 Access to restricted patient clinical data is limited to authorized personnel only. Cannot proceed"}//Added by Ajay Hatwate on 16-Oct-2023 for MMS-DM-CRF-0210.1
		
	};			
}		
