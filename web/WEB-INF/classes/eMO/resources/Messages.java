/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {

			{"PATIENT_IS_NOT_DECEASED","APP-MO0001 Patient is not deceased"},
			{"PATIENT_ALREADY_REGISTERED","APP-MO0002 Patient is already registered"},
			{"MAX_SHOULD_BE_GT_NEXT","APP-MO0003 $ should be greater than #"},
			{"MAX_SHOULD_BE_GT_START","APP-MO0004 Max number should be greater than start number"},
			{"START_NUM_CANT_BE_ZERO","APP-MO0005 Start Number cannot be zero"},
			{"CANT_BE_LT_DECEASED_DATE","APP-MO0006 Body Receipt/Burial Permit date cannot be less than Deceased date"},
			{"PM_END_CANT_BE_LT_PM_START","APP-MO0007 Postmortem End Date/Time cannot be less than Start Date/Time"},
			{"DATE_CANT_BE_LT_RECEIPT","APP-MO0008 Date cannot be less than Body Receipt Date"},
			{"REG_NO_EXCEEDS_MAX_NO","APP-MO0009 Registration No exceeds the Max No set in the Parameter"},
			{"AREA_EXCEEDS_CAPACITY","APP-MO0010 Capacity is full for the Area"},
			{"REGN_NO_CTRL_TO_BE_SETUP","APP-MO0011 Registration No Control Parameter has to be setup"},
			{"SAME_PRACT_ID_NOT_ALLOWED","APP-MO0012 Same Practitioner cannot be selected"},
			{"PARAMETER_TO_BE_SETUP","APP-MO0013 MO Parameter Setup has to be done"},
			{"CUTOFF_PERIOD_CHECK","APP-MO0014 Less than hours should be greater than More than hours"},
			{"REGN_NOT_ALLOWED","APP-MO0015 Registration is not allowed"},
			{"CANNOT_CREATE_BAYS","APP-MO0016 Locations are already created as per the Area Capacity"},
			{"BURIAL_PERMIT_NO_EXISTS","APP-MO0017 Burial Permit No already Exists"},
			{"BURIAL_PERMIT_NO_GT_ZERO","APP-MO0018 Next Burial Permit No should be greater than Zero and should not be less than Next Burial Permit No"},
			{"DONOR_DETAILS_EXCEEDS_LIMIT","APP-MO0019 Donor Details cannot be greater than 500 characters"},
			{"SAME_WITNESS","APP-MO0020 Cannot have the same Witness"},
			{"SPECI_ANOTOM_UNIQUE","APP-MO0021 Specimen Type and Anotomical Site should be unique"},
			{"POSTMORTEM_FINDINGS","APP-MO0022 Postmortem Findings cannot be greater than 500 characters"},
			{"CNT_ASIGN_SAME_DIAG_CODE","APP-MO0023 Cannot assign same Diagnosis Code"},
			{"PM_PURPOSE","APP-MO0024 Purpose of performing Postmortem cannot exceed 250 characters"},
			{"DEATH_CAUSE_EXCEEDS_LMT","APP-MO0025 Cause of death cannot exceed 250 characters"},
			{"POLICE_DET_EXCEEDS_LMT","APP-MO0026 Police details cannot exceed 500 characters"},
			{"EXPRT_ADR_EXCEEDS_LMT","APP-MO0027 Address cannot exceed 500 characters"},
			{"BURIAL_PERMIT_NOT_EXIST","APP-MO0028 Burial Permit does not exist"},
			{"BURIAL_PERMIT_NOT_ALLOWED","APP-MO0029 Burial Permit is not allowed because Postmortem is required"},
			{"OBTAINFROM_SELECT","APP-MO0030 Obtained From must be selected"},
			{"REFRESH_INTERVAL_CHK","APP-MO0031 Refresh interval should be in between 1 and 9999"},
			{"BLK_DATE_TIME","APP-MO0032 Blocked Until Date time should be greater than system date time"},
			{"VAC_BED_SEL","APP-MO0033 Selected Location is currently allocated/blocked"},
			{"BUR_NT_GEN","APP-MO0034 Burial Permit is not yet generated.Cannot Proceed...."},
			{"POLICE_DET_MAND","APP-MO0035 Police details must be captured"},
			{"CAUSE_OF_DEATH_NOT_REC","APP-MO0036 Cause of Death not Recorded. Cannot Proceed."},
			{"CNT_REASSIGN","APP-MO0037 Order has been placed.Cancel Order To Reassign Area."},
			{"CAPACITY_GREATER_LOCATION","APP-MO0038 The Capacity value should be greater than the created Location."},
			{"CAPACITY_GREATER_ZERO","APP-MO0039 The Capacity value should be greater than zero."},
			{"DATE_CANT_BE_BLANK","APP-MO0040 Date cannot be blank"},
			{"ENTER_BDYRCPT_DTTIME","APP-MO0041 Body Receipt Date/Time must be entered first.."},
			{"ENTER_POLICE_DTLS","APP-MO0042 All the Police details must be entered"},
			{"FROM_DATE_LESS_EQ_TO_DATE","APP-MO0043 From Date should be Lesser than  or equal to To Date"},
			{"REASON_CANT_MORE","APP-MO0044 Reason cannot be more than 100 characters..."},
			{"BODY_PART_DTLS_CANT_VIEW","APP-MO0045 Body Part Registration Details cannot be viewed here..."},
			{"ENTER_TISSUE_PROCMENT_DATE","APP-MO0046 Tissue Procurement Date must be entered"},
			{"CAPTURE_SPECIMEN_DTLS","APP-MO0047 All the specimen details must be captured"},
			{"DATE_CANT_BE_LESS","APP-MO0048 $ date cannot be less than # date"},
			{"CAPTURE_BURIAL_PRMT_DTLS","APP-MO0049 All the Burial Permit Details must be captured"},
			{"SELECT_BODY_PART","APP-MO0050 Atleast one of the Body Part must be selected"},
			{"CAPTURE_CONSENT_DTLS","APP-MO0051 All the Consent details must be captured"},
			{"CAPTURE_DONOR_DTLS","APP-MO0052 All the Donor details must be captured"},
			{"ENTER_DONOR_CARD_INFO","APP-MO0053 Donor Card Information must be entered"},
			{"ID_MARKS_EXCEEDS_LMT","APP-MO0054 Identification Marks cannot  exceed 500 characters..."},
			{"USER_CANT_EXCEEDS_PARAM","APP-MO0055 User can not exceed the parameter value"},
			{"MO_PARAM_NOT_FOUND","APP-MO0056 MO Parameter is not defined"},
			{"NOT_EXT_PAT","APP-MO0057 Patient deceased in logged in facility. Cannot register as external"},
			{"REASON_EXCEED_MAX_LEN","APP-MO0058 Reason cannot exceed 100 characters"} ,
            {"ENTER_DECEASED","APP-MO0059 Enter Deceased Patient only"},
            {"EMBALM_HOME_OR_HOSPITAL","APP-MO0060 Either Embalm at Hospital or Embalm at Home need to be selected"},
			{"EMBALM_NOT_COMPLETED","APP-MO0061 Body cannot be released as Embalm not completed."},
			//Modified against IN:051368
			{"EMBALM_NOT_DEFINED","Embalm Number Control is not defined. Cannot Proceed."},
			{"EMBALM_REG_NO_EXCEEDS_MAX_NO","Embalm Registration No exceeds the Max No set in the Embalm Number Control."},
			{"CANT_BE_LT_DECEASED_DATE1","APP-MO0062 Body Received/Burial Permit date cannot be less than Deceased date"}//Added by Shanmukh for Ml-MMOH-CRF-1036
	};			
}		
