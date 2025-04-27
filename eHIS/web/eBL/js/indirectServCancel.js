/*
Sr No     Version        Incident			SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1          V220525							GHL-CRF-0632     		Mohanapriya
-----------------------------------------------------------------------------------
*/
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var invalidCode = "";

function populateValues()
{
	var localeName = document.ind_serv_cancel.localeName.value;
	var order_category = document.ind_serv_cancel.order_category.value
	var clickedTab = "SEARCH";
	qry_string = "order_category="+order_category+"&clickedTab="+clickedTab+"&mode=1";	
	
	if(order_category!="")
		parent.indirect_serv_cancel.location.href = "../jsp/IndirectServCancel.jsp?"+qry_string
	else
		parent.indirect_serv_cancel.location.href = "../../eCommon/html/blank.html"
}

function checkChk1Value(obj,recordType,form_mode){

 if(obj.checked == true)
       obj.value = "Y";
  else
		obj.value="N";
		
  var strtype = recordType.value;
  var xmlDoc = "" ;
  var xmlHttp = new XMLHttpRequest() ;
  var xmlStr ="<root><SEARCH ";
  xmlStr +=" /></root>";
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  xmlHttp.open("POST","IndirectServCancelValidate.jsp?order_status_code="+strtype+"&form_mode="+form_mode+"&selected="+ obj.value,false);
  xmlHttp.send(xmlDoc);
  responseText=xmlHttp.responseText ;
  eval(responseText);
}

function submitPrevNext(from, to){
	document.indirect_order_status.from.value = from;
	document.indirect_order_status.to.value = to; 
	document.indirect_order_status.submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
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

function reset()
{
	indirectServCancelFrame.location.reload();
	indirect_serv_cancel.location.href = "../../eCommon/html/blank.html";
}

function checkIsValidForProceed()
{
	var url = indirect_serv_cancel.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function apply() 
{	
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID","BL");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}

    var formObj = indirect_serv_cancel.document.indirect_order_status;
	eval(formApply(indirect_serv_cancel.document.indirect_order_status, "../../eBL/jsp/IndirectServSubmit.jsp"));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ messageGlobal;	   
	if(resultGlobal){
	  onSuccess();
	}
}


function onSuccess() 
{
}
