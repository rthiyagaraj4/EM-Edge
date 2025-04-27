function query()
{
	f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=1";
	plineFrame.location.href ="../../eCommon/html/blank.html";
}

function blank(lab) {
		var error='';
		error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',lab);
		error = error + "<br>" ;

	return error;
}

function apply() {
	var action = f_query_add_mod.SuspendReinstatePatient.Action.value;
	var reason = f_query_add_mod.SuspendReinstatePatient.Reason.value;
	var errors = "";
	if( action != "" ) {
		if(action == "Suspend" && reason.length == 0) {
			errors = errors + blank(getLabel("Common.reason.label","Common"));
		}	
	} else errors = errors + blank(getLabel("Common.action.label","Common"));

	if(errors.length > 0) {
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	} else {
	
		if( CheckMaxLen(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.SuspendReinstatePatient.Suspension_Remarks,500,messageFrame) && CheckMaxLen(getLabel("Common.remarks.label","common"),f_query_add_mod.document.SuspendReinstatePatient.Reinstatement_Remarks,500,messageFrame)) {
		
			f_query_add_mod.SuspendReinstatePatient.submit();
		}	
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
	query();
	messageFrame.location.href="../../eCommon/jsp/error.jsp";

}

function fieldFocus()
{
	setTimeout('foc()',300);
}

function CheckDeceased(DYn) {
	if(DYn == 'Y') {
		alert(getMessage("PAT_DECEASED_NOT_ALLOWED",'MP'));
		parent.query();
	}
}