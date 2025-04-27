function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyAllergyType.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMR/jsp/AllergyTypeQueryCriteria.jsp";
}

function apply() {

	var fields = new Array (f_query_add_mod.document.AllergyType_form.allergy_type_code,
							f_query_add_mod.document.AllergyType_form.long_desc,
							f_query_add_mod.document.AllergyType_form.short_desc
							);

	var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")
				);


	var field = new Array (f_query_add_mod.document.AllergyType_form.allergy_type_code	);

	var name = new Array ( getLabel("Common.code.label","Common"));

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.AllergyType_form.submit();
				var fn_status = f_query_add_mod.document.AllergyType_form.function_name.value ;
			}
		}

}

function onSuccess() {
/*if(f_query_add_mod.document.AllergyType_form.function_name.value=="insert")
{

	f_query_add_mod.document.AllergyType_form.allergy_type_code.value	= "" ;
	f_query_add_mod.document.AllergyType_form.short_desc.value	= "" ;
	f_query_add_mod.document.AllergyType_form.long_desc.value	= "" ;
	//f_query_add_mod.document.BloodGroup_form.eff_status.value	= "" ;


}
*/
f_query_add_mod.location.reload();
}

function reset() {

/*			if(f_query_add_mod.document.forms[0].name == "AllergyType_form")
				f_query_add_mod.document.AllergyType_form.reset() ;
		    else if(f_query_add_mod.document.forms[0].name == "query_form" )
				f_query_add_mod.document.location.reload();
			else f_query_add_mod.document.query_form.reset() ;
*/
		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.forms[0].reset();


}

function change() {
      	 if (AllergyType_form.eff_status.checked == true)
      	 	AllergyType_form.eff_status.value="E";
      	 else
      		AllergyType_form.eff_status.value="D";
      	}
