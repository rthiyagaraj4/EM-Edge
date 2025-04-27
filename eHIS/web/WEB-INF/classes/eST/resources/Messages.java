/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved. 
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*  
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016				57461					B.Badmavathi									  Query mode for Product Transfer\Repackaging					
26/04/2016				56060					Badmavathi B					  				  PMG2015-CRF-INT-ST-0001(Use 'Authorize at Issue Store' privilege to Authorize)	
26/07/2016				60402					Badmavathi B					  				  ML-BRU-SCF-1686 - Parent Store and Item Class Combination	
26/10/2016				62242					B.Badmavathi									  Expired Batch and Invalid Barcode
06/02/2017				63027					Badmavathi B									  GHL-CRF-0413.7 - US009 - Barcode search
09/05/2017				IN062881				B.Badmavathi								      PO Mandatory in GRN 
29/05/2017				IN063673				Badmavathi B									  GHL-SCF-1169  - 'Process Expired Batches'-> unchecked , 'Use After Expiry' -> checked 
08/06/2017				IN064208				Badmavathi B									  GHL-CRF-0464
24/08/2017				IN064209				Soorya Prakash M								GHL-CRF-0465
27/11/2017				IN065672				Chandra											PMG2017-SS-CRF-0002
27/08/2019              IN071167                B Haribabu                                        GHL-ICN-0050
10/10/2019              IN:071343              B Haribabu                                         GHL-CRF-0608
31/10/2019              IN:071344              B Haribabu           31/10/2019         Manickam   GHL-CRF-0609	
31/12/2020				TFS-8224      		     Prabha      		31/12/2020		Manickam	  MMS-DM-CRF-0177
05/02/2021      TFS id:6938                     B Haribabu          05/02/2021       Manickam           MMS-DM-CRF-0174.3
13/5/2021				TFS:14012				Shazana												MO-CRF-20165
05/07/2021		TFS id:-19018       			Prabha	 			 16/06/2021	   Manicakavasagam	AMS-CRF-0258
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package eST.resources;

import java.util.*; 

public class Messages extends ListResourceBundle implements java.io.Serializable
{

	public Object[][] getContents() 
	{
         return contents; 
    }

