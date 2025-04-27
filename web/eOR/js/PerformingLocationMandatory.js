/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
09/01/2019  IN066377  		Kamalakannan G	09/01/2019		Ramesh G			AMS-CRF-0139
--------------------------------------------------------------------------------------------------------------
*/
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var invalidCode = "";
function apply() {
	frmObj=f_query_perf_mand.document.perf_locn_mand;
	eval(formApply(frmObj, OR_CONTROLLER));
	 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
     if( resultGlobal ) 
      onSuccess();
}

function onSuccess() {
	f_query_perf_mand.location.href = "../../eOR/jsp/PerformingLocationMandatoryMenu.jsp?mode="+MODE_MODIFY
}

function changeValue(chk)
{
	if(chk.checked)
		chk.value = 'Y';
	else 
		chk.value = 'N';
}

function assignResult(_result, _message, _flag){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
}

function assignResult(_result,_message, _flag, invCode){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}

function reset(){
	f_query_perf_mand.document.forms[0].reset();
}
