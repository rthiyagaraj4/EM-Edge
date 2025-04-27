/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDR.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {		
		{"THREE_FIELD","APP-DR0001 Atleast 3 Fields should be selected"},
		{"CHECK_DAY_MONTH","APP-DR0002 Check is done on Year/Month/Day combination"},
		{"CHECK_MONTH_YEAR","APP-DR0003 Check is done on Year/Month"},
		{"ATLEAT_ONE_NAME","APP-DR0004 Atleast one name component should be selected"},
		{"SEARCH_ACTIVE","APP-DR0005 This search function is already activated"},
		{"ONLY_TWO","APP-DR0006 Only 2 Patients can be selected"},
		{"TWO_PATIENTS","APP-DR0007 Minimum 2 Patients should be selected"},
		{"TEN_PATIENTS","APP-DR0008 Viewing is not possible for more than 10 Patients. Select any two patients using checkbox."},
		{"NO_RECORD","APP-DR0009 Patient Record does not exist"},
		{"PATIENT_NOT_SELECTED","APP-DR0010 No Patient Record is selected"},
		{"CYCLE_IN_PROGRESS","APP-DR0011 The Cycle is already in progress"},
		{"NO_RECORD_AVAILABLE","APP-DR0012 No records available in the table"},
		{"DR_PARAM_NOT_AVAILABLE","APP-DR0013 DR parameter is not set up"},
		{"ATLEAST_ONE_VALID","APP-DR0014 One Main Patient ID should be selected"},
		{"INVALID_DATETIME","APP-DR0015 Invalid Date Time Format"},
		{"NON_DUPLICATES","APP-DR0016 Patient Ids are already present as duplicates"},
		{"PATIENT_POSSIBLE_DUPLICATES","APP-DR0017 Patient Id already exists in Possible Duplicates"},
		{"DUPLICATE_PATIENT_ENTRY","APP-DR0018 Duplicate Patient Entry"},
		{"START_LATER_TIME","APP-DR0019 Start-Later Date Time should be greater than Current Date Time"},
		{"ONLY_ONE_PAIR","APP-DR0020 Only One Record should be selected"},
		{"CHANGE_ID_SERIES_NOT_ALLOWED","APP-DR0021 Change To ID Series Not Allowed for Alternate or National Series"},
		{"SHD_NOT_BE_BLANK","APP-DR0022 Patient ID cannot be blank"},
		{"ID_NO_NOT_BLANK","APP-DR0023 ID No cannot be blank"},
		{"DUPLICATE_ID_NO","APP-DR0024 ID No already exists"},
		{"RECORD_EXISTS","APP-DR0025 Record already exists"},
		{"SEARCH_MERGE_JOB_EXISTS","APP-DR0026 Search / Merge Job is present in Job Queue"},
		{"NO_USER_RIGHTS","APP-DR0027 The User does not have Access to this Function"},
		{"REMARKS_CANNOT_BE_BLANK","APP-DR0028 Remarks cannot be blank"},
		{"DR_USER_ID_NOT_BLANK","APP-DR0029 User Id Cannot be Blank"},
		{"MINIMUM_TWO_PATIENTS","APP-DR0030 Minimum two patients should be entered"},
		{"DECEASED_PATIENT","APP-DR0031 Patient is a Deceased Patient"},
		{"DATE_TIME_NOT_BLANK","APP-DR0032 Date Time cannot be blank"},
		{"NO_SEARCH_PROCESS","APP-DR0033 No DR Process Cycle is in progress"},
		{"NO_RECORDS_FOR_REVIEW","APP-DR0034 There is no data available for review"},
		{"NAME_MANDATORY","APP-DR0035 Atleast One Mandatory Name Component should be selected as the criteria"},
		{"PATIENT_REGISTERED_FACILITY","APP-DR0036 Patient is not registered under current facility"},
		{"SEARCH_ALL_FACILITY","APP-DR0037 Search will be done across all facilities"},
		{"SEARCH_PROCESS_JOB","APP-DR0038 Search Process is submitted as a Job"},
		{"MERGE_PROCESS_JOB","APP-DR0039 Merge Process is submitted as a Job"},
		{"UNMERGE_PROCESS_JOB","APP-DR0040 Unmerge Process is submitted as a Job"},
		{"IDSERIES_PROCESS_JOB","APP-DR0041 Change to ID Series Process is submitted as a Job"},
		{"NO_USER_RIGHTS_ALL_FCY","APP-DR0042 The User does not have Access to this Function across facilities"},
		{"ATLEAST_ONE_DUPLICATE","APP-DR0043 One duplicate Patient ID should be selected"},
		{"DR_PROCESS_CYCLE","APP-DR0044 The DR process cycle is already in progress"},
		{"REMARKS_NOT_EXCEED_500_CH","APP-DR0045 Remarks cannot exceed 500 characters"},
		{"ID_MIN_LENGTH","APP-DR0046  Id No minimum length should be "},
		{"INVALID_PAT","APP-DR0047 Invalid Patient ID"},
		{"DELETE_RECORD","APP-DR0048 Do you want to Delete the Record?"},
		{"CANT_BE_LT","APP-DR0049 $ cannot be less than #"},
		{"NO_MERGED_PAT_REC","APP-DR0050 No Merged Patient Records Exist"},
		{"PATIENT_CUR_OUTPATIENT","APP-DR0051 Patient is currently an Outpatient"},
		{"START_LATER_DATE_BLANK","APP-DR0052 Start Later Date and Time cannot be blank"},
		{"ABORT_PROCESS","APP-DR0053 Do you want to Abort the Process ?"},
		{"NEXT_EXE_DATE_GRT_CUR_DATE","APP-DR0054 Next Execution Date should be greater than current date"},
		{"ATLEAST_ONE_CHECK_BEF_DEL","APP-DR0055 Atleast one record should be selected for Deletion"},
		{"ED_TIME_LESS_EQL_ST_TIME","APP-DR0056 End time cannot be lesser than or equal to start  time"},
        {"PAT_LENGTH","APP-DR0057 Patient Id has to be of"},
        {"CLOSE_PROCESS","APP-DR0058 Do you want to Close the Process ?"},
        {"DR_INVALID_MERGE_TIME","APP-DR0059 Invalid Merge Time.Cannot Proceed"},
        {"EXCLUDE_DUPLICATE_RECORD","APP-DR0060 Exclude Possible duplicates are exists"},
		{"PAT_SHD_BE_IDENTIFIED","APP-DR0061 Patient Should be Identified First"},
		{"ONLY_ONE_MAIN","APP-DR0062 Only One Main Patient ID should be selected"},
		{"MERGE_DUPLICATES_EXISTS","APP-DR0063 Patient Id already exists in Merge Duplicates"},
		{"ONE_MAIN_AND_ATLEAST_ONE_DUPLICATE","APP-DR0064 One main and atleast one duplicate patient id should be selected"},
		{"ONLY_ONE_INPATIENT","APP-DR0065 This patient is currently an inpatient. Cannot have more than one patient as inpatient for merging."},
		{"ATLEAST_ONE_VALID_EXISTS","APP-DR0066 Atleast one duplicate record should Exists. Cannot Proceed"},
		{"SELECT_MANDATORY_NAME","APP-DR0067 Atleast One of # Component should be selected as the criteria"},
		{"DELETE_BOTH_MAIN_AND_DUPLICATE","APP-DR0068 Both Main and Duplicate Patients will be deleted. Do you want to continue?"},
		{"TOOMANY_RECORDS_REFINE_SEARCH","APP-DR0069 Too many records found for the selected criteria. Refine the Search"}
		
	};			
}		  
