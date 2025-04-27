/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCP.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents;
    }

	static final Object[][] contents = 
	{		
		{"RECORD_INSERTED","APP - CP0001 Operation Completed Successfully......"},
		{"RECORD_MODIFIED","APP - CP0001 Operation Completed Successfully ...."},
		{"RECORD_DELETED","APP - CP0001 Operation Completed Successfully ...."},
		{"TRANSACTION_FAILED","APP - CP0002 Transaction Failed to commit"},
		{"CAN_NOT_BE_EXEED","APP-CP0003 Explanatory Text Length cannnot be more than 400"},
		{"TERMSET_MUST_BE_SELECT","APP-CP0004 Terminology Set must be selected"},
		{"VALUE_GT_ZERO","APP-CP0005 Value must be greater than zero"},
		{"ONE_FINAL_LIB_VERSION","APP-CP0006 Final version of library already exists"},
		{"ATLEAST_ONE_PATIENT_CLASS","APP-CP0007 Atleast One patient class to be selected"},
		{"DEPENDENCY_LEVEL_CANNOT_ZERO","APP-CP0008 Dependency_level cannot be Blank"},
		{"LIBRARY_BASIS_CANNOT_ZERO","APP-CP0009 Library Basis cannot be Blank"},		
		{"ABS_QTY_CANNOT_ZERO","APP - CP0010 Order Quantity cannot be zero or blank"},
		{"NUM_ALLOWED","APP-CP0011 Only numbers are allowed"},
		{"APPLY_NOT_VALID","APP-CP0012 Apply is not a valid operation here"},
		{"INVALID_DATE_TIME","APP-CP0013 Invalid Data Time..."},
		{"NO_INTERVENTION_TO_RECORD","APP-CP0014 No Interventions to record in Detail"},
		{"NO_RECORD_FOUND","APP-CP0015 No Records Found to Plan Summary"},
		{"NO_INTERVENTION_SELECTED","APP-CP0016 No Interventions are selected to Plan in Detail"},
		{"NO_STD_CP_AVAIL","APP-CP0017 No Standard Care Plans Available"},		
		{"LENGTH_CANT_EXCEED","APP-CP0018 Explanatory Text Length cannnot be more than 4000"},
		{"REASSESS_INTVL_NOT_ZERO","APP-CP0019 Reassessment Interval must be greater than zero"},
		{"ATLEAST_1_INT_1_OUTC","APP-CP0020 Atleast 1 intervetion and 1 outcome must be selected for a group"},
		{"RANGE_1_TO_100","APP-CP0021 Valid range for Cut-off score is 1 to 100"},
		{"ERROR_IN_INSERTING_INTO","APP-CP0022 Atleast one record shold be selected or Some other errors while Inserting"},
		{"TO_DT_GR_EQ_FM_DT","APP-CP0024 To Date Must Be Greater Than Or Equal To From Date"},
		{"DETAILIB_NOT_SELECT","APP-CP0025 No Libraries are selected to plan in Detail"},
		{"INTVN_NOT_SELECT","APP-CP0026 Atleast One Intervention should be selected to Plan in Detail"},
		{"INTVN_PER_GRP","APP-CP0027 Atleast One Intervention/Outcome should be selected per Group"},
		{"INTVN_ACHIEVE_GOAL","APP-CP0028 Atleast One Intervention should be selected to achieve the goal"},
		{"DIAGTARTGET_GREATER_DATE","APP-CP0029 Diagnosis Target Date Should be Greater than or equal to Goal's Target Date"},
		{"PTARGET_GREATER_DATE","APP-CP0030 Plan's Target Date Should be Greater than or equal to Diagnosis Target date"},
		{"DIAGSTART_LESS_DATE","APP-CP0031 Diagnosis Start Date Should be Less than or equal to Plans Start date"},
		{"GOALTARGET_GREATER_DATE","APP-CP0032 Goal's Target Date Should be Greater than or equal to Diagnosis Start date"},
		{"INTVN_START_DATE","APP-CP0033 Intervention cannot start before the Plan's Start Date"},
		{"INTVN_END_DATE","APP-CP0034 Intervention's End Date Shoud be Greater than or Equal to Intervention's Start Date"},
		{"GOAL_PER_DIAGNOSIS","APP-CP0035 Atleast One Goal Per Diagnosis Should be Selected"},
		{"LENGTH_CANNOT_4000","APP-CP0036 Length Can Not Exceed 4000 characters"},
		{"REMARKS_NOT_BLANK","APP-CP0037 Remarks must be recorded"},
		{"CODE24_GREATER","APP-CP0038 Value should not be greater than 24"},
		{"WDAY_NOT_BLANK","APP-CP0039 Working Hours for Working day cannot be blank"},
		{"NWDAY_NOT_BLANK","APP-CP0040 Working Hours for Non-Working day cannot be blank"},
		{"HDAY_NOT_BLANK","APP-CP0041 Working Hours for Holiday cannot be blank"},
		{"EXCEED_MAX_LENGTH","APP-CP0042 Exceeds maximum length"},
		{"DURATION_CANNOT_ZERO","APP-CP0043 Duration Cannot be Zero"},
		{"VAR_CAUSE_REASON_NOT_BLANK","APP-CP0044 Variance Cause / Variance Reason must be recorded"},
		{"VAR_ATLEAST_1_CAUSE_REASON","APP-CP0045 Atleast ONE variance cause must be selected"},
		{"ATLEAST_1_VAR_CAUSE_REASON","APP-CP0046 Atleast ONE variance cause, reason must be selected"},
		{"START_DT_AND_DURN_MUST_ENTER","APP-CP0047 Start Date and Duration must be entered"},
		{"INVALID_DATE_TIME","APP-CP0048 Date and Time is not Valid"},
		{"END_DT_SHOULD_GT_START_DT","APP-CP0049 End Date Should be Greater than Start Date"},
		{"START_DT_SHOULD_GT_SYS_DT","APP-CP0050 Start Date Should be Greater than System Date"},
		{"LENGTH_CANT_EXCEED_200","APP-CP0051 $ Length cannnot be more than 200"},
		{"INCL_DIAG_INTO_PAT_PROFILE","APP-CP0052 Please include selected diagnosis as  part of patient profile and continue"},
		{"CANT_ZERO_OR_NEG_NUM","APP-CP0053 $ Cannot be Zero or Negative Number"},
		{"EVAL_MEAS_NOT_ASSOC_GOAL","APP-CP0054 Evaluation Measures are not associated to the Goal"},
		{"EVAL_MEAS_NOT_ASSOC_OUTCOME","APP-CP0055 Evaluation Measures are not associated to the Outcome"},
		{"EVAL_MEAS_NOT_ASSOC_TERMCODE","APP-CP0056 Evaluation Measures are not associated to the Terminology Code"},
		{"MIN_SCORE_MANDATORY","APP-CP0023 Minimum Score must be entered for all selected dependencies"},
		{"TERM_SET_MANDATORY","APP-CP0057 Atleast one Measure should be associated with the Terminology Set..."} //LICN_1
	};
}		




