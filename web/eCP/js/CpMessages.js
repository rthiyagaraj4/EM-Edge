//This file is saved on 21/12/2005

// *** Automatically Generated Using Java Program *** //

var cpMessageArray;

cpMessageArray = new Array() ;

//  CP Module Messages.
  cpMessageArray["DURATION_CANNOT_ZERO"]= "APP-CP0001 Duration Cannot be Zero" ;
  cpMessageArray["CUTOFF_PERIOD_CANNOT_ZERO"]= "APP-CP0002 CutOff Period Cannot be Zero" ;
  cpMessageArray["CODE_LENGTH_CANNOT_ZERO"]= "APP-CP0003 Code Length Cannot be Zero" ;
  cpMessageArray["SUM_CODELENGTH_MAX_30"]= "APP-CP0004 Sum of all Code Lengths cannot exceed 30" ;
  cpMessageArray["VALUE_GT_ZERO"]= "APP-CP0005 Value must be greater than zero" ;
  cpMessageArray["ONE_FINAL_LIB_VERSION"]= "APP-CP0006 Final version of library already exists" ;
  cpMessageArray["ATLEAST_ONE_PATIENT_CLASS"]= "APP-CP0007 Atleast One patient class to be selected" ;
  cpMessageArray["DEPENDENCY_LEVEL_CANNOT_ZERO"]= "APP-CP0008 Dependency_level cannot be Blank" ;
  cpMessageArray["LIBRARY_BASIS_CANNOT_ZERO"]= "APP-CP0009 Library Basis cannot be Blank" ;
  cpMessageArray["CODELENGTH_LESS"]= "APP-CP0010 Code Length is less" ;
  cpMessageArray["CODE24_GREATER"]= "APP-CP0011 Value should not be greater than 24" ;
  cpMessageArray["APPLY_NOT_VALID"]= "APP-CP0012 Apply is not a valid operation here" ;
  cpMessageArray["DELETE_NOT_VALID"]= "APP-CP0013 Delete is not a valid operation here" ;
  cpMessageArray["HIGHER_LVL_SEL"]= "APP-CP0014 Higher level not selected";
  cpMessageArray["CODELENGTH_MAX_30"]= "APP-CP0015 Code Length cannot be greater than 30" ;
  cpMessageArray["WDAY_NOT_BLANK"]= "APP-CP0016 Working Hours for Working day cannot be blank";
  cpMessageArray["NWDAY_NOT_BLANK"]= "APP-CP0017 Working Hours for Non-Working day cannot be blank";
  cpMessageArray["HDAY_NOT_BLANK"]= "APP-CP0018 Working Hours for Holiday cannot be blank";
  cpMessageArray["LIB_NOT_SELECT"]= "APP-CP0019 No Records Found to List the Plan's Summary";
  cpMessageArray["INTVN_NOT_SELECT"]= "APP-CP0020 Atleast One Intervention should be selected to Plan in Detail";
  cpMessageArray["DETAILIB_NOT_SELECT"]= "APP-CP0021 No Libraries are selected to plan in Detail";
  cpMessageArray["DIAGSTART_LESS_DATE"]= "APP-CP0022 Diagnosis Start Date Should be Less than or equal to Plans Start date";
  cpMessageArray["INTVN_PER_GRP"]= "APP-CP0023 Atleast One Intervention should be selected per Group";
  cpMessageArray["DIAGTARTGET_GREATER_DATE"]= "APP-CP0024 Diagnosis Target Date Should be Greater than or equal to Goal's Target Date";
  cpMessageArray["PTARGET_GREATER_DATE"]= "APP-CP0025 Plan's Target Date Should be Greater than or equal to Diagnosis Target date";
  cpMessageArray["GOALTARGET_GREATER_DATE"]= "APP-CP0026 Goal's Target Date Should be Greater than or equal to Diagnosis Start date";
  cpMessageArray["STANDRD_PLAN_DATE"]= "APP-CP0027 Shall I Standardize the Plan's Target Date with Diagnosis Target Date";
  cpMessageArray["INTVN_START_DATE"]= "APP-CP0028 Intervention cannot start before the Plan's Start Date";
  cpMessageArray["INTVN_END_DATE"]= "APP-CP0029 Intervention's End Date Shoud be Greater than or Equal to Intervention's Start Date";
  cpMessageArray["STANDRDINTVN_PLAN_DATE"]= "APP-CP0030 Shall I Standardize the Plan's Target Date with Intervention's Target Date";
  cpMessageArray["GOAL_PER_DIAGNOSIS"]= "APP-CP0031 Atleast One Goal Per Diagnosis Should be Selected";
  cpMessageArray["LEVEL_NOT_SELECT"]= "APP-CP0032 This level cannot be selected";
  cpMessageArray["INCL_SEL_DIAG"]= "APP-CP0033 Please include selected diagnosis as  part of patient profile and continue";
  cpMessageArray["REMARKS_NOT_BLANK"]= "APP-CP0034 Remarks must be recorded";
  cpMessageArray["VAR_CAUSE_REASON_NOT_BLANK"]= "APP-CP0035 Variance Cause / Variance Reason must be recorded";
  cpMessageArray["VAR_ATLEAST_1_CAUSE_REASON"]= "APP-CP0036 Atleast ONE variance cause must be selected";
  cpMessageArray["ATLEAST_1_VAR_CAUSE_REASON"]= "APP-CP0037 Atleast ONE variance cause, reason must be selected";
  cpMessageArray["REASSESS_INTVL_NOT_ZERO"]= "APP-CP0038 Reassessment Interval must be greater than zero";
  cpMessageArray["ATLEAST_1_INT_1_OUTC"]= "APP-CP0039 Atleast 1 intervetion and 1 outcome must be selected for a group";
  cpMessageArray["RANGE_1_TO_100"]= "APP-CP0040 Valid range for Cut-off score is 1 to 100";
  cpMessageArray["MIN_SCORE_MANDATORY"]= "APP-CP0041 Minimum Score must be entered for all selected dependencies";
 
 
// CP Messages End
function getCpMessage( message_ref ) {
    var message = cpMessageArray[message_ref] ;
    if ( message == null ) message = "Message Not Available" ;
    return message ;
}
