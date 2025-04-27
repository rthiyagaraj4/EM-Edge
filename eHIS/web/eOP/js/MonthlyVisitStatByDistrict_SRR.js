
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

function run() 
{
	var fields = new Array ( f_query_add_mod.document.forms[0].p_st_date);
	//var names = new Array ( getLabel("eOP.StatisticsMonthYear.label","Op"));
	var names = new Array ( getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{

	f_query_add_mod.document.forms[0].p_res_area_from.value = f_query_add_mod.document.forms[0].p_fm_resarea.value;
	f_query_add_mod.document.forms[0].p_res_area_to.value = f_query_add_mod.document.forms[0].p_to_resarea.value;	
	f_query_add_mod.document.forms[0].p_res_town_from.value = f_query_add_mod.document.forms[0].p_fm_restown.value;
	f_query_add_mod.document.forms[0].p_res_town_to.value = f_query_add_mod.document.forms[0].p_to_restown.value;	
	f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
	f_query_add_mod.document.forms[0].p_stat_date.value = f_query_add_mod.document.forms[0].p_st_date.value;	

		if(CheckString1( getLabel("Common.AreaCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_resarea,f_query_add_mod.document.forms[0].p_to_resarea,messageFrame))
		if(CheckString1( getLabel("Common.TownCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_restown,f_query_add_mod.document.forms[0].p_to_restown,messageFrame))	
			if(CheckString1( getLabel("eMP.Province.label","MP"),f_query_add_mod.document.forms[0].p_fm_province,f_query_add_mod.document.forms[0].p_to_province,messageFrame))	
			if(CheckString1(getLabel("Common.SpecialtyCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
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

