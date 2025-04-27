
/*function validateDate(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/

function run() {

 if (f_query_add_mod.document.forms[0].statistics.checked == true)
 {
	f_query_add_mod.document.forms[0].statistics.value = "Y";
 }
 else if(f_query_add_mod.document.forms[0].statistics.checked == false)
 {
	f_query_add_mod.document.forms[0].statistics.value = "N";
 }
	var fields = new Array ( f_query_add_mod.document.forms[0].stat_date);
	var names = new Array ( getLabel("eOP.StatisticsDate.label","Op"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.forms[0].p_stat_date.value = f_query_add_mod.document.forms[0].stat_date.value;	
		f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
		f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
		f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
		f_query_add_mod.document.forms[0].p_incl_no_show.value = f_query_add_mod.document.forms[0].statistics.value;
	
		if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	f_query_add_mod.document.forms[0].target="messageFrame"; 	
		f_query_add_mod.document.forms[0].submit();
	}
}
function reset() {
	f_query_add_mod.document.forms[0].reset();
	}
