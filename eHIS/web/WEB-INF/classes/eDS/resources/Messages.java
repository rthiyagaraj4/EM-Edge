/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = { 	
		{"DS_TODATE_GRTR_OR_EQL_FRMDATE","To Date should be Greater than or equal to From Date"},
		{"DS_FREQ_GRTR_ZERO","Frequency Based should be greater than 0"},
		{"DS_FIELD_NOT_EMPTY","# cannot be empty"},
		{"DS_MAXLEN_CHARS","DS0010 Should not be more than # characters"},
		{"DS_REC_EXISTS","Record already exists"},
		{"DS_CANT_SELECT","You cannot select this option"},
		{"DS_GRACEPER_INHRS","Grace Period Must be in Hours"},
		{"DS_FOODITEM_NOT_BLANK","Food Item Cannot be Blank"},
		{"DS_SERVGDATE_LIMIT","# is outside the limit specified in Parameter"},//Modified for GDOH-CRF-0083
		{"DS_ATTEN_GRTR_ZERO","No of Attendent should be greater than Zero"},
		{"DS_ORDER_TODATE_GRTR_FRMDATE","Order To Date should be Greater than or equal to Order Date From "},
		{"DS_REC_EXISTS","APP-002005 Record Already Exists"},
		{"DS_ACKDATE_LESS_CURDATE","APP-DS0028 Acknowledge Date Time should be less than or equal to Current Date Time"},
		{"DS_ACKDATE_EQL_EVENTDATE","APP-DS0027 Acknowledge Date should  be equal to event date"},
		{"DS_INVAL_FRMPATID","Invalid From Patient ID"},
		{"DS_INVAL_TOPATID","Invalid To Patient ID"},
		{"DS_DUP_ITMSRLNO","Duplicate Item Srl Number"},
		{"DS_COMB_NOT_AVAIL","Combination Not Available"},
		{"DS_ITMTYPE_NOT_BLANK","Item Type Cannot be Blank"},
		{"DS_ITM_NOT_BLANK","Item CanNot be Blank"},
		{"DS_QTY_NOT_BLANK","Qty. Cannot be Blank"},
		{"DS_MEALTYPE_NOT_BLANK","MealType can not be Blank..."},
		{"DS_FOODITM_EXIST","This Food Item Is Already Exists"},
		{"DS_SEL_REC_TODEL","Please Select Atleast One Record to delete"},
		{"DS_SEL_RECORD","APP-DS0019 Select Atleast One Record"},
		{"DS_TODATE_GRTR_FRMDATE","To Date Should be greater than from Date"},
		{"DS_SYSERR_XMLHTTPREQ","System Error initializing XMLHttpRequest!"},
		{"DS_NUM_ONLY_ALLOWED","Numbers Only Allowed"},
		{"DS_FRMDATE_NOT_BLANK","From Date Cannot be Blank"},
		{"DS_PERBET_NOT_BLANK","Period Between Cannot be Blank"},
		{"DS_FREQ_NOT_BLANK","Frequency Cannot be Blank"},
		{"DS_EXCEED_24HRS","Specified Frequency and Period Between combination  exceeds 24 hrs so Can not proceed..."},
		{"DS_INVAL_TIMEFORMAT","Invalid Time Format"},
		{"DS_HOUR_INVALID","Hour must be between 1 and 12"},
		{"DS_INVAL_DATE_TIME_FORMAT","Invalid Date/Time Format"},
		{"DS_OPER_COMPLETE","APP-DS0001 Operation Completed Successfully..."},
		{"DS_FOODTYPE_NOT_BLANK","Food Type Cannot be Blank"},
		{"DS_SEL_MENU","Select the Menu"},
		{"DS_ENT_FOODITM","Enter the Food Item"},
		{"DS_ENT_QTY","Enter the Quantity"},
		{"DS_DUP_RECORD","Duplicate Record"},
		{"DS_ITMQTY_NOT_BLANK","ItemQty Cannot be Blank"},
		{"DS_REM_NOT_BLANK","Remarks cannot be blank"},
		{"DS_INVAL_DATEFMT","APP-SM0035 Invalid Date Format"},
		{"DS_SEL_FACILITY","Please select a facility"},
		{"DS_DUP_SRLNUM","DUPILICATE SERIAL NUMBER"},
		{"DS_DUP_ITMCODE","DUPILICATE ITEM CODE"},
		{"DS_SEL_PAT","Atleast one patient should be selected"},
		{"DS_SEL_MEALTYPE","Atleast One MealType Should be selected for the following appointment/visit:\nAppt No\tEncounter ID"},
		{"DS_SEL_MEALTYPE_EM","Atleast One MealType Should be selected for the following patient(s):\nPatient ID\tEncounter ID"},
		{"DS_UPD_REC","Atleast one Record Should be Updated..."},
		{"DS_KIT_NOTAVAIL_FOR_SPEC","Kitchen is not setup for the Specialty."},
		{"DS_MTYP_NOTCONFIG_OP","Meal Type is not configured for Outpatients."},
		{"DS_MTYP_NOTCONFIG_EM","Meal Type is not configured for Emergency patients."},
		{"DS_REFERTODIET_WITHOUT_DIETORD","Do you want to Refer to Dietician without Diet Order for Patient?"},
		{"DS_NURSGUNIT_NOT_BLANK","Nursing Unit Cannot be blank"},
		{"DS_SEL_ATLEAST_2PAT","Atleast 2 patients should be selected for bulk order"},
		{"DS_KIT_NOTSET_FOR_NURSUNIT","Kitchen is not setup for the Nursing unit"},
		{"DS_OPER_UNSUCCESS","Operation Unsuccessful..."},
		{"DS_CONFIRM_TO_CONT","The Changes will not be Saved. Are you sure you wish to continue?"},
		{"DS_ORDERTYP_DUP", "Order Type can not be Duplicate Record"},
		{"DS_DATETIME_NOT_BLANK","Date / Time Cannot be Blank"},
		{"DS_STATDAT_VISDAT_SAME","Status Date Should be Same as Visit Date."},
		{"DS_NXTMEALPLAN_NOT_BLANK","Next Meal Plan No. cannot be blanks"},
		{"DS_GRACEPER_NOT_BLANK","Grace Period cannot be blank"},
		{"DS_GRACEPER_NOTGRTR_24","Grace Period should not be greater than 24Hrs"},
		{"DS_ORDFRMDATE_LESSOREQL_ORDTODATE","APP-NF0004 Order Date From should be less than or equal to Order Date To"},
		{"DS_MEALSER_LESSOREQL_MEALSORDR","No. of meals served should be less than or equal to No. of Meals ordered"},
		{"DS_DAT_NOT_BLANK","APP-SM0073 Date cannot be blank"},
		{"DS_EVNTDATE_NOT_BLANK","APP-SM0073 Event Date cannot be blank"},
		{"DS_DATIME_LESSOREQL_CURDATE","Date Time should be less than or equal to Current Date"},
		{"DS_COMPLAINT_NOT_BLANK","APP-SM0073 Complaints cannot be blank"},
		{"DS_DUP_NUM","Duplicate Order Number"},
		{"DS_SERVDAT_GRTROREQL_CURDAT","Serving Date should be greater than or equal to current date"},
		{"DS_NBMTODAT_GRTREQL_FRMDAT","Nil By Mouth To date should be greater than or equal to Nil By Mouth From date"},
		{"DS_NBMTODTIM_GRTREQL_FRMDTIM","Nil By Mouth To date time should be greater than or equal to Nil By Mouth From date Time"},
		{"DS_NBMFRMDTIM_NOTLES_CURDTIM","Nil By Mouth From Date Time should not be less than Current Date Time"},
		{"DS_MENU_NOT_DEFINED","DS0004 No menu has been defined"},
		{"DS_DIETFORMEAL_NOT_BLANK","Diet Type For Meal cannot be blanks"},
		{"DS_TODAT_GRTREQL_SYSDAT","App-DS0011 To Date should be greater than or equals to SysDate"},
		{"DS_FRDAT_GRTREQL_SYSDAT","App-DS0011 From Date should be greater than or equals to SysDate"},
		{"DS_DIETCYC_NOT_BLANK","Diet Cycle can not be blank For Assign Diet Type"},
		{"DS_FMDAT_SYSDAT_GRACPER","From date should be System date for Grace Period Patients"},
		{"DS_FMTODAT_SYSDAT_GRACPER","From date and To date should be System date for Grace Period Patients"},
		{"DS_FRDAT_GRTREQL_FRDAT_ORD","App-DS0011 From Date should be greater than or equals to From Date of Existing Order"},
		{"DS_ADMTODAT_GRTREQL_FRMDAT","Admission To Date should be greater than or equal to Admission From Date"},
		{"DS_REC_NOTSAV_TRYAGN","Record has not saved. Please try again"},
		{"DS_HDRREC_NOTSAV_TRYAGN","Header Record has not saved. Please try again"},
		{"DS_MORREC_NOTSAV_TRYAGN","One or more detail records have not been saved. Please try again"},
		{"DS_ENT_ATLST_ONEREC","APP-000008 Atleast One record should be entered"},
		{"DS_AUDREC_NOTSAV_TRYAGN","One or more Audit records have not been saved. Please try again"},
		{"DS_REJREC_NOTSAV_TRYAGN","One or more Rejected records have not been saved. Please try again"},
		{"DS_UNABLE_PLACE_ORDER","Unable to place meal order as the Appointment/Visit details do not match for the following Appointment/Visit: \nAppt No  Encounter ID"},
		{"DS_UNABLE_PLACE_ORDER_EM","Unable to place meal order as the Visit details do not match for the following patients: \nPatient ID\tEncounter ID"},
		{"DS_OVERRIDE_MEALORDER","Meal Order has already been placed for the following appointment/visit. Saving the changes will override the previous meal order. Are you sure you wish to continue?\nAppt No\tEncounter ID"},
		{"DS_OVERRIDE_MEALORDER_EM","Meal Order has already been placed for the following patients. Saving the changes will override the previous meal order. Are you sure you wish to continue?\nPatient ID\t\tEncounter ID"},
		{"DS_NEW_PRF_CREATD","New profile is created, this will be effective from"},
		{"DS_DISCARD_CHANGES","The Changes in the Place Diet Order and/or Edit Menu screens will not be Saved. Are you sure you wish to continue?"}, // AAKH-CRF-0065
		{"DS_SHOULD_BE_WITHIN","# should be within # to #"},//MMOH-CRF-0427
		{"DS_SHOULD_BE_AFTER_BEFORE","# should be after # and before #"},//MMOH-CRF-0409
		{"DS_MAX_SERVING_RANGE","Serving Date Range should be maximum 7 days"},//GDOH-CRF-083
		{"DS_IRREGULAR_SHOULD_BE_BEFORE","Late/Irregular Diet Order End Time Should be before"},//ML-MMOH-CRF-0409
		{"DS_AUTOMATIC_REMOVE_IRREGULAR_TIME","Serving Start/End Time has been removed. Saving the meal type without Serving Start/End Time will automatically remove the Late/Irregular Diet Order Start/End Time. Do you wish to continue?"},//ML-MMOH-CRF-0409
		{"DS_IRREGULAR_DIET_ORDER","Late/Irregular Diet Order on # for the Meal: "},//ML-MMOH-CRF-0409
		{"DS_MAX_ATTENDANT_ALLOWED","Maximum # Orders Allowed (For Each Day) should be minimum 1 and maximum 9"},//ML-MMOH-CRF-412
		//{"DS_MAX_ATTENDANT_FOR_DAY","Maximum # # allowed for each day.\nCannot add # for the dates:"}//ML-MMOH-CRF-412 
		{"DS_MAX_ATTENDANT_FOR_DAY","# cannot be added. You have exceeded the allowed number of #s # for one or more Diet Date(s)."},
		//ML-MMOH-CRF-412 
		{"DS_KITCHEN_NURSING_UNIT","APP-DS0012 Either Kitchen or Nursing unit should be selected"},//MMS-QH-CRF-0079
		{"DS_UNSAVED_CHANGE_LOST","Unsaved changes will be lost. Do you wish to continue?"},
		//ML-MMOH-CRF-0423
		{"DS_SERVDAT_NOT_GRTR_CURDAT","Serving Date should be Less than or equal to current date"},
		{"DS_SERVDAT_NOT_BLANK","Serving Date Cannot be Blank"},
		//ML-MMOH-CRF-0423
		{"DS_DEFAULT_DIET_REQUEST_LOC_CHECK","Default diet location is already available"},
		//ML-MMOH-CRF-0730
		{"DS_MEALSERVD_LESSOREQL_TOTMEALSSRVD","No. of meals received should be less than or equal to Total No. of Meals served"},
		{"DS_NOREJECT_LESSOREQL_NOOFORDS","No. of meals rejected should be less than or equal to No. of Orders"},
		{"DS_MEALSERVD_NORECEIVE_NOREJECT","No of meals served, No of meals received, No of meal rejected - Any one field is mandatory"},
		//KDAH-CRF-0359.1
		{"DS_EXISTING_ITEM_CHECK","Existing item cannot be blank"},
		{"DS_NEW_ITEM_CHECK","New item cannot be blank"},
		//Added against ML-MMOH-CRF-0599
		{"DS_MEAL_REJ_DATE","APP-DS0013 From Date Should be less than or equal to Sysdate"},
		{"DS_MEAL_REJ_TO_DATE","APP-DS0014 To Date Should be less than or equal to Sysdate"},
		{"DS_MEAL_DIFF_DAYS","APP-DS0015 Difference between from date and to date should not be more than 31 Days"},
		//Added against ML-MMOH-CRF-0599
	
		//Added against ML-MMOH-CRF-0672 
		{"DS_ALA_CARTE_ORDER","APP-DS0016 Patient is entitled for an \"Ala Carte Order (Special Food Items)\""},
		//Added against ML-MMOH-CRF-0598 starts Here
		{"DS_FROM_TO_DATE_NOT_BLANK","APP-DS0017 From and To date cannot be blank"},
		{"DS_PATIENT_CLASS_NOT_BLANK","APP-DS0018 Patient Class cannot be blank"},
		{"DS_FROMDATE_NOT_GTN_TODATE","APP-DS0019 From date cannot be greater than To date"},
		//Added against ML-MMOH-CRF-0598 Ends Here		

		//ML-MMOH-CRF-0675
		{"DS_MEAL_CATEGORY","APP-DS0020 Meal Category cannot be blank"},
		//ML-MMOH-CRF-0684
		{"DS_MENU_TYPE","APP-DS0021 Menu Type cannot be blank"},
		{"DS_MEAL_PROD","APP-DS0022 Date Should not be less than Current Date."},//ML-MMOH-CRF-0680
		{"DS_PROD_DATE","APP-DS0023 Date Cannot be blank"},	//ML-MMOH-CRF-0680
		{"DS_FROM_DATE","APP-DS0024 From Date Cannot be blank"},//ML-MMOH-CRF-0599
		{"DS_TO_DATE","APP-DS0025 To Date Cannot be blank"},	//ML-MMOH-CRF-0599
		{"DS_STATUS_IP_OP_EM","APP-DS0026 At least one status for IP and OP/EM need to select for \"Allow place diet order\""},//ML-MMOH-CRF-0600
		{"DS_DEL_STATUS","APP-DS0027 Are You Sure Do You Want to Delete Existing Records"},//ML-MMOH-CRF-0832
		{"DS_MEAL_DIFFS_DAYS","APP-DS0029 Difference between from date and to date should not be more than 90 Days"},//ML-MMOH-CRF-0685 & ML-MMOH-CRF-0687
		{"DS_DTYPE_DIFF_OBDIET","APP-DS0030 At least one assigned diet type should match with the Diet Type"},
		{"DS_MEALTYPES_NOT_BLANK","MealTypes Cannot be Blank"},//ML-MMOH-CRF-1060
		{"DS_MENU_NOT_DEFINED_MC_DT","APP-DS0004 No menu has been defined for Selected Meal Class and Diet Type Combination"},//ML-MMOH-CRF-1124
		{"DS_PLACEORDER_NOT_BLANK","Place Order For Cannot be blank"},//ML-MMOH-CRF-1123
		{"DS_DETAIL_REPORT_FOR_EXCEL","APP-DS0031 Excel Option should be chosen to view Detailed report"}, //KDAH-CRF-0353
		{"DS_REASON_NOT_BLANK","APP-DS0032 Reason For Cancellation cannot be blank"},//PMG2013-CRF-0009.1
		{"DS_ORDER_DATE_NOT_BLANK","APP-DS0033 Order Date cannot be empty"},//Added By Santhosh for ML-MMOH-CRF-1961
		{"DS_AUTHORIZED_DATE_NOT_BLANK","APP-DS0034 Authorized Date/Time cannot be empty"}//Added By Santhosh for ML-MMOH-CRF-1961
	};
}