function reset() 
{
	if(f_query_add_mod.document.menu_form)
	{ 
	   f_query_add_mod.location.reload();
	}
}

function run()
{
	var fields = new Array( f_query_add_mod.document.menu_form.from_date,f_query_add_mod.document.menu_form.to_date);
	
    var report_id = f_query_add_mod.document.menu_form.p_report_id.value;
	if(report_id == "MOMPOSMC")
	var names = new Array(getLabel('Common.from.label','Common')+" "+getLabel('Common.date.label','Common'),getLabel('Common.to.label','Common')+" "+getLabel('Common.date.label','Common'));
	else 
	if(report_id == "MOMIPMC")
	var names = new Array(getLabel('Common.from.label','Common')+" "+getLabel('Common.year.label','Common'),getLabel('Common.to.label','Common')+" "+getLabel('Common.year.label','Common'));
	else
	var names = new Array(getLabel('Common.from.label','Common')+" "+getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common'),getLabel('Common.to.label','Common')+" "+getLabel('Common.month.label','Common')+"/"+getLabel('Common.year.label','Common'));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	 {
		f_query_add_mod.document.forms[0].p_from_date.value=f_query_add_mod.document.forms[0].from_date.value;
		f_query_add_mod.document.forms[0].p_to_date.value=f_query_add_mod.document.forms[0].to_date.value;
		f_query_add_mod.document.forms[0].submit() ;
	 }
}

