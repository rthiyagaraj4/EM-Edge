function onSuccess() { 
	frames[1].location.href= '../../eMR/jsp/ReprintSickLeaveCriteria.jsp';
	frames[2].location.href= '../../eCommon/html/blank.html';

}

function reset() {

	frames[1].document.forms[0].reset() ;
}

function patqry() {

	var pat_id=PatientSearch();
	if(pat_id == null) pat_id = "";
	document.forms[0].PatientId.value=pat_id;
}
function clearQry() {

	parent.frames[1].document.forms[0].reset();
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/jsp/error.jsp";
	
}
function DisplyResult()
{
  var PatientId			= document.forms[0].PatientId.value;
  var PatientClass		= document.forms[0].PatientClass.value;
  var EncounterId		= document.forms[0].EncounterId.value;
  var LeaveFrom			= document.forms[0].LeaveFrom.value;
  var LeaveTo			= document.forms[0].LeaveTo.value;
 if(doDateCheckAlertLocal(document.forms[0].LeaveFrom,document.forms[0].LeaveTo))
 {
	alert(getMessage("LV_END_DATE_EQ_FROM_DATE","COMMON"));
	document.forms[0].LeaveTo.focus()
 }					 
 else
	parent.frames[2].location.href="../../eMR/jsp/ReprintSickLeaveResult.jsp?PatientId="+PatientId+"&PatientClass="+PatientClass+"&EncounterId="+EncounterId+"&LeaveFrom="+convertDate(LeaveFrom,'DMY',localeName)+"&LeaveTo="+convertDate(LeaveTo,'DMY',localeName);
}

function doDateCheckAlertLocal(from,to){
	if(from.vlaue!=""&&to.value!=""){
        var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(!isBefore(greg_fromDate,greg_toDate,'DMY',localeName))
		 return true;
	else 
		return false;
	}
}
