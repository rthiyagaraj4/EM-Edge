var messageArray;

if( messageArray == null )
{
	messageArray = new Array() ;
} 

// MM Messages Starts

messageArray["ATLEAST_ONE_RECORD_ENTERED"]			=	"APP-MM0001 Atleast one record should be entered";
messageArray["ITEM_ANALYSIS_UNIQUE"]				=	"APP-MM0002 Item Analysis Code should be unique";
messageArray["ITEM_EITHER_PH_CSSD"]					=	"APP-MM0003 Item Should be either Pharmacy Stock or CSSD Component";
messageArray["STORE_EITHER_EXT_DEPT"]				=	"APP-MM0004 Store Should be either External or Department";
messageArray["INVALID_AM_TRADE_ID"]				    =	"APP-MM0005 Invalid Trade ID";
messageArray["INVALID_MM_ITEM_CODE"]				=	"APP-MM0006 Invalid Item Code";   
messageArray["DUPLICATE_ENTRIES_NOT_ALLOWED"]		=	"APP-MM0007 Duplicate entries are not allowed";
messageArray["NOT_APPL_FOR_THIS_INSTAL"]			=	"APP-MM0008 This function is not applicable";
messageArray["DUPLICATE_CODE_EXISTS"]			=	"APP-002433 Duplicate Code not allowed";  //Common.js
//DUPLICATE_CODE_EXISTS","APP-002433 Duplicate Code not allowed


// MM Messages Ends

function getMMMessage( message_ref ) {
    var message	=	messageArray[message_ref] ;
    if ( message == null ) 
		message =	"Message Not Available" ;
    return message ;
}