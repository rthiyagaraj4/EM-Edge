/*******************************************************************************
 * Copyright 1999-2015, 	Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, 	or any portion of it, 	
 * may result in severe civil and criminal penalties, 	and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------------------------------------------
?             100            ?           	created
											
04/12/2012	IN035961		Vijayakumar K	Issue: When we Click on ‘Search’ button we get exception error.
04/03/2013	IN037676		Dinesh T		Signing the addendum is controlled by the note type parameter 
15/03/2013  IN038579		Nijitha         CRF-CA-CHL-CRF-0006/05-Redefine summary Component-> System is displaying error message 	even after entering data for User Defined description.
30/09/2013	IN043577		Vijayakumar K		Alpha-CA-by entering special Characters at Hint message in Section template getting Internal Server Error
06/06/2014	IN037701		Chowminya		 SKR-CRF-0036
01/10/2014  IN051373		Chowminya       Patient List By PPR Relationship Issue 
12/04/2015	IN048704	 	Nijitha S		HSA-CRF-0175
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G								In Clinical note there should be an option to auto fetch/Copy data from same template 
																	if filled up earlier for same patient in template format.
21/12/2015	IN058155		Krishna Gowtham J 						 Limit on chart section - 99 rows only allowed								
10/01/2017	IN062564		Raja S			12/01/2017	Ramesh G	MO-GN-5511
27/06/2017	IN064566		Raja S			27/06/2017	Ramesh G	PMG2017-GHL-CRF-0005
13/07/2016	IN061885		Krishna Gowtham	13/07/2017	Ramesh G		ML-MMOH-CRF-0537
27/07/2017	IN061891		Raja S			27/07/2017		Ramesh G		ML-MMOH-CRF-0543
05/12/2017	IN065683		Ramesh G										Vaccination Schedule getting automatically generated
06/11/2017	IN065070		Raja S			02/11/2017		Ramesh G		ML-MMOH-CRF-0623.1
23/11/2017	IN061897		Raja S			23/11/2017		Ramesh G		ML-MMOH-CRF-0549
05/12/2017	IN065683		Ramesh G										Vaccination Schedule getting automatically generated 																			on opening patient chart in CA		
22/01/2018	IN063931		Prakash C	   23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)
22/01/2018  IN062606        Sharanraj         01/02/2018              Ramesh G        ML-MMOH-CRF-0726
07/02/2018  IN061886		Kamalakannan G  07/02/2018  Ramesh G 		ML-MMOH-CRF-0538 		
12/02/2018  IN066647        Sharanraj       13/02/2018  Ramesh G        CA-ML-MMOH-CRF-0726/05																	on opening patient chart in CA		
09/02/2018  IN065910        Sharanraj                   Ramesh G        GHL-CRF-0494
10/05/2018 IN065341             Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
11/05/2018	IN063838		Ramesh G									ML-MMOH-CRF-0813																			on opening patient chart in CA		
22/05/2018	IN067607		Raja S			22/05/2018	Ramesh G		ML-MMOH-CRF-1130.2
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
07/08/2018	IN063818		Raja S			07/08/2018	Ramesh G		MMS-DM-CRF-0102
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2	
25/01/2019		IN057997	Kamalakannan G	  25/01/2019				Ramesh G.		AAKH-CRF-0079
06/04/2020	IN072674		Durga Natarajan		07/04/2020		Ramesh G		MMS-KH-CRF-0032
19/05/2020	IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
31/05/2021  IN017999        Chandrashekar A                                AAKH-CRF-0132.1
03/02/2022  IN27710        Suji Keerthi G    03/02/2022   RAMESH G         GHL-CRF-0658
07/09/2023	   41654			Twinkle Shah		Ramesh Goli                   MMS-JU-CRF-0015.4	
10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
18/10/2023     32902       Krishna Pranay    19/10/2023      Ramesh G    MMS-DM-CRF-0210	

--------------------------------------------------------------------------------------------------------------
*/ 
package eCA.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents()
	{
         return contents;
    }

	static final Object[][] contents =
	{
	{"INVALID_DIAG_DATE"			, 	"APP-CA0001 Diagnosis date Should be between Admission date and Discharge Date/System date " },
	{"CLOSED_CONSULTATION"			, 	"APP-CA0002 For this patient consultation is already over" },
	{"UPDATION_PERIOD_EXPIRED"		, 	"APP-CA0003 Cannot update details after allowable period" },
	{"AUTHORIZE"					, 	"APP-CA0005 Not authorized to add sensitive diagnosis which requires authorization" },
	{"NOTEGROUP_NOTETYPE"			,	"APP-000005 Note Group/Note Type for the symbol group Cannot be Blank."}, 	 //added for CA SYMBOL Group warning message IN041021
	{"INVALID_BLOCK_DATE"			, 	"APP-CA0006 Block Until Datetime should be greater than or equal to discharge date" },
	{"DEFINE_MR_PARAM"				, 	"APP-CA0007 MR Parameters not defined. Define and Proceed" },
	{"ONDATE_GREATER_VISIT_DATE"	, 	"APP-CA0008 To come back On Date should be greater than or equal to Visit date" },
	{"DECEASED_ONLY"				, 	"APP-CA0009 This Note is applicable only for deceased patients" },
	{"FITDATE_GREATER_VISIT_DATE"	, 	"APP-CA0010 Fit for Duty Date should be greater than or equal to Visit date" },
	{"OP_PARAM_NOT_FOUND"			, 	"APP-CA0011 Fatal Error! OP Parameter Record not found - set up and continue" },
	{"INVALID_FROM_PAST_VISIT_DATE"	, 	"APP-CA0012 Past Visit Date Should be within the allowable limit" },
	{"INVALID_FROM_DISCHARGE_DATE"	, 	"APP-CA0013 From Date Should be within the allowable limit" },
	{"EITHER_ONE_APPT_TYPE_MUST"	, 	"APP-CA0014 Atlease One Appointment Type should be selected before search" },
	{"DIS_ADV_NOT_EXISTS"			, 	"APP-CA0015 Discharge advice not yet prepared for this admission" },
	{"ONE_DIS_SUMM_ONLY"			, 	"APP-CA0016 Discharge summary already prepared for this admission" },
	{"ONE_EPSD_SUMM_ONLY"			, 	"APP-CA0017 Episode summary already prepared for this visit" },
	{"FORWARD_NOT_NULL"				, 	"APP-CA0018 Forward To cannot be null" },
	{"NO_DECIMAL"					, 	"APP-CA0019 Decimal Value is not allowed" },
	{"INVALID_PRECISION"			, 	"APP-CA0020 Invalid Precision" },
	{"MINIMUM_DIGITS"				, 	"APP-CA0021 Minimum number of digits for $ must be " },
	{"MAXIMUM_DIGITS"				, 	"APP-CA0022 Maximum number of digits the value can have " },
	{"INVALID_ON_DATE"				, 	"APP-CA0023 On Date should be greater than or equal to System Date " },
	{"INVALID_DATE_FMT"				, 	"APP-CA0024 Invalid Date Format [Date Format: DD/MM/YYYY]" },
	{"INVALID_TIME_FMT"				, 	"APP-CA0025 Invalid Time Format [Time Format: hh:mm]" },
	{"INVALID_DATE_TIME"			, 	"APP-CA0026 Invalid date time format [Date/Time Format: DD/MM/YYYY hh:mm]" },
	{"MORE_THAN_ONE_NOT_ALLOWED"	, 	"APP-CA0029 More than one Note type is not allowed for this Class"},
	{"OP_NOTE_TYPE_NOT_EXISTS"		, 	"APP-CA0030 Default Episode Summary Note Type doesnot exits! Contact your Admin"},
	{"IP_NOTE_TYPE_NOT_EXISTS"		, 	"APP-CA0031 Default Discharge Summary Note Type doesnot exits! Contact your Admin"},
	{"RL_NOTE_TYPE_NOT_EXISTS"		, 	"APP-CA0032 Referral letter Note Type not set up. Contact your Administrator"},
	{"MORE_THAN_TWO_NOT_ALLOWED"	, 	"APP-CA0033 More than two Note type is not allowed for this Class"},
	{"MORE_THAN_FOUR_NOT_ALLOWED"	, 	"APP-CA0034 More than Four Note type is not allowed for this Class"},
	{"DIAG_AUTH_REQD"				, 	"APP-CA0035 Sorry You don't have the previlege to choose sensitive diagnosis"},
	{"CA_HIGH_RISK_PREV"			, 	"APP-CA0036 Sorry You don't have the previlege to view high risk condition"},
	{"CA_DIAG_PROCEDURE"			, 	"APP-CA0037 You cannot access this function beyond the limit specified in IP/OP parameter"},
	{"CA_SEC_FORMULA_VAL"			, 	"APP-CA0038 Enter Value"},
	{"MORE_ROW_VALUE_NOT_ALLOWED"	, 	"APP-CA0039 Row Position Should be with in the Limit"},
	{"MORE_COL_VALUE_NOT_ALLOWED"	, 	"APP-CA0040 Column Position Should be with in the Limit (1 to 3)"},
	{"MORE_ROW_SPAN_NOT_ALLOWED"	, 	"APP-CA0041 Row Span Should be with in the Limit"},
	{"MORE_COL_SPAN_NOT_ALLOWED"	, 	"APP-CA0042 Column Span Should be with in the Limit (1 to 3)"},
	{"CANT_LOCATE_POSISTION"		, 	"APP-CA0043 Can't able to Locate Position"},
	{"ROW_SPAN_NOT_BLANK"			, 	"APP-CA0044 Row Span should not be blank"},
	{"COL_SPAN_NOT_BLANK"			, 	"APP-CA0045 Column Span should not be blank"},
	{"COL_POS_NOT_BLANK"			, 	"APP-CA0047 Column Position should not be blank"},
	{"SUMMARY_NOT_BLANK"			, 	"APP-CA0048 Summary descrption cannot be blank"},
	{"WRONG_ROW_COLUMN_VALUES"		, 	"APP-CA0049 Wrong Values for Row Column Position"},
	{"VALUE_NOT_GREATER_THAN_9"		, 	"APP-CA0050 Value should not greater than 9"},
	{"ROWCOL_POS_SPAN_NOT_BLANK"	, 	"APP-CA0051 Row Column Position Values Should Not be Blank"},
	{"DTL_DFN_INCOMP"				, 	"APP-CA0052 Details Definition is Incomplete"},
	{"HOME_PAGE_PRACT_TYPE"			, 	"APP-CA0053 Practitioner Type is mandatory"},
	{"ROWS_COLUMS_EMPTY"			, 	"APP-CA0054 Rows or Columns cannot be Empty or Zero"},
	{"NOTE_ALREADY_EXISTS"			, 	"APP-CA0055 Chief Complaint Section already selected for this Note"},
	{"START_GR_EQ_VISIT"			, 	"APP-CA0056 Start Date Should be Greater than or Equal to VisitDate"},
	{"SEQUENCE_NOT_ZERO"			, 	"APP-CA0058 Sequence Number Cannot be Zero or Negative Integer or Blank"},
	{"SECTION_NOT_BLANK"			, 	"APP-CA0059 Section cannot be blank"},
	{"POSITIVE_NUMBER_ALLOWED"		, 	"APP-CA0060 Only Positive number is allowed"},
	{"PRACTITIONER_CANNOT_BE_BLANK"	, 	"APP-CA0061 Practitioner Type cannot be blank"},
	{"RECORD_CANNOT_DELETE"			, 	"APP-CA0062 Record cannot be Deleted"},
	{"BACKDATE_NOT_ZERO"			, 	"APP-CA0063 BackDate Cannot be Zero "},
	{"NO_SPECIAL_CHARACTER"			, 	"APP-CA0065 Backdate cannot have special characters"},
	{"ROW_COL_NOT_DEF"				, 	"APP-CA0066 Row Column Values Not Defined Properly"},
	{"ACTIVE_RELN_PRESENT"			, 	"APP-CA0067 There is an active Relationship with the patient"},
	{"IMAGE_ENTERED_WITH_EMPTY_NOTE", 	"APP-CA0068 Image Content has been edited but without its supporting text. \nClear Content And Proceed?"},
	{"CHART_CANNOT_BLANK"			, 	"APP-CA0069 Chart Cannot be Blank"},
	{"DUPLICATE_SEQUENCE_NUMBER"	, 	"APP-CA0070 Duplicate Sequence Number"},
	{"INVALID_TIME_HOUR"			, 	"APP-CA0072 Hour Entered is Invalid .It Should  between 0 and 23"},
	{"INVALID_TIME_MINUTE"			, 	"APP-CA0073 Minute Entered is Invalid .It Should  between 0 and 59"},
	{"CHART_COMPONENT_EXISTS"		, 	"APP-CA0074 Chart Component already Exists.Choose a Different Component"},
	{"CHECK_SEQUENCE_NUMBER"		, 	"APP-CA0075 Click the Check Box to Enable the Text to Enter the Order Sequence Number"},
	{"SUMMARY_TYPE_NOT_BLANK"		, 	"APP-CA0076 Summary Type Cannot Be Blank"},
	{"DISCRETE_MEASURE_NOT_BLANK"	, 	"APP-CA0077 Discrete Measure for the Selected Summary Type Cannot Be Blank"},
	{"SUMMARY_COLUMN_NOT_BLANK"		, 	"APP-CA0078 Summary Column Cannot Be Blank"},
	{"RECORD_TIME_EXISTS"			, 	"APP-CA0080 Records already exists for this time"},
	{"INVALID_DIAG_CODE_FOR_PATIENT", 	"APP-CA0081 The Diagnosis Code entered is not applicable to this patient" },
	{"NO_GRAPH_SELECTED"			, 	"APP-CA0082 No chart events selected" },
	{"RECORD_TIME_NOT_BLANK"		, 	"APP-CA0083 Recording Date Time cannot be blank"},
	{"ATTEND_PRACT_NOT_ASSIGNED"	, 	"APP-CA0084 Attending practitioner not assigned. Cannot proceed" },
	{"DUPLICATE_SUMMARY_COLUMN"		, 	"APP-CA0085 Duplicate Summary Column" },
	{"INVALID_TIME_HOUR_GR"			, 	"APP-CA0086 Time Entered is greater than Current Time" },
	{"INPUT_GREATER_THAN_TABLE_TIME", 	"APP-CA0087 Time Entered is Less than all the Recorded Time" },
	{"CANCEL_CHARTING_TRANSACTION"	, 	"APP-CA0088 Please Choose a Chart From the List Box in Order to Continue with the Transaction" },
	{"REVERSE_SUMMARY_SELECTION"	, 	"APP-CA0089 This Action Will Clear All The Summary Values For This Chart... Do You Want to Continue?" },
	{"CHOOSE_AT_LEAST_ONE_ITEM"		, 	"APP-CA0090 Please Select at least One Item from the Item List" },
	{"VAL_NOT_BLANK"				, 	"APP-CA0091 Values cannot be blank" },
	{"FROM_DATE_GREATER_SYSDATE"	, 	"APP-CA0093 From Date Should Not Be Greater than Current Date"},
	{"SCOPE_NOT_ZERO"				, 	"APP-CA0094 Scope Cannot be Zero or Negative Integer"},
	{"DATE_TIME_NOT_BLANK"			, 	"APP-CA0095 Date Time Field Cannot be Blank"},
	{"PERFORMED_NOT_BLANK"			, 	"APP-CA0097 Practitoner Field Cannot be Blank"},
	{"REASON_NOT_BLANK"				, 	"APP-CA0098 Reason Field Cannot be Blank"},
	{"DATE_TIME_GREATER_SYSDATE"	, 	"APP-CA0099 Date Time Should Not Be Greater than Current Date"},
	{"TASK_NOT_BLANK"				, 	"APP-CA0100 Task Type Cannot be Blank"},
	{"TASK_TYPE_NOT_BLANK"			, 	"APP-CA0101 Task  Cannot be Blank"},
	{"INVALID_TIME_HOUR_LESS"		, 	"APP-CA0102 Time Entered is Less than Current Time" },
	{"SCOPE_GREATER_THAN_LIMIT"		, 	"APP-CA0103 Scope Value Entered Exceeds the Allowed Limit.Changing  to Max Limit " },
	{"ENCOUNTER_ID_INVALID"			, 	"APP-CA0104 Invalid Encounter Id " },
	{"LOCN_PATIENT_ENCTR_BLANK"		, 	"APP-CA0106 Enter atleast any one of Location or Patient Id or Encounter Id criteria " },
	{"NUM_ALLOWED"					, 	"APP-CA0107 Only numbers are allowed " },
	{"ONSET_DATE_GREATER_SYSDATE"	, 	"APP-CA0108 Onset Date cannot be greater than System Date " },
	{"DIAG_NOT_AVAILABLE"			, 	"APP-CA0109 Diagnosis Code not available " },
	{"DUP_COMP_WITH_ANAL"			, 	"APP-CA0111 You cannot have same component repeated with include for analysis " },
	{"PROC_ALREADY_EXISTS"			, 	"APP-CA0112 This Procedure already exists. Do you want to continue? " },
	{"ANAES_ALREADY_CHOSEN"			, 	"APP-CA0113 This Anaesthetist has already been chosen " },
	{"CLEAR_HIST_VALS"				, 	"APP-CA0114 This action will de-link the history elements. Do you want to continue?" },
	{"CLIN_EVENT_BLANK"				, 	"APP-CA0115 Clinical Event cannot be blank " },
	{"TIME_FRAME_VAL_BLANK"			, 	"APP-CA0116 Time Frame Value cannot be blank or Zero" },
	{"TIME_FRAME_UNIT_BLANK"		, 	"APP-CA0117 Time Frame Unit cannot be blank " },
	{"LINK_HIST_VAL_BLANK"			, 	"APP-CA0118 Link History Elements cannot be blank" },
	{"CLOSE_ALL_CHARTS"				, 	"APP-CA0120 One or more Patient Chart open - Please close before exiting" },
	{"NO_PATIENT_SELECTED"			, 	"APP-CA0121 No Patient Chart Opened currently to Switch " },
	{"NO_EVENTS_SELECTED"			, 	"APP-CA0122 Please select an event " },
	{"NO_OF_EVENTS_MORE_THAN_10"	, 	"APP-CA0123 More than 10 events not allowed " },
	{"URL_CHECK"					, 	"APP-CA0124 Contact Admin.There is no URL defined for the application" },
	{"INVALID_IMAGE"				, 	"APP-CA0125 Invalid FileName" },
	{"STARTDT_LESS_ENDDT"			, 	"APP-CA0126 Start Date should be less than or equal to End Date" },
	{"NO_DISCR_MSR"					, 	"APP-CA0128 There is no discrete element linked to the battery $$ to record." },
	{"NO_BATTERY"					, 	"APP-CA0129 Battery is not defined" },
	{"SPECIALITY_NOT_BLANK"			, 	"APP-CA0130 Speciality cannot be blank" },
	{"ATLEAT_ONE_VITAL_DATA_REQ"	, 	"APP-CA0131 Atleast one vital data should be entered"},
	{"VAL_NOT_ZERO"					, 	"APP-CA0132 Value cannot be zero"},
	{"VAL_NOT_MODIFIED"				, 	"APP-CA0133 Value is not modified"},
	{"ACTION_CLEARS_VALUES"			, 	"APP-CA0134 This action will clear all the values. Do u want to continue?"},
	{"ATLEAST_ONE_VAL"				, 	"APP-CA0135 Atleast one value has to be entered"},
	{"MIN_ROW_VAL"					, 	"APP-CA0136 Shifting can not be done beyond minimum allowable limit"},
	{"MAX_ROW_VAL"					, 	"APP-CA0137 Shifting can not be done beyond maximum allowable limit"},
	{"ASS_DIAG_UNIQUE_CHK"			, 	"APP-CA0138 Please enter a Unique Associate Code"},
	{"ASS_DIAG_IN_SUF_DATA"			, 	"APP-CA0139 Data entered was not sufficient"},
	{"CLEAR"						, 	"APP-CA0140 This Change will clear the Formula Definition"},
	{"FROM_TO_DATE_NOT_BLANK"		, 	"APP-CA0141 From and to dates cannot be blank"},
	{"FROM_DATE_NOT_BLANK"			, 	"APP-CA0142 From date cannot be blank"},
	{"TO_DATE_NOT_BLANK"			, 	"APP-CA0143 To date cannot be blank"},
	{"NO_GRAPH_EVENTS_MORE"			, 	"APP-CA0144 A single group cannot have more than 10 chart events"},
	{"NEWBORN_DISPLAY_CRITERIA"		, 	"APP-CA0145 Atleast one of the Display Criterias should be checked"},
	{"FUNC_NOT_APPLICABLE"			, 	"APP-CA0146 This function is not applicable"},
	{"FILE_NOT_SUPPORTED"			, 	"APP-CA0147 Selected file type is not supported in the current version. Please try with valid types"},
	{"FILE_SIZE_NOT_SUPPORTED"		, 	"APP-CA0148 Selected File Size exceeds the allowable limit. Please try with smaller file"},
	{"CONTRID"						, 	"APP-CA0149 Select the Contributing System"},
	{"RECORD_INSERTED"				, 	"APP-CA0150 Operation Completed Successfully" },
	{"DELETE_NOTE"					, 	"APP-CA0151 The Selected Note will be deleted....Confirm?" },
	{"LESS_THAN_BDAY_DATE"			, 	"APP-CA0152 Onset date cannot be prior to date of birth" },
	{"PRACT_SAME"					, 	"APP-CA0153 Same Practitioner Cannot be Selected Twice" },
	{"CHIEF_COMPL_NOT_ALLOWED"		, 	"APP-CA0154 Only one section can be marked for Chief Complaint"},
	{"INVALID_NOTES_DATE"			, 	"APP-CA0155 Notes Date/Time should be between Allowable Back dated date and Current Date" },
	{"ATLEAST_ONE_CHILD_MENU"		, 	"APP-CA0156 There should not be any menu item without a child item. Please correct and retry" },
	{"ALRGY_ALREADY_SELECTED"		, 	"APP-CA0157 This allergy description has already been chosen" },
	{"MIN_ONE_ITEM_SEL_REQ"			, 	"APP-CA0158 Atleast one item should be selected" },
	{"MIN_ONE_TASK_SEL_REQ"			, 	"APP-CA0159 Atleast one Task should be included" },
	{"DET_DEF_INCOMPLETE"			, 	"APP-CA0161 Details Definition Is Incomplete" },
	{"END_DATE_VALIDATION"			, 	"APP-CA0163 End Date should be less than or equal to Current Date" },
	{"END_TIME_LESS_START_TIME"		, 	"APP-CA0164 Ending Time Should Not Be Less than Starting Time" },
	{"END_TIME_MORE_SYS_TIME"		, 	"APP-CA0165 Ending Time Should Not Be More than System Time" },
	{"EVENT_CODE_NOT_BLANK"			, 	"APP-CA0166 Event Code cannot be blank" },
	{"EVENT_END_DATE_VALID"			, 	"APP-CA0167 Event End Date should be greater than or equal to Event Start Date" },
	{"EVENT_GROUP_NOT_BLANK"		, 	"APP-CA0168 Event Group cannot be blank" },
	{"EXP_INVALID"					, 	"APP-CA0169 Expression is Invalid" },
	{"FROM_DATE_GREAT_SYS"			, 	"APP-CA0170 From Date should be greater than or equal to Current Date" },
	{"FROM_DATE_GREAT_EFF"			, 	"APP-CA0171From Date should be greater than the Effective To date" },
	{"FROM_DATE_MORE_BIRTH"			, 	"APP-CA0172 From Date should be more than the birth date" },
	{"INVALID_MATRIX_COLUMN_VALUES"	, 	"APP-CA0176 Invalid Matrix Column Span values" },
	{"LAST_CHAR_NOT_NUMBER"			, 	"APP-CA0177 Last character cannot be a Numeric" },
	{"MABP_LESS_ICP"				, 	"APP-CA0178 MABP cannot be less than ICP" },
	{"MONTHS_VALIDATION"			, 	"APP-CA0179 Months cannot be greater than 11" },
	{"NO_USER_FOUND"				, 	"APP-CA0182 No user found" },
	{"NO_USERS_FOR_GROUP"			, 	"APP-CA0183 No users available for this group" },
	{"ONLY_NUMBER_ALLOWED"			, 	"APP-CA0184 Only number is allowed" },
	{"GRIDID_DESC_VALID"			, 	"APP-CA0187 Please input Grid ID and Short Description before defining" },
	{"MATRIXID_DESC_VALID"			, 	"APP-CA0188 Please input Matrix ID and Short Description before defining" },
	{"ENSURE_SELECTION"				, 	"APP-CA0189 Please Make a selection" },
	{"EVENTS_FOR_QUICKTEXT"			, 	"APP-CA0190 Please select the events to enter quick text" },
	{"SEL_RECORD_FOR_DELETION"		, 	"APP-CA0191 Please select the record to delete" },
	{"SELECT_PLEASE"				, 	"APP-CA0192	Please Select" },
	//{"NO_TABLE_RETURN_RECORDS"	, 	"APP-CA0193	Records returned in table format not allowed" },
	{"NO_TABLE_RETURN_RECORDS"		, 	"APP-CA0193 The selected records can be returned only to the free text editor." },
	{"REMARKS_CANNOT_BLANK"			, 	"APP-CA0194 Remarks cannot be blank" },
	{"ROW_CANNON_BLANK"				, 	"APP-CA0195 Row Position cannot be blank" },
	{"SELECT_ANY_VALUE"				, 	"APP-CA0196 Select Any Value" },
	{"AJAX_ERROR"					, 	"APP-CA0197 Sorry. There was an error" },
	{"STAR_DATE_LESS_END_DATE"		, 	"APP-CA0198 Starting Date Should Not Be Less than Ending Date" },
	{"START_TIME_LESS_END_TIME"		, 	"APP-CA0199 Starting Time Should Not Be More than Ending Time" },
	{"START_TIME_LESS_SYS_TIME"		, 	"APP-CA0200 Starting Time Should Not Be More than System Time" },
	{"PRACT_CHOSEN"					, 	"APP-CA0203 This Practitioner has already been chosen" },
	{"TO_DATE_LESS_EFF_DATE"		, 	"APP-CA0204 To Date should be lesser than the Effective To date" },
	{"VERIFY_OK"					, 	"APP-CA0206 Verification Successful" },
	{"ONLY_ONE_DEFAULT_IMAGE"		, 	"APP-CA0210 You are allowed to make only one image as the default" },
	{"NO_AUTH_SENSITIVE_DIAGNOSIS"	, 	"APP-CA0211 You are not an authorised user to view Sensitive Diagnosis details" },
	{"MAX_3LOOKUP"					, 	"APP-CA0212 You can have a maximum of three lookup windows" },
	{"MAX_2LOOKUP"					, 	"APP-CA0213 You can have a maximum of two lookup windows" },
	{"NO_DEFAULT_IMAGE"				, 	"APP-CA0214 You have not defaulted any image" },
	{"NO_IMAGE_ASSOCIATED"			, 	"APP-CA0215 You have not selected any images to be linked" },
	{"IMAGE_DEFAULT_SELECTION"		, 	"APP-CA0216 You have to select the image which has been defaulted" },
	{"ERR_IN_COMMITING"				, 	"APP-CA0217 Error While Commiting" },
	{"NO_IND_NUR_RELATIONSHIP"		, 	"APP-CA0219 There is no indirect nursing relationship defined. Contact Admin" },
	{"RMRKS_MAX_LENGTH"				, 	"APP-CA0220 Remarks column exceeds the Maximum limit"},
	{"INVALID_CLOSE_DATE"           , 	"APP-CA0221 Close Date should be between Onset Date and Current Date"},
	{"GROUPBY_NOT_BLANK"            , 	"APP-CA0223 Group By Cannot be Blank"},
	{"INVALID_ONSET_DATE"			, 	"APP-CA0222 Onset Date should be less than or equal to Current Date"},
	{"FAILED_TRANSACTION"			, 	"APP-CA0224 Transaction could not be completed"},
	{"DTP_PAT_CHART_SEL"			, 	"APP-CA0225 Either Desktop or Patient Chart should be selected..."},
	{"SEL_COMB_APPL_EXISTS"			, 	"APP-CA0226 Currently specified combination already linked with Application."},
	{"ONLY_MAX_CHARS"				, 	"APP-CA0227 You  are not allowed to enter more than $$ characters" },
	{"LOCN_USER_SPEC_LOCN"			, 	"APP-CA0228 This user already has some specific location settings" },
	{"CLINIC_USER_HIGHER_EXIST"		, 	"APP-CA0229 Specific clinic/higher privilege setting exists for this user" },
	{"NUNIT_USER_HIGHER_EXIST"		, 	"APP-CA0230 Specific Nursing Unit/higher privilege setting exists for this user" },
	{"LOCN_USER_SETTING_EXIST"		, 	"APP-CA0231 This setting already exists for this user" },
	{"TO_DT_GR_EQ_FM_DT"			, 	"APP-CA0232 To Date should be greater than or equal to From date" },
	{"NOTE_IN_USE"					, 	"APP-CA0233 This Note Type in use, 	cannot be deleted..." },
	{"RECORD_DELETED"				, 	"APP-CA0234 Record Deleted" },
	{"DUP_ENT_NOT_ALLOWED"			, 	"APP-CA0235 Duplicate Entries Not Allowed" },
	{"EXP_VALID"					, 	"APP-CA0236 Expression is Valid" },
	{"HIGH_PRI_EXIST"				, 	"APP-CA0237 Higher privilege setting exists for this user"},
	{"DELETE_FORMULA_YN"			,   "APP-CA0238 Do you want to Delete entire formula"},
	{"NOT_DFLT_CHECK_ITEM"			, 	"APP-CA0239 Cannot default the unchecked Item"},
	{"CLEAR_ASS_FIELDS_CONF"		, 	"APP-CA0240 This Operation will clear all the fields associations done. Do u want to continue?"},
	{"MIN_MAX_VALUE_RANGE"			, 	"APP-CA0241 Entered value should be between (1) and (2)"},
	{"EXIST_COMP_OVERLAP"			, 	"APP-CA0242 Overlaps with existing Component"},
	{"EXIST_GROUP_COMP"				, 	"APP-CA0243 This Grid/Matrix component has already been added to this section"},
	{"ALREADY_CHILD_COMP"			, 	"APP-CA0244 This Component is already child of \nanother component in this template"},
	{"COMP_ALREADY_LINKED"			, 	"APP-CA0245 Component is already linked with another component"},
	{"IMAGE_ALRDY_EXISTS"			, 	"APP-CA0246 Image already exists do you want to continue adding the image"},
    {"TRD_PTN_NO_PRACT"				, 	"APP-CA0247 Third Portion with no practitioner and patient_class not in AE and OP"},
	{"RVT_BAK_WITH_CMTS"			, 	"APP-CA0248 Revert back with comments"},
	{"CONF_RDT_MAIN_PAGE"			, 	"APP-CA0249 Do you want to go to Main Page"},
    {"SCHEDULE_BLOCK"				, 	"APP-CA0250 Appointment Schedule Blocked"},
	{"NO_SHORT_DESC"				, 	"APP-CA0251 No Short Description"},
	{"CL_DATE_NOT_LT_BDATE"			, 	"APP-CA0252 Close date cannot be less than date of birth"},
	{"RELN_REQ_ENC_ID"				, 	"APP-CA0253 Relationship requires Encounter Id"},
	{"RELN_NOT_ELGIBLE"				, 	"APP-CA0254 You are not eligible to establish any relationship. Contact admin"},
	{"CA_ENC_RELN_NO"				, 	"APP-CA0255 Currently encounter relationship feature is disabled"},
	{"PWD_MISMATCH"					, 	"APP-CA0256 Password Mismatch"},
	{"LMP_DATE_GRT_SYSDATE"			, 	"APP-CA0257 LMP Date cannot be greater than sysdate"},
	{"EVENT_START_GREATER_DOB"		, 	"APP-CA0258 Event Start Date Should be Greater than Patient's Date Of Birth"},
	{"EVENT_START_LESS_SYSDATE"		, 	"APP-CA0259 Event Start Date Should Be Lesser than or Equal To Current Date"},
	{"NO_CHART_FOR_CLINIC"			, 	"APP-CA0260 There is no chart defined for this clinic or the chart does not have any components attached."},
    {"IMG_TOOL_LD_FATAL_ERROR"		, 	"APP-CA0260 There has been a fatal error in loading the Image Editing Tool"},
	{"MAX_NOTES_LIMIT"				, 	"APP-CA0261 Allowed number of records per encounter reached the limit...You cannot create a new note"},
	{"INSUFFICIENT_PARAMS"			, 	"APP-CA0262 Enough Parameters have not been passed for this function to record Notes. Please Contact your administrator"},
	{"IMAGE_NOT_FOUND_INLIB"		, 	"APP-CA0263 The selected image is not available in Application Library. Please Contact Application Admin."},
	{"IMG_LD_FATAL_ERROR"			, 	"APP-CA0264 A fatal error has occured while loading the image into the editor. <BR>Please contact the Administrator.."},
	{"CONS_NOT_APPL"				, 	"APP-CA0265 Not applicable for this visit"},
	{"CANNOT_ASSIGN_ALL_COL"		, 	"APP-CA0266 Cannot Assign More than $$ columns"},
	{"CANNOT_ASSIGN_ALL_LIST"		, 	"APP-CA0267 Cannot Assign More than $$ List Components"},
	{"SELECT_RECEIPIENT"			, 	"APP-CA0268 Select a Receipt"},
	{"DEFINE_NOTE_PARAM"			, 	"APP-CA0269 Define Note Parameter"},
	{"NO_PATIENT_ID"				, 	"APP-CA0270 Patient ID is not given"},
	{"NOT_VALID_ENCTRD"				, 	"APP-CA0271 Invalid Facility/Encounter"},
	{"NOT_VALID_PATID"				, 	"APP-CA0272 Invalid Patient Id"},
	{"INVALID_CA_USER"				, 	"APP-CA0273 You are not a valid CA user, 	contact administrator"},
	{"NO_RESP"						, 	"APP-CA0274 Logged in user doesnt have proper responsibility"},
	{"INVALID_USER_PWD"				, 	"APP-CA0275 Invalid User Name/Password"},
	{"CONF_FWD"						, 	"APP-CA0276 Confirm Forward?"},
	{"CONF_SIGN"					, 	"APP-CA0277 Confirm Sign?"},
	{"CONF_ADDENDUM"				, 	"APP-CA0278 Confirm Addendum?"},
	{"CONF_MARKERROR"				, 	"APP-CA0279 Confirm to Mark as Error?"},
	{"TEMP_MANDATORY"				, 	"APP-CA0280 Mandatory Values are not entered, 	This Operation will clear the current modification in this Template"},
	{"CONF_MODIFY"					, 	"APP-CA0281 Confirm Modify?"},
	{"CONF_REVIEW"					, 	"APP-CA0282 Confirm Review?"},
	{"OPRN_NOT_PRESERVE_VALUE"		, 	"APP-CA0283 This Operation will not preserve the currenly modifed values"},
	{"IMAGE_WIPE"					, 	"APP-CA0284 Selecting another image will wipe the screen..\n Do you want to continue?"},
	{"INVALID_MIN_VAL"				, 	"APP-CA0285 Minimum value should be less than maximum value"},
	{"SINGLE_DIGIT_FOR_NUM"			, 	"APP-CA0286 Single digit is allowed for Numeric and Decimal Integer"},
	{"INVALID_VAL_ENTERED"			, 	"APP-CA0287 Invalid value entered in "},
	{"DUPLICATE_SRL_NO"				, 	"APP-CA0288 Duplicate Serial No"},
	{"COMBINATION_EXISTS"			, 	"APP-CA0289 This combination already exists"},
	{"SPEC_LOCN_OR_PATIENT"			, 	"APP-CA0290 Atleast one of the search criteria has to be entered.\n1. Patient ID\n2. Attending Practitioner\n3. Speciality\n4. $$"},
	{"NO_VITAL_SIGN_BATTERY"		, 	"APP-CA0291 No Vital Signs Battery"},
	{"MIN_ONE_EVENT_TYPE"			, 	"APP-CA0292 Either inpatient admission or outpatient visit is mandatory"},
	{"NOTE_CONTENT_NOT_EXISTS"		, 	"APP-CA0293 Note content cannot be blank"},
	{"LOCN_USER_HIGHER_EXIST"		, 	"APP-CA0294 Higher privilege setting exists for this user"},
	{"FORWARD_CLINICIAN_REQUIRED"	, 	"APP-CA0295 Forward Clinician Required"},
	{"CHART_LESS_PREV_REC"			, 	"APP-CA0296 Chart Recording Date should be between Last Recording date and current date"},
	{"REVIEW_REC_ALREDY_EXISTS"		, 	"APP-CA0297 This document is already pending for the selected resource review"},
	{"IMAGE_FILE_EXISTS"			, 	"APP-CA0298 Image already exists "},
	{"LIMIT_UPTO100_ONLY"			, 	"APP-CA0299 Limit is for upto 100 key ranges only"},
	{"XAXIS_YAXIS_DIFFERENT"		, 	"APP-CA0300 X-Axis and Y-Axis must be different..."},
	{"NUMBER_NOT_IN_RANGE"			, 	"APP-CA0301 Number is not within the range"},
	{"VALUE_FOR_X_NOT_BLANK"		, 	"APP-CA0302 Value for X axis cannot be blank"},
	{"VALUE_FOR_Y_NOT_BLANK"		, 	"APP-CA0303 Value for Y axis cannot be blank"},
	{"NO_DATA_AVAILABLE"			, 	"APP-CA0304 Data is not availabe to plot the graph"},
	{"ENDVAL_LESS_STARTVAL"			, 	"APP-CA0305 End value must be greater than start value"},
	{"STARTVALUE_NOT_EXIST"			, 	"APP-CA0306 Start value doesn't exist"},
	{"KEYS_NOT_GENERATED"			, 	"APP-CA0307 Keys are not generated"},
	{"DUP_ELE_TYPE"					, 	"APP-CA0308 Duplicate Element Type..."},
	{"XAXI_YAXI_NOT_SAME"			, 	"APP-CA0309 X-Axis and Y-Axis parameters should not be the same"},
	{"ELE_TYPE_NA"					, 	"APP-CA0310 Selection of Element Type Not Applicable for this component"},
	{"NOT_VALID"					, 	"APP-CA0311 Apply is not a valid operation here"},
	{"PAT_UNASSIGN"					, 	"APP-CA0312 Patient is unassigned to a physician. \nWould you like to assign and continue?"},
	{"NO_COMMON_RELN"				, 	"APP-CA0313 There is no common relation setup exists with Assign privilege for the logged in user and Hold privilege for selected practitioner. \nContact Admin."},
	{"SEL_MAX_PROB_NA"				, 	"APP-CA0314 Selection of more than $$ problem is not allowed..."},
	{"DAYS_SHOULD_NOT_EXCEED"		, 	"APP-CA0315 Auto Close Period Should Not Exceed 31 Days..."} ,
	{"MONTHS_SHOULD_NOT_EXCEED"		, 	"APP-CA0315 Auto Close Period Should Not Exceed 12 Months ..."},
	{"WEEKS_SHOULD_NOT_EXCEED"		, 	"APP-CA0315 Auto Close Period Should Not Exceed 52 Weeks..."},
	{"AUTO_CLOSE_PERIOD_NOT_BLANK"	, 	"APP-CA0316 Auto Close Period Should Not be Blank ..."},
	{"MAX_CHART_EVENTS"				, 	"APP-CA0317 Selection of more than $$ chart events is not allowed..."},
	{"MISSING_ENC_PARAM"			, 	"APP-CA0318 Define CA Encounter Parameter and Proceed..."},
	{"NO_CHANGES_TO_UPDATE"			, 	"APP-CA0319 No changes made to Update..."},
	{"OUTCOME_CLOSE_CURR_CYCLE"		, 	"APP-MC0320 This outcome will close the curent Cycle.\nDo you like to continue?"},
	{"OUTCOME_CLOSE_CURR_EVENT"		, 	"APP-MC0321 This outcome will close current Event and create new Event.\nDo you like to continue?"},
	{"DATE_RANGE_FOR_NOTES"			, 	"APP-CA0322 Atleast one of the below condition should be true...\n  1.Date Range within one month\n  2.Patient ID entered "},
	{"COLOR_DESC_NOT_SYNC"			, 	"APP-CA0323 $$ and color are not synchronozed. Do you want to change to $$ color?"},
	{"DATE_RANGE_OR_PATID"			, 	"APP-CA0324 Please provide Patient Id or Enter Date range within one month... "},
	{"CATEGORY_CANNOT_BLANK"		, 	"APP-CA0325 Category cannot be blank"},
	{"VACCINE_DUPLICATE_CHECK_DAYS"	, 	"APP-CA0326 Duplicate Check days cannot be blank when Duplicate Check Required is Checked"},
	{"VACCINE_CANNOT_BLANK"		    , 	"APP-CA0327 Vaccine Id cannot be blank"},
	{"DEFAULT_CHECK"	            , 	"APP-CA0328 Cannot Select more then one site as default site for a vaccine"},
	{"DATE_DOB_CHECK"	            , 	"APP-CA0329 $$ should be Greater than Date of Birth"},
	{"DURATION_CHECK"	            , 	"APP-CA0330 If Duration is entered, 	must select Duration type"},
	{"PREVIOUS_ADM_CHECK"	        , 	"APP-CA0331 If Previous Administered is checked, 	Check Previous Days cannot be null"},
	{"DURATION_DUPLICATE_CHECK"	    , 	"APP-CA0332 No two records Duration should be same"},
	{"DURATION_CANNOT_BLANK"	    , 	"APP-CA0333 Duration (or) Duration Type cannot be blank"},
	{"DATE_RANGE_OR_PATIENTID"		, 	"APP-CA0324 Please provide Patient Id or Enter Date range within one week... "},
	{"CREATE_SCHEDULE_NOT_BLANK"	, 	"APP-CA0325 Create Schedule cannot be blank... "},
	{"MULTIPLE_SCHEDULE_CHECK"		, 	"APP-CA0326 For the selected category there is only one schedule allowed... "},
	{"MAXIMUM_ICONS_ALLOWED"		, 	"APP-CA0327 Maximum Icons to be selected are "},
	{"LOCATION_CODE_NOTNULL"		, 	"APP-CA0328 Location Code cannot be blank... "},
	{"PATIENT_ID_NOTNULL"			, 	"APP-CA0329 When Search Patient option Checked ! Patient ID cannot be blank...  "},
	{"COMP_TAMPERED"				, 	"APP-CA0330 Component has been tampered."},
	{"RESET_DOC_REF_STR"			, 	"APP-CA0331 Do you want revert current changes?"},
	{"UNSYNCHORINIZED_IMAGE_EXISTS"	, 	"APP-CA0332 There are Unsynchronized image references. Do you want to specify the URLs now?"},
	{"DO_WANT_VIEW"					, 	"APP-CA0333 Do you want to View?"                                                          },
	{"CHANGES_BANNER_CONTINUE"		, 	"APP-CA0334 This action will revert the changes to the banner. Do you want to continue?"},
	{"DISP_VAL_NOT_GREATER_MAX_VAL"	, 	"APP-CA0335 Display length cannot be greater than max length."},
	{"SEQUENCE_NOT_BLANK"			, 	"APP-CA0336 Sequence Number Cannot be Zero or Negative Integer or Blank"},
	{"PAT_MED_RPT_NOT_BLANK"		, 	"APP-CA0337 Patient Medical Report cannot be balnk."},
	{"PAT_CLASS_NOT_BLANK"			, 	"APP-CA0338 Please select atleast one Patient Class."},
	{"REPORT_CANT_BE_BLANK"			, 	"APP-CA0339 Report cannot be blank"},
	{"EMAIL_ID_BE_BLANK"			, 	"APP-CA0340 EMail ID cannot be blank"},
	{"EVENTS_TO_EMAIL"				, 	"APP-CA0341 Please select the events to send the mail"},
	{"EVENTS_TO_MANAGE"				, 	"APP-CA0342 Please select the events to manage"},
	{"EVENTS_TO_PRINT"				, 	"APP-CA0342 Please select the events to print"},
	{"SELECT_SPECIALITY"			, 	"APP-CA0343 Please select speciality to populate Notes"},
	{"EFF_DATES_OVERLAP"			, 	"APP-CA0344 Effective dates overlaps with existing set up"},
	{"REGISTERED_RECIPIENT_CANT_BE_BLANK"	, 	"APP-CA0345 Registered Email Recipient details cannot be blank"},
	{"EMAIL_ID_CANT_BE_BLANK"		 , 	"APP-CA0346 Email ID cannot be blank"},
	{"MIN_DIGITS_COMP"				 , 	"APP-CA0347 Value for $$ Must have minimum ## digits " },
	{"MIN_ONE_EMAILID_SEL_REQ"		 , 	"APP-CA0348 Atleast one emailid control should be selected " },
	{"PAT_EMAIL_ID_NOT_NULL"		 , 	"APP-CA0349 Patient email id is null. Cannot be mailed. Update the patient email id and try." },
	{"MAILING_NOT_ALLOWED"			 , 	"APP-CA0350 Mailing of this report is not allowed. Check the setup for the module - module name and report - report description combination." },
	{"INVALID_EMAIL_ID"				 , 	"APP-CA0351 Invalid email id." },
	{"REC_AND_CONTINUE"				 , 	"APP-CA0352 Apply the details before defining Result Category." },
	{"DEFINE_RESULT_CATEG"			 , 	"APP-CA0353 Do you want to define Result Categories...?" },
	{"NO_ATTCHMENT_FOUND"			 , 	"APP-CA0354 No attachment found..." },
	{"NO_MAIL_DATA_FOUND"			 , 	"APP-CA0355 No mail data found..." },
	{"INVALID_EMAIL_ID"				 , 	"APP-CA0356 Invalid Email ID" },
	{"AUTHORIZATION_REQD"			 , 	"APP-CA0357 Authorization is required for this mail. This will be mailed only after authorization. Do you want to continue?" },
	{"ALREADY_ADMINISTERED"			 , 	"APP-CA0358 This vaccine is already administered $$ day(s) before. \n There should be a time interval of ## day(s). Do you want to continue...?" },
	{"CANT_ADMINISTER"				 , 	"APP-CA0359 This vaccine is already administered $$ day(s) before. \n There Must be a time interval of ## day(s)." },
	{"INVALID_OPERATION"			 , 	"APP-CA0360 $ is not a valid operation here"},
	{"INVALID_URL"					 , 	"APP-CA0361 Invalid URL"},
	{"PAT__NOT_BLANK"				 , 	"APP-CA0362 Please select atleast one Patient to Record."},
	{"CONS_DESC_EXIST"				 , 	"APP-CA0363 Consultation List Description already exist."},
	{"NO_CONS_CATALOG"				 , 	"APP-CA0364 Consultation Catalog is not linked to current practitioner/primary speciality of current practitioner. Contact Admin."},
	{"CONS_LT_CURRDATE"				 , 	"APP-CA0365 Consultation Date can't be less than $ day(s) from Current date."},
	{"CONFIRM_DEFAULT_YN"			 , 	"APP-CA0366 This action will set the default configuration. Confirm?"},
	{"CANNOT_BE_GREATER_THAN_ADM_DATE" ,	"APP-CA0367 Date cannot be lesser than Admission Date"},
	{"MIN_WEIGHT"					 , 	"APP-CA0368 Weights should be heavier than 10 kilograms (22 pounds)."},
	{"MAX_WEIGHT"					 , 	"APP-CA0369 Weights should be lighter than 200 kilograms (441 pounds)."},
	{"MIN_HEIGHT"					 , 	"APP-CA0370 Heights should be taller than 33 centimeters (13 inches)."},
	{"MAX_HEIGHT"					 , 	"APP-CA0371 Heights should be shorter than 241 centimeters ( 7 feet, 	11 inches)."},
	{"AGE_CANT_BLANK"				 , 	"APP-CA0372 Please enter a specific age for $$ ."},
	{"MIN_AGE"						 , 	"APP-CA0373 Ages younger than 1 year old are too young for this calculation. Sorry."},
	{"MAX_AGE"						 , 	"APP-CA0374 All ages from 70 to 120 are treated as age 75."},
	{"WGT_CANT_BLANK"				 , 	"APP-CA0375 Please enter a value for Weight."},
	{"RMRKS_MAX_LENGTH_CNT"			 , 	"APP-CA0376 Remarks column exceeds the Maximum limit of $ characters."},
	{"REMARKS_MUST_GR"				 , 	"APP-CA0377 To $ should be greater than From #"},
	{"DEATH_REG_NOT_APPL"			 , 	"APP-CA0378 Death Register is not applicable "},
	{"CANNOT_BE_GREATER_THAN_SYSDATE", 	"APP-CA0379 $$ cannot be greater than system date. "},
	{"FILE_CORRUPTED"				 , 	"APP-CA0380 File is corrupted "},
	{"FILL_COMPONENT"				 , 	"APP-CA0381 Fill atleast one component to record a Note "},
	{"CHK_IN_TRANS"					 , 	"APP-CA0382 History data lookup is available only in transaction."},
	{"GEN_REP"						 , 	"APP-CA0383 Generating the report..."},
	{"MON_YEAR_GREATER_CURR_MON_YEAR", 	"APP-CA0384 Month/year cannot be greater than current month/year."},
	{"DAY_MON_YEAR_ZERO"			 , 	"APP-CA0385 Day/Month/Year Should not be Zero."},
	{"LINK_FUN_MORE_THAN_5"			 , 	"APP-CA0386 Number of linked functions cannot be more than $$."},
	{"DATE_ST_GT_ISSUE"				 , 	"APP-CA0387 Transfuse start date should be greater than issued Date"},
	{"DATE_ST_LT_RESER"				 , 	"APP-CA0388 Transfuse start date should be less than reserved Date"},
	{"DATE_EN_LT_SYS"				 , 	"APP-CA0389 Transfuse end date should not be greater than system Date"},
	{"DATE_EN_GT_TRANS"				 , 	"APP-CA0390 Transfuse end date should be greater than  Transfuse start date"},
	{"DATE_EN_LT_RESER"				 , 	"APP-CA0391 Transfuse end date should be less than reserved Date"},
	{"REQUEST_PRINT"				 , 	"APP-CA0392 Print Request has been sent to the server"},
	{"MORE_PAT_CHART"				 , 	"APP-CA0393 Cannot open more than $$ patient charts."},
	{"DATE_NOT_GREATER_VISIADMIN"	 , 	"APP-CA0394 Date Cannot be before patient visit admission date."},
	{"ATLEAST_ONE_LINK_FUN"			 , 	"APP-CA0395 Atleast one function should be linked to the adaptive function."},
	{"LOCN_TYPE_NOT_BLNK"			 , 	"APP-CA0396 Location type cannot be blank."},
	{"RELOAD_CHANGES"				 , 	"APP-CA0397 Reloading the changes...."},
	{"NO_DATA_AVAILABLE_TO_PRINT"	 , 	"APP-CA0304 Data is not availabe to print"},
	{"PREV_HDR_PERCNTL_NOT_BLANK"	 , 	"APP-CA0305 Previous Header Percentile Should not be empty"},
	{"HDR_PERCNTL_NOT_BLANK"		 , 	"APP-CA0306 Header Percentile # Should not be empty"},
	{"VARIABLE_DEC_DIGIT"			 , 	"APP-CA0307 Only @ decimal digit(s) allowed" },
	{"DECIMAL_DIGIT_POSITION"        , 	"APP-CA0308 Decimal position cannot be allowed after # digit(s) " },
	{"NOT_STANDARD_URL"				 , 	"APP-CA0309 The URL entered is not a standard URL. Do you want to continue?" },
	{"TEMPLATE_MANDATORY"			 , 	"APP-CA0310 Mandatory Values are not entered, 	Cannot record."},
	{"NUMBER_FIELD_CANNOT_BLANK"	 , 	"APP-CA0311 Number field(s) cannot be blank" },
	{"COMP_MORE_10_NOT_ALLOWED"		 , 	"APP-CA0312 Selection of More than 10 Components is not Allowed" },
	{"AGE_MORE_150_NOT_ALLOWED"		 , 	"APP-CA0313 Age should not more than 150 years" },
	{"FROM_AGE_NOT_MORETHAN_TOAGE"	 , 	"APP-CA0314 From age should not more than To age" },
	{"FROM_AGE_NOT_EMPTY"			 , 	"APP-CA0315 From age should not be empty" },
	{"TO_AGE_NOT_EMPTY"				 , 	"APP-CA0316 To age should not be empty" },
	{"AGE_UNIT_NOT_EMPTY"			 , 	"APP-CA0317 Age unit(s) should not be empty" },
	{"INVALID_CORRECTED_EDD"		 , 	"APP-CA0318 Corrected EDD should be either (+/-)# days to EDD" },
	{"NO_GRAPH_AVAILABLE"			 , 	"APP-CA0319 No graph available" },
	{"REGN_NEWBORN_BFR_CLOSE"		 , 	"APP-CA0320 please Register All Newborns Before Closing the Event." },
	{"NO_DATA_FOUND"				 , 	"APP-CA0321 No Data Found."},
	{"DUE_BEFORE_NOT_EMPTY"			 , 	"APP-CA0322 Due Before (or) Due before Type should not be empty"},
	{"ELAPSED_AFTER_NOT_EMPTY"		 , 	"APP-CA0323 Elapsed After (or) Elapsed After Type should not be empty"},
	{"FAILED_OPERATION"				 , 	"APP-CA0325 Operation Failed....."},
	{"ATLEAST_ONE_APPTASKS_SELECTED" , 	"APP-CA0326 Atleast One Applicable Task should be selected."},
	{"AGE_DOSE_NOT_MATCH"			 , 	"APP-CA0327 Age entered does not match with the age group for the vaccine category"},
	{"REMOVE_SCHEDULE"				 , 	"APP-CA0328 Do you want unlink vaccine $ from category?"},
	//{"REC_DESC_DATE_TIME"			 , 	"APP-CA0329 Recording of  $$ for the Date time: $$"},
	{"VACC_FREQ_NOT_EMPTY"			 , 	"APP-CA0329 Frequency  for $$ vaccine(s) can not be empty."},
	{"AGE_GRP_LINK"					 , 	"APP-CA0330 Cannot link the age group as the applicable age for the vaccine is beyond the selected age group."},
	{"DOSE_COUNT_NOT_MATCH"			 , 	"APP-CA0331 No. of doses are not matching with schedule dose entered."},
	{"APPLICABLE_AGE_EMPTY"			 , 	"APP-CA0332 The Applicable Age should be entered"},
	{"DAYS_CHECK"					 , 	"APP-CA0333 Days cannot be greater than 30"},
	{"DEL_STAGES_NOT_FINALIZED"		 , 	"APP-CA0334 Delivery stages are not finalized.Do you want to continue?"},
	{"VACCINE_ALLREADY_DEFINED"		 , 	"APP-CA0335 This vaccine is already defined for the specific age."},
	{"ATLEAST_ONE_FORMAT_COMMIT"	 , 	"APP-CA0336 There should be atleast one Format item to commit."},
	{"DATE_ST_LT_SYS"				 , 	"APP-CA0337 Transfuse start date should not be greater than system Date."},
	{"INVALID_FILE_EXTN"			 , 	 "APP-CA0337 Invalid File"},
	{"FILE_LIMIT_EXCEED"			 , 	"APP-CA0338 Upload Files Limit Exceeded"},
	{"FILE_SIZE_EXCEED"				 , 	"APP-CA0339  Total uploaded Files size Limit Exceeded"},
	{"DUPLICATE_FILE"				 , 	"APP-CA0340 Duplicate Filename"},
	{"CONFIRM_FILE_DELETE"			 , 	"APP-CA0341 Do you want to delete file?"},
	{"FILE_UPLOAD_ON_SIGN"			 , 	"APP-CA0342 Cannot delete / add file for signed notes."},
	{"RECORD_VALIDATE_ON_UPLOAD"	 , 	"APP-CA0343 No new files to upload."},
	{"PROGRESS_NOTE_NOT_SIGNED"		 , 	"APP-CA0344 Please Sign All the notes before Closing the progression..."},
	{"PROGRESSION_CLOSE"			 , 	"APP-CA0345 This will Close the Progression.Do you want to continue...?"},
	{"PROGRESSION_ACCESS_LTD"		 , 	"APP-CA0345 The access is limited to the practitioner of the progression speciality."},
	{"NOTE_NOT_SELECTED"			 , 	"APP-CA0346 Please select a Progress Note."},
	{"INVALID_CORR_EDD"				 , 	"APP-CA0347 Corrected EDD is beyond the min and max gestation age."},
	{"INVALID_LMP"					 , 	"APP-CA0348 Calculated Gestation age $ is beyond the max gestation age#."},
	{"INVALID_GESTATION"			 , 	"APP-CA0349 Calculated Gestation age $ and display Gestation age # are different.\nPlease recalculate Gestation age."},
	{"FILE_SIZE_LIMIT"				 , 	"APP-CA0350 Total file Size Limit should not be grater than 20 MB."},
	{"PAT_LST_LOCN_PAST_DISCH"		 , 	 "APP-CA0351 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of 2 days for Discharged patient. \n     And Period range is max of 2 days for Past visits. \n"},
	{"PAT_LST_LOCN_PAST"			 , 	 "APP-CA0352 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of 2 days for Past visits. \n"},
	{"PAT_LST_LOCN_DISCH"			 , 	 "APP-CA0353 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of 2 days for Discharged patient."},
	{"PAT_LST_LOCN_CRITERIA"		 , 	 "APP-CA0354 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of One Week."},
	{"EMPTY_CONTENT"				 , 	"APP-CA0355 Free Text Content cannot be empty"},
	{"MEDICAL_SERVICE_BLNK"			 , 	"APP-CA0356 Medical Service can not be empty"},
	{"MAX_REG_CONS_EXCEED"			 , 	"APP-CA0357 Maximum No: of Regular Consultation Exceeded."},
	{"MAX_REF_CONS_EXCEED"			 , 	"APP-CA0358 Maximum No: of Referral Consultation Exceeded."},
	{"TGT_PAT_SERIES_NOT_CONFIG"	 , 	"APP-CA359 Target Patient Series Group not configured...."},
	{"SELECT_EVENT_CLASS"			 , 	"APP-CA360 Select atleast one event to process...."},
	{"SRC_TGT_PAT_CANNOT_BE_SAME"	 , 	"APP-CA361  Source and Target Patient ID should not be the same .... "},
	{"PAT_SERIES_NOT_ALLOWED"		 , 	"APP-CA362  Selected Patient Series not allowed for Transfer .... "},
	{"PAT_LST_LOCN_PAST_DISCH_LMT"		 , 	 "APP-CA0363 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of $D days for Discharged patient. \n     And Period range is max of $V days for Past visits. \n"},
	{"PAT_LST_LOCN_PAST_LMT"			 , 	 "APP-CA0364 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of $V days for Past visits. \n"},
	{"PAT_LST_LOCN_DISCH_LMT"			 , 	 "APP-CA0365 Atleast one of the below conditions should be true. \n 1. Patient ID  entered. \n 2. Period range is max of $D days for Discharged patient."},
	{"PARAM_LIST_NOT_BLNK"				 , 	"APP-CA0366 Parameter List cannot be blank."},
	{"INVALID_FROM_PAST_VISIT_DATE_DAYS"	, 	"APP-CA0367 Past Visit Date Should be within the allowable limit ($ days)" },
	{"INVALID_FROM_DISCHARGE_DATE_DAYS"		, 	"APP-CA0368 Discharged Period From Date Should be within the allowable limit ($ days)" },
	{"TRANS_INVESTIGATE"				 	, 	 "APP-CA0369 Please order transfusion reaction investigation."},
	{"DELV_EXIST"				 			, 	 "APP-CA0370 Delivery Already recorded.Please reload the page."},
	{"ANALYTICAL_GROUP_EXISTS"				, 	 "APP-CA0371 Analytical Group Already Exixts."},
	{"SELECT_CHART_TYPE"				 	, 	 "APP-CA0372 Please select the Chart Type."},
	{"VISIT_CANCELLED"				, 	"APP-CA0373 Visit has been cancelled for this patient, 	cannot proceed."},//IN032928
	{"CHARACTER_NOT_ALLOWED"		, 	"APP-CA0374 Invalid character, 	Numeric only allowed."},//IN035961
	{"CHECK_INSERT_ACCESS" 			, 	"APP-CA0375 Record access rights not available for this user."}, 	//IN030466
	{"CHECK_UPDATE_ACCESS" 			, 	"APP-CA0376 Update access rights not available for this user."}, 	//IN030466
	{"CA_HIGH_RISK_PREV_RECORD"		, 	"APP-CA0398 Sorry You don't have the previlege to record high risk condition"}, 	//IN037021
	{"CA_MAX_ENCOUNTER_WARNING"		, 	"APP-CA0399 Number of encounters should not exceed 99."}, 	//added for CHL-CRF-018 IN035924
	{"CA_SIGN_OTH_ADDENDUM"			, 	"APP-CA0400 Unsigned Addendum exists, 	cannot proceed"},//IN037676
	{"CA_SHORT_DESC_BLANK"			, 	"APP-CA0401 Short Description Cannot Be Blank, 	cannot proceed"},//IN038579
	{"CA_DIAG_SET_RESET"			, 	"Change of Diagnosis Set should reset all your entered data. \n Are you sure to change the Diagnosis Set?"},//CRF-028
	{"CA_ALPHA_NUMERIC_SYMBOL"		, 	"APP-CA0402 Alphanumeric characters and Symbols ( ~ , $ , & , ^) are not allowed."}, 	 //IN041021
	{"CA_SELECT_MENU"				, 	"APP-CA0403 Please Select Menu."},//IN043533
	{"CA_SPCL_CHAR_NOT_ALLOWED"		, 	"APP-CA0402 Special characters not allowed."},//IN043577
	{"CA_VACC_PRINT"				, 	"APP-CA0404 Please select the events to print."}, 	 //IN045400
	{"CA_ONE_ORDERABLE"				, 	"APP-CA0405 Select atleast One "},//IN042552
	{"SUMMARY_NOT_BLANK"			, 	"APP-CA0403 Summary cannot be blank"}, 	//added for Encounter Summary By Sethu
	{"SUMMARY_NOT_CONFIGURED"		, 	"APP-CA0404 Summary has not been configured"}, 	//added for Encounter Summary By Sethu
	{"DUP_VITAL_CHK"		 		, 	"APP-CA0408 Vital Component Already Exist... "},//IN037701
	{"PAT_DISCHARGED"		 		, 	"APP-CA0409 Patient has been Discharged. "},//IN051373
	{"PAT_CHKD_OUT"		 			, 	"APP-CA0410 Patient has been Checked Out. "},//IN051373
	{"PAT_ASSIGN_CONFIRM"			, 	"APP-CA0411 Patient is Unassigned to a Physician. Would you like to ?"},//IN048704
	{"COPY_PREVIOUS_NOTE_CONFIRM"	, 	"APP-CA0412 Copying from selected note will clear all filled details from current note. \n\nDo you want to continue ?"},//IN052940
	{"NOTE_FORMAT_CHANGED"			, 	"APP-CA0413 Note Format Changed; Can't copy from past records"},//IN052940
	{"MAX_OF_999"					, 	"More than 999 Sections are not allowed."},//IN058155
	{"CA_MIN_MAX_TIME_AUTO_REFRESH"	, 	"APP-CA0414 Please enter the time between 1 min to 99 mins..."},//IN052053
	{"TO_DATE_GREATER_SYSDATE"		, 	"APP-CA0415 To Date Should Not Be Greater than Current Date"}, 	//IN062560
	{"FUNC_NOTAPP_RESP_RELN" 		, 	"APP-CA0416 This function is not applicable for this Responsibility/Relationship"},//IN062564
	{"MANDATORY_VALUES" 			, 	"APP-CA0417 Current Section Mandatory Values are not entered.."}, 	//IN064566
	{"CA_MIN_MAX_DAYS_GRACE_PERIOD"	, 	"APP-CA0418 Please enter the number of days between 1 day to 9 days..."},//IN061885
	{"SELECT_ATLEAST_ONE" 			, 	"APP-CA0419 Select atleast one Record to Remove"},//IN061891
	{"ADD_PAT_SUCCESS" 				, 	"APP-CA0420 Added Patient to Personalized Patient List Successfully"},//IN061891
	{"SELECT_AEMANAGE_PATQUEUE" 	, 	"APP-CA0421 Please select chart type for the Current Emergency Patients<br>"},//IN065070 //66156
	{"SELECT_CHARTTYPE_CA" 			, 	"APP-CA0422 Please select chart type for AE Consultation in Clinician Access<br>"},//IN065070 //66156
	{"SELECT_DEFAULT_CHART" 		, 	"APP-CA0423 Chart Type to be selected to add Default"},//IN061897
	{"CHOOSE_AT_LEAST_ONE_SCHEDULE"	, 	"APP-CA0424 Please Select atleast One Schedule." },//IN065683
	{"COPY_PREVIOUS_SECTION_CONFIRM", 	"APP-CA0425 Copying from selected section note will clear all filled details from current section. \n\nDo you want to continue ?"},//IN063931
	{"SECTION_FORMAT_CHANGED"		, 	"APP-CA0426 Section Format Changed; Can't copy from past records"},//IN063931
	{"CA_MIN_MAX_HOURS_DURATION" 	, 	"APP-CA0421 Please Enter the Duration Between 0 to 23 Hours"},//IN062606
	{"XAXI_YMULTI_NOT_SAME"			, 	"APP-CA427 X-Axis, 	Y-Axis, 	Y1-Axis and Y2-Axis parameters should not be the same"},//IN061886
	{"CA_DATE_RANGE_ONE_WEEK" 		, 	"APP-CA0428 Please Enter Date Range Within One Week..."},//IN066647
	{"CA_DFLT_MIN_MAX_VAL_DAYS" 	, 	"APP-CA0429 Default Values Allowed Shall be Within 1 to 30 Days"},//IN065910
	{"TENNER_STAGING_PENIS_PUBIC"	, 	"APP-CA0429 Genital (Penis) Development & Pubic hair cannot be blank"}, 	//IN063838
	{"TENNER_STAGING_BREAST_PUBIC"	, 	"APP-CA0430 Breast Development & Pubic hair cannot be blank"},//IN063838
	{"TENNER_STAGING_BREAST"		, 	"APP-CA0431 Breast Development cannot be blank"},//IN063838
	{"TENNER_STAGING_PUBIC"			, 	"APP-CA0431 Pubic hair cannot be blank"},//IN063838
	{"CA_CNETRALISED_DEFAULT_DAYS"	, 	"APP-CA0432 Please enter the number of days between 1 to 999 days"},//IN065341
	{"MYHIX_ALERT" 					, 	"APP-CA0433 Do you want to send Patient Discharge Summary info to MyHix ?"},//IN067607
	{"CONF_MARK_REJECT"				, 	"APP-CA0434 Confirm to Mark as Reject?"},//IN67872
	{"CONF_UPDATE" 					, 	"APP-CA0435 Confirm Update?"},//IN063818
	{"NUMBER_TO_BE_ENTERED" 		, 	"APP-CA0436 Please enter the number between 40 to 96"},//IN068669
	{"INSURANCE_NOT_MATCHED" 		, 	"APP-CA0437 No report is configured for this insurance."},//IN059704
	{"PATIENT_ID_CANNOT_BE_BLANK" 	, 	"APP-CA0438 Patient ID cannot be blank."},//IN059704
	{"ENCOUNTER_ID_CANNOT_BE_BLANK" , 	"APP-CA0439 Encounter ID cannot be blank."},//IN059704
	{"INVALID_INPUT" 				, 	"APP-CA0440 Invalid Input."},//AAKH-CRF-0079
	{"CA_THIRDPARTY_VITALS_TIME_DUR", 	"APP-CA0440 Please enter the number of minutes between 1 to 999."},//IN072674
	{"SHARED_PATH_INCORRECT"		, 	". Shared path is either incorrect or is not Read-Write accessible."},//IN070345
	{"PATIENTIDMANDATE"				, 	"APP-CA0441 Patient ID is mandatory without that user cannot proceed"},//6451
	{"VITAL_SIGN_BED_SEARCH" 		, 	"APP-CA0442 Bed. No related interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do want to proceed"},//IN017999
	{"VITAL_SIGN_ENCOUNTER_SEARCH" 	, 	"APP-CA0443 Interfaced vital sign observations shall be moved to respective patient ID: $ and Encounter ID: # Do want to proceed"},//IN017999
	{"URL_NOT_INST_IN_USER_MACHINE" , 	"APP-CA0444 URL shall not work, 	as it is not installed in user machine with applicable browser"}, 	//IN27710
	{"PRACTITIONER_ID_CANNOT_BE_BLANK" 		, 	"APP-CA0445 Practitioner ID cannot be blank."},//
	{"SEARCH_RESULT_CANNOT_BE_BLANK" 		, 	"APP-CA0446 Search Result Cannot be blank."},//
	{"EFFECTIVE_FROM_DATE_CANNOT_BE_BLANK" 	, 	"APP-CA0447 Selected Record Effective From Date cannot be Blank."},
	{"DISCH_FROM_TO_DATE_NOT_BLANK"			, 	"APP-CA0448 Discharged Period From and to dates cannot be blank"},
	{"DISCH_FROM_DATE_NOT_BLANK"			, 	"APP-CA0449 Discharged Period From date cannot be blank"},
	{"DISCH_TO_DATE_NOT_BLANK"				, 	"APP-CA0450 Discharged Period To date cannot be blank"},
	{"ENC_FROM_TO_DATE_NOT_BLANK"				, 	"APP-CA0451 Encounter Period From and to dates cannot be blank"},
	{"ENC_FROM_DATE_NOT_BLANK"					, 	"APP-CA0452 Encounter Period From date cannot be blank"},
	{"ENC_FROM_DATE_NOT_BLANK"					, 	"APP-CA0453 Encounter Period To date cannot be blank"},
	{"INVALID_FROM_ENC_DATE_DAYS"	, 	"APP-CA0454 Encounter Period From Date Should be within the allowable limit ($ days)" },
	{"ENC_DISCH_NOT_SELECTED"		, 	"APP-CA0455 Either Discharged Period  or Encounter Period to be Selected." },
	{"MAX_TEXT_REASON_DESC"		, 	"APP-CA0456 Max limit of Reason Text is 200 Characters" },
	{"SUMM_ALREADY_CONFIGURED"				, 	"APP-CA0404 Same  Summary  already configured" },
	{"UNCHK_CHKBOX_NOT_PERMITTED"		, 	"Unchecking the Checkbox is not Permitted at this Stage for Completed or In-Error or Not Administered Vaccine Status"}, //41654
	 //32902 start.
	{"FROM_DATE_LESS_SYSDATE","APP-CA0058 Date From Cannot be less than System Date"},
	{"TO_DT_GR_EQ_SY_DT"			, 	"APP-CA0259 Date To Cannot be less than System Date" },
	{"ONE_PRACT_SHOULD_SELECTED","APP-CA0260 At least One Practitioner Should be selected to Proceed"},
	{"DT_TO_GRTER_DT_FRM"	, 	"APP-CA0261 Date To Should be greater than or Equal to Date From" },
	//  32902 end.
    {"AC_RSTR_PAT_LMT_AUT"			, 	"APP-000061 Access to restricted patient clinical data is limited to authorized personnel only. Cannot proceed" } //32902
		};
	
}
