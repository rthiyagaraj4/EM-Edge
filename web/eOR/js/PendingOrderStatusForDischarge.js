/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
/*
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	 Rev.By 	Description
--------------------------------------------------------------------------------------------------------------------------------
25/09/2018	  IN068719		sivabagyam	 25/09/2018	Ramesh G   GHL-CRF-0517.1
--------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var invalidCode = "";

function changeValue(chk)
{	
	if(chk.checked)
		chk.value = 'A';
	else 
		chk.value = 'N';
}
function changeValue1(chk)
{	
	if(chk.checked)
		chk.value = 'D';
	else 
		chk.value = 'N';
}
//IN068719 starts
function changeValue2(chk)
{	
	if(chk.checked)
		chk.value = 'C';
	else 
		chk.value = 'N';
}
//IN068719 ends
function apply() 
{
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

    var formObj = pend_ord_status_discharge.document.pend_order_status;
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();

	arrFieldName[0]			=	"long_desc";
	arrFieldName[1]			=	"order_status_code";
			
	arrLegends[0]			=	getLabel("Common.longdescription.label","Common");
	arrLegends[1]			=	getLabel("Common.OrderStatus.label","Common");
			
	arrPKFieldNames[0]		=	"long_desc";
	arrPKFieldNames[1]		=	"order_status_code";
	//resetDuplicateClass(formObj, arrPKFieldNames );
	
	eval(formApply(pend_ord_status_discharge.document.pend_order_status, OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;	   
	if(resultGlobal){
	  onSuccess();
	}
}

function assignResult(_result, _message, _flag)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
}


function assignResult(_result,_message, _flag, invCode)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}

function onSuccess() 
{
	//pend_ord_status_discharge.location.href = "../../eCommon/html/blank.html";//IN033039
}


function formReset () 
{
	var formObj = pend_ord_status_discharge.document.pend_order_status;
	formObj.reset();
}

function reset()
{
	pend_ord_status_discharge.document.forms[0].reset();
}

function checkIsValidForProceed()
{
	var url = pend_ord_status_discharge.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function clickAll()
{
	if(document.getElementById("select_all").checked == true)
	{
		document.pend_order_status.select_all.checked=true;
		document.pend_order_status.select_all.value='Y';
		for(cnt=0; cnt<document.pend_order_status.total_recs.value; cnt++)
		{
			val = eval("document.pend_order_status.chk1_"+cnt);
			val.checked = true;
			val.value = 'Y';
		}
	}
	else
	{
		document.pend_order_status.select_all.checked=false;
		document.getElementById("select_all").value='N';
		for(cnt=0; cnt<document.pend_order_status.total_recs.value; cnt++)
		{
			val = eval("document.pend_order_status.chk1_"+cnt);
			val.checked = false;
			val.value = 'N';
		}
	}
}
function populateValues()
{
	var localeName = document.pend_ord_status_cat.localeName.value;
	var order_category = document.pend_ord_status_cat.order_category.value
	var clickedTab = "SEARCH";
	qry_string = "order_category="+order_category+"&clickedTab="+clickedTab+"&mode=1";	
	if(order_category!="")
		parent.pend_ord_status_discharge.location.href = "../jsp/PendingOrderStatusForDischargeAmend.jsp?"+qry_string
	else
		parent.pend_ord_status_discharge.location.href = "../../eCommon/html/blank.html"
}
//Code Added For ML-BRU-SCF-0184 Start
function submitPrevNext(from, to){
	document.pend_order_status.from.value = from;
	document.pend_order_status.to.value = to; 
	document.pend_order_status.submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";		
}
function checkChk1Value(obj,recordType){

 if(obj.checked == true)
       obj.value = "A";
  else
		obj.value="N";
		
  var strtype = recordType.value;
  //var form_mode = "";//COMMENTED FOR IN068719
  var form_mode = "chk1";//IN068719
  var xmlDoc = "" ;
  var xmlHttp = new XMLHttpRequest() ;
  var xmlStr ="<root><SEARCH ";
  xmlStr +=" /></root>";
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  xmlHttp.open("POST","PendingOrderStatusValidate.jsp?order_status_code="+strtype+"&form_mode="+form_mode+"&selected="+ obj.value,false);
  xmlHttp.send(xmlDoc);
  responseText=xmlHttp.responseText ;
  eval(responseText);
}
function checkChk2Value(obj,recordType){

 if(obj.checked == true)
       obj.value = "D";
  else
		obj.value="N";
  var strtype = recordType.value;
  var form_mode = "chk2";
  var xmlDoc = "" ;
  var xmlHttp = new XMLHttpRequest() ;
  var xmlStr ="<root><SEARCH ";
  xmlStr +=" /></root>";
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  xmlHttp.open("POST","PendingOrderStatusValidate.jsp?order_status_code="+strtype+"&form_mode="+form_mode+"&selected="+ obj.value,false);
  xmlHttp.send(xmlDoc);
  responseText=xmlHttp.responseText ;
  eval(responseText);
}
//Code Added For ML-BRU-SCF-0184 End
//IN068719 starts
function checkChk3Value(obj,recordType){
	 if(obj.checked == true)
	       obj.value = "C";
	  else
			obj.value="N";
	  var strtype = recordType.value;
	  var form_mode = "chk3";
	  var xmlDoc = "" ;
	  var xmlHttp = new XMLHttpRequest() ;
	  var xmlStr ="<root><SEARCH ";
	  xmlStr +=" /></root>";
	  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	  xmlHttp.open("POST","PendingOrderStatusValidate.jsp?order_status_code="+strtype+"&form_mode="+form_mode+"&selected="+ obj.value,false);
	  xmlHttp.send(xmlDoc);
	  responseText=xmlHttp.responseText ;
	  eval(responseText);
	}
//IN068719 ends
