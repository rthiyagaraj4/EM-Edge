/*
CRF/SCF Reference No 	:  ML-MMOH-CRF-1955
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  1-07-2023
Purpose of the Script   :  Mark Patient as Medico Legal Case (MLC) Patient and to revert the MLC marked patient as Non-MLC patient 				   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
*/

function query()
{
	f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=13";
	plineFrame.location.href ="../../eCommon/html/blank.html";
	resultFrame.location.href="../../eCommon/html/blank.html";
}

function blank(lab) {
	var error='';
	error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
	error = error.replace('$',lab);
	error = error + "<br>" ;
	return error;
}
function apply() {
	var action = f_query_add_mod.MarkPatientMLC.Action.value;
	var reason = f_query_add_mod.MarkPatientMLC.Reason.value;
	var errors = "";
	if( action != "" && reason.length == 0 ) {
		errors = errors + blank(getLabel("Common.reason.label","Common"));	
	} 
	if(errors.length > 0) {
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	} else {
			f_query_add_mod.MarkPatientMLC.submit();
	}
}

function reset() 
{
	parent.content.frames[2].document.forms[0].reset();
	f_query_add_mod.fieldFocus();
}

function onSuccess() 
{
	alert(getMessage("RECORD_INSERTED",'SM'));
	resultFrame.location.href="../../eCommon/html/blank.html";
	query();
	messageFrame.location.href="../../eCommon/jsp/error.jsp";

}
function fieldFocus()
{
	setTimeout('foc()',300);
}

