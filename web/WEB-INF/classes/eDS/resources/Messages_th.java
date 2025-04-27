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

public class Messages_th extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {		
		{"DS_TODATE_GRTR_OR_EQL_FRMDATE","th_To Date should be Greater than or equal to From Date"},
		{"DS_FREQ_GRTR_ZERO","th_Frequency Based should be greater than 0"},
		{"DS_FIELD_NOT_EMPTY","th_# cannot be empty"},
		{"DS_MAXLEN_CHARS","th_DS0010 Should not be more than # characters"},
		{"DS_REC_EXISTS","th_Record already exists"},
		{"DS_CANT_SELECT","th_You cannot select this option"},
		{"DS_GRACEPER_INHRS","th_Grace Period Must be in Hours"},
		{"DS_FOODITEM_NOT_BLANK","th_Food Item Cannot be Blank"},
		{"DS_SERVGDATE_LIMIT","th_Serving Date is outside the limit specified in Parameter"},
		{"DS_ATTEN_GRTR_ZERO","th_No of Attendent should be greater than Zero"},
		{"DS_ORDER_TODATE_GRTR_FRMDATE","th_Order To Date should be Greater than or equal to Order Date From "},
		{"DS_REC_EXISTS","th_APP-002005 Record Already Exists"},
		{"DS_ACKDATE_LESS_CURDATE","th_APP-DS0028 Acknowledge Date Time should be less than or equal to Current Date Time"},
		{"DS_ACKDATE_EQL_EVENTDATE","th_APP-DS0027 Acknowledge Date should  be equal to event date"},
		{"DS_INVAL_FRMPATID","th_Invalid From Patient ID"},
		{"DS_INVAL_TOPATID","th_Invalid To Patient ID"},
		{"DS_DUP_ITMSRLNO","th_Duplicate Item Srl Number"},
		{"DS_COMB_NOT_AVAIL","th_Combination Not Available"},
		{"DS_ITMTYPE_NOT_BLANK","th_Item Type Cannot be Blank"},
		{"DS_ITM_NOT_BLANK","th_Item CanNot be Blank"},
		{"DS_QTY_NOT_BLANK","th_Qty. Cannot be Blank"},
		{"DS_MEALTYPE_NOT_BLANK","th_MealType can not be Blank..."},
		{"DS_FOODITM_EXIST","th_This Food Item Is Already Exists"},
		{"DS_SEL_REC_TODEL","th_Please Select Atleast One Record to delete"},
		{"DS_SEL_RECORD","th_APP-DS0019 Select Atleast One Record"},
		{"DS_TODATE_GRTR_FRMDATE","th_To Date Should be greater than from Date"},
		{"DS_SYSERR_XMLHTTPREQ","th_System Error initializing XMLHttpRequest!"},
		{"DS_NUM_ONLY_ALLOWED","th_Numbers Only Allowed"},
		{"DS_FRMDATE_NOT_BLANK","th_From Date Cannot be Blank"},
		{"DS_PERBET_NOT_BLANK","th_Period Between Cannot be Blank"},
		{"DS_FREQ_NOT_BLANK","th_Frequency Cannot be Blank"},
		{"DS_EXCEED_24HRS","th_Specified Frequency and Period Between combination  exceeds 24 hrs so Can not proceed..."},
		{"DS_INVAL_TIMEFORMAT","th_Invalid Time Format"},
		{"DS_HOUR_INVALID","th_Hour must be between 1 and 12"},
		{"DS_INVAL_DATE_TIME_FORMAT","th_Invalid Date/Time Format"},
		{"DS_OPER_COMPLETE","th_APP-DS0001 Operation Completed Successfully..."},
		{"DS_FOODTYPE_NOT_BLANK","th_Food Type Cannot be Blank"},
		{"DS_SEL_MENU","th_Select the Menu"},
		{"DS_ENT_FOODITM","th_Enter the Food Item"},
		{"DS_ENT_QTY","th_Enter the Quantity"},
		{"DS_DUP_RECORD","th_Duplicate Record"},
		{"DS_ITMQTY_NOT_BLANK","th_ItemQty Cannot be Blank"},
		{"DS_REM_NOT_BLANK","th_Remarks cannot be blank"},
		{"DS_INVAL_DATEFMT","th_APP-SM0035 Invalid Date Format"},
		{"DS_SEL_FACILITY","th_Please select a facility"},
		{"DS_DUP_SRLNUM","th_DUPILICATE SERIAL NUMBER"},
		{"DS_DUP_ITMCODE","th_DUPILICATE ITEM CODE"},
		{"DS_SEL_PAT","th_Atleast one patient should be selected"},
		{"DS_SEL_MEALTYPE","th_Atleast One MealType Should be selected for the following appointment/visit:\nAppt No\tEncounter ID"},
		{"DS_UPD_REC","th_Atleast one Record Should be Updated..."},
		{"DS_KIT_NOTAVAIL_FOR_SPEC","th_Kitchen is not setup for the Specialty."},
		{"DS_MTYP_NOTCONFIG_OP","th_Meal Type is not configured for Outpatients."},
		{"DS_REFERTODIET_WITHOUT_DIETORD","th_Do you want to Refer to Dietician without Diet Order for Patient?"},
		{"DS_NURSGUNIT_NOT_BLANK","th_Nursing Unit Can not be blank"},
		{"DS_SEL_ATLEAST_2PAT","th_Atleast 2 patients should be selected for bulk order"},
		{"DS_KIT_NOTSET_FOR_NURSUNIT","th_Kitchen is not setup for the Nursing unit"},
		{"DS_OPER_UNSUCCESS","th_Operation Unsuccessful..."},
		{"DS_CONFIRM_TO_CONT","th_The Changes will not be Saved. Are you sure you wish to continue?"},
		{"DS_ORDERTYP_DUP", "Order Type can not be Duplicate Record"},
		{"DS_DATETIME_NOT_BLANK","th_Date / Time Cannot be Blank"},
		{"DS_STATDAT_VISDAT_SAME","th_Status Date Should be Same as Visit Date."},
		{"DS_NXTMEALPLAN_NOT_BLANK","th_Next Meal Plan No. cannot be blanks"},
		{"DS_GRACEPER_NOT_BLANK","th_Grace Period cannot be blank"},
		{"DS_GRACEPER_NOTGRTR_24","th_Grace Period should not be greater than 24Hrs"},
		{"DS_ORDFRMDATE_LESSOREQL_ORDTODATE","th_APP-NF0004 Order Date From should be less than or equal to Order Date To"},
		{"DS_MEALSER_LESSOREQL_MEALSORDR","th_No. of meals served should be less than or equal to No. of Meals ordered"},
		{"DS_DAT_NOT_BLANK","th_APP-SM0073 Date cannot be blank"},
		{"DS_EVNTDATE_NOT_BLANK","th_APP-SM0073 Event Date cannot be blank"},
		{"DS_DATIME_LESSOREQL_CURDATE","th_Date Time should be less than or equal to Current Date"},
		{"DS_COMPLAINT_NOT_BLANK","th_APP-SM0073 Complaints cannot be blank"},
		{"DS_DUP_NUM","th_Duplicate Order Number"},
		{"DS_SERVDAT_GRTROREQL_CURDAT","th_Serving Date should be greater than or equal to current date"},
		{"DS_NBMTODAT_GRTREQL_FRMDAT","th_Nil By Mouth To date should be greater than or equal to Nil By Mouth From date"},
		{"DS_NBMTODTIM_GRTREQL_FRMDTIM","th_Nil By Mouth To date time should be greater than or equal to Nil By Mouth From date Time"},
		{"DS_NBMFRMDTIM_NOTLES_CURDTIM","th_Nil By Mouth From Date Time should not be less than Current Date Time"},
		{"DS_MENU_NOT_DEFINED","th_DS0004 No menu has been defined"},
		{"DS_DIETFORMEAL_NOT_BLANK","th_Diet Type For Meal cannot be blanks"},
		{"DS_TODAT_GRTREQL_SYSDAT","th_App-DS0011 To Date should be greater than or equals to SysDate"},
		{"DS_FRDAT_GRTREQL_SYSDAT","th_App-DS0011 From Date should be greater than or equals to SysDate"},
		{"DS_DIETCYC_NOT_BLANK","th_Diet Cycle can not be blank For Assign Diet Type"},
		{"DS_FMDAT_SYSDAT_GRACPER","th_From date should be System date for Grace Period Patients"},
		{"DS_FMTODAT_SYSDAT_GRACPER","th_From date and To date should be System date for Grace Period Patients"},
		{"DS_FRDAT_GRTREQL_FRDAT_ORD","th_App-DS0011 From Date should be greater than or equals to From Date of Existing Order"},
		{"DS_ADMTODAT_GRTREQL_FRMDAT","th_Admission To Date should be greater than or equal to Admission From Date"},
		{"DS_REC_NOTSAV_TRYAGN","th_Record has not saved. Please try again"},
		{"DS_HDRREC_NOTSAV_TRYAGN","th_Header Record has not saved. Please try again"},
		{"DS_MORREC_NOTSAV_TRYAGN","th_One or more detail records have not been saved. Please try again"},
		{"DS_ENT_ATLST_ONEREC","th_APP-000008 Atleast One record should be entered"},
		{"DS_AUDREC_NOTSAV_TRYAGN","th_One or more Audit records have not been saved. Please try again"},
		{"DS_REJREC_NOTSAV_TRYAGN","th_One or more Rejected records have not been saved. Please try again"},
		//ML-MMOH-CRF-0730
		{"DS_MEALSERVD_LESSOREQL_TOTMEALSSRVD","No. of meals received should be less than or equal to Total No. of Meals served"},
		{"DS_NOREJECT_LESSOREQL_NOOFORDS","No. of meals rejected should be less than or equal to No. of Orders"},
		{"DS_MEALSERVD_NORECEIVE_NOREJECT","No of meals served, No of meals received, No of meal rejected - Any one field is mandatory"}

	};			
}		  
