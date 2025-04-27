function create()
{
	f_query_add_mod.location.href = "../../eAM/jsp/addModifySubservice.jsp?&source=Insert" ;
}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eAM/jsp/SubserviceQueryCriteria.jsp?function=Subservice";
}

function apply()
{

	
		if(f_query_add_mod.document.subservice_form)
		{
	var fields = new Array ( f_query_add_mod.document.subservice_form.service_code,
				 f_query_add_mod.document.subservice_form.subservice_code,
				 f_query_add_mod.document.subservice_form.long_desc,
				 f_query_add_mod.document.subservice_form.short_desc
				);

	var names = new Array ( getLabel("Common.service.label","Common"),
					getLabel("Common.subservice.label","Common")+getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")
				);
	var spFields = new Array (f_query_add_mod.document.subservice_form.subservice_code);
	var spNames = new Array (getLabel("Common.subservice.label","Common")+getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			 var fn_status = f_query_add_mod.document.subservice_form.function_name.value ;
			 f_query_add_mod.document.subservice_form.submit();
		}
		}else
	{
	messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=";

	}
}

function onSuccess()
{
    if(f_query_add_mod.document.forms[0])
    {
	f_query_add_mod.location.reload();

    }
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		//f_query_add_mod.document.forms[0].reset() ;
		   	f_query_add_mod.document.location.reload();


}
