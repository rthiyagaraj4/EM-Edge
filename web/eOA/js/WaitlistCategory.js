function create()
{
	f_query_add_mod.location.href = '../../eOA/jsp/addModifyWaitlistCategory.jsp?function_name=insert';
}
function reset()
{
	if (f_query_add_mod.document.forms[0])
		
		f_query_add_mod.document.location.reload();
}

function apply()
{
	var fields = new Array ( 
					 f_query_add_mod.document.forms[0].waitlist_code,
					f_query_add_mod.document.forms[0].long_desc,
					 f_query_add_mod.document.forms[0].short_desc) ;

		var names = new Array ( getLabel("Common.code.label","Common"),
								getLabel("Common.longdescription.label","Common"),
								getLabel("Common.shortdescription.label","Common"));

		var spFields = new Array (f_query_add_mod.document.forms[0].waitlist_code);
		var spNames = new Array (getLabel("Common.code.label","Common"));
var error_page = "../../eCommon/jsp/error.jsp";
if(f_query_add_mod.SpecialCharCheck(spFields,spNames,messageFrame,"M",error_page))
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
         f_query_add_mod.document.waitlist_form.submit();
	}
}
function query() 
{
	f_query_add_mod.location.href ="../../eOA/jsp/WaitlistCategoryQueryCriteria.jsp?function=Waitlist Category";
	return true;
}
function onSuccess() 
{
	 if(f_query_add_mod.document.waitlist_form.function_name.value == "insert")
	  {
		f_query_add_mod.document.waitlist_form.waitlist_code.value	= "" ;
		f_query_add_mod.document.waitlist_form.short_desc.value		= "" ;
		f_query_add_mod.document.waitlist_form.long_desc.value		= "" ;
		f_query_add_mod.document.waitlist_form.eff_status.checked	= true ;

	//Added by Manish Anand on 30-06-2002
		f_query_add_mod.document.waitlist_form.waitlist_code.select();
		 }
	else
		if(f_query_add_mod.document.waitlist_form.function_name.value == "modify")
			f_query_add_mod.document.location.reload();
}
