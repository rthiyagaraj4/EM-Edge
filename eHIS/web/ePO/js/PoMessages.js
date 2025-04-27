var messageArray;

if( messageArray == null )
{
	messageArray = new Array() ;
} 

// PO Messages Starts

messageArray["ATLEAST_ONE_RECORD_ENTERED"]			=	"APP-PO0001 Atleast one record should be entered";
messageArray["ITEM_ANALYSIS_UNIQUE"]				=	"APP-PO0002 Item Analysis Code should be unique";
messageArray["ITEM_EITHER_PH_CSSD"]					=	"APP-PO0003 Item Should be either Pharmacy Stock or CSSD Component";
messageArray["STORE_EITHER_EXT_DEPT"]				=	"APP-PO0004 Store Should be either External or Department";
messageArray["INVALID_AM_TRADE_ID"]				    =	"APP-PO0005 Invalid Trade ID";
messageArray["INVALID_MM_ITEM_CODE"]				=	"APP-PO0006 Invalid Item Code";   
messageArray["DUPLICATE_ENTRIES_NOT_ALLOWED"]		=	"APP-PO0007 Duplicate entries are not allowed";
messageArray["NOT_APPL_FOR_THIS_INSTAL"]			=	"APP-PO0008 This function is not applicable";
messageArray["DUPLICATE_CODE_EXISTS"]			=	"APP-002433 Duplicate Code not allowed";  //Common.js
messageArray["DEPNO_BLANK"]							=	"APP-PO0009 Dep No cannot be blank";
messageArray["EFF_FROM_BLANK"]						=	"APP-PO0010 Eff From field cannot be blank";
messageArray["MASTER_CODE_BLANK"]					=	"APP-PO0011 Master Code field cannot be blank";
messageArray["PURCHASE_UNIT_BLANK"]					=	"APP-PO00012 Purchase Unit cannot be blank";
//Added by Padmapriya for INC # 34818 on 03/09/2012
messageArray["ATLEAST_ONE_TRANS"]					=   "APP-PO0013 Atleast one transaction has to be checked";
messageArray["ORDER_QTY_CANNOT_BLANK"]				=   "APP-PO0014 Order Quantity Cannot be blank";
messageArray["ORDER_QTY_CANNOT_ZERO"]				=   "APP-PO0015 Order Quantity Cannot be zero";
messageArray["ORDER_QTY_NOT_GRT_MAX_REQ_QTY"]		=   "APP-PO0016 Order Quantity is not greater than maximum requested quantity";
//End by Padmapriya for INC # 34818 on 03/09/2012

// PO Messages Ends

function getPOMessage( message_ref ) {
    var message	=	messageArray[message_ref] ;
    if ( message == null ) 
		message =	"Message Not Available" ;
    return message ;
}
