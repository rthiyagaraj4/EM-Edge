function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyDiagGroup.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/DiagGroupQueryCriteria.jsp";
}

 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}



function apply() {

		if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 


	var fields = new Array (	f_query_add_mod.document.DiagGroup_form.tab_list_no,
					f_query_add_mod.document.DiagGroup_form.long_desc,
					f_query_add_mod.document.DiagGroup_form.short_desc,
					f_query_add_mod.document.DiagGroup_form.tab_list_type
				);

	var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common"),
				getLabel("eMR.TabulationListType.label","MR")

	);

	var field = new Array (	f_query_add_mod.document.DiagGroup_form.tab_list_no );

	var name = new Array (getLabel("Common.code.label","Common"));


		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.DiagGroup_form.submit();
			}
		}
}

function onSuccess() {
/*if(f_query_add_mod.document.DiagGroup_form.function_name.value=="insert")
{

	f_query_add_mod.document.DiagGroup_form.tab_list_no.value	= "" ;
	f_query_add_mod.document.DiagGroup_form.short_desc.value	= "" ;
	f_query_add_mod.document.DiagGroup_form.long_desc.value		= "" ;
	f_query_add_mod.document.DiagGroup_form.eff_status.value	= "E" ;
	f_query_add_mod.document.DiagGroup_form.eff_status.value	= true ;
}
*/
f_query_add_mod.location.reload();
}

function reset() {
	
/*			if(f_query_add_mod.document.forms[0].name == "DiagGroup_form") 
				f_query_add_mod.document.DiagGroup_form.reset() ;
		    else if(f_query_add_mod.document.forms[0].name == "query_form" )
				f_query_add_mod.document.location.reload();
			else f_query_add_mod.document.query_form.reset() ;
*/
	//	if(f_query_add_mod.document.forms[0])
		//   f_query_add_mod.document.forms[0].reset();
		if(f_query_add_mod.document.forms[0])
		  	f_query_add_mod.location.reload();
		


}


function chkmaxlength(obj)
{
	if(obj.name=="long_desc")
	{
		var val = obj.value;
		var len = val.length;
		if(len=="120")
			event.returnValue = false;
	}
	if(obj.name=="diag_code_range")
	{
		var val = obj.value;
		var len = val.length;
		if(len == "50")
			event.returnValue = false;
	}
}


function checkNoOfCharacter(obj,maxSize)
{
			
	if ( obj.value.length >= maxSize )
	{

		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		if(obj.name=="long_desc")
			msg = msg.replace("$",getLabel("Common.longdescription.label","Common"));
		if(obj.name=="diag_code_range")
			msg = msg.replace("$",getLabel("eMR.DiagnosisCodeRange.label","mr"));
		msg = msg.replace("#",maxSize);
		alert(msg);
		obj.focus();
		obj.select();
		//return  false;
	}
}

function change() 
{
 if (DiagGroup_form.eff_status.checked == true)
	DiagGroup_form.eff_status.value="E";
 else
	DiagGroup_form.eff_status.value="D";
}
function notallowenter(event)
{
	if(event.keyCode==13)
		return false;
}
