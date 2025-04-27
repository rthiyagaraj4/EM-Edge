/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.resources;

import java.util.*;

public class  Messages  extends ListResourceBundle implements java.io.Serializable{
	public Object[][] getContents() {
         return contents;
    }







	static final Object[][] contents = {
		{"MR_INVALID_DIAG_CODE_FOR_PATIENT","APP-MR0001 The Diagnosis Code entered is not applicable to this patient."},
		{"MRDATE1_GT_DATE2","APP-MR0002 $ cannot be greater than #"},
		{"MRDATE1_LT_DATE2","APP-MR0003 $ cannot be less than #"},
		{"MRDATE1_GTR_DATE2","APP-MR0004 $ should be greater than #"},
		{"MR_VIEW_DTH_REG","APP-MR0005 Any one of the Criteria  Patient Id /Deceased Period should be entered"},
		{"DIAG_REC0D_AUDIT","APP-MR0006 Any one of the Criteria  Patient Id /Encounter Period should be entered"},
		{"APPLY_NOT_VALID","APP-MR0007 Apply is not Valid"},
		{"APPT_NOT_GIVEN","APP-MR0008 Appointment Details not prepared for this Patient. Cannot Prepare Medical Report."},
		{"SELECT_TWO_PRACT","APP-MR0009 Atleast two Practitioners should be selected."},
		{"TERM_DESC_SHOULD_NOT_BE_BLANK","APP-MR0010 Description Cannot be Blank"},
		{"MR_DIAG_DIFFGRP_CONFIRM","APP-MR0011 Do You Want Assign/Create Diagnosis Group for this current Diagnosis."},
		{"MR_CONFIRM_PRINT","APP-MR0012 Do you want print the Report - #?"},
		{"DUPLI_SRL_NO","APP-MR0013 Duplicate Order Serial Nos are not allowed for this combination."},
		{"DUP_SERIAL_NO","APP-MR0014 Duplicate Serial Number"},
		{"END_DT_GR_START_DT","APP-MR0015 End Date Should be Greater than or equal to Start Date"},
		{"CANT_XCEED_250_CHARS","APP-MR0016 Entered value cannot exceed 250 characters"},
		{"CANT_XCEED_2000_CHARS","APP-MR0017 Event Details cannot exceed 2000 characters"},
		{"EVENT_START_GREATER_DOB","APP-MR0018 Event Start Date Should be Greater than or Equal To Patient's Date Of Birth"},
		{"EVENT_START_LESS_SYSDATE","APP-MR0019 Event Start Date Should Be Lesser than or Equal To Current Date"},
		{"FILE_DOESNOT_EXIST","APP-MR0020 File Does Not Exists for this Patient"},
		{"FILE_ALREADY_CREATED_FCY","APP-MR0021 File has already been created for this Patient in this Facility"},
		{"GROUP_NAME_LENGTH","APP-MR0022 Group Name Length should Not be greater than # Characters"},
		{"HIGHER_LVL_SEL","APP-MR0023 Higher Level cannot be selected. Select the Lower Level"},
		{"INVALID_SRL_NO","APP-MR0024 Invalid Order Serial No"},
		{"MASTER_SELECT","APP-MR0025 Master should be selected"},
		{"ALREADY_EXIST_MBOARD","APP-MR0026 Medical Board Type assocaited to Medical Board. Cannot disable."},
		{"NOTE_DOESNOT_EXIST_CANT_PROCEED","APP-MR0027 Medical Report not prepared for this Patient. Cannot Proceed"},
		{"NOTE_DOESNOT_EXIST","APP-MR0028 Medical Report not prepared for this Patient. Cannot view medical report"},
		{"CONT_MRTHN_ONE_CHIEF","APP-MR0029 More than one Chief not allowed"},
		{"MR_EOC_MULT_NOT_ALLOWED","APP-MR0030 Multiple Selection Not Allowed Here."},
		{"ONLY_TEN_SEL_ALLOWED","APP-MR0031 Only Ten Selections are allowed"},
		{"INVALID_SERIAL_NO","APP-MR0032 Order Srl No Value should be greater than 0"},
		{"PATIENT_NOT_REGISTERED","APP-MR0033 Patient not registered with Facility. Cannot proceed."},
		{"PAYMENT_NOT_COMPLETE","APP-MR0034 Payment details not complete"},
		{"MR_PRY_CONT_MRT_ONE","APP-MR0035 Pirmary Diagnosis cannot more than one."},
		{"MR_INCLUDE_DIG","APP-MR0036 Please Include the Diagnosis."},
		{"MR_EX_SELECT_ONE_DIAG","APP-MR0037 Please select at least one Diagnosis."},
		{"MR_DIAG_DIFF_GROUP","APP-MR0038 Please select the checkbox."},
		{"RANGE_LENGTH","APP-MR0039 Range Length should Not be greater than 200 Characters"},
		{"REF_DATE_GREATER_DOB","APP-MR0040 Reference Date Should be Greater than or equal to Patient's Date Of Birth"},
		{"REF_DATE_LESS_SYSDATE","APP-MR0041 Reference Date should be Lesser than or equal to Current Date"},
		{"REMARKS_XCEED_2000_CHARS","APP-MR0042 Remarks cannot exceed 2000 characters"},
		{"REQUEST_ALREADY_MADE","APP-MR0043 Request already available. Cannot request again"},
		{"REQ_REAL_IS_MANDATORY","APP-MR0044 Requestor or Relationship should be selected."},
		{"REQ_DOCS_CANT_XCEED_100_CHARS","APP-MR0045 Required Documents cannot exceed 100 characters"},
		{"SERIAL_NO_NOT_BLANK","APP-MR0046 Serial Number cannot be blank"},
		{"STAT_DT_BT_ONSET_AND_CURR","APP-MR0047 Status Date should be between Onset Date and Current Date"},
		{"TERM_CODE_SHOULD_NOT_BE_BLANK","APP-MR0048 Term Code Cannot be Blank"},
		{"TERM_CODE_LEVEL_1_IS_MANDATORY","APP-MR0049 Terminology Code For Level 1 is mandatory"},
		{"TERM_SET_SHOULD_NOT_BE_BLANK","APP-MR0050 Terminology Set Cannot be Blank "},
		{"MR_REC_DIAG_NO_EXIT_GRP","APP-MR0051 There is no other existing Diagnosis group."},
		{"MR_DIAG_CURR_ACTIVE","APP-MR0052 You Cannot update Resolved/Revoked/InError Status Diagnosis."},
		{"ENC_CANNOT_BLANK","APP-MR0053 Encounter has to be selected for Medical Report Request"},
		{"ONLY_ONE_BLOOD_GRP_WITH_INDETERMINATE_AS_YES","APP-MR0054 There should be only one blood group with indeterminate as Yes"},
		{"CUTOFF_PERIOD_CANNOT_ZERO","APP-MR0055 Cutoff Period cannot be zero"},
		{"CODE_LENGTH_CANNOT_ZERO","APP-MR0056 Code length cannot be zero"},
		{"MR_PARAM_NOT_DEFINED","APP-MR0057 MR Parameter is not defined"},
		{"SAME_GRP_CHKBOX","APP-MR0058 Please select the checkboxes from the same group"},
		{"ATLEAST_ONE_PRACT","APP-MR0059 Atleast one Internal Practitioner must be selected"},
		{"CODELENGTH_MAX_30","APP-MR0060 Code length cannot be greater than 30"},
		{"INVALID_DIAG_CODE","APP-MR0061 Invalid Diagnosis code"},
		{"APPT_LESS_THAN_SYSDATE_CANT_PROCEED","APP-MR0062 Appointment Date is less than Current Date. Cannot Proceed"},
		{"SUBMIT_CURR_PAGE","APP-MR0063 Do you want to submit the current page."},
		{"PREV_ENC_TO_CURR_ENC","APP-MR0064 Do you want to update Previous Encounter Diagnosis to Currrent Encounter."},
		{"LEVEL_NOT_SELECT","APP-MR0065 This level cannot be selected."},
		{"SUM_CODELENGTH_MAX_30","APP-MR0066 Sum of all Code Lengths cannot exceed 30."},
		{"COMBINATION_NOT_ALLOWED","APP-MR0067 Record already exists for this patient,adverse event indicator,adverse event type and allergen combination."},
		{"MAINTAIN_SEVERITY_LEVEL","APP-MR0068 Severity level should be maintained."},
		{"REACTION_ALREADY_RECORDED_DATE","APP-MR0069 Reaction already recorded for the entered date."},
		{"DIAG_PROCEDURE","APP-MR0070 You cannot access this function beyond the limit specified in IP/OP parameter"},
		{"CANNOT_RECODE_AGAIN","APP-MR0071 Cannot Re-code the same diagnosis code again"},
		{"ONSET_DT_BT_DOB_AND_CURR","APP-MR0072 Onset date should be between date of birth and current date"},
		{"ASS_DIAG_IN_SUF_DATA","APP-MR0073 Data entered was not sufficient"},
		{"ASTERIX_CODE_NOT_EXISTS","APP-MR0074 Asterisk code cannot be blank"},
		{"ADM_OR_DEATH_PERIOD","APP-MR0075 Any one of the Criteria Admission Period / Discharge Period should be entered"},
		{"PATIENT_FILE_NOT_APPL","APP-MR0076 Create Patient File is not Applicable "},
		{"NO_ALLERGY_REC_IN_CURR_SYS","APP-MR0077 No Allergy recorded in the current system"},
		{"REACTION_CANNOT_ERROR","APP-MR0078 All reactions cannot be marked as error . Please uncheck one reaction or add another reaction"},
		{"PRIMARY_DIAGNOSIS_TERM_SET","APP-MR0079 Only one primary diagnosis can be entered for a term set."},
		{"CONFIRM_CODE","APP-MR0080 Do you want to Confirm the Code?"},
		{"ERROR_CODE","APP-MR0081 Do you want to Mark this item as Error?"},
		{"AUTHORIZE_CODE","APP-MR0082 Do you want to Authorize?"},
		{"REJECT_CODE","APP-MR0083 Do you want to Reject?"},
		{"CUT_OFF_PERIOD_FOR_RECODING","APP-MR0084 Cut off period for Recoding cannot be zero days"},
		{"GRACE_PERIOD","APP-MR0085 Grace Period cannot be zero"},
		{"NO_SELECTION","APP-MR0086 No record selected, cannot proceed"},
		{"RECODE_PRIVILEGE_NOT_DEFINED","APP-MR0087 Recode Privilege not defined for this user.Cannot proceed."},
		{"DATE_RANGE_WEEK","APP-MR0088 From date to To date cannot be greater than 7 days"},
		{"DIAG_RECODE_CANT_CNF","APP-MR0089 Diagnosis Recoded cannot confirm."},
		{"MR_FROM_DATE_LESS_SYSDATE","APP-MR0090 From Date should be less than or equal to Current Date"},
		{"MR_TO_DATE_LESS_SYSDATE","APP-MR0091 To Date should be less than or equal to Current Date"},
		{"ACT_DIAG_PROC_CODE","APP-MR0092 Entered code is an active one. Please enter a different code"},
		{"DIAG_PROC_RECD","APP-MR0093 Please select either Diagnosis or Procedure"},
		{"SEL_DIAG_PROC","APP-MR00942 Please select atleast one code"},
		{"DUP_DIAG_PROC","APP-MR0095 You have entered a duplicate code . Please enter a different code"},
		{"ORG_MRK_ERR","APP-MR0096 Orignal code cannot be marked for error"},
		{"CNRFM_DIAG_PROC","APP-MR0097 You are about to confirm the selected code. You wont be able to make any more changes. Do you want to continue"},
		{"ERR_DIAG_PROC","APP-MR0098 You are about to mark the selected code as error. You wont be able to revert back. Do you want to continue"},
		{"CMPL_DIAG_PROC","APP-MR0099 You are about to complete the recoding of Diagnosis/Procedure. You wont be able to make any more changes. Do you want to continue"},
		{"MR_REV_CNT_COMP","APP-MR0100 Codes exist in Review status. Cannot Complete."},
		{"MR_DRG_ERR1","APP-MR0101 No Principal Diagnosis"},
		{"MR_DRG_ERR2","APP-MR0102 Invalid Principal Diagnosis"},
		{"MR_DRG_ERR3","APP-MR0103 Unacceptable Principal Diagnosis"},
		{"MR_DRG_ERR4","APP-MR0104 Principal Diagnosis not valid for age"},
		{"MR_DRG_ERR5","APP-MR0105 Principal Diagnosis not valid for sex"},
		{"MR_DRG_ERR6","APP-MR0106 Ungroupable due to age error"},
		{"MR_DRG_ERR7","APP-MR0107 Ungroupable due to sex error"},
		{"MR_DRG_ERR8","APP-MR0108 Ungroupable due to discharge type error"},
		{"MR_DRG_ERR9","APP-MR0109 Length of stay error"},
		{"MR_DRG_ERR10","APP-MR0110 Ungroupable due to admission weight error"},
		{"MR_DRG_INACT","APP-MR0111 Error occured during DRG process call. Please start the DRG Process."},
		{"MR_ATLEAST_PAT_CLASS","APP-MR0112 Atleast one Patient Class should be selected"},
		{"CHP_DEF_ERR","APP-MR0113 Chapter definition is not correct. Cannot proceed"},
		{"ENC_PEN_L1","APP-MR0114 This encounter is pending for Level 1 user.Do you want to proceed."},
		{"ENC_PEN_L2","APP-MR0115 This encounter is pending for Level 2 user.Do you want to proceed."},
		{"DIAG_PROC_REC_NO","APP-MR0116 Recode Privilege not defined .Cannot proceed."},
		{"PRI_DIAG_ERR","APP-MR0117 More than one diagnosis cannot be classified as primary"},
		{"NIL_PRI_DIAG","APP-MR0118 Primary Diagnosis not specified for the encounter"},
		{"MRK_ERR_CHK","APP-MR0119 Codes in Review Status cannot be marked error"},
		{"MR_ACT_DIAG_PROC_MRK_ERR","APP-MR0120 $  $ Cannot be marked error. $  $  is active."},
		{"MR_SELECT_ONE_FTR_CODE","APP-MR0121 Atleast one Related factor/Defining Characteristics must be selected."},
		{"SINCE_DT_BT_DOB_AND_CURR","APP-MR0122 Since date should be between date of birth and current date"},
		{"SLCT_OT_NONOT_PROC","APP-MR0123 Please select either OT Procedure or Non OT Procedure."},
		{"MR_INVALID_PROC_CODE","APP-MR0124 Invalid Procedure Code"},
		{"REQ_REAL_TYPE_MANDATORY","APP-MR0125 Requestor Type or Relationship Type should be selected."},
		{"PBLM_ONSET_BEYOND_DIAG_ONSET","APP-MR0126 Onset Date of the Problem is beyond the Onset Date of the Diagnosis."},
		{"INVALID_INTEGER","APP-MR0127 Invalid Integer."},
		{"INVOKE_MAINTAIN_DEATH_REGISTER","APP-MR0128 Do you want to invoke Maintain Death Register"},
		{"CAUSE_OF_DEATH_MAND","APP-MR0129 Recording one cause of Death is mandatory."},
		{"PREGNANCY_DTLS_MAND","APP-MR0130 Recording Pregnance details is mandatory."},
		{"MR_PARAM_SETUP","APP-MR0131 You cannot add diagnosis as per MR parameter limit."},
		{"MR_PARAM_SETUP_NEW_DIAG","APP-MR0132 You cannot add new diagnosis as per MR parameter limit."},
		{"MDR_FINALIZED_DISCH_CANT_CANCEL","APP-MR0133 Death register is finalized.Discharge advice cannot be cancelled"},
		{"CLEAR_MDR_DTLS","APP-MR0134 Do you want to clear the details?"},
		{"PRINT_DEATH_CERT","APP-MR0135 Do you want to print Death Register Certificate"},
		{"MR_PARAM_NOT_DEFINED_MDR","APP-MR0136 MR Parameter is not defined for Maintain Death Register"},
		{"MR_MDR_NOT_APPLICABLE","APP-MR0137 Maintain Death Register is not applicable for this encounter."},
		{"MRDRG_IDL_TM","APP-MR0138 Request for DRG calculation is timed out. Please try again."},
		{"MRDRG_ERROR","APP-MR0139 No data retrieved from DRG."},
		{"MRDRG_INVOKE","APP-MR0140 Authorization Done. Invoking DRG. Please wait"},
		/*Added For MR Report SetUP 11/13/2009*/
		{"ORDER_SRLNO_CANNOT_BE_BLANK","APP-MR0141 Order Srl No Cannot be Blank"},
		/*Added On 12/28/2009 For SRR-CRF-303.1*/
		{"DATES_MUST_GR_EQUAL","APP-MR0142 $ should be Lesser than or equal to #"},
		{"DATE_BTWN_ENC_PERIOD_RANGE","APP-MR0143 $ should be with in the encounter period."},
		{"OT_PROC_CANNOT_CONFIRM","APP-MR0144  Cannot confirm as the check in and check out time should be entered."},
		{"ENC_ALREADY_MODIFIED","APP-MR0145 Same encounter has been modified by another user."},
		/*Added On 12/28/2009 For SRR-CRF-303.2*/
		{"PRIM_DIAG_NOT_APPLICABLE","APP-MR0146 Primary Diagnosis is not applicable for Dagger Independent Term Code."},
		{"RECODING_IN_PROGRESS","APP-MR0147 Recoding of the Diagnosis for the Patient is In Progress and the same will not be marked as error in the Recoding screen. Do you want to continue?"},
		{"DUP_SEQ_NO_NOT_ALLOWED","APP-MR0148 Duplicate sequence number not allowed"},
		{"CODE_NOT_SELECTABLE","APP-MR0149 Entered code is not Selectable"},
		{"PREVIOUS_REQ_NOT_PROCESSED","APP-MR0150 Previous Request was not processed, Recalculate DRG..."},
		{"RECORDING_SUPPRT_DIAG_NOT_ALLOWED","APP-MR0151 Entered Code is a Supporting Diagnosis. Cannot proceed."},
		{"PRIM_DIAGS_NOT_ALLOWED","APP-MR0152 More than One Primary Diagnosis is not allowed."},
		{"SEARCH_CRITERIA_BEYOND_6_MONTHS","APP-MR0153 Discharge period is beyond 6 months.Please select either Patient ID/Encounter ID/Specialty."},
		{"SEARCH_CRITERIA_BEYOND_2_YEARS","APP-MR0153 Discharge period is beyond 2 years.Please select either Patient ID/Encounter ID."},
		{"SPECIFY_3_CHARS_FOR_SEARCH","APP-MR0154 Please specify minimum 3 characters for search."},
		{"MANDATORY_FIELDS_FOR_SEARCH","APP-MR0155 Please select either Patient ID/Encounter ID/Specialty/Location."},
		{"CANNOT_MODIFY_PREV_ENC_DATA","APP-MR0156 Diagnosis is not linked to the current encounter.Cannot proceed..."},
		{"ONLY_TWENTY_SEL_ALLOWED","APP-MR0157 Only Twenty Selections are allowed"},
		{"REACTION_ALREADY_EXIST","APP-MR0158 The Selected Reaction(s) already exist for this Allergen"},
		/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
		{"DATE_RANGE_CAN_NOT_EXCEED","APP-MR0159 Date Range Should not Exceed MR Parameter Range"},
		//Maheshwaran K added for the SKR-CRF-0020 as on 10/07/2013
		{"DFLT_PRINCIPAL_CLASS_TYPE","APP-MR0160 Default Principal Classification Type already exists for this Term Set."},
		{"COUNT_CANNOT_LESS_TNAN_1","APP-MR0161 Count Cannot be Less Than 1"},
		{"OVER_LAP_ENC_ID","APP-MR0162 There is an overlapping treatment start date with encounter ID"}, //Added Senthil
		 //Added Senthil
/* ----end KDAH-CRF-0032---*/
		{"CHECK_LIST_INCOMPLETE","APP-MR0163 Check List is incomplete. Cannot mark application status as complete."},
		{"DIAGNOSIS_ALREADY_MAPPED","APP-MR0164 Diagnosis is already mapped with $"},
		{"SMRP_FILE_GENERATED","APP-MR0165 SMRP File Generated"},
		{"SMRP_FILE_NOT_GENERATED","APP-MR0166 SMRP File Not Created"},
		{"SMRP_FILE_PATH_NO_SPECIFY","APP-MR0167 Incorrect SMRP File Generation Path"},
		{"MISMATCH_PATIENT_ENCOUNTER","APP-MR0168 Mismatch of Patient ID with Encounter ID"},  // added by mujafar for ML-MMOH-CRF-0615
		{"ENTER_DATE_HOLIDAY","APP-MR0171 Entered Date is an Holiday"},// added by mujafarfor ML-MMOH-CRF-0704
		{"ALREADY_EXIST_REQTYPE","APP-MR00172 Requestor Type assocaited to Requestor. Cannot disable."}, //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
		{"REQ_TYPE_USER_RESTRICTION","APP-MR0173 User does not have access to 'Requestor Type' setup."}, //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
		{"CHK_LIST_MAX_REACHED","APP-MR0174 Cannot select more than 10 checklist"}, // Added by mujafar for ML-MMOH-CRF-0762
		{"CHK_LIST_NOT_DEFINED","APP-MR0175 Checklist not defined, cannot proceed."}, // Added by mujafar for ML-MMOH-CRF-0762
		{"SEL_DESC_MANDATORY","APP-MR0176 Atleast one Description should be entered."}, // Added by mujafar for ML-MMOH-CRF-1281
		{"TERM_CODE_NOT_ACTIVE","APP-MR0177 Term code is not active. Cannot proceed."}, //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		{"SPL_NOT_COFIGURED","APP-MR0178 Specialty # disabled / not mapped for Medical Records."},
		{"BATCH_ID_REACHED_MAX","APP-MR0179 Batch ID has reached the maximum value"},
		{"CLINIC_ALRDY_MAPPED","APP-MR0180 Selected Clinic is already mapped with Service #"}, //Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351
		{"CHK_LIST_MAX_REACH_REQUEST","APP-MR0181 Cannot select more than 25 checklist"},//Added by Kamatchi S ML-MMOH-CRF-1464
		{"PRIMARY_DIAG_NOT_RECORDED","APP-MR0182 Primary Diagnosis is not recorded. Cannot proceed further to record secondary diagnosis. Please record primary diagnosis"},//Added by Maheshwaran K for MMS-DM-CRF-0197.1
		//Added by Santhosh for ML-MMOH-CRF-1959
		{"FOURTEEN_DAYS_VALIDATION","APP-MR0183 Date Range cannot be greater than 14 Days"},
		{"DISCHARGE_DATE_NOT_BLANK","APP-MR0184 Discharge Period Date cannot be empty"},
		{"ENCOUNTER_TYPE_NOT_BLANK","APP-MR0185 Encounter Type Cannot be empty"},
		//END
		{"ONE_MONTH","one month"}//Added by Lakshmanan P for ML-MMOH-CRF-2030
	};			
}		
