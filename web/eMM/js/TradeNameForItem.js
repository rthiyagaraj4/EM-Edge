var invalidCode = "";
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function create() {
	f_query_add_mod.location.href	=	"../../eMM/jsp/TradeNameForItemFrame.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	clearList();
	//f_query_add_mod.document.location.reload();
}
 
function query() {
	f_query_add_mod.location.href	=	"../../eMM/jsp/TradeNameForItemQueryCriteria.jsp?function_id="+function_id;
}

function apply() {

	if(f_query_add_mod.frameTradeNameForItemAddModify==undefined){
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return;
	}
	var formObj = f_query_add_mod.frameTradeNameForItemAddModify.document.formTradeNameForItemAddModify;
	formObj.item_code.value =
		f_query_add_mod.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.item_code.value;	
	var fields = new Array (formObj.item_code);
	var names = new Array ( getLabel("Common.item.label","Common"));
	var errorPage	= "../../eCommon/jsp/error.jsp" ;	
	var blankObj 	= null ;
	blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;

	if(blankObject==true) {

	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr ="<root><SEARCH/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?validate=MINIMUM_CHECK", false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	//alert("responseText :"+responseText);
	//eval(responseText);
	if(responseText) {
		//alert("apply 2");
			var responseText=formApply(formObj, MM_CONTROLLER);
			eval(responseText) ;
				messageFrame.location.href = errorPage+"?err_num="+ message ;
			if( responseText ) {
			//alert("apply 3");
				onSuccess() ;				
			}
		}
		else {
			message = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
			messageFrame.location.href = errorPage+"?err_num="+ message ;
		}

	}
/*	else {
		messageFrame.location.href = errorPage+"?err_num="+ message;
	}*/
}

async function searchItem(objCode,objDesc) {
	//alert("5");
parent.parent.messageFrame.location.href ="../../eCommon/jsp/error.jsp" ;	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=document.forms[0].p_language_id.value;
	
	//dataNameArray[0]  = "language_id";
	//dataValueArray[0]  =document.forms[0].p_language_id.value;
	//dataTypeArray[0] = STRING;

	//argumentArray[0] = document.formTradeNameForItemHeader.SQL_MM_ITEM_LOOKUP.value;
	argumentArray[0] = "";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,3";
	argumentArray[4] = "1,2";
	if(objDesc.readOnly) {
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objDesc.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	argumentArray[12]  = "SQL_MM_TRADENAMEFORITEM_ITEM_LOOKUP";
	argumentArray[13]  = "eMM.Common.MmRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray
	
	
	
	returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );
 //retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") ) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;		
		document.formTradeNameForItemHeader.item_search.disabled=true;
		temp_jsp="TradeNameForItemLoadData.jsp?item_code="+arr[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//eval(responseText);
		parent.frameTradeNameForItemAddModify.location.href="../../eMM/jsp/TradeNameForItemAddModify.jsp?item_code="+objCode.value+"&mode="+document.formTradeNameForItemHeader.mode.value;
		parent.frameTradeNameForItemDetail.location.href="../../eMM/jsp/TradeNameForItemDetail.jsp";
	} 
}

