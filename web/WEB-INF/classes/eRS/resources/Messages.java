/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law . 
 ******************************************************************************/
package eRS.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents;
    }

	static final Object[][] contents = 
	{		
		{"RECORD_INSERTED","APP - RS0001 Operation Completed Successfully......"},
		{"RECORD_MODIFIED","APP - RS0002 Operation Completed Successfully ...."},
		{"RECORD_DELETED","APP - RS0003 Operation Completed Successfully ...."},
		{"TRANSACTION_FAILED","APP - RS0004 Transaction Failed to commit"},
		{"CAN_NOT_BE_EXEED","APP-RS0005 Explanatory Text Length cannnot be more than 400"},
		{"TERMSET_MUST_BE_SELECT","APP-RS0006 Terminology Set must be selected"},
		{"NO_VALID_SHIFTS_SWAP","APP-RS0007 No valid shifts found for Swap"},
		{"WORK_HRS_CANNOT_BE_ZERO","APP-RS0008 Work Hours cannot be Zero"},
		{"EXPLTEXT_MAX_4000", "APP-RS0009 Explanatory Text cannot exceed 4000 characters"},
	  	{"MIN_SCORE_MANDATORY","APP-RS00010 Minimum Score must be entered for all selected dependencies"},
	  	{"TO_DATE_LESSER_FROM_DATE", "APP-RS00011 To date must be less than From date"},
	  	{"TO_DT_GR_EQ_FM_DT", "APP-RS00012 To date must be greater than or equal to From date"},
	  	{"FROM_DATE_CANNOT_BE_BLANK", "APP-RS00013 From date cannot be blank"},
	  	{"NOT_VALID", "APP-RS0014 Apply is not a valid operation here"},
	  	{"INVALID_SHIFT", "APP-RS0015 Invalid Shift"},
	  	{"FROM_DATE_GREATER_TO_DATE", "APP-RS00016 From date must be greater than To Date"},
	  	{"HR_LESS_TWENTYFOUR", "APP-RS00017 Hr must be less than Twentyfour"},
	  	{"NO_AXS_FOR_WP_REQ_SETUP", "APP-RS0018 User does not have access to setup workplace requirement"},
	  	{"MI_LESS_SIXTY", "APP-RS00019 MI must be less than Sixty"},
		{"TO_DATE_LESS_SYSDATE","APP-RS0020 To Date should be less than or equal to Current Date"},
	  	{"REMARKS_XCEED_2000_CHARS", "APP-RS00021 Remarks cannot exceed 2000 characters"},
	  	{"SCHEDULE_PERIOD_LESS", "APP-RS0022 Period for Work Schedule Generate is less...."},
	  	{"FROM_DATE_LESS_SYSDATE", "APP-RS0023  From Date should be less than or equal to Current Date"},
	  	{"FROM_DATE_GREATER_SYSDATE", "APP-RS0024  From Date should be greater than or equal to Current Date"},
	  	{"ONE_SHIFT_SELECT_FOR_SWAP", "APP-RS0025 One shift must be selected for swap"},
	  	{"WORKPLACE_NOT_BLANK", "APP-RS0026 workplace cannot be balnk"},
	  	{"LOCATION_NOT_BLANK", "APP-RS0027 Location Type cannot be balnk"},
	  	{"STAFF_NOT_BLANK", "APP-RS0028 Staff cannot be balnk"},
	  	{"ONE_SHIFT_SELECT_FOR_SWAP",  "APP-RS0029 One shift must be selected for swap"},
	  	{"REASON_BLANK",  "APP-RS0030 Reason Cannot be blank"},
	  	{"TRANSFER_BLANK",  "APP-RS0031 Transfer cannot be blank"},
	  	{"OVERTIME_ASSIGNMENT_NOT_ALLOWED",  "APP-RS0032 Overtime assignment is not allowed on active shift"},
	  	{"OVERTIME_DURATION_LAPSED",  "APP-RS0033 Duration to assign overtime from start of shift is lapsed"},
	  	{"OVERTIME_DURATION_CLASHES",  "APP-RS0034 Overtime duration clashes with the next shift of the staff"},
	  	{"HR_LESS_TWENTYFOUR",  "APP-RS00035 HR_LESS_TWENTYFOUR"},
	  	{"OVERTIME_DURATION_NOT_ZERO",  "APP-RS0036 Overtime Duration cannot be zero"},
	  	{"CANNOT_ASSIGN_SHIFT",  "APP-RS0037 Cannot assign the shift"},
	  	{"SHIFT_BLANK",  "APP-RS0038 Shift cannot be blank"},
	  	{"STEP_IN_OVERLAP",  "APP-RS0039 Step In Time overlapped"},
	  	{"STEP_OUT_CANNOT_BLANK",  "APP-RS0040 Step Out Time can not be blank...."},
	  	{"STEP_IN_CANNOT_BLANK",  "APP-RS0041 Step In Time can not be blank...."},
	  	{"STEP_IN_OUT_HOURS_0_TO_23",  "APP-RS0042 StepIn/Out Hours should be between 0 and 23"},
	  	{"STEP_IN_OUT_MINIT_0_TO_59",  "APP-RS0043 StepIn/Out Minutes should be between 0 and 59"},
	  	{"REACHED_END",  "APP-RS0044 Already reached the end"},
	  	{"REACHED_BEGIN",  "APP-RS0045 Already reached the begining"},
	  	{"NO_AXS_FOR_MARK_ATTENDANCE",  "APP-RS0046 User does not have access for mark Attendance"},
	  	{"NO_AXS_FOR_GEN_SCH",  "APP-RS0047 User does not have access to generate schedule"},
	  	{"NO_VALID_SHIFT_ALLOCATION",  "APP-RS0048 No valid shifts found for allocation"},
	  	{"NO_VALID_SHIFTS_CHANGE",  "APP-RS0049 No valid shifts found for Change"},
	  	{"ALREADY_SHIFT_ASSIGNED",  "APP-RS0050 Selected shift is already assigned to the staff"},
	  	{"STAFF1_SHIFT_ALREADY_ASSIGNED_TO_STAFF2_SHIFT",  "APP-RS0051 Selected shift of staff 1 is already assigned to staff 2"},
	  	{"STAFF2_SHIFT_ALREADY_ASSIGNED_TO_STAFF1_SHIFT",  "APP-RS0052 Selected shift of staff 2 is already assigned to staff 1"},
	  	{"STAFF1_SCHEDULE_OVERLAPS_WITH_STAFF2",  "APP-RS0053 Staff 1 existing schedule overlaps with Staff 2 shift to be swapped"},
	  	{"STAFF2_SCHEDULE_OVERLAPS_WITH_STAFF1",  "APP-RS0054 Staff 2 existing schedule overlaps with Staff 1 shift to be swapped"},
	  	{"STAFF_NOT_AVAILABLE",  "APP-RS0055 Staff is not available"},
	  	{"STAFF_SUBSTITUTION_FEATURE_NOT_ENABLED",  "APP-RS0056 Staff substitution feature is not enabled"},
	  	{"EXPIRING_DAYS",  "APP-RS0057 Expiring Days cannot be blank..."},
	  	{"OPERATING_HOURS_0_TO_23",  "APP-RS0058 Operating Hours Can be between 0 and 23"},
	  	{"OPERATING_MINUTES_0_TO_59",  "APP-RS0059 Operating Minutes Can be between 0 and 59"},
	  	{"WORKING_DAYS_FROM_TO_NOT_EQUAL",  "APP-RS0060 Working Days From and To cannot be Equal"},
	  	{"NON-WORKING_DAYS_FROM_TO_NOT_EQUAL",  "APP-RS0061 Non-Working Days From and To cannot be Equal"},
		{"ERROR_IN_INSERTING_INTO", "APP-RS0062 Error encountered while recording staff unavailability"},
		{"FTE_RANGE", "APP-RS0063 Range must be from 0 to 0.9 only..."},
		{"HOLIDAYS_FROM_TO_NOT_SAME",  "APP-RS0064 Holidays From and To cannot be Same"},
		{"TO_DATE_GR_FR_DATE", "APP-RS0065 To date must be greater than From date"},
		{"FROM_TO_BLANK_NOT", "APP-RS0066  From and To date both should be blank or valid date"},
		{"ROLE_TYPE_BLANK",  "APP-000067 Role Type cannot be blank..."},
		{"ALL_GREATER_ZERO",  "APP-RS0068 If any one of min, max, opt has a value > 0 then all the three (min,max,opt) in that set must be > 0"},
		{"TO_DATE_NOT_BLANK",  "APP-RS0069 To date should not be blank or valid date...."},
		{"ATLESAST_ONE_SET_GREATER_ZERO",  "APP-RS0070 In at least one set the min, max,opt all the 3 must have a value greater than zero"},
		{"DURATION_CANNOT_BE_ZERO",  "APP-RS0071 Duration cannot be Zero"},
		{"NO_SERVICE_AVAILABLE",  "APP-RS0072 No Services Available"},
		{"REASON_CODE_BLANK",  "APP-RS0073 Reason Code Cannot be blank"},
		{"ONLY_POSITIVE_NUM",  "APP-RS0074 Only positive integer is allowed"},
		{"INVALID_DECIMAL_NUMBER",  "APP-RS0075 Invalid Decimal Number"},
		{"DECIMAL_NOT_ALLOWED",  "APP-RS0076 Decimals not allowed"},
		{"REASON_APPLICABILITY_CHECK",  "APP-RS0077 Atleast one flag should be checked"},
		{"GRADE_CODE_NOT_BLANK",  "APP-RS0078 Atleast one flag should be checked"},
		{"CANCEL_LEAVE_ALLOCATE",  "APP-RS0079 Do you want to allocate the shift?"},
		{"LEAVE_CANNOT_BE_RECORDED",  "APP-RS0080 Leave cannot be recorded as duplicates found"},
		{"REASON_CANCEL_LEAVE_CANNOT_BE_BLANK",  "APP-RS0081 Reason for Cancel Leave can not be blank when Cancel is selected"},
		{"LEAVE_TO_CANNOT_BE_BLANK",  "APP-RS0082 Leave Period To can not be blank when From Date is selected"},
		{"LEAVE_FROM_CANNOT_BE_BLANK",  "APP-RS0083 Leave Period From can not be blank when To Date is selected"},
		{"LEAVE_FROM_TO_CANNOT_BE_BLANK",  "APP-RS0084 Leave Period From and Leave Period To can not be blank when Reason is selected"},
		{"TO_DATE_GREATER_SYSDATE", "APP-RS0085  To Date should be greater than or equal to Current Date"},
		{"STAFF_PROFILE_MISSING", "APP-RS0086 Staff Profile is not defined for the selected staff"},
		{"PARAMETER_SETUP_MISSING", "APP-RS0086 Parameter Setup is not available for login facility."} //Added for GHL-SCF-1161 

	  	
	};
}		




