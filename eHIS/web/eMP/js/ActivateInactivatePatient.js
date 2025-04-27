function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/blank.jsp?step_1=7";
	plineFrame.location.href ="../../eCommon/html/blank.html";

}

function blank(lab) {
		var error='';
		error = error+ getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',lab);
		error = error + "<br>" ;

	return error;
}

function apply() 
{

	var action     = f_query_add_mod.ActiveInactivePatient.Action.value;
	var reason    = f_query_add_mod.ActiveInactivePatient.Reason.value;
	var Active_Yn = f_query_add_mod.ActiveInactivePatient.Active_Yn.value;
	
	var errors = "";
	if(action != "") 
	{
		if(action == "Inactive" && f_query_add_mod.ActiveInactivePatient.Reason.selectedIndex == 0) 
		{
			errors = errors + blank(getLabel("Common.reason.label","Common"));  
		}	
	} 
	else errors = errors + blank(getLabel("Common.action.label","Common"));

	if(errors!="") 
	{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors+"&error_value=0" ;
	} 
	else 
	{	
	if(CheckMaxLenLc(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.ActiveInactivePatient.Inactivate_Remarks,500,messageFrame) && CheckMaxLenLc(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.ActiveInactivePatient.Activate_Remarks,500,messageFrame)) 
		{

			if(Active_Yn == 'Y')
			{
				var field = new Array (f_query_add_mod.document.ActiveInactivePatient.Reason);
				var name = new Array (getLabel("Common.reason.label","Common"));
				if(checkFieldsofMst(field,name,messageFrame))
				{
					f_query_add_mod.ActiveInactivePatient.submit();
				}
			}
			else
			{
				f_query_add_mod.ActiveInactivePatient.submit();
			}
		}	
	} 	
}
function reset() {
	parent.content.frames[2].document.forms[0].reset();
	//f_query_add_mod.focusField();
}
function onSuccess() 
{
	alert(getMessage("RECORD_INSERTED",'SM'));
	query(); 
	messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

function CheckMaxLenLc(lab,obj,max,messageFrame) {
		if(obj.value.length > max) {
			var msg = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			msg = msg.replace('$', lab);
			msg = msg.replace('#', max);
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg  + "&error_value=0" ;
			return false;
		} else return true;
}