function reset()
{
	var called_from = f_query_add_mod.document.forms[0].called_from.value;
	if (called_from=='CA')
	{
		f_query_add_mod.document.forms[0].PatientId.value=pat_id;
		f_query_add_mod.document.forms[0].PatientId.readOnly=true;
	}
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].clear.onclick();
}
