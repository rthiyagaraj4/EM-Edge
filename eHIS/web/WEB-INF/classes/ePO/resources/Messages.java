/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.resources;

import java.util.*;

public class Messages extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = 
	{		
		{"RECORD_INSERTED",					 "APP-PO0001 Operation Completed Successfully......"},
		{"RECORD_MODIFIED",					 "APP-PO0001 Operation Completed Successfully......"},
		{"RECORD_DELETED",                   "APP-PO0001 Operation Completed Successfully......"},
		{"OPER_CANCELLED",					 "APP-PO0002 Operation Cancelled"},
		{"FM_DATE_GR_TO_DATE",               "APP-PO0003 From Date cannot be greater than To Date"}, 
		{"TO_DATE_NOT_BLANK",				 "APP-PO0004 To Date cannot be blank"}, 
		{"FROM_DATE_NOT_BLANK",				 "APP-PO0005 From Date cannot be blank"},  
		{"TO_DATE_GR_FROM_DATE",			 "APP-PO0006 To date should be greater than or equal to From date"},
		{"ENTER_BATCH_DETAILS",			 	 "APP-PO0007 Please enter the batch details for the Item"},
		{"SELECT_PO_FOR_DO",			 	 "APP-PO0008 Please select the Purchase Order(s) for this Delivery Order"},
		{"DISCOUNT_PER_LT_100",			 	 "APP-PO0009 Discount Percentage should be less than 100"},
		{"DISCOUNT_AMT_LT_GROSS",			 "APP-PO0010 Discount Amount should be less than Gross Amount"},
		{"BAT_DTLS_CANNOT_BLANK",			 "APP-PO0011 Batch Details Cannot be Blank"},
		{"BAL_BUD_LESS_THAN_ORDER_QTY",		 "APP-PO0012 Balance Budget Amount Less Than Order Quantity"},
		{"DUPLICATE_CURR_EXISTS",			 "APP-PO0013 Transaction Currency should be same"},
		{"DATE_NOT_GREATER_SYSDATE",		 "APP-PO0014 Date cannot be greater than System Date"},
		{"DUPLICATE_NOT_POSSIBLE",			 "APP-PO0015 Duplicate Not Possible"},
		{"VALID_UPTO_GR_SYSDATE",			 "APP-PO0016 Valid upto date should be greater than or equal to system date"},
		{"CODE_NOT_BLANK",					 "APP-PO0017 Code Cannot Be Blank"},
		{"LONG_DESC_NOT_BLANK",				 "APP-PO0018 Long Description Cannot Be Blank"},
		{"SHORT_DESC_NOT_BLANK",			 "APP-PO0019 Short Description Cannot Be Blank"},
		{"EFF_STATUS_NOT_BLANK",			 "APP-PO0020 Effective Status Cannot Be Blank"},
		{"DEPT_CODE_NOT_BLANK",				 "APP-PO0021 Dept Code Cannot Be Blank"},
		{"EFF_TO_DATE_GR_FROM_DATE",		 "APP-PO0022 Effective to date should be greater than or equal to Effective from date"},
		{"DOC_NO_NULL",						 "APP-PO0023 Document number setup is not available. Please set the same and retry the transaction"},
		{"BUDGET_EXCEEDED",					 "APP-PO0024 Budget Exceeded."},
		{"NET_AMT_GR_BAL_AMT",				 "APP-PO0025 Net Amount is greater than Balance Budget Amount."},
		{"NET_AMT",							 "APP-PO0026 Net Amount"},
		{"BAL_BUD_AMT",						 "APP-PO0027 Balance Budget Amount"},
		{"COMMIT_CODE",						 "APP-PO0028 Commitment Code"},
		{"DEPT",							 "APP-PO0029 Department"},
		{"TRANS_NOT_PROCEED_AS_BUD_AMT_EXCEED",	"APP-PO0030 Transaction cannot proceed as the budget amount is exceeded!"},
		{"ITEM_APPROVAL_PENDING",			 "APP-PO0031 Item level approval is pending for some items - Status is Partially Approved"},
		{"TOTQTY_EQ_ORDQTY",			 	 "APP-PO0032 Total Quantity should be equal to Order Quantity"},
		{"ATLEAST_ONE_DELV_SCH_RECORD",	 	 "APP-PO0033 Atleast one delivery schedule record"}, 
		{"ATLEAST_ONE_TRANS",	 			 "APP-PO0034 Atleast one transaction has to be checked"}, 
		{"ORDER_QTY_CANNOT_BLANK",	 		 "APP-PO0035 Order Quantity Cannot be blank"}, 
		{"ORDER_QTY_CANNOT_ZERO",	 		 "APP-PO0036 Order Quantity Cannot be zero"}, 
		{"ORDER_QTY_NOT_GRT_MAX_REQ_QTY",	 "APP-PO0037 Order Quantity should not be greater than pending quantity"}, 
		{"VALID_DT_GR_EXP_DELV_DT",	         "APP-PO0038 Valid upto date should be greater than or equal to expected delivery date"}, 
		{"EXP_DT_LE_VALID_DT",	       		 "APP-PO0039 Expected delivery date should be less than or equal to valid upto date"}, 
		{"BATCH_DTLS",	       				 "APP-PO0040 Please enter the batch details for the Item"}, 
		{"DELV_QTY_MISMATCH",	       		 "APP-PO0041 Delivery quantity is mismatch in batch details"}, 
		{"PUR_ORD_FOR_DELV_ORD",	       	 "APP-PO0042 Please select the Purchase Order(s) for this Delivery Order"}, 
		{"TOT_QTY_EQ_DELV_QTY",	       		 "APP-PO0043 Total Quantity should be equal to Delivery Quantity"}, 
		{"BAT_EXP_CANNOT_SAME",	       		 "APP-PO0044 Batch Id, Expiray Date, Facility Id, Store Cannot be same"}, 
		{"ATLEAST_ONE_BATCH_DTLS",	    	 "APP-PO0045 Atleast one batch Details has to be record"}, 
		{"TRANS_CURR_SHOULD_SAME",	    	 "APP-PO0046 Transaction Currency should be same"}, 
		{"DUPLICATE_PO_NOT_ALLOW",	    	 "APP-PO0047 Duplicate Purchase Order not allowed"}, 
		{"DELV_QTY_NOT_GR_PEN_QTY",	    	 "APP-PO0048 Delivery Quantity cannot be greater than Pending Quantity"}, 
		{"ITEM_STORE_DOES_NOT_EXIST",	     "APP-PO0049 Item - Store combination does not exist"}, 
		{"NOT_LESS_THAN_SYSDATE",			 "APP-PO0050 Date cannot be less than System date"},
		{"VALID_DT_EQ_SYS_DT",				 "APP-PO0051 Valid upto date should be greater than or equal to system date"},
		{"PLS_PRESS_CLOSE_BUTTON",			 "APP-PO0052 Please Press Close Button"},
		{"WEIGHTAGE_PER_LS_100",			 "APP-PO0053 Weightage Percentage should be less than 100"},
		{"PLS_UPDATE_ITEM_APPROVAL",		 "APP-PO0054 Please update item level approval reference and recommit"},
		{"PLS_ENTER_ALPHA_NUMERIC_CHAR",	 "APP-PO0055 please enter alpha numeric characters only"},
		{"PURCHASE_UNIT_BLANK",				 "APP-PO0056 Purchase Unit cannot be blank"},
		{"SUPP_CANNOT_BLANK",				 "APP-PO0057 Supplier Cannot be blank"},
		{"CODE_ALREADY_EXISTS",		         "APP-PO0058 Code Already Exists"},
		{"NO_CHANGES_TO_SAVE",               "APP-PO0059 No Changes to Save"},
		{"DOC_NO",                           "APP-PO0060 DOC No"},
		{"PURCHASE_UNIT_SEARCH_MANDATORY",   "APP-PO0061 Invalid Purchase Unit, click search button"},
		{"MIN_ONE_RECORD_AVB",				 "APP-PO0062 Minimum One record should be Available"},
		{"DOC_NOS_GEN_FROM",                 "APP-PO0063 Document Numbers Generated From"},
		{"NO_DELETE_ACCESS_FOR_USER",		 "APP-PO0064 User does not have access rights to Delete the Document"},
		{"COMMIT_CODE_CANNOT_BLANK",		 "APP-PO0065 Commitment Code Cannot be Blank"},
		{"NO_CONV_FAC_FOR_REQ_UOM_CODE",	 "APP-PO0066 Conversion Factor is not available for the Request UOM"},
		{"SELECT_OPTION",                    "Select"},	
		{"ORDER_AMENDED",					 "This order will be Amended. Do you want to Continue?"},
		{"PUR_UNIT_CANNOT_BE_BLANK",		 "APP-PO0067 Purchase Unit cannot be blank"},
		{"USER_CANNOT_BE_BLANK",			 "APP-PO0068 User cannot be blank, please select a user"} ,
		{"CLOSED_DATE_GR_OPEN_DATE",		 "APP-PO0069 Closed date should be greater than or equal to Open date"},
		{"DUPLICATE_REQ_NOT_ALLOWED",		 "APP-PO0070 Duplicate Purchase Request not allowed"},
		{"EXPECTED_DELV_DT_GR_PO_DT",		 "APP-PO0071 Expected delivery date should be greater than or equal to PO date"},
		{"PUR_UNIT_NOT_GLOBAL",				 "APP-PO0072 This Purchase Unit is not 'Global' and hence only One Facility can be linked."},
		{"SPECIAL_CHARCTERS_NOT_ALLOWED",	 "APP-PO0073 Special Characters Not Allowed"},
		{"REMARKS_NOT_BLANK",	 			 "APP-PO0074 Remarks cannot be blank"},
		{"CANNOT_CLOSE_PO_SINGLE", 			 "APP-PO0075 Cannot Close PO as there is Pending GRN against the Delivery Qty"},
		{"CANNOT_CLOSE_PO_MULTIPLE",	 	 "APP-PO0076 Cannot Close PO for unchecked record(s) as there is/are Pending GRN against the Delivery Qty"},
		{"CANNOT_CLOSE_PO_DO_UNF_QTY", 		 "APP-PO0077 Cannot Cancel/Close PO as there is unfinalized DO Qty available"},
		{"CANNOT_CLOSE_PO_GRN_UNF_QTY", 	 "APP-PO0078 Cannot Cancel/Close PO as there is unfinalized GRN Qty available"},
		{"CANNOT_CLOSE_PO_DO_UNF_QTY_MULTIPLE", 	"APP-PO0079 Cannot Cancel/Close PO for unchecked record(s) as there is/are unfinalized DO Qty available"},
		{"CANNOT_CLOSE_PO_GRN_UNF_QTY_MULTIPLE", 	"APP-PO0080 Cannot Cancel/Close PO for unchecked record(s) as there is/are unfinalized GRN Qty available"}
		
		
	
	};
}		
