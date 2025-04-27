function create() {
	f_query_add_mod.location.href = "../../eMO/jsp/addModifyBodyCondition.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMO/jsp/BodyConditionQueryCriteria.jsp?function=MO_BODY_CONDITION";
}


 function checkIsValidForProceed()
{
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
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

    var fields = new Array ( f_query_add_mod.document.MOBodyCondition_form.body_cond_code );
	var names  =  new Array (getLabel('Common.code.label','Common'));
	//var messageFrame = parent.frames[1].frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

		var fields = new Array ( f_query_add_mod.document.MOBodyCondition_form.body_cond_code,
							f_query_add_mod.document.MOBodyCondition_form.short_desc,f_query_add_mod.document.MOBodyCondition_form.long_desc
						);
		var names = new Array (getLabel('Common.code.label','Common'),
					 getLabel('Common.shortdescription.label','Common'),getLabel('Common.longdescription.label','Common'));

		
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
						f_query_add_mod.document.MOBodyCondition_form.submit();
						var fn_status = f_query_add_mod.document.MOBodyCondition_form.function_name.value ;
			}
		
	}
}

function onSuccess() {
f_query_add_mod.location.reload();
}	



function change() {
if (MOBodyCondition_form.eff_status.checked == true)
MOBodyCondition_form.eff_status.value="E";
else
MOBodyCondition_form.eff_status.value="D";
}



function reset() {
	

		if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;

}
