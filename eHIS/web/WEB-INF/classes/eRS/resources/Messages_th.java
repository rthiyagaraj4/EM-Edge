/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.resources;

import java.util.*;

public class Messages_th extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents;
    }

	static final Object[][] contents = 
	{		
		{"RECORD_INSERTED"," th APP - RS0001 Operation Completed Successfully......"},
		{"RECORD_MODIFIED"," th APP - RS0001 Operation Completed Successfully ...."},
		{"RECORD_DELETED"," th APP - RS0001 Operation Completed Successfully ...."},
		{"TRANSACTION_FAILED"," th APP - RS0002 Transaction Failed to commit"},
		{"CAN_NOT_BE_EXEED"," th APP-RS0003 Explanatory Text Length cannnot be more than 400"},
		{"TERMSET_MUST_BE_SELECT"," th APP-RS0004 Terminology Set must be selected"},
		{"NO_VALID_SHIFTS_SWAP"," th APP-RS0061 No valid shifts found for Swap"},
		{"WORK_HRS_CANNOT_BE_ZERO"," th APP-RS0018 Work Hours cannot be Zero"},
		{"EXPLTEXT_MAX_4000"," th APP-RS0019 Explanatory Text cannot exceed 4000 characters"},
	  	{"MIN_SCORE_MANDATORY"," th APP-RS0023 Minimum Score must be entered for all selected dependencies"},
	  	{"TO_DATE_LESSER_FROM_DATE"," th To date must be less than From date"},
	  	{"TO_DT_GR_EQ_FM_DT"," th To date must be greater than or equal to From date"},
	  	{"FROM_DATE_CANNOT_BE_BLANK"," th From date cannot be blank"},
	  	{"NOT_VALID"," th APP-RS0012 Apply is not a valid operation here"},
	  	{"INVALID_SHIFT"," th APP-RS0031 Invalid Shift"},
	  	{"FROM_DATE_GREATER_TO_DATE"," th From date must be greater than To Date"},
	  	{"HR_LESS_TWENTYFOUR"," th Hr must be less than Twentyfour"},
	  	{"NO_AXS_FOR_WP_REQ_SETUP"," th APP-RS0014 User does not have access to setup workplace requirement"},
	  	{"MI_LESS_SIXTY"," th MI must be less than Sixty"},
		{"TO_DATE_LESS_SYSDATE"," th APP-RS0023 To Date should be less than or equal to Current Date"},
	  	{"REMARKS_XCEED_2000_CHARS"," th Remarks cannot exceed 2000 characters"},
	  	{"SCHEDULE_PERIOD_LESS"," th APP-RS0032 Period for Work Schedule Generate is less...."},
	  	{"FROM_DATE_LESS_SYSDATE"," th APP-RS0022  From Date should be less than or equal to Current Date"},
	  	{"ONE_SHIFT_SELECT_FOR_SWAP"," th APP-RS0062 One shift must be selected for swap"},
	  	{"WORKPLACE_NOT_BLANK"," th APP-RS0063 workplace cannot be balnk"},
	  	{"STAFF_NOT_BLANK"," th APP-RS0064 Staff cannot be balnk"},
	  	{"ONE_SHIFT_SELECT_FOR_SWAP"," th APP-RS0062 One shift must be selected for swap"},
	  	{"REASON_BLANK"," th APP-RS0003 Reason Cannot be blank"},
	  	{"TRANSFER_BLANK"," th APP-RS0047 Transfer cannot be blank"},
	  	{"OVERTIME_ASSIGNMENT_NOT_ALLOWED"," th APP-RS0052 Overtime assignment is not allowed on active shift"},
	  	{"OVERTIME_DURATION_LAPSED"," th APP-RS0053 Duration to assign overtime from start of shift is lapsed"},
	  	{"OVERTIME_DURATION_CLASHES"," th APP-RS0054 Overtime duration clashes with the next shift of the staff"},
	  	{"HR_LESS_TWENTYFOUR"," th HR_LESS_TWENTYFOUR"},
	  	{"OVERTIME_DURATION_NOT_ZERO"," th APP-RS0055 Overtime Duration cannot be zero"},
	  	{"CANNOT_ASSIGN_SHIFT"," th APP-RS0046 Cannot assign the shift"},
	  	{"SHIFT_BLANK"," th APP-RS0044 Shift cannot be blank"},
	  	{"STEP_IN_OVERLAP"," th APP-RS0033 Step In Time overlapped"},
	  	{"STEP_OUT_CANNOT_BLANK"," th APP-RS0028 Step Out Time can not be blank...."},
	  	{"STEP_IN_CANNOT_BLANK"," th APP-RS0027 Step In Time can not be blank...."},
	  	{"STEP_IN_OUT_HOURS_0_TO_23"," th APP-RS0029 StepIn/Out Hours should be between 0 and 23"},
	  	{"STEP_IN_OUT_MINIT_0_TO_59"," th APP-RS0030 StepIn/Out Minutes should be between 0 and 59"},
	  	{"REACHED_END"," th APP-RS0034 Already reached the end"},
	  	{"REACHED_BEGIN"," th APP-RS0035 Already reached the begining"},
	  	{"NO_AXS_FOR_MARK_ATTENDANCE"," th APP-RS0037 User does not have access for mark Attendance"},
	  	{"NO_AXS_FOR_GEN_SCH"," th APP-RS0015 User does not have access to generate schedule"},
	  	{"NO_VALID_SHIFT_ALLOCATION"," th APP-RS0043 No valid shifts found for allocation"},
	  	{"NO_VALID_SHIFTS_CHANGE"," th APP-RS0056 No valid shifts found for Change"},
	  	{"ALREADY_SHIFT_ASSIGNED"," th APP-RS0057 Selected shift is already assigned to the staff"},
	  	{"STAFF1_SHIFT_ALREADY_ASSIGNED_TO_STAFF2_SHIFT"," th APP-RS0065 Selected shift of staff 1 is already assigned to staff 2"},
	  	{"STAFF2_SHIFT_ALREADY_ASSIGNED_TO_STAFF1_SHIFT"," th APP-RS0066 Selected shift of staff 2 is already assigned to staff 1"},
	  	{"STAFF1_SCHEDULE_OVERLAPS_WITH_STAFF2"," th APP-RS0067 Staff 1 existing schedule overlaps with Staff 2 shift to be swapped"},
	  	{"STAFF2_SCHEDULE_OVERLAPS_WITH_STAFF1"," th APP-RS0068 Staff 2 existing schedule overlaps with Staff 1 shift to be swapped"},
	  	{"STAFF_NOT_AVAILABLE"," th APP-RS0038 Staff is not available"},
	  	{"STAFF_SUBSTITUTION_FEATURE_NOT_ENABLED"," th APP-RS0060 Staff substitution feature is not enabled"},
	  	{"EXPIRING_DAYS"," th APP-000001 Expiring Days cannot be blank..."},
	  	{"OPERATING_HOURS_0_TO_23"," th Operating Hours Can be between 0 and 23"},
	  	{"OPERATING_MINUTES_0_TO_59"," th Operating Minutes Can be between 0 and 59"},
	  	{"WORKING_DAYS_FROM_TO_NOT_EQUAL"," th Working Days From and To cannot be Equal"},
	  	{"NON-WORKING_DAYS_FROM_TO_NOT_EQUAL"," th Non-Working Days From and To cannot be Equal"},
		{"ERROR_IN_INSERTING_INTO"," th APP-RS0060 Error in Inserting into "},
		{"FTE_RANGE"," th Range must be from 0 to 1 only..."},
		{"HOLIDAYS_FROM_TO_NOT_SAME"," th Holidays From and To cannot be Same"},
		{"ROLE_TYPE_BLANK"," th APP-000001 Role Type cannot be blank..."}
		
	  	
	  	
	};
}		




