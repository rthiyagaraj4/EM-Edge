function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyMedicalEventType.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/MedicalEventTypequeryCriteria.jsp";
}

function apply() {

	var fields = new Array (	f_query_add_mod.document.MedicalEventType_form.event_type,
					f_query_add_mod.document.MedicalEventType_form.long_desc,
					f_query_add_mod.document.MedicalEventType_form.short_desc
				);

	var names = new Array ( getLabel("Common.EventType.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")

				);

	var field = new Array (	f_query_add_mod.document.MedicalEventType_form.event_type );

	var name = new Array ( getLabel("Common.EventType.label","Common") );



		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.MedicalEventType_form.submit();
				var fn_status = f_query_add_mod.document.MedicalEventType_form.function_name.value ;
			}
		}
	}

function onSuccess() {
f_query_add_mod.location.reload();
}

function reset() {

/*			if(f_query_add_mod.document.forms[0].name == "MedicalEventType_form")
				f_query_add_mod.document.MedicalEventType_form.reset() ;
		    else if(f_query_add_mod.document.forms[0].name == "query_form" )
				f_query_add_mod.document.location.reload();
			else f_query_add_mod.document.query_form.reset() ;
*/
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.forms[0].reset();


}

function change() {
      	 if (MedicalEventType_form.eff_status.checked == true)
      	 	MedicalEventType_form.eff_status.value="E";
      	 else
      		MedicalEventType_form.eff_status.value="D";
      	}
