 var messageArray;

if( messageArray == null )
{
	messageArray = new Array() ;
}

// ST Messages Starts
// Message ID Should not exceeed 30 characters
messageArray["INVALID_ITEM_CODE"]				= "APP-ST0001 Invalid Item Code";
messageArray["STORE_NOT_FOUND"]					= "APP-ST0002 Store not found";
messageArray["MIN_CANNOT_EXCEED_MAX"]			= "APP-ST0003 Minimum Stock quantity cannot exceed Maximum Stock quantity";
messageArray["REORDER_CANNOT_EXCEED_MAX"]		= "APP-ST0004 Reorder Level cannot be greater than Maximum Stock quantity";
messageArray["REORDER_CANNOT_LESS_THAN_MIN"]	= "APP-ST0005 Reorder Level cannot be less than Minimum Stock quantity";
messageArray["NO_CONV_FACTOR_FOR_UOM_CODE"]		= "APP-ST0006 Conversion Factor is not available for the Sale UOM";
messageArray["QOH_CANNOT_CHANGE_STOCK_ITEM"]	= "APP-ST0007 Quantity on hand is greater than 0, cannot change Stock Item Status";
messageArray["PHY_INV_CANT_CHANGE_STK_ITEM"]	= "APP-ST0008 Physical Inventory is in progress, cannot change Stock Item Status";
//messageArray["PHY_YR_CNT_CANNOT_EXCEED_MAX"]	= "APP-ST0009 Physical Year Count cannot be greater than 12";
messageArray["INVALID_STORE_CODE"]				= "APP-ST0010 Invalid Store Code";
messageArray["INVALID_STERILE_TYPE"]			= "APP-ST0011 Invalid Sterile Type";
messageArray["LESS_OR_EQUAL_VALIDATE"]			= "APP-ST0012 From @ should be less than or equal to To @" ;
messageArray["ITEM_CODE_ALREADY_EXIST"]			= "APP-ST0013 Item Code Already Exist";
messageArray["QUANTIY_MUST_BE_EQUAL"]			= "APP-ST0014 Sum of Batch Qty Must be equal to Item Quantity";
messageArray["STORE_CANNOT_BE_BLANK"]			= "APP-ST0015 Store cannot be blank";
messageArray["REQ_BY_ITEM_STORE_NOT_FOUND"]		= "APP-ST0016 Requested by Store and Item combination does not exist";
messageArray["REQ_ON_ITEM_STORE_NOT_FOUND"]		= "APP-ST0017 Requested on Store and Item combination does not exist";
messageArray["REQ_ON_REQ_BY_CANNOT_BE_SAME"]	= "APP-ST0018 Requested on Store cannot be same as Requested by Store";
messageArray["ST_DOC_DT_NOT_LT_PROC_MTH"]		= "APP-ST0019 Document Date should not be less than Processing Period";
messageArray["ST_ASMB_CHILD_ITEM_NOT_SAME"]		= "APP-ST0020 Child Item  cannot be same as Item";
messageArray["ST_ASMB_ITEM_NOT_BLANK"]			= "APP-ST0021 Item cannot be blank";
messageArray["ST_NO_CONV_FACTOR_MFG_UOM_CODE"]	= "APP-ST0022 Conversion Factor is not available for the MFG UOM";
messageArray["MIN_ONE_CHILD_ITEM_REQD"]			= "APP-ST0023 Atleast One Child Item  Record Must be there";
messageArray["DATE_NOT_BLANK"]				    = "APP-ST0024 Date cannot be blank";
messageArray["BATCH_ID_NOT_BLANK"]				= "APP-ST0025 Batch ID cannot be blank";
messageArray["TRADE_ID_NOT_BLANK"]				= "APP-ST0026 Trade ID cannot be blank";
messageArray["BIN_LOCN_NOT_BLANK"]				= "APP-ST0027 Bin Location cannot be blank";
messageArray["TRADE_NOT_ASS_FOR_ITEM"]			= "APP-ST0028 Trade Name not associated for the item";
messageArray["BIN_LOCN_NOT_ASS_FOR_STORE"]		= "APP-ST0029 Bin Location not associated for the Store";
messageArray["REQ_QTY_NOT_GR_PEND_QTY"]			= "APP-ST0030 Authorize Quantity Cannot be greater than Available Quantity";
messageArray["ST_CANT_ENTER_MORE"]				= "APP-ST0031 Cannot enter more than ";
messageArray["ST_ITEM_CODE_BLANK"]				= "APP-ST0032 Item Code cannot be blank";
messageArray["ST_STORE_CODE_BLANK"]				= "APP-ST0033 Requesting Store  cannot be blank";
messageArray["TO_AND_FM_BIN_LOC_NOT_SAME"]		= "APP-ST0034 New bin location should not be same as old bin location";
messageArray["TFR_QTY_LESS_THAN_AVL_QTY"]		= "APP-ST0035 Quantity should be less or equal to available quantity";
messageArray["QTY_TO_TFER_NOT_BLANK"]			= "APP-ST0036 Quantity to transfer cannot be blank";
messageArray["NEGATIVE_STOCK"]					= "APP-ST0037 Insufficient Stock";
messageArray["ITEM_IS_SUSPENDED"]				= "APP-ST0038 The selected Item is suspended";
messageArray["DUPLICATE_IN_OPENING_STOCK"]		= "APP-ST0039 Duplicate Entries are not allowed in Opening stock";
messageArray["INSUFFICIENT_BATCH_QTY"]			= "APP-ST0040 Insufficient batch quantity";
messageArray["NOT_LESS_THAN_SYSDATE"]			= "APP-ST0041 Date cannot be less than System date";
messageArray["ITEM_STORE_NOT_FOUND"]			= "APP-ST0042 Item Store combination does not exist";
messageArray["STOCK_NOT_AVAILABLE"]				= "APP-ST0043 Stock is not available for this Item";
messageArray["NOT_STOCK_ITEM"]					= "APP-ST0044 Item is not a stock Item";
messageArray["QTY_NOT_GRT_AVLQTY"]				= "APP-ST0045 Transaction Quantity cannot be greater than Available Quantity";
messageArray["BATCH_DTL_ALREADY_EXIST"]			= "APP-ST0046 Batch Detail already exists";
messageArray["ST_DOC_DT_NOT_GR_SYSDATE"]		= "APP-ST0047 Date cannot be greater than System Date";
messageArray["ENTITY_PARAM_NOT_SET"]			= "APP-ST0048 Entity Parameter is not set";
messageArray["MEDICAL_NON_MEDICAL_CHECKED"]		= "APP-ST0049 Either Medical Item or Non-Medical Item has to be checked";
messageArray["ATLEAST_ONE_TRANS"]				= "APP-ST0050 Atleast one transaction has to be checked";
messageArray["STORE_ALRDY_EXISTS"]				= "APP-ST0051 Store already exists";
messageArray["PHY_COUNT_CANT_EXCEED_MAX"]		= "APP-ST0052 Physical Year Count cannot exceed Physical Count Per Year";
messageArray["TO_AND_FM_ITEM_NOT_SAME"]		    = "APP-ST0053 From item should not be same as To item";
messageArray["REORDER_QTY_CANNOT_EXCEED_MAX"]	= "APP-ST0054 Reorder Qty cannot be greater than Maximum Stock quantity";
messageArray["MIN_LVL_CANT_EXCEED_MAX_LEVEL"]	= "APP-ST0055 Min Stk Level cannot be greater than Max Stk Level";
messageArray["MIN_SAL_CANT_EXCEED_MAX_LVL"]	    = "APP-ST0056 Min Sales Qty cannot be greater than Max Stk Level";
messageArray["BOTH_ITEM_EXP_OR_NON_EXP"]	    = "APP-ST0057 Both the item should be either expired or non expired item";
messageArray["ITEM_CONV_FACTOR_BLANK"]	        = "APP-ST0058 Item Conversion factor cannot be blank";
messageArray["QTY_NOT_GRT_ISSQTY"]	            = "APP-ST0059 Transaction Quantity cannot be greater than Issued Quantity";
messageArray["MIN_ONE_RET_QTY_REQD"]	        = "APP-ST0060 Minimun one transaction must have Return Quantity";
messageArray["BATCH_SELECT_MANDATORY"]	        = "APP-ST0061 Batch selection mandatory";
messageArray["INVALID_DRUG_CODE"]				= "APP-ST0062 Invalid Drug Code";
messageArray["REMARKS_CHAR_EXCEEDS_LIMIT"]		= "APP-ST0063 Remarks field cannot exceed 200 characters";
messageArray["BATCH_DETAILS_NOT_BLANK"]		    = "APP-ST0064 Batch Details cannot be blank";
messageArray["OPENING_STOCK_DUPLICATE_ITEM"]	= "APP-ST0065 Opening Stock has already been entered for this item-store combination";
messageArray["MIN_ONE_ITEM_REQD"]	            = "APP-ST0066 Atleast One Item Record Must be there";
messageArray["BOTH_STORE_CANNOT_BE_SAME"]	    = "APP-ST0067 From store and To store cannot be same";
messageArray["TO_BIN_LOC_NOT_BLANK"]			= "APP-ST0068 To bin location code cannot be blank";
messageArray["STOCK_ITEM_FLAG_CHANGED"]			= "APP-ST0069 The stock item flag has been changed";
messageArray["BATCH_RECORD_NOT_FOUND"]			= "APP-ST0070 Batch record not found";
messageArray["SUSPENDED_BATCH"]					= "APP-ST0071 Suspended batch";
messageArray["MAX_RET_QTY_ZERO"]				= "APP-ST0072 Zero quantity available to return";
messageArray["RET_QTY_NOT_GRT_MAX_RET_QTY"]		= "APP-ST0073 Return Qty cannot be greater than Max Returnable Qty";
messageArray["RET_QTY_CANNOT_BLANK"]			= "APP-ST0074 Return qty cannot be blank";
messageArray["VALUE_CANNOT_BE_BLANK"]			= "APP-ST0075 Value cannot be blank";
messageArray["REQ_QTY_CANNOT_BE_ZERO"]			= "APP-ST0076 Request qty cannot be zero";
//messageArray["RET_QTY_NOT_GRT_ISS_QTY"]		= "APP-ST0077 Return qty cannot be greater than Issue Quantity";
messageArray["ITEM_OR_ITEM_CLASS_MANDATORY"]	= "APP-ST0078 Item / Item Class cannot be blank";
messageArray["OPER_CANCELLED"]					= "APP-ST0079 Operation Cancelled";
messageArray["BATCH_REFRESHED"]					= "APP-ST0080 Batch data will be refreshed";
messageArray["PREP_TYPE_DO_NOT_MATCH"]			= "APP-ST0081 Preparation type does not match for the  item";
messageArray["PREP_MODE_DO_NOT_MATCH"]			= "APP-ST0082 Preparation mode does not match for the  item";
messageArray["COMP_QTY_NOT_GRT"]				= "APP-ST0083 Component for qty cannot be greater than";
messageArray["FACILITY_PARAM_NOT_SET"]			= "APP-ST0084 Facility Parameter is not set";
messageArray["INVALID_SLOT_VALUE"]				= "APP-ST0085 Invalid Slot Value";
messageArray["BATCH_QTY_NOT_GRT"]				= "APP-ST0086 Batch Qty cannot be greater than Quantity";
messageArray["USER_SEARCH_MANDATORY"]			= "APP-ST0087 Invalid User, click search button";
messageArray["VALUE_NOT_FOUND_FOR_REPORT"]		= "APP-ST0088 There is an overlap of parameters with an existing physical count";
messageArray["INVAL_PERIOD_END_DATE"]		    = "APP-ST0089 Cannot be processed within the current period" ;	      
messageArray["NO_CONV_FAC_FOR_PUR_UOM_CODE"]	= "APP-ST0090 Conversion Factor is not available for the Purchase UOM";
messageArray["PHY_INV_PROCESS_INITIATED"]		= "APP-ST0091 Physical inventory process in progress";
messageArray["DOC_NOT_PROCESSED"]				= "APP-ST0092 @ record(s) not processed to GL";
messageArray["VALUE_CANNOT_BE_POSITIVE"]		= "APP-ST0093 Value also should be negative or zero";
messageArray["QUANTITY_CANNOT_BE_POSITIVE"]		= "APP-ST0094 Quantity also should be negative or zero";
messageArray["BAT_QTY_AND_TOT_QTY_NOT_ZERO"]	= "APP-ST0095 The Batch Quantity and Total Quantity cannot be Zero";
messageArray["INVALID_PERIOD_MONTH_YEAR"]		= "APP-ST0096 Period is not defined";
messageArray["ISS_QTY_CANNOT_BE_ZERO"]			= "APP-ST0097 Issue Quantity cannot be zero for all records";
messageArray["CANNOT_BE_GT_CURR_PERIOD"]		= "APP-ST0098 To Month/Year cannot be greater than current process Month/Year";
messageArray["NO_MULTI_GRN_FOR_ITEM"]			= "APP-ST0099 Batches of multiple GRNs are not allowed";
messageArray["OVERWRITE_STOCK_LEVELS"]			= "APP-ST0100 Stock Levels will be overwritten in Item master";
messageArray["INVALID_ITEM_FOR_REQ_TYPE"]		= "APP-ST0101 Item Disallowed for the Selected Request Type";
messageArray["QTY_GREATER_THAN_AVAIL"]		    = "APP-ST0102 Return Qty cannot be greater than the available qty";
messageArray["NO_CONV_FAC_FOR_REQ_UOM_CODE"]	= "APP-ST0103 Conversion Factor is not available for the Request UOM";
messageArray["PUR_SALE_UOM_UNDEFINED"]			= "APP-ST0104 Purchase/Sale UOM Applicability should be checked in AM UOM";
messageArray["ADJ_REMARKS_NOT_BLANK"]			= "APP-ST0105 Remarks field cannot be blank ";
messageArray["NO_CONV_FAC_FOR_ISS_UOM_CODE"]	= "APP-ST0106 Conversion Factor is not available for the Issue UOM";
messageArray["RTV_REF_CANNOT_BLANK"]			= "APP-ST0107 RTV Reference cannot be blank";
messageArray["RTV_REF_REFRESHED"]				= "APP-ST0108 RTV Reference data will be refreshed";

