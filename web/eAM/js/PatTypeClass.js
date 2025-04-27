function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/AddModifyPatTypeClass.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/PatTypeClassQueryCriteria.jsp?function=pattypeclass";
}

function apply() {

	var fields = new Array 	( f_query_add_mod.document.pattypeclass_form.patient_type
			    	);

	var names = new Array ( getLabel("Common.patienttype.label","Common") );


	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

		SelectAll();
		f_query_add_mod.document.pattypeclass_form.submit();
		var fn_status = f_query_add_mod.document.pattypeclass_form.function_name.value;
	}

}

function onSuccess() {
	if(f_query_add_mod.document.pattypeclass_form.function_name.value=="insert")
	{
		/*f_query_add_mod.document.pattypeclass_form.patient_type.value			= "" ;
		f_query_add_mod.document.pattypeclass_form.available_patient_class.value	= "" ;
		f_query_add_mod.document.pattypeclass_form.selected_patient_class.value		= "" ;*/
	f_query_add_mod.document.location.reload();
}

}

function reset()
{

	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();


}

function addOptiontoSelection()
{
	var from = pattypeclass_form.available_patient_class;
	if ( from.options.length > 0 )
	{
		var to = pattypeclass_form.selected_patient_class;
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value= from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
	}
}

function removeOptionfromSelection()
{
	var from = pattypeclass_form.selected_patient_class;
	if ( from.options.length > 0 )
	{
		var to = pattypeclass_form.available_patient_class;
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
	}
}

function SelectAll()
{
	var i = 0;
	f_query_add_mod.document.pattypeclass_form.selected_patient_class.selectedIndex=0;
	while ( i < f_query_add_mod.document.pattypeclass_form.selected_patient_class.length)
	{
		f_query_add_mod.document.pattypeclass_form.selected_patient_class.options[i].selected=true;
		i++;
	}
}

function RemoveAll()
{
	var selected = pattypeclass_form.selected_patient_class;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var available = pattypeclass_form.available_patient_class;
	while ( available.options.length > 0 )
		available.remove(available.options[0]);
	var patienttype = pattypeclass_form.patient_type.value;
	if (patienttype != null && patienttype != "")
	{
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='querypatclass' id='querypatclass' method='post' action='../../eAM/jsp/QueryPatientClass.jsp'><input type='hidden' name='patient_type' id='patient_type' value='"+patienttype+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.querypatclass.submit();
	}


}