async function searchTradeItem(objCode,objDesc) {
	//alert("1");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LOCALE_ID`";
	parValueArray[0]=document.formTradeNameForItemDetail.p_language_id.value;
	
	//dataNameArray[0]  = "language_id";
	//dataValueArray[0]  =document.formTradeNameForItemDetail.p_language_id.value;
	//dataTypeArray[0] = STRING;

	//argumentArray[0] = document.formTradeNameForItemDetail.SQL_AM_TRADE_NAME_LOOKUP.value;
	argumentArray[0] = "";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,3";
	argumentArray[4] = "1,2";
	if(objDesc.readOnly) {
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objDesc.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE
	
	argumentArray[12]  = "SQL_MM_TRADE_NAME_FOR_ITEM_TRADENAME_LOOKUP";
	argumentArray[13]  = "eMM.Common.MmRepository";
	argumentArray[14]  = parNameArray
	argumentArray[15]  = parValueArray
	
	
	returnedValues = await CommonLookup( getLabel("Common.Trade.label","Common"), argumentArray );
	
	
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	
	if((returnedValues != null) && (returnedValues != "") ) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.readOnly=true;
		temp_jsp="TradeNameForItemManufacturer.jsp?trade_id="+arr[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//eval(responseText);
	} 
}

function addToList() {
	var formObj=document.formTradeNameForItemDetail;
	var errorPage	 = "../../eCommon/jsp/error.jsp"

	if((!formObj.trade_name.readOnly)&&(!formObj.trade_name.disabled)&&(formObj.trade_name.value!="")) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlDoc.loadXML("<search/>");
		xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?trade_id=" + formObj.trade_name.value + "&validate=TRADE_NAME", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		//eval(responseText);
		if(! responseText ) {
			message = getMessage(message,"ST");
			parent.parent.messageFrame.location.href = errorPage+"?err_num="+ message;
			return;
		}
	}
	var fields = new Array ( parent.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.item_code,document.formTradeNameForItemDetail.trade_id);
	var names  =  new Array ( getLabel("Common.item.label","Common"),  getLabel("Common.TradeName.label","Common"));
	var obj    =null;
	var messageFrame = parent.parent.messageFrame; 
	var errorPage	 = "../../eCommon/jsp/error.jsp";
	obj=checkMMFields( fields, names, messageFrame,errorPage);
	if(obj==true) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr ="<root><SEARCH  /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var item_code = parent.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.item_code.value;
		var item_name =  parent.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.item_desc.value;
		var trade_id  = document.formTradeNameForItemDetail.trade_id.value;
		var trade_name =  document.formTradeNameForItemDetail.trade_name.value; 
		var manufacturer_id = document.formTradeNameForItemDetail.manufacturer_id.value; 
		var manufacturer_name = document.formTradeNameForItemDetail.manufacturer_name.value;

		xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?item_code="+item_code+"&item_name="+escape(item_name)+"&trade_id=" +trade_id+"&trade_name=" + escape(trade_name)+"&manufacturer_id="+manufacturer_id+"&manufacturer_name="+manufacturer_name+"&index="+document.formTradeNameForItemDetail.index.value+ "&validate=ADD_TO_LIST", false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		//eval(responseText);
		if( responseText ) {
			refreshDetails();
		}
		else {
			message = getMessage("DUPLICATE_ENTRIES_NOT_ALLOWED","ST");
			messageFrame.location.href = errorPage+"?err_num="+ message;
		}
	}
	else {
	}
}

function setManufacturerDetails(manufacturer_id, manufacturer_name) {
	document.formTradeNameForItemDetail.manufacturer_id.value=manufacturer_id;
	document.formTradeNameForItemDetail.manufacturer_name.value=manufacturer_name;
}

function setTradeIdDetails(trade_id, trade_name) {
	document.formTradeNameForItemDetail.trade_id.value= trade_id;
	document.formTradeNameForItemDetail.trade_name.value=trade_name;
	document.formTradeNameForItemDetail.trade_name.readOnly=true;
}

function refreshDetails() {
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	parent.parent.f_query_add_mod.frameTradeNameForItemDetail.document.location.href="../../eMM/jsp/TradeNameForItemDetail.jsp";
	refreshList();
}

function refreshList() {
	parent.parent.f_query_add_mod.frameTradeNameForItemAddModify.document.location.reload();
}

function assignFlag(index) {
	var txtObj = eval("document.formTradeNameForItemAddModify.checkbox"+index);
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr ="<root><SEARCH  /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?flagIndex="+index+"&flagValue="+txtObj.checked+"&validate=ASSIGN_FLAG", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	
	result = _result ;
	message  = _message ;
	flag = _flag ;
	if( _invalidCode==null) {
		 _invalidCode="";
	}
	invalidCode = _invalidCode;
	if(	f_query_add_mod.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.mode.value == 2) {
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr ="<root><SEARCH  /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?validate=CLEAR_BEAN", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
	}
	f_query_add_mod.location.reload();
//reset();
}

function assignValues( _result, _message, _flag, _invalidCode ) {

	result = _result ;
	message  = _message ;
	flag = _flag ;
	if( _invalidCode==null) {
		 _invalidCode="";
	}
	invalidCode = _invalidCode;
}

function clearList() {
	//alert("clear");
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr ="<root><SEARCH  /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../eMM/jsp/TradeNameForItemValidate.jsp?validate=CLEAR", false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText;
	//alert(responseText);
	//responseText = trimString(responseText);
	eval(responseText);
}