messageArray["ONLY_TRADE_SPEC_ITEM_ALWD"]		= "APP-ST0109 Only Trade specific item allowed";
messageArray["QTY_GREATER_THAN_MAX_QTY"]	    = "APP-ST0110 Req Qty should be less than Max Stock Qty";
messageArray["BATCH_ID_GREATER_THAN_PREVIOUS"]	= "APP-ST0111 Batch ID should be greater than Current Batch Id";
messageArray["REPACKING_GROUPS_DIFFERENT"]	    = "APP-ST0112 Repacking Groups should be same for Repacking";
messageArray["AVAILQTY_LESS_THAN_FACTOR"]	    = "APP-ST0113 Actual Balance Quantity should be less than the Repack Factor ";
messageArray["ACT_BAL_QTY_BLANK"]				= "APP-ST0114 Actual Balance Quantity cannot be blank";
messageArray["CST_CHG_TO_RTV_CST"]				= "APP-ST0115 Unit Cost will be changed based on RTV Cost";
messageArray["CONV_FACTOR_NOT_DEFINED"]			= "APP-ST0116 Conversion Factor not defined";
messageArray["FROM_STORE_NOT_DEFINED"]			= "APP-ST0117 From Store Cannot be blank...";
//Added on 3/2/2006
messageArray["MIN_ONE_RECORD_AVB"] = "APP-ST0118 Minimum One record should be Available";
messageArray["ONE_QTY_MUST"] = "APP-ST0119 Either Normal/Bonus/Sample Quantity should be entered";
messageArray["NOT_PROCESSING_MONTH"] = "APP-ST0120 Not a Processing Month" ;
messageArray["DATE_NOT_GREATER_SYSDATE"] = "APP-ST0121 Date cannot be greater than System Date" ;
messageArray["NOT_PROCESSING_YEAR"] = "APP-ST0122 Not a Processing Year" ;
messageArray["TFR_QTY_NOT_BLK"] = "APP-ST0123 Transfer Quantity cannot be blank..." ;
messageArray["NOR_OR_BON_MUST"] = "APP-ST0124 Either Normal/Bonus Quantity should be entered" ;
messageArray["SEARCH_STRING_CANNOT_BE_BLANK"]= "APP-ST0125 Search String cannot be blank";
messageArray["REPORT_SUBMITTED"] = "APP-ST0126 Report submitted successfully";
messageArray["VALUE_LESS_THAN_STORE_VALUE"] = "APP-ST0127 Value cannot be less than Store value";




// ST Messages Ends

function getMessage( message_ref ) {

    var message = messageArray[message_ref] ;
    if ( message == null ) message = "Message Not Available ||ID:"+message_ref+"||" ;
    return message ;

}

function getMMMessage( message_ref ) {
//	alert("enter in st message");
    var message	=	messageArray[message_ref] ;
    if ( message == null ) 
		message =	"Message Not Available" ;
    return message ;
}