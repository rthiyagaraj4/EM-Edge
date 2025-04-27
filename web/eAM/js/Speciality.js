function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifySpeciality.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/querySpecialityForm.jsp?function=speciality";
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
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array ( f_query_add_mod.document.speciality_form.speciality_code,
						f_query_add_mod.document.speciality_form.long_desc,
						f_query_add_mod.document.speciality_form.short_desc
				    );

	var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")
						 );

//////////Added by Manish Anand on 30-06-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.speciality_form.speciality_code);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
//////////----------------------------------////////////////////
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if(f_query_add_mod.document.speciality_form.vital_signs_battery.disabled)
				f_query_add_mod.document.speciality_form.vital_signs_battery.disabled = false;
			f_query_add_mod.document.speciality_form.submit()
			var fn_status = f_query_add_mod.document.speciality_form.function_name.value ;
		}
}

function onSuccess() {
	if(f_query_add_mod.document.forms[0])
	{
	f_query_add_mod.location.reload();

	}
}

function reset() {

			if(f_query_add_mod.document.forms[0])
					f_query_add_mod.document.location.reload();
					//f_query_add_mod.document.forms[0].reset() ;

}