	static final Object[][] contents = 
	{		
		{"INVALID_ITEM_CODE",				 "APP-ST0001 Invalid Item Code"},
		{"STORE_NOT_FOUND",					 "APP-ST0002 Store not found"},
		{"MIN_CANNOT_EXCEED_MAX",			 "APP-ST0003 Minimum Stock quantity cannot exceed Maximum Stock quantity"},
		{"REORDER_CANNOT_EXCEED_MAX",		 "APP-ST0004 Reorder Level cannot be greater than Maximum Stock quantity"},
		{"REORDER_CANNOT_LESS_THAN_MIN",	 "APP-ST0005 Reorder Level cannot be less than Minimum Stock quantity"},
		{"NO_CONV_FACTOR_FOR_UOM_CODE",		 "APP-ST0006 Conversion Factor is not available for the Sale UOM"},
		{"QOH_CANNOT_CHANGE_STOCK_ITEM",	 "APP-ST0007 Quantity on hand is greater than 0, cannot change Stock Item Status"},
		{"PHY_INV_CANT_CHANGE_STK_ITEM",	 "APP-ST0008 Physical Inventory is in progress, cannot change Stock Item Status"},
		{"INVALID_STORE_CODE",				 "APP-ST0010 Invalid Store Code"},
		{"INVALID_STERILE_TYPE",			 "APP-ST0011 Invalid Sterile Type"},
		{"LESS_OR_EQUAL_VALIDATE",			 "APP-ST0012 From @ should be less than or equal to To @"},
		{"ITEM_CODE_ALREADY_EXIST",			 "APP-ST0013 Item Code Already Exist"},
		{"QUANTIY_MUST_BE_EQUAL",			 "APP-ST0014 Sum of Batch Qty Must be equal to Item Quantity"},
		{"STORE_CANNOT_BE_BLANK",			 "APP-ST0015 Store cannot be blank"},
		{"ITEM_ANLSIS_UNIQUE",				 "APP-ST0002 Item Analysis Code should be unique"},                    
		{"REQ_BY_ITEM_STORE_NOT_FOUND",		 "APP-ST0016 Requested by Store and Item combination does not exist"},
		{"REQ_ON_ITEM_STORE_NOT_FOUND",		 "APP-ST0017 Requested on Store and Item combination does not exist"},
		{"REQ_ON_REQ_BY_CANNOT_BE_SAME",	 "APP-ST0018 Requested on Store cannot be same as Requested by Store"},
		{"ST_DOC_DT_NOT_LT_PROC_MTH",		 "APP-ST0019 Document Date should not be less than Processing Period"},
		{"ST_ASMB_CHILD_ITEM_NOT_SAME",		 "APP-ST0020 Child Item  cannot be same as Item"},
		{"ST_ASMB_ITEM_NOT_BLANK",			 "APP-ST0021 Item cannot be blank"},
		{"ST_NO_CONV_FACTOR_MFG_UOM_CODE",	 "APP-ST0022 Conversion Factor is not available for the MFG UOM"},
		{"MIN_ONE_CHILD_ITEM_REQD",			 "APP-ST0023 Atleast One Child Item  Record Must be there"},
		{"DATE_NOT_BLANK",				     "APP-ST0024 Date cannot be blank"},		
		{"BATCH_ID_NOT_BLANK",				 "APP-ST0025 Batch ID cannot be blank"},
		{"TRADE_ID_NOT_BLANK",				 "APP-ST0026 Trade ID cannot be blank"},
		{"BIN_LOCN_NOT_BLANK",				 "APP-ST0027 Bin Location cannot be blank"},
		{"TRADE_NOT_ASS_FOR_ITEM",			 "APP-ST0028 Trade Name not associated for the item"},
		{"BIN_LOCN_NOT_ASS_FOR_STORE",		 "APP-ST0029 Bin Location not associated for the Store"},
		{"REQ_QTY_NOT_GR_PEND_QTY",			 "APP-ST0030 Authorize Quantity Cannot be greater than Available Quantity"},
		{"ST_CANT_ENTER_MORE",				 "APP-ST0031 Cannot enter more than "},
		{"ST_ITEM_CODE_BLANK",				 "APP-ST0032 Item Code cannot be blank"},
		{"ST_STORE_CODE_BLANK",				 "APP-ST0033 Requesting Store  cannot be blank"},
		{"TO_AND_FM_BIN_LOC_NOT_SAME",		 "APP-ST0034 New bin location should not be same as old bin location"},
		{"TFR_QTY_LESS_THAN_AVL_QTY",		 "APP-ST0035 Quantity should be less or equal to available quantity"},
		{"QTY_TO_TFER_NOT_BLANK",			 "APP-ST0036 Quantity to transfer cannot be blank"},
		{"NEGATIVE_STOCK",					 "APP-ST0037 Insufficient Stock"},
		{"ITEM_IS_SUSPENDED",				 "APP-ST0038 The selected Item is suspended"},
		{"DUPLICATE_IN_OPENING_STOCK",		 "APP-ST0039 Duplicate Entries are not allowed in Opening stock"},
		{"INSUFFICIENT_BATCH_QTY",			 "APP-ST0040 Insufficient batch quantity"},
		{"NOT_LESS_THAN_SYSDATE",			 "APP-ST0041 Date cannot be less than System date"},
		{"ITEM_STORE_NOT_FOUND",			 "APP-ST0042 Item Store combination does not exist"},
		{"STOCK_NOT_AVAILABLE",				 "APP-ST0043 Stock is not available for this Item"},
		{"NOT_STOCK_ITEM",					 "APP-ST0044 Item is not a stock Item"},
		{"QTY_NOT_GRT_AVLQTY",				 "APP-ST0045 Transaction Quantity cannot be greater than Available Quantity"},
		{"BATCH_DTL_ALREADY_EXIST",			 "APP-ST0046 Batch Detail already exists"},
		{"ST_DOC_DT_NOT_GR_SYSDATE",		 "APP-ST0047 Date cannot be greater than System Date"},
		{"ENTITY_PARAM_NOT_SET",			 "APP-ST0048 Entity Parameter is not set"},
		{"MEDICAL_NON_MEDICAL_CHECKED",		 "APP-ST0049 Either Medical Item or Non-Medical Item has to be checked"},
		{"ATLEAST_ONE_TRANS",				 "APP-ST0050 Atleast one transaction has to be checked"},
		{"STORE_ALRDY_EXISTS",				 "APP-ST0051 Store already exists"},
		{"PHY_COUNT_CANT_EXCEED_MAX",		 "APP-ST0052 Physical Year Count cannot exceed Physical Count Per Year"},
		{"TO_AND_FM_ITEM_NOT_SAME",		     "APP-ST0053 From item should not be same as To item"},
		{"REORDER_QTY_CANNOT_EXCEED_MAX",	 "APP-ST0054 Reorder Qty cannot be greater than Maximum Stock quantity"},
		{"MIN_LVL_CANT_EXCEED_MAX_LEVEL",	 "APP-ST0055 Min Stk Level cannot be greater than Max Stk Level"},
		{"MIN_SAL_CANT_EXCEED_MAX_LVL",	     "APP-ST0056 Min Sales Qty cannot be greater than Max Stk Level"},
		{"BOTH_ITEM_EXP_OR_NON_EXP",	     "APP-ST0057 Both the item should be either expired or non expired item"},
		{"ITEM_CONV_FACTOR_BLANK",	         "APP-ST0058 Item Conversion factor cannot be blank"},
		{"QTY_NOT_GRT_ISSQTY",	             "APP-ST0059 Transaction Quantity cannot be greater than Issued Quantity"},
		{"MIN_ONE_RET_QTY_REQD",	         "APP-ST0060 Minimum one transaction must have Return Quantity"},
		{"BATCH_SELECT_MANDATORY",	         "APP-ST0061 Batch selection mandatory"},
		{"INVALID_DRUG_CODE",				 "APP-ST0062 Invalid Drug Code"},
		{"REMARKS_CHAR_EXCEEDS_LIMIT",		 "APP-ST0063 Remarks field cannot exceed 200 characters"},
		{"BATCH_DETAILS_NOT_BLANK",		     "APP-ST0064 Batch Details cannot be blank"},
		{"OPENING_STOCK_DUPLICATE_ITEM",	 "APP-ST0065 Opening Stock has already been entered for this item-store combination"},
		{"MIN_ONE_ITEM_REQD",	             "APP-ST0066 Atleast One Item Record Must be there"},
		{"BOTH_STORE_CANNOT_BE_SAME",	     "APP-ST0067 From store and To store cannot be same"},
		{"TO_BIN_LOC_NOT_BLANK",			 "APP-ST0068 To bin location code cannot be blank"},
//		{"STOCK_ITEM_FLAG_CHANGED",			 "APP-ST0069 The stock item flag has been changed"},
		{"STOCK_ITEM_FLAG_CHANGED",			 "APP-ST0069 The Item is not a Stock Item"},
		{"BATCH_RECORD_NOT_FOUND",			 "APP-ST0070 Batch record not found"},
		{"SUSPENDED_BATCH",					 "APP-ST0071 Suspended batch"},
		{"MAX_RET_QTY_ZERO",				 "APP-ST0072 Zero quantity available to return"},
		{"RET_QTY_NOT_GRT_MAX_RET_QTY",		 "APP-ST0073 Return Qty cannot be greater than Max Returnable Qty"},
		{"RET_QTY_CANNOT_BLANK",			 "APP-ST0074 Return qty cannot be blank"},
		{"VALUE_CANNOT_BE_BLANK",			 "APP-ST0075 Value cannot be blank"},
		{"REQ_QTY_CANNOT_BE_ZERO",			 "APP-ST0076 Request qty cannot be zero"},
		{"ITEM_OR_ITEM_CLASS_MANDATORY",	 "APP-ST0078 Item / Item Class cannot be blank"},
		{"OPER_CANCELLED",					 "APP-ST0079 Operation Cancelled"},
		{"BATCH_REFRESHED",					 "APP-ST0080 Batch data will be refreshed"},
		{"PREP_TYPE_DO_NOT_MATCH",			 "APP-ST0081 Preparation type does not match for the  item"},
		{"PREP_MODE_DO_NOT_MATCH",			 "APP-ST0082 Preparation mode does not match for the  item"},
		{"COMP_QTY_NOT_GRT",				 "APP-ST0083 Component for qty cannot be greater than"},
		{"FACILITY_PARAM_NOT_SET",			 "APP-ST0084 Facility Parameter is not set"},
		{"INVALID_SLOT_VALUE",				 "APP-ST0085 Invalid Slot Value"},
		{"BATCH_QTY_NOT_GRT",				 "APP-ST0086 Batch Qty cannot be greater than Quantity"},
		{"USER_SEARCH_MANDATORY",			 "APP-ST0087 Invalid User, click search button"},
		{"VALUE_NOT_FOUND_FOR_REPORT",		 "APP-ST0088 There is an overlap of parameters with an existing physical count"},
		{"INVAL_PERIOD_END_DATE",		     "APP-ST0089 Cannot be processed within the current period"},	      
		{"NO_CONV_FAC_FOR_PUR_UOM_CODE",	 "APP-ST0090 Conversion Factor is not available for the Purchase UOM"},
		{"PHY_INV_PROCESS_INITIATED",		 "APP-ST0091 Physical inventory process in progress"},
		{"DOC_NOT_PROCESSED",				 "APP-ST0092 @ record(s) not processed to GL"},
		{"VALUE_CANNOT_BE_POSITIVE",		 "APP-ST0093 Value also should be negative or zero"},
		{"QUANTITY_CANNOT_BE_POSITIVE",		 "APP-ST0094 Quantity also should be negative or zero"},
		{"BAT_QTY_AND_TOT_QTY_NOT_ZERO",	 "APP-ST0095 The Batch Quantity and Total Quantity cannot be Zero"},
		{"INVALID_PERIOD_MONTH_YEAR",		 "APP-ST0096 Period is not defined"},
		{"ISS_QTY_CANNOT_BE_ZERO",			 "APP-ST0097 Issue Quantity cannot be zero for all records"},
		{"CANNOT_BE_GT_CURR_PERIOD",		 "APP-ST0098 To Month/Year cannot be greater than current process Month/Year"},
		{"NO_MULTI_GRN_FOR_ITEM",			 "APP-ST0099 Batches of multiple GRNs are not allowed"},
		{"OVERWRITE_STOCK_LEVELS",			 "APP-ST0100 Stock Levels will be overwritten in Item master"},
		{"INVALID_ITEM_FOR_REQ_TYPE",		 "APP-ST0101 Item Disallowed for the Selected Request Type"},
		{"QTY_GREATER_THAN_AVAIL",		     "APP-ST0102 Return Qty cannot be greater than the available qty"},
		{"NO_CONV_FAC_FOR_REQ_UOM_CODE",	 "APP-ST0103 Conversion Factor is not available for the Request UOM"},
		{"PUR_SALE_UOM_UNDEFINED",			 "APP-ST0104 Purchase/Sale UOM Applicability should be checked in AM UOM"},
		{"ADJ_REMARKS_NOT_BLANK",			 "APP-ST0105 Remarks field cannot be blank "},
		{"NO_CONV_FAC_FOR_ISS_UOM_CODE",	 "APP-ST0106 Conversion Factor is not available for the Issue UOM"},
		{"RTV_REF_CANNOT_BLANK",			 "APP-ST0107 RTV Reference cannot be blank"},
		{"RTV_REF_REFRESHED",				 "APP-ST0108 RTV Reference data will be refreshed"},
		{"ONLY_TRADE_SPEC_ITEM_ALWD",		 "APP-ST0109 Only Trade specific item allowed"},
		{"QTY_GREATER_THAN_MAX_QTY",	     "APP-ST0110 Req Qty should be less than Max Stock Qty"},
		{"BATCH_ID_GREATER_THAN_PREVIOUS",	 "APP-ST0111 Batch ID should be greater than Current Batch Id"},
		{"REPACKING_GROUPS_DIFFERENT",	     "APP-ST0112 Repacking Groups should be same for Repacking"},
		{"AVAILQTY_LESS_THAN_FACTOR",	     "APP-ST0113 Actual Balance Quantity should be less than the Repack Factor "},
		{"ACT_BAL_QTY_BLANK",				 "APP-ST0114 Actual Balance Quantity cannot be blank"},
		{"CST_CHG_TO_RTV_CST",				 "APP-ST0115 Unit Cost will be changed based on RTV Cost"},
		{"CONV_FACTOR_NOT_DEFINED",			 "APP-ST0116 Conversion Factor not defined"},
		{"FROM_STORE_NOT_DEFINED",			 "APP-ST0117 From Store Cannot be blank..."},
		{"MIN_ONE_RECORD_AVB",				 "APP-ST0118 Minimum One record should be Available"},
		{"ONE_QTY_MUST",					 "APP-ST0119 Either Normal/Bonus Quantity should be entered"},
		{"NOT_PROCESSING_MONTH",			 "APP-ST0120 Not a Processing Month"},
		{"DATE_NOT_GREATER_SYSDATE",		 "APP-ST0121 Date cannot be greater than System Date"},
		{"NOT_PROCESSING_YEAR",				 "APP-ST0122 Not a Processing Year"},
		{"TFR_QTY_NOT_BLK",					 "APP-ST0123 Transfer Quantity cannot be blank..."},
		{"NOR_OR_BON_MUST",					 "APP-ST0124 Either Normal/Bonus Quantity should be entered"},
		{"SEARCH_STRING_CANNOT_BE_BLANK",	 "APP-ST0125 Search String cannot be blank"},
		{"REPORT_SUBMITTED",				 "APP-ST0126 Report submitted successfully"},
		{"VALUE_LESS_THAN_STORE_VALUE",		 "APP-ST0127 Value cannot be less than Store value"},		
		{"RECORD_INSERTED",					 "APP-ST0128 Operation Completed Successfully......"},
		{"RECORD_MODIFIED",					 "APP-ST0128 Operation Completed Successfully......"},
		{"RECORD_DELETED",                   "APP-ST0128 Operation Completed Successfully......"},
		{"RECORD_EXISTS",                    "APP-ST0129 Record already exists"},
		{"RECORD_ALREADY_EXISTS",            "APP-ST0130 Duplication Not Possible..."},
		{"INVALID_DATE_FMT",                 "APP-ST0131 Invalid Date Format"},
		{"SELECT_OPTION",                    "Select"},	
		{"PERIOD_N_GR_TN_12_MONTH",          "APP-ST0133 Period Should Not Be Greater Than 12 Months"}, 
		{"TO_DT_GR_FM_DT",                   "APP-ST0134 To Date should be Greater than From Date"}, 
		{"DOC_NO",                           "APP-ST0135 DOC No"},
		{"RECORD_LOCKED",		             "APP-ST0136 Record is modified by another User"},
		{"UNFINALIZED_TRN_EXITS",		     "APP-ST0137 Unfinalized Transaction exist, cannot proceed with the Adjustment"},
		{"CODE_ALREADY_EXISTS",		         "APP-ST0138 Code Already Exists"},
		{"DUPLICATE_ENTRIES_NOT_ALLOWED",	 "APP-ST0139 Duplicate entries are not allowed"},
		{"DUPLICATE_BATCHES",				 "APP-ST0140 Duplicate Batches are not allowed"},
		{"SEQ_NO_ALREADY_EXIST",			 "APP-ST0141 Duplicate Sequence Number is not allowed"},
		{"GENERAL_LEDGER_INTERFACE_ENABLED", "APP-ST0142 General Ledger interface is not enabled"},
		{"INVALID_PATIENT",					 "APP-ST0143 INVALID PATIENT"},
		{"PEND_TRANS",						 "APP-ST0144 Pending transactions found for item, cannot change/save details"},
		{"DOC_NOS_GEN_FROM",                 "APP-ST0145 Document Numbers Generated From"},
		{"RQTY_NOT_GRTR_MAX_STK",            "APP-ST0146 Reorder Quantity Cannot Be Greater Than Max Stock"},
		{"ITEM_CLASS_CANNOT_BLANK",          "APP-ST0147 Item Class Cannot be blank"},
		{"INVALID_TIME_FMT",				 "APP-ST0148 Invalid Time Format"},
		{"ST_BL_DETAILS_NOT_SET",			 "APP-ST0149 Billing Details Are Not Set For The Item(s)"},
		{"INVALID_SALES_TYPE_FOR_STORE",     "APP-ST0150 Selected Sale Type is not applicable for the Store"},
		{"MONTH_NOT_GREATER_SYSDATE",		 "APP-ST0151 Month/Year Cannot Be Greater Than Current Processing Month/Year"},
		{"COMMON_ITEM_CLASS_NOT_FOUND",		 "APP-ST0152 Item Class common to both the stores is not available"},
		{"MIN_ONE_ITEM_CLASS_REQUIRED",		 "APP-ST0153 Please Select At Least One Item Class"},
		{"STOCK_EXIST_BIN_LOCN",             "APP-ST0154 Stock exists in the Bin Location, cannot modify"},
		{"ACK_NOT_APPLICABLE",				 "APP-ST0155 Acknowledgment is not Applicable"},
		{"RCVD_QTY_NOT_GREATER_ISSUED_QTY",	 "APP-ST0156 Recieved Quantity Cannot Be Greater Than Pending Quantity"},
		{"RCVD_QTY_NOT_BLANK",				 "APP-ST0157 Received Quantity Cannot Be Blank"},
		{"UNFINALIZED_TRN_EXITS_ST_PARAM",	 "APP-ST0158 Unfinalized Transaction exist, cannot modify"},
		{"SYS_GEN_DOC_NO_NOT_SELECTED",		 "APP-ST0159 System Generated Document Number Flag is not Checked For Adjustment"},
		{"SALE_PRICE_NOT_GREATER_UNIT_PRICE","APP-ST0160 Sale Price Cannot Be Greater Than Unit Cost"},
		{"DEF_ADJ_DOC_TYPE_CODE_NOT_SELECTED","APP-ST0161 Set The Default Documetnt Type For Stock Adjustment in Facility Parameter"},
		{"SALE_PRICE_NOT_BLANK",			 "APP-ST0162 Sale Price Cannot Be Blank"},
		{"SELECT_PROD_TFR_REQUEST_NO",		 "APP-ST0163 Select the Request No. to be deleted"},
		{"SALE_PRICE_NOT_LESSER_UNIT_PRICE", "APP-ST0164 Sale Price can not be less than Unit Cost"},
		{"PO_REQUEST_NOT_APPLICABLE",		 "APP-ST0165 PO Request Is Not Applicable"},
		{"NO_DELETE_ACCESS_FOR_USER",		 "APP-ST0166 User does not have access rights to Delete the Document"},
		{"FRM_DOC_DATE_NOT_LESS_SYSDATE",	 "APP-ST0167 Doc Date From cannot be Greater Than Current Date"},
		{"TO_DOC_DATE_NOT_LESS_FRM_DOC_DATE","APP-ST0168 To Doc Date cannot be Less Than From Doc Date"},
		{"RJCTD_QTY_NOT_GREATER_ISSUED_QTY", "APP-ST0169 Rejected Quantity Cannot Be Greater Than Pending Quantity"},
		{"ISS_STR_CANNOT_SAME_REC_STR",		 "APP-ST0170 Issuing Store and Receiving Store Cannot be Same"},
		{"ISS_STR_CANNOT_BLANK_REC_STR",	 "APP-ST0171 Either Issuing Store or Receiving Store should be entered"},
		{"CANNOT_CHANGE_CONSIGN_FLAG",		 "APP-ST0172 Cannot Change Consignment Flag When Quantity On Hand is Greater Than Zero"},
		{"ST_REASON_CODE_NOT_BLANK",		 "APP-ST0173 Reason Code Cannot Be Blank"},
		{"ST_EXPIRY_FLAG_NOT_CHANGED_FOR_DRUGS",	 "APP-ST0174 Expiry Flag is not updateable for items identified as drugs in Pharmacy Management"},
		{"QTY_CANNOT_BE_ZERO_ALL_RECORDS",			 "APP-ST0175 Request Quantity cannot be zero for one or more Items"},
		{"EXPIRY_DATE_CHANGE_OF_IDENTICAL_BATCHES",	 "APP-ST0176 Expiry/Receipt Dates of all identical batches will be changed to"},
		{"ST_PROCESSING_WAIT", "APP-ST0177 Processing please wait......"},
		{"ST_NO_RECORDS_FOR_PRINT"," APP-ST0178 No records are selected for print "},
		{"ST_DOC_NO_FINALIZED_USER",				"APP-ST0179 Selected Document Number was Finalized/Modified by someother user"},
		{"RECORD_UPDATED_BY_OTH_USER",				"APP-ST0180 The Record Already In Use By Other User.Please Try again..."},
		{"RECORD_UPDATED_BY_OTH_USER1",				"APP-ST0242 The Record Already  Used By Other User.Please Try again..."},
		{"AUTH_QTY_CANNOT_BE_ZERO",			 "APP-ST0181 Authorize Quantity cannot be zero for all records"},
		{"SALE_QTY_CANNOT_BE_ZERO",			 "APP-ST0182 Sale Quantity cannot be zero"},
		{"FROM_DATE_NOT_BLANK",				 "APP-ST0183 From Date cannot be blank"}, //ganga
		{"TO_DATE_NOT_BLANK",				 "APP-ST0184 To Date cannot be blank"},//ganga
		{"FM_DATE_GR_TO_DATE",               "APP-ST0185 From Date cannot be greater than To Date"},//ganga
		{"PHYSICIAN_ID_CANNOT_BE_NULL",			 "APP-ST0186 Physician Id is not specified for this Patient. Pls attach the Physician Id"},//ganga
		{"RET_QTY_CANNOT_ZERO",			     "APP-ST0187 Return qty cannot be Zero"},//ganga
		{"SUSPENDED_BATCH_YN",    "APP-ST0187 User does not have access to process Suspended_Batch"}, //Rabbani on 11/11/11
		{"PHY_QTY_CANNOT_LESS_THAN_COMMITTED_QTY",			     "APP-ST0188 Physical Qty cannot be less than Committed Qty"},//ganga
		{"SUCCESS",                     "Success"}, //Rabbani
		{"AVAIL_BATCH_QTY_ALREADY_USED",	 "APP-ST0190 Available qty is Already Used in this Transaction"},//ganga
		{"BARCODE_WITH_MORE_ITEMS",	 "APP-ST0191 More Items found having same Barcode"},//ganga
		{"EFFECTIVE_RATE_NOT_AVAILABLE",	 "APP-ST0192 BL9647  Effective Rate not Available for This Item/Trade ID/Batch ID"},//ganga
 	    {"CONSIGNMENT_ITEM",    "APP-ST0188   Please Select Consignment items"}, //Rabbani
  	    {"USER_MANDATORY",    "APP-ST0189   User cannot be blank"},
	    {"NO_CHANGE",    "APP-ST0190   No Changes to Save ...."},
		{"BATCH_MANDATORY",    "APP-ST0190  Item Batch combination already exist"},
		//Added by Sakti Sankar For using in PO module 
		{"PUR_UNIT_CANNOT_BE_BLANK",			 "APP-ST00191 Purchase Unit cannot be blank"},
		{"USER_CANNOT_BE_BLANK",			 "APP-ST00192 User cannot be blank, please select a user"},
		{"NO_RECORD_UPDATED",    "APP-ST0193  Item with the selected Batch,ExpDt,Trade and Bin location is not found"}, //Rabbani
		{"ORDER_QTY_CANNOT_BLANK",			 "APP-ST0191 Order qty cannot be blank"},
		{"ORDER_QTY_CANNOT_ZERO",			 "APP-ST0192 Order qty cannot be Zero"},
		{"ORDER_QTY_NOT_GRT_MAX_REQ_QTY",			 "APP-ST0192 Order qty cannot be Greater than Request Qty"},
		{"GRN_QTY_CANNOT_BLANK",			 "APP-ST0191 GRN Qty cannot be blank"},
		{"GRN_QTY_CANNOT_ZERO",			 "APP-ST0192 GRN Qty cannot be Zero"},
		{"GRN_QTY_NOT_GRT_MAX_ORD_QTY",			 "APP-ST0192 GRN Qty cannot be Greater than Ordered Qty"},
		{"PURCHASE_UNIT_SEARCH_MANDATORY", "APP-ST0193 Invalid Purchase Unit, click search button"},
		{"BAL_BUD_LESS_THAN_ORDER_QTY",			 "APP-ST0201 Balance Budget Amount Less Than Order Quantity"},
		{"CLICK_ON_MODIFY_BUTTON", "APP-ST0202 Please Click On Modify Button Then Apply"},
		{"NEXT_DEL_DATE_CANNOT_BLANK",			 "APP-ST0202 Delievery Date For Pending Qty cannot be blank"},
		{"NEXT_DEL_DATE_CANNOT_LESS_SYS",			 "APP-ST0203 Delievery Date Should be greater than System Date"},
		{"UPDATE_EXP_RECORDS",			 "APP-ST0204 Batch Details Should not be Empty"},
		{"DTL_AND_EXP_QTY_SHOULD_BE_EQUAL",			 "APP-ST0205 Item Qty and Batch Qty Should be Equal"},
		{"IMG_PATH_NOT_SET",			 "APP-ST0206 Image Path is not set in Facility Parameter"},
		{"FILE_NAME_NOT_FOUND",			 "APP-ST0207 File Not Found "},
		{"NO_OF_ITEM_CANNOT_BE_BLANK_OR_ZERO",			 "APP-ST0206 No of Item Cannot be Blank or Zero"},
		{"EXP_DATE_CANNOT_GRTR", "APP-ST0207 Expiry Date Cannot be Greater Than : "},//Added against Inc#34872
		//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts
		{"WISH_TO_CONDEMNEXPIRED_BATCH",	"APP-ST0208 Do you wish to Condemn Expired Batch?"},
		{"SET_UP_BATCH_ID",	"APP-ST0209 Pls Setup the Rule for Batchid generation for Disposable Adjustment"},
		{"SPECIAL_CHARCTERS_NOT_ALLOWED","APP-ST0210 Special Characters Not Allowed"},
		//ends
		{"ACK_FROM_DATE_NOT_BLANK","APP-ST0211 Acknowledgment From Date Cannot be Blank"},
		{"CHOOSE_SPECIFIC_STORE","APP-ST0212 Choose a specific Store when 'All Stores' is not checked"},
		{"BARCODE_ITEM_NOT_EXISTS","APP-ST0213 The scanned barcode and the barcode of the Listed Item(s) does not match. Please scan the correct barcode."},
		{"BARCODE_SCANNING_NOT_COMPLETE","APP-ST0214 Barcode scanning is not complete. There are Item(s) pending for barcode scanning. Do you wish to proceed further?"},
		
		//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
		{"CANNOT_CLOSE_MULTIPLE_SEQ_EXIST","APP-ST0215 Cannot 'Close Upon issue' as there are Unfinalized Issue sequence docs"},
		{"CANNOT_CLOSE_HOLD_ITEMS_EXIST","APP-ST0216 Cannot 'Close Upon issue' as there are Items marked On Hold"},
		{"UNFINALIZED_TRN_EXITS_ST_ENTITY",	 "APP-ST0217 Setup/Unfinalized Transaction for Manufacturing exist, cannot be blank"},
		{"ATLEAST_ONE_PREP_TYPE",	 "APP-ST0218 At least one 'Preparation type' must be available"},
		{"TO_DOC_DATE_NOT_LESS_SYSDATE", "APP-ST0219 To Doc Date cannot be greater than Current Date"},//Added for ML-MMOH-CRF-0448 [IN:57461] by B.Badmavathi on 04/02/2016
		{"ALLOW_AUTHORIZE_AT_ISS_STORE","APP-ST0220 - Note: Checking this  will enable 'Authorize at Issue Store' Access Control in 'Store Setup' as well as 'User Access for Store'. The 'Authorize at Issue Store' privileges must be setup to continue to authorize the Issue Requests at Issue Store. Users with 'Requisition Issue' privilege will no longer be able to authorize. "},//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		{"NOT_ALLOW_AUTHORIZE_AT_ISS_STORE","APP-ST0221 - Note: Unchecking this will remove all existing privileges setup for 'Authorize at Issue Store' Access Control in 'Store Setup' as well as 'User Access for Store'. Users with 'Requisition Issue' privilege will be able to authorize the Issue Requests at the Issue Store. "},//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			{"NO_ACCESS_FOR_USER","APP-ST0222 - User not authorised to view this report "},//GHL-CRF-0019
		{"ITEM_STORE_ITEM_CLASS_NOT_FOUND", "APP-ST0223 Item Class belonging to the Item is not associated with Parent and/or Child Store"},//Added for ML-BRU-SCF-1686 by B.Badmavathi on 26/07/2016
		{"EXPIRED_BATCH",					 "APP-ST0224 Expired batch"},//Added against IN:062247
		{"ST_INVALID_BAR_CODE", "APP-ST0225 The scanned Barcode is not found/recognized"},//Added against IN:062328
		{"ST_NOT_AUTHORIZED_ITEM", "APP-ST0226 Not an Authorized Item"},//Added against GHL-CRF-0413.2-US002
		{"ST_NOT_AUTHORIZED_BATCH", "APP-ST0227 The scanned batch is not an 'Issue Authorized Batch'"},//Added against GHL-CRF-0413.2-US002
		{"QTY_CANNOT_BLANK",				 "APP-ST0228 Quantity Cannot Be Blank"},//GHL-CRF-0446
		{"CONDEMN_BATCH_BARCODE_NOT_FOUND",				 "APP-ST0229 The scanned Item Batch is not present in the 'Condemn Batches' search results"},//GHL-CRF-0446
		{"PHY_INV_BARCODE_NOT_FOUND",				 "APP-ST0230 The scanned Item Batch is not found in the chosen Physical Inventory ID"},//GHL-CRF-0413.7
		{"PHY_INV_BATCH_NOT_VALID","APP-ST0231 The scanned Item Batch is not associated with the chosen Store"},
		{"ITEM_STORE_NOT_FOUND1","APP-ST0232 The scanned Item is not associated with the chosen Store"},//GHL-CRF-0413
		{"BARCODE_NOT_FOUND_ISS_DOC","APP-ST0233 The scanned Item is not available in the picked Issue Document. Please pick the correct Issue Document"},//GHL-CRF-0413
		{"BARCODE_NOT_FOUND_SAL_DOC","APP-ST0234 The scanned Item is not available in the picked Sale Document. Please pick the correct Sale Document"},//GHL-CRF-0413
		{"PO_MANDATORY_CHECKED","APP-ST0235 'MM Parameter -> PO Number Mandatory in GRN' is checked. Please uncheck it to proceed"},//GDOH-CRF-0109
		{"EXPIRED_BATCH_CONS","APP-ST0236 Batch has Expired. User doesn't have Privilege to Process Expired Batches"},//Added for GHL-SCF-1169 
		{"TFR_QTY_LESS_THAN_AVL_QTY_BARCODE","APP-ST0237 Ret Qty should be less than or equal to available qty for scanned/selected batch"},//Added for GHL-CRF-0464
		{"PERIOD_TO_DATE_NOT_BLANK", "APP-ST0238 Period To cannot be blank"},//Added for CRF-99.2
		{"ISS_QTY_EXCEED_AUTHORIZED_QTY","APP-ST0238 Issue Quantity exceeds Authorized Quantity.\nClick 'OK' to proceed or 'Cancel' to revert to Authorized Quantity"},//Added for GHL-CRF-0465
		{"PARAMETER_SETUP","APP-ST0239 Please setup the ST Entity Parameter, ST Facility Parameter and MM Parameter to proceed."}, //Added for PMG2017-SS-CRF-0002
		{"ST_DOC_DT_NOT_GR_TO_DT_LIMIT","APP-ST0240 Difference between From and To date cannot be greater than 90 Days."}, //Added for KDAH-CRF-0380
		{"ST_RESTRICT_OP_EM_ENCTR","APP-ST0241 Patient has an active IP/DC admission.Sales/Patient Issues for AE or OP encounters cannot be performed.Please Select an IP/DC encounter for Placing the order."}, //Added for GHL-CRF-0419.2
		{"FROM_AUTH_DATE_CHECK","APP-ST0242 From Authorize Date should be less than or equal to To Authorize Date"},
		{"TO_AUTH_DATE_CHECK","APP-ST0243 TO Authorize Date should be gratter than or equal to From Authorize Date"},
		{"BATCH_QTY_NOT_GRT_AVLQTY",				 "APP-ST00244 Batch Transaction Quantity cannot be greater than Available Batch Quantity"},//Added for GHL-ICN-0050
		{"EXCEED_MAX_STOCK","APP-ST0245 Requested Quantity plus Quantity on Hand exceeds Maximum Quantity by"},//Added for IN:071343
		{"CON_PERIOD_BLANK","APP-ST0246 Please record the Consumption Period to proceed. Consumption Period is necessary to Autocalculate Stock Levels"},//Added for IN:071344
		{"INVALID_CON_PERIOD","APP-ST0247 Consumption Period must be between 1 to 90 days"},//Added for IN:071344
		{"PO_GRN_DOC_TYPE_DIFFERET","APP-ST0248 GRN Document Type and PO Document Type cannot be different"},//Added for IN:071539
		{"BATCH_QTY_MULTIPLE_STORE_UOM","APP-ST0246 Batch Quantity should be in multiples of "},//Added for IN:072096
		{"PH_NEAR_EXPIRY_CANT_BE_BLANK","APP-00000 Field value for Pre Allocation of Drugs based on Near Expiry Cannot be blank"}, //Added for MMS-DM-CRF-0177
		{"ST_SALE_TRANSACTION_01","Please note down the bill"}, 
		{"ST_SALE_TRANSACTION_02","For The Sale Transaction"},		
		{"BARCODE_SCAN_ITEM_NOT_EXISTS","APP-ST0247 The scanned Item is not available in the picked Acknowledge Document"},//Added for TFS id:6938
		{"ST_DATE_NOT_GRTR_FUTURE_DATE","APP-ST0249 Manufacture Date cannot be a Future Date"},//added for MO-CRF-20165 START
		{"REMARKS_NOT_EXCEED_100_CH","APP-ST0250 Remarks cannot exceed 100 characters"},
		{"REMARKS_NOT_EXCEED_182_CH","APP-ST0251 Remarks cannot exceed 182 characters"},
		{"ST_DATE_NOT_GRTR_EXPIRY_DATE","APP-ST0252 Manufacture Date cannot be greater than Expiry Date"},//Added for 19510 	
		{"FROM_DATE_NOT_GREATER_SYSDATE","APP-ST0253 The Difference between From and To Date cannot be Greater than 365 Days"}, //Added for AMS-CRF-0258
		{"TO_DATE_NOT_GREATER_SYSDATE","APP-ST0254 To Date cannot be greater than System Date"}, //Added for AMS-CRF-0258
		{"ITEM_STORE_NO_OF_DAYS_GREATER","APP-ST0255 New Request cannot be raised for this item now as per configuration. Stock has been received recently "},//Added for MO-CRF-20172   	  
		{"CANNOT_BE_ZERO","APP-ST0256 Number of Days must be Greater than 0"},//Added for MO-CRF-20172
		{"CANNOT_USE_ITEM_DOCUMENT_LEVEL_CLOSE","Cannot use both Item Level Close and Document Level Close at the same Time"},//added for MO-CRF-20173
		{"TRANSACTION_ONE_RECORD", "APP-ST0257 Transaction must have at least one detail record"},//added for MO-CRF-20173
		{"MANUFACTURER_REMARKS_CHAR_EXCEEDS_LIMIT",	"APP-ST0258 Only 250 characters allowed in Manufacturer Freetext"},
		{"REMARKS_ARE_PRESENT_SO_CAN'T_APPLY" ,	"APP-ST0259 Can't Apply as remarks are there for some entries"},    //added for  TH-KW-CRF-0083
		{"NULL_BATCHES_WILL_UPDADATE_TO_ZERO" ,	"APP-ST0260 Batches Having Null Item Quantity Will Get Updated To Zero After Post Variance. Do You Want To Continue?"},    //added for  TH-KW-CRF-0083
		{"SELECT_FILE" ,	"APP-ST0261 Select a file to view"}    //added for  TH-KW-CRF-0083
		};
}		



