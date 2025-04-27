
  function run() 
{
	f_query_add_mod.document.forms[0].p_circum_injury_from.value = f_query_add_mod.document.forms[0].p_fm_circum_inj.value;	
	f_query_add_mod.document.forms[0].p_circum_injury_to.value=	f_query_add_mod.document.forms[0].p_to_circum_inj.value;	
	f_query_add_mod.document.forms[0].p_clinic_from.value = f_query_add_mod.document.forms[0].p_fm_locn_code.value;
	f_query_add_mod.document.forms[0].p_clinic_to.value = f_query_add_mod.document.forms[0].p_to_locn_code.value;	
	f_query_add_mod.document.forms[0].p_visit_status.value = f_query_add_mod.document.forms[0].visit_status.value;
	f_query_add_mod.document.forms[0].p_date_from.value = f_query_add_mod.document.forms[0].p_fm_date.value;	
	f_query_add_mod.document.forms[0].p_date_to.value = f_query_add_mod.document.forms[0].p_to_date.value;	
	var fields = new Array(f_query_add_mod.document.forms[0].p_date_from,
			f_query_add_mod.document.forms[0].p_date_to );
	//var names = new Array(getLabel("eOP.StatisticsDateFrom.label","Op"), getLabel("eOP.StatisticsDateTo.label","Op"));
	var names = new Array((getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common")));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{	
	if(chkGrtr(f_query_add_mod.document.forms[0].p_date_from,f_query_add_mod.document.forms[0].p_date_to)==true)
	if(f_query_add_mod.CheckString(getLabel("Common.CircumstanceofInjury.label","Common"), f_query_add_mod.document.forms[0].p_fm_circum_inj,f_query_add_mod.document.forms[0].p_to_circum_inj, messageFrame )  )
	if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code, messageFrame )  )
	{
		 f_query_add_mod.document.forms[0].submit();
	}
}
}

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

function chkGrtr(obj1,obj2)
{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}



