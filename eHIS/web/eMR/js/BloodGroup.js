function create() 
{
	f_query_add_mod.location.href = "../../eMR/jsp/addModifyBloodGroup.jsp" ;
}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eMR/jsp/BloodGroupqueryCriteria.jsp";
}

function apply()
{

	var fields = new Array (
					f_query_add_mod.document.BloodGroup_form.blood_grp,
					f_query_add_mod.document.BloodGroup_form.long_desc,
					f_query_add_mod.document.BloodGroup_form.short_desc
				);

	var names = new Array ( 
					getLabel("Common.code.label","Common"),
					getLabel("Common.longdescription.label","Common"),
					getLabel("Common.shortdescription.label","Common")
				);

	var field = new Array (	f_query_add_mod.document.BloodGroup_form.blood_grp);
	var name = new Array ( getLabel("Common.bloodgroup.label","Common"));
	
	/**---------Added by Manish Anand on 12-07-2002---------------**/
	var spFields = new Array (f_query_add_mod.document.BloodGroup_form.blood_grp);
	var spNames = new Array (getLabel("Common.code.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			f_query_add_mod.document.BloodGroup_form.indeterminate_yn.disabled=false;
			f_query_add_mod.document.BloodGroup_form.submit();
			var fn_status = f_query_add_mod.document.BloodGroup_form.function_name.value ;
		}
	}
}

function onSuccess()
{
	/**---------Added by Manish Anand on 12-07-2002---------------**/
	f_query_add_mod.location.reload();
}

function reset() 
{
	if(f_query_add_mod.document.forms[0])
	   f_query_add_mod.document.forms[0].reset();
}


function change() 
{
	if (BloodGroup_form.eff_status.checked == true)
    	BloodGroup_form.eff_status.value="E";
     else
    	BloodGroup_form.eff_status.value="D";
}

function change_ind() 
{
	if(BloodGroup_form.indeterminate_yn.checked == true)
		BloodGroup_form.indeterminate_yn.value="Y";
    else
    	BloodGroup_form.indeterminate_yn.value="N";
}
