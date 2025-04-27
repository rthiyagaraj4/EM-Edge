
function validateMthYr(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'MY',localeName)==false)
				{
				alert(getMessage("MONTH_YEAR_INVALID", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}

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
	//var names = new Array ( getLabel("eOP.StatisticsMonthYear.label","Op"));
	var names = new Array ( getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common"));

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		f_query_add_mod.document.forms[0].p_stat_date.value = f_query_add_mod.document.forms[0].stat_date.value;	
		f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
		f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
		f_query_add_mod.document.forms[0].p_pract_from.value = f_query_add_mod.document.forms[0].p_fm_pract_id.value;	
		f_query_add_mod.document.forms[0].p_pract_to.value=	f_query_add_mod.document.forms[0].p_to_pract_id.value;	
		f_query_add_mod.document.forms[0].p_incl_no_show.value = f_query_add_mod.document.forms[0].statistics.value;
		f_query_add_mod.document.forms[0].p_visit_status.value =	f_query_add_mod.document.forms[0].visit_status.value;

		if(f_query_add_mod.CheckString1(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
		if(f_query_add_mod.CheckString1(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
		
		if(f_query_add_mod.CheckString1(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_fm_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
			f_query_add_mod.document.forms[0].submit();
	}
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}

function CheckString1(str ,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
