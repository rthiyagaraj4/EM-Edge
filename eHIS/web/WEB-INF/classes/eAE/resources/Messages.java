package eAE.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	final Object[][] contents = { 		
		{"AE_VISIT_REG_COMPLETE","APP-AE0001 Visit Registration completed successfully with Encounter ID as "},
		{"NO_OF_HRS_1_T0_23","APP-AE0002 No. of hours should be in the range 1 - 23"},
		{"MAX_DAYS_FOR_REV_VISIT","APP-AE0003 Max number of days allowed for revising visit should be greater or equal to 1"},
		{"GYNAE_AGE_LIMIT","APP-AE0004 Minimum age for capturing gynaec detail should be greater than 12"},
		{"PAEDIATRIC_MAX_AGE","APP-AE0005 Maximum age for capturing pediatric details should be less than or equal to 15"},
		{"CUT_OFF_MAX_HRS","APP-AE0006 Cut off period for including previous day visits should not be greater than 12"},
		{"AE_INVALID_ENCOUNTER_ID","APP-AE0007 Invalid Encounter ID"},
		{"AE_INVALID_MRN","APP-AE0008 Invalid File Number"},
		{"AE_PAT_MRN_ENC_BLANK","APP-AE0009 Specify any one of Patient ID / File Number / Encounter ID criteria"},
		{"AE_BLANK_LOCATION","APP-AE0010 Location cannot be blank"},
		{"AE_VISIT_PARAM_DATE_TIME","APP-AE0011 Visit date time should be greater than AE parameter setup date time and less then System date time"},
		{"AE_ALREADY_VISIT_LOCN","APP-AE0012 This patient has already visited the Location"},
		{"AE_TRIAGE_START_DATE_TIME","APP-AE0013 Start date time should be greater than Visit date time and less than System date time"},
		{"AE_TRIAGE_END_DATE_TIME","APP-AE0014 End date time should be greater than Start date time and less then System date time"},
		{"AE_VISIT_REG_INCOMPLETE","APP-AE0015 Visit Registration Incomplete ...."},
		{"AE_MULTI_OPER_STN_FOR_USER","APP-AE0016 Having more than one Operator station access.. cannot proceed"},
		{"AE_NO_CLINICS_FOR_USER","APP-AE0017 Location is not defined for Operator Station"},
		{"AE_NO_OPER_STN_FOR_USER","APP-AE0018 Operator station is not defined for this user"},
		{"AE_MANAGEQ_NOT_ALL_OPERSTN","APP-AE0019 Manage Patient Queue is not allowed for Operator Station"},
		{"CHECKOUT_NOT_ALL_OPERSTN","APP-AE0020 Check Out is not allowed for Operator Station"},
		{"AE_REG_ATTN_NOT_ALL_OPERSTN","APP-AE0021 Register Attandance is not allowed for Operator Station"},
		{"AE_SUSPENDED_NOT_ALLOWED","APP-AE0022 Patient is suspended.. cannot proceed"},
		{"AE_DECEASED_NOT_ALLOWED","APP-AE0023 Patient is deceased.. cannot proceed"},
		{"AE_REVISIT_NOT_ALL_OPERSTN","APP-AE0024 Revise Visit is not allowed for Operator Station"},
		{"AE_TMT_AREA_BLANK","APP-AE0025 Treatment area cannot be blank"},
		{"AE_LOCATION_BLANK","APP-AE0026 Location cannot be blank"},
		{"AE_PRACTITIONER_BLANK","APP-AE0027 Practitioner cannot be blank"},
		{"AE_VISIT_DATE_TIME_CK1","APP-AE0028 Visit date time should be greater than AE parameter/Patient Registration date time"},
		{"AE_VISIT_DATE_TIME_CK2","APP-AE0029 Visit date time should be less than system date time"},
		{"AE_PARAM_NOT_FOUND","APP-AE0030 AE Parameter is not set up for the facility"},
		{"AE_INACTIVE_PATIENT","APP-AE0031 Patient is inactive.."},
		{"AE_NUR_PHY_BLANK","APP-AE0032 Either Nurse or Physician is mandatory"},
		{"AE_NO_LOC_FOR_SEL_AGE_SEX","APP-AE0033 No Location for the selected patients gender/age"},
		{"AE_LMP_DATE_CHECK","APP-AE0034 LMP date cannot be greater than system date"},
		{"AE_ANY_ONE_NEEDED","APP-AE0035 Any one of the assessment detail should be entered"},
		{"AE_EXAM_DATE_TIME_C1","APP-AE0036 Exam date time should be greater than or equal to assign treatment area date time"},
		{"AE_EXAM_DATE_TIME_C2","APP-AE0037 Exam date time should be less than or equal to system date time"},
		{"AE_ASSIGN_DATE_TIME_C1","APP-AE0038 Date time should be greater than or equal to Visit date time"},
		{"AE_ASSIGN_DATE_TIME_C2","APP-AE0039 Date time should be less than or equal to system date time"},
		{"AE_ASSESSMENT_DATE_TIME_C2","APP-AE0040 Assessment date time should be less than or equal to system date time"},
		{"AE_ASSESSMENT_DATE_TIME_C1","APP-AE0041 Assessment date time should be greater than or equal to assign treatment area date time"},
		{"AE_NUMBER_ZERO","APP-AE0042 Number should be greater than zero"},
		{"AE_EMER_DEAD_PATIENT","APP-AE0043 A & E Details cannot be entered for Emergency Brought Dead Patient"},
		{"AE_ASSIGN_TMT_AREA","APP-AE0044 Do you want to Assign Bed/Treatment Area ? "},
		{"PAT_DECEASED_CONTINUE","APP-AE0045 Patient is Deceased... Do you want to Continue? "},
		{"PAT_SUSPENDED_CONTINUE","APP-AE0046 Patient is Suspended... Do you want to Continue? "},
		{"PAT_INACTIVATED_CONTINUE","APP-AE0047 Patient is Inactivated... Do you want to Continue? "},
		{"VACC_DATE_LE_CURRDATE","APP-AE0048 Vaccination Date should be less than or equal to current date"},
		{"DIAG_NOT_REC_CHKOUT_NOT_ALLWD","APP-AE0049 Diagnosis Not Recorded. Patient Cannot be Checked Out"},
		{"OPEN_VST_STATUS_FOR_AE_CLINIC","APP-AE0050 Patient already has a open visit. Cannot Proceed"},
		{"REV_DATE_LESS_AE_PARAM","APP-AE0051 Cannot Revise Attendance details for a visit lesser than the days specified in the AE Parameter"},
		{"NOTES_NOT_REC_CHKOUT_NOT_ALLWD","APP-AE0052 Notes Not Recorded. Patient Cannot be Checked Out"},
		{"ANY_ONE_VALUE_ENTERED","APP-AE0053 No of Patients should be entered"},
		{"DATE_NOT_LESS_THIRY_ONE","APP-AE0054 Days should be less than or equal to 30"},
		{"SPARE_BAY_CANT_BE_ASGNED","APP-AE0055 Pseudo Bed/Bay cannot be assigned as Normal Bed/Bays are Free."},
		{"SELECT_ONE_PATIENT_ID","APP-AE0056 Only one patient can be selected at a time"},
		{"PREG_DATE_GT_DOB","APP-AE0057 Pregnant Date should be greater than Date of Birth"},
		{"NOT_UNKNOWN_PATIENT","APP-AE0058 Patient Registered as Unknown only can be Selected/Entered"},
		{"NOT_KNOWN_PATIENT","APP-AE0059 Patient Registered as Unknown cannot be Selected/Entered"},
		{"PROCESS_SUBMITTED","APP-AE0060 Process is submitted as a Job"},
		{"LMP_DATE_GT_DOB","APP-AE0061 LMP Date should be greater than Date of Birth"},
		{"START_DT_LE_CURR_DT","APP-AE0062 Start Date time should be less than or equal to Current date time"},
		{"REFRESH_INTVL_CHK","APP-AE0063 Refresh interval should be in between 5 and 9999"},
		{"AE_CHECKED_OUT","APP-AE0064 Patient is already checked out"},
		{"AE_PAT_ENC_BLANK","APP-AE0065 Specify any one of Patient ID / Encounter ID criteria"},
		{"BED_OCCUPIED","APP-AE0066 Bed is already Occupied by another patient.  "},
		{"INVALID_BED","APP-AE0067 Invalid Bed "},
		{"BED_RESERVED","APP-AE0068 Bed is already Reserved"},
		{"RES_UNTIL_LESS_SYSDATE","APP-AE0069 Reserve until Date and Time should not be less than System Date and Time"},
		{"PRACT_IS_NOT_WORKING","APP-AE0070 Practitioner Not Working for the Day"},
		{"SCORE_CANNOT_REPE","APP-AE0071 $ Score cannot be repeated"},
		{"PAT_ID_ENC_ID_GENERATED","APP-AE0072 Patient ID generated From ! To @ With Encounter ID From # To $"},
		{"PAT_ID_GENERATED","APP-AE0073 Patient ID generated From ! To @"},
		{"NO_BED_FOR_CRITERIA","APP-AE0074 Beds Not Available for the Specified Criteria"},
		{"BED_RESERVN_FAILED","APP-AE0075 Bed Reservation has failed"},
		{"CANT_ASSIGN_TRMT_AREA","APP-AE0076 This Patient cannot be assigned to this Treatment Area"},
		{"ATTEND_DATE_GT_CURR","APP-AE0077 $ Attendance Date should not be greater than current Date."},
		{"DATE_GT_CURR","APP-AE0078 $ Date should not be greater than current Date."},
		{"DISPOSI_DATE_GT_CURR","APP-AE0079 $ Disposition Date should not be greater than current Date."},
		{"DECEASE_DATE_GT_CURR","APP-AE0080 $ Deceased Date should not be greater than current Date."},
		{"ASSIGN_BED_YN","APP-AE0081 Do you want to assign bed $ to Patient"},
		{"PATSEEN_DATE_GT_CURR","APP-AE0082 $ Patients Seen Date/Time should not be greater than current Date/Time."},
		{"PREG_DT_GT_SYSDATE_AND_DOB","APP-AE0083 Pregnant Date should not be greater than System Date and should not be lesser than Date of Birth"},
		{"VISIT_DATE_GT_CURR","APP-AE0084 $ Visit Date should not be greater than current Date."},
		{"AE_DISASTER_LIMIT","APP-AE0085 The total number of patients cannot exceed more than 50 at one point of time. If more patients are to be registered, please perform once again!!!"},
		{"CHG_FIN_DTLS_AE","APP-AE0086 Location/Registration Type/Visit Date Time is changed. Check the financial details again."},
		{"REG_ATTEN_NOT_ALLOWED_FOR_CURR_INPAT","APP-AE0087 Register Attendance is not allowed for Current Inpatient"},
		{"NO_AE_USER_RIGHTS","APP-AE0088 The User does not have Access to this Function...Cannot Proceed"},
		{"PAT_ID_ENC_ID_GENERATED1","APP-AE0089 Patient ID generated ! With Encounter ID $"},
		{"PAT_ID_GENERATED1","APP-AE0090 Patient ID ! generated "},
		{"NEW_PAT_ID_CANNOT_BLANK","APP-AE0091 New Patient ID cannot be blank "},
		{"BOTH_PAT_ID_CANNOT_BLANK","APP-AE0092 Existing Patient ID and New Patient ID, both cannot be blank "},
		{"AE_PARAM_DEFAULT_AGE_VAL","APP-AE0093 Default Unknown Adult Age in AE Parameter should be greater than Pediatric Age"},
		{"PRACT_ASSIGNED_CANNOT_CANCEL","APP-AE0094 Practitioner Assigned / Consultation In Progress. Cannot Cancel the Attendance "},
		{"CONSULT_INPROGRESS_CANNOT_CANCEL","APP-AE0095 Consultation In Progress. Cannot Cancel the Attendance "},
		{"SECONDARY_TRIAGE_CANNOT_CANCEL","APP-AE0096 Secondary Triage recorded. Cannot Cancel the Attendance "},
		{"CANNOT_CANCEL_VISIT_LESSER","APP-AE0097 Cannot Cancel Attendance  for a visit lesser than the days specified in the AE Parameter "},
		{"VISIT_ALRDY_REGISTERED","APP-AE0098 This Patient is already having an encounter registered as BID/Deceased. Cannot Proceed "},
		{"ENC_ALREADY_MODIFIED","APP-AE0099 Same encounter has been modified by another user."},
		{"PRACT_ALREADY_CAPTURED","APP-AE0100 Practitioner field cannot be blank since it was captured already."}, //Added CRF AAKH-CRF-0010 [IN:038535]
		{"START_NOT_EQUAL_END","APP-AE0101 Start and End number should not be the same"},
		{"RESOUCE_NOT_ALLOWED","APP-AE0102 Only one resource can be marked for contact display"},
		{"NOT_VALID","APP-AE0103 Apply is not a valid operation here"},
		{"AE_AMB_ENDMETER","APP-AE0104 End Meter Should Be Greater Than Start Meter"},
		{"AE_AMB_PRDTYPEBLANK","APP-AE0105 Period Type Can Not Be Blank"},
		{"AE_AMB_DATE","APP-AE0106 Not a Valid Date"},
		{"AE_AMB_NUMBER","APP-AE0107 Not a Valid Number"},
		{"AE_ID_ALREADY_EXISTS","APP-AE0108 ID Already Exists"},
		{"AE_AMB_VALID_PERIOD","APP-AE0109 Not a Valid Number"},
		{"AE_AMB_START_NUM_LS_END_NUM","APP-AE0110 Start number must be less than End number."},
		{"AE_AMB_END_NUM_GT_START_NUM","APP-AE0111 End number must be greater than Start number."},
		{"AE_AMB_START_NUM_GT_ZERO","APP-AE0112 Starting Number should be greater than zero."},
		{"AE_AMB_NOT_MORE_THAN_TWO_THOUSAND","APP-AE0113 You  are not allowed to enter more than 2000 characters"},
		{"AE_AMB_NOT_MORE_THAN_FIVE_HUND","APP-AE0114 You  are not allowed to enter more than 500 characters"},
		{"AE_AMB_BLANK_AMBULANCE","APP-AE0115 Ambulance cannot be Blank"},
		{"AE_AMB_VALID_AGE","APP-AE0116 Please Enter A Valid Age"},
		{"TO_DT_GR_FM_DT","APP-0117 To Date should be Greater than From Date."},
		{"SPACE_NOT_ALLOWED","APP-0118 Space is not allowed for ID"},
		{"ETR_NAME_N_DES","APP-0119 Please enter Name and Description."},
		{"RE_ATT_WITH_IN_HRS","APP-0120 The value must be between 24 and 99 Hours."}, //Added for this CRF ML-MMOH-CRF-0639
		/*Added by Thamizh selvi on 20th Oct 2017 against ML-MMOH-CRF-0623 Start*/
		{"AE_PARAM_CONS_DATE_TIME","APP-AE0121 Consultation date/time should not be less than $ as defined in AE parameter."},
		{"ASSIGN_TRMT_AREA_CONS_DATE_TIME","APP-AE0122 Consultation date/time should not be less than Assigned to Treatment Area date/time."},
		{"BACK_DATE_CONS","APP-AE0123 Consultation date/time cannot be same as Current date/time since Backdate Consultation is checked."},
		/*End*/
		/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
		{"AFTR_DATE_TIME_VALD","APP-AE0125 After Date and Time cannot be lesser than Current Date and Time."},
		/*Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001*/
		{"BED_OCCUPD_RESRVD","APP-AE0126 Bed is Occupied/Reserved. Cannot disable it."},
		{"BED_DISABLED","APP-AE0129 Bed is disabled"},
		/*Added by Shanmukh on 2nd-APR-2018 for ML-MMOH-CRF-0656*/
		{"AE_SEC_TRG_DATE","APP-AE0127 Triage Date/Time cannot be Less than or equal to Primarily Secondary Triage Date/Time"},
		{"AE_SEC_TRG_DATE_SYS","APP-AE0128 Secondary Triage Date/Time cannot be greater than to System Date/Time"},
		{"AE_SEC_TRG_DATE_EXISTS","APP-AE0129 Triage date/Time already Exist cannot Proceed"},
		/*End*/
		{"CONFIRM_PENDING_ADMISSION","APP-AE0130 Do you want to confirm IP Admission for this patient?"},//Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658
		{"DT_TM_NOT_LESS_THN_REG_ATTN","APP-AE0131 Date/Time cannot be lesser than Register Attendance Date/Time"},//Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133
		{"PRIORITY_ZONE_ALREADY_AVAIL","APP-AE0132 Patient already available for the priority zone. Cannot disable"},//Added by Shanmukh on 17th-SEPT-2018 for MMS-DM-CRF-0147
		{"PROCEED_CHECKOUT","APP-AE0133 Do you wish to proceed with AE Checkout ?"},
		{"PRIO_ZONE_DIS_CANNOT_PROCEED","APP-AE0134 Priority Zone is disabled, cannot proceed further. Please contact System Administrator"},//Added by Shanmukh on 10th-OCT-2018 for MMS-DM-CRF-0147
		{"REG_FOLLOWUP_WITH_IN_HRS","APP-0134 The value must be between 01 and 99 Hours."}, // Added by mujafar for KDAH-CRF-0526
		{"CASE_OF_TRAUMA_YN","APP-0135 Do you want to proceed as Case of Trauma?"},//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		{"MLC_CAPTURE_DATE_CANNOT_FUTURE","APP-0136 Date of MLC Capture should not be Future Date & Time"},//Added by Ajay Hatwate for GHL-CRF-0650
		{"FOR_ADMISSION","APP-0137 This Patient is marked as For Admission. Do you want to continue?"},//Added by Kamatchi S for ML-MMOH-CRF-1972  
		{"MAND_CANT_BLNK","APP-0138 Mandatory field cannot be blank"},//Added by lakshmanan for ML-MMOH-CRF-1972 on 12-07-2023
		{"CASE_TYPE_PARAM_NOT_CHECK","APP-0139 This function is not applicable because Case Type in AE Parameter is not checked."},//Added by Ajay Hatwate for ML-MMOH-CRF-1653 
		{"PAT_ID_EXIST_IN_JOB_QUEUE","APP-0140 Patient ID Exist in Job Queue"},//Added by Ashwini on 16-Jan-2024 for MOHE-SCF-0305
		{"DISASTER_CATEGORIZAION_NOT_ENABLE","APP-0141 Disaster categorization is not enabled in AE parameter."},//Added by Ajay Hatwate on 16-04-2024 for ML-MMOH-CRF-2111
		{"MAX_QUEUENUM_CANT_BLANK","APP-0142 Maximum Number of Digits allowed for Queue Number Cannot be Blank."},//Added by Santhosh for ML-MMOH-CRF-2069 
		{"MIN_VALUE_1","APP-0143 Minimum value allowed is 1"},//Added by Santhosh for ML-MMOH-CRF-2069
		{"MAX_VALUE_15","APP-0144 Maximum value allowed is 15"},//Added by Santhosh for ML-MMOH-CRF-2069
		{"APP_PRIORITY_ZONE_CANTBE_BLANK","APP-0145 Applicable Priority Zone Cannot be Blank"},//Added by Santhosh for ML-MMOH-CRF-2069
		{"QUEUE_NO_DUPLICATE","APP-0146 Queue Number is already assigned to another patient"},//Added by Santhosh for ML-MMOH-CRF-2069
		{"MAX_QUEUE_DIGIT_ALLOWED","APP-0147 Maximum Number of Digits allowed for Queue Number is $"}//Added by Ajay for ML-MMOH-CRF-2069
	};			
}		  