function reset() {
		if(f_query_add_mod.QueryForm!=null)
			return;
		if(f_query_add_mod.frameTradeNameForItemHeader!=null)
			create();
		else
			f_query_add_mod.location.reload();

//		f_query_add_mod.location.reload();
}
/* {
	clearList();
	
	if(f_query_add_mod.frameTradeNameForItemHeader != null) {
		f_query_add_mod.frameTradeNameForItemHeader.document.location.href = "../../eMM/jsp/TradeNameForItemHeader.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&fromQueryPage=0";
		f_query_add_mod.frameTradeNameForItemAddModify.document.location.reload();
		f_query_add_mod.frameTradeNameForItemDetail.document.location.href="../../eCommon/html/blank.html";
	}

	if(f_query_add_mod.document.query_form!=null) {
		f_query_add_mod.document.query_form.reset();
	}
}
*/
function onSuccess() {
/*	if( f_query_add_mod.frameTradeNameForItemAddModify ) {
		var mode	=	f_query_add_mod.frameTradeNameForItemAddModify.document.formTradeNameForItemAddModify.mode.value;
		if( mode == MODE_INSERT ) {
			formReset();			
		}
		else {
			f_query_add_mod.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.mode.value = 1;
		}
	}
	else {
		f_query_add_mod.document.location.reload();
	}*/
//create();
	f_query_add_mod.location.href	=	"../../eMM/jsp/TradeNameForItemFrame.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
	clearList();

}

function formReset () {
f_query_add_mod.frameTradeNameForItemAddModify.document.location.href="../../eMM/jsp/TradeNameForItemAddModify.jsp?item_code="+""+"&mode="+f_query_add_mod.frameTradeNameForItemHeader.document.formTradeNameForItemHeader.mode.value;
	
	f_query_add_mod.frameTradeNameForItemDetail.document.formTradeNameForItemDetail.reset();
//create();
}

function Modify(obj,code) {
	item_desc = obj.cells[0].innerText;
	document.location.href	=	"../../eMM/jsp/TradeNameForItemFrame.jsp?mode="+MODE_MODIFY+"&fromQueryPage=1"+"&function_id="+parent.function_id+"&item_code="+code+"&item_desc="+escape(item_desc);
}

function resetColorCode(obj) {
    var arrPKFieldNames = new Array();
    var formObj = parent.parent.f_query_add_mod.bin_location_detail.document.formBinLocation;
    arrPKFieldNames[0] = "code_";
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}
async function searchItem_MOHE(objCode,objDesc) {
	parent.parent.messageFrame.location.href ="../../eCommon/jsp/error.jsp" ;	
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();

		var parNameArray  = new Array() ;
		var parValueArray  = new Array() ;
		parNameArray[0] ="~LOCALE_ID`";
		parValueArray[0]=document.forms[0].p_language_id.value;
		
		//dataNameArray[0]  = "language_id";
		//dataValueArray[0]  =document.forms[0].p_language_id.value;
		//dataTypeArray[0] = STRING;

		//argumentArray[0] = document.formTradeNameForItemHeader.SQL_MM_ITEM_LOOKUP.value;
		argumentArray[0] = "";
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		//argumentArray[4] = "2,3";
		argumentArray[4] = "1,2";
		if(objDesc.readOnly) {
			argumentArray[5] = "";
		}
		else {
			argumentArray[5] = objDesc.value;
		}
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		
		argumentArray[12]  = "SQL_MM_TRADENAMEFORITEM_ITEM_LOOKUP_MOHE";
		argumentArray[13]  = "eMM.Common.MmRepository";
		argumentArray[14]  = parNameArray
		argumentArray[15]  = parValueArray
		
		returnedValues = await CommonLookup( getLabel("Common.item.label","Common"), argumentArray );

	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if((returnedValues != null) && (returnedValues != "") ) {
			objCode.value = arr[0];
			objDesc.value = arr[1];
			objDesc.readOnly=true;		
			document.formTradeNameForItemHeader.item_search.disabled=true;
			temp_jsp="TradeNameForItemLoadData.jsp?item_code="+arr[0];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			parent.frameTradeNameForItemAddModify.location.href="../../eMM/jsp/TradeNameForItemAddModify.jsp?item_code="+objCode.value+"&mode="+document.formTradeNameForItemHeader.mode.value;
			parent.frameTradeNameForItemDetail.location.href="../../eMM/jsp/TradeNameForItemDetail.jsp";
		} 
	}

