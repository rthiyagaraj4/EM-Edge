//This file is saved on 18/10/2005

function checkSequence(objSequence,textValue)
{
	var errorMessage =""
	var number =objSequence.value
		if(objSequence.value != '')
	{
		if(number<= 0)
			{
				//errorMessage= "APP-CP0002 - "+textValue+" Cannot be Zero or Negative Number"
				errorMessage= getMessage("CANT_ZERO_OR_NEG_NUM","CP");
				errorMessage=errorMessage.replace("$",textValue);
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
	 if(objSequence.value.charAt(0) == '-'||objSequence.value.charAt(1) == '-')
			{
				//errorMessage= "APP-CP0003 - "+textValue+" Cannot be Zero or Negative Integer"
				errorMessage= getMessage("CANT_ZERO_OR_NEG_NUM","CP");
				errorMessage=errorMessage.replace("$",textValue);
				alert(errorMessage);
				objSequence.value=''
				objSequence.focus()
				return false
			}
	}
}
/*function resetGif(objText,objGif) 
{

	if(objText.value=="")
	{
		objGif.style.display='none'		
	}
}*/
/*function create()
{
	f_query_add_mod.location.href ='../../eCP/jsp/InterventionParamAddModify.jsp'
}*/
/*function query()
{

}*/
/*function deleterecord()
{

}*/
function apply()
{


	if (! checkIsValidForProceed() ) {
		message  = getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var fields = new Array();
	var names = new Array();
	fields[0] = f_query_add_mod.document.interventionParamAddModifyForm.before_start_time_text;
	names[0] = getLabel("eCP.DurationBeforeStartTime.label","CP");
	fields[1] = f_query_add_mod.document.interventionParamAddModifyForm.duration_start_time;
	names[1] = getLabel("eCP.UnitsFor.label","CP")+getLabel("eCP.DurationBeforeStartTime.label","CP");
	fields[2] = f_query_add_mod.document.interventionParamAddModifyForm.after_start_time_text;
	names[2] = getLabel("eCP.DurationAfterStartTime.label","CP");
	fields[3] = f_query_add_mod.document.interventionParamAddModifyForm.duration_after_time;
	names[3] = getLabel("eCP.UnitsFor.label","CP")+getLabel("eCP.DurationAfterStartTime.label","CP");;
	fields[4] = f_query_add_mod.document.interventionParamAddModifyForm.end_time;
	names[4] = getLabel("eCP.DurationAfterEndTime.label","CP");
	fields[5] = f_query_add_mod.document.interventionParamAddModifyForm.end_time_select;
	names[5] = getLabel("eCP.UnitsFor.label","CP")+getLabel("eCP.DurationAfterEndTime.label","CP");
	fields[6] = f_query_add_mod.document.interventionParamAddModifyForm.backdate;
	names[6] = getLabel("eCP.UnitsFor.label","CP")+getLabel("eCP.BackdatingLimit.label","CP");
	fields[7] = f_query_add_mod.document.interventionParamAddModifyForm.Backdate_limit;
	names[7] = getLabel("eCP.BackdatingLimit.label","CP");

	if(checkFieldsofMst(fields,names,messageFrame))
	{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
				f_query_add_mod.document.interventionParamAddModifyForm.submit();
	}

}



function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*********************************************/
function reset()
{ 
 f_query_add_mod.location.reload();
}
function onSuccess()
{
	f_query_add_mod.location.href="../../eCP/jsp/InterventionParamAddModify.jsp";
}
